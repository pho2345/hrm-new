package sgu.hrm.module_taikhoan.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;
import sgu.hrm.repository.RoleTaiKhoanRepository;

import java.text.Normalizer;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService
//        , UserDetailsService
{

    final TaiKhoanRepository taiKhoanRepository;

    final RoleTaiKhoanRepository roleTaiKhoanRepository;

    final SoYeuLyLichRepository soYeuLyLichRepository;

    final JavaMailSender javaMailSender;

    @Override
    public ResDTO<List<ResTaiKhoan>> xemDanhSachTaiKhoan() {
        List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
        List<ResTaiKhoan> khoanResponseDTOs = taiKhoans.stream().map(taiKhoan -> new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getSoCCCD(),
                taiKhoan.getUsername(),
                taiKhoan.getSoYeuLyLich().getId(),
                taiKhoan.getRoleTaiKhoan().getTitle(),
                taiKhoan.isTrangThai()
        )).toList();
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                khoanResponseDTOs
        );
    }

    @Override
    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoSoCCCDOrUsername(String number) {
        try {
            ResTaiKhoan resTaiKhoan = null;
            TaiKhoan taiKhoanSOCCCD = taiKhoanRepository.findBySoCCCD(number);
            TaiKhoan taiKhoanUsername = taiKhoanRepository.findByUsername(number);
            if (taiKhoanSOCCCD != null) {
                resTaiKhoan = new ResTaiKhoan(
                        taiKhoanSOCCCD.getId(),
                        taiKhoanSOCCCD.getHoVaTen(),
                        taiKhoanSOCCCD.getSoCCCD(),
                        taiKhoanSOCCCD.getUsername(),
                        taiKhoanSOCCCD.getSoYeuLyLich().getId(),
                        (taiKhoanSOCCCD.getRoleTaiKhoan().getId() == 1) ? "EMPLOYEE" : "ADMIN",
                        taiKhoanSOCCCD.isTrangThai());
            }
            if (taiKhoanUsername != null) {
                resTaiKhoan = new ResTaiKhoan(
                        taiKhoanUsername.getId(),
                        taiKhoanUsername.getHoVaTen(),
                        taiKhoanUsername.getSoCCCD(),
                        taiKhoanUsername.getUsername(),
                        taiKhoanUsername.getSoYeuLyLich().getId(),
                        (taiKhoanUsername.getRoleTaiKhoan().getId() == 1) ? "EMPLOYEE" : "ADMIN",
                        taiKhoanUsername.isTrangThai());
            }
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan
            );
        } catch (RuntimeException e) {
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Override
    public ResDTO<TaiKhoan> xemTaiKhoanTheoId(int id) {
        try {
            Optional<TaiKhoan> taiKhoan = taiKhoanRepository.findById(id);
            return taiKhoan.map(
                    khoan -> new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            khoan
                    )).orElseGet(() -> new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    null
            ));

        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<TaiKhoan> themTaiKhoan(ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = null;
        SoYeuLyLich soYeuLyLich = null;
        try {
            //tạo username
            String hoVaTen = reqTaiKhoan.hoVaTen();
            String temp = Normalizer.normalize(hoVaTen, Normalizer.Form.NFD);
            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
            hoVaTen = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
            String[] sSplit = hoVaTen.split(" "); // tách chuỗi
            StringBuffer newS = new StringBuffer(); // tạo 1 chuỗi mới
            // cho ca tu loew roi cho tu dau tien up
            if (sSplit.length > 0) {
                for (int i = 0; i < sSplit[sSplit.length - 1].length(); i++) {
                    if (i != 0) {
                        newS.append(Character.toLowerCase(sSplit[sSplit.length - 1].charAt(i)));
                        continue;
                    }
                    newS.append(sSplit[sSplit.length - 1].charAt(i));
                }
            }
            for (int i = 0; i < sSplit.length - 1; i++) {
                newS.append(sSplit[i].charAt(0));
            }
            //check trung username, co thi2 them so dang truoc
            int checkUsername = taiKhoanRepository.findAll().stream().filter(tKhoan -> tKhoan.getUsername().contentEquals(newS)).toList().size();
            if (checkUsername > 0) {
                newS.append(checkUsername);
            }

            taiKhoan = TaiKhoan.builder()
                    .hoVaTen(reqTaiKhoan.hoVaTen())
                    .soCCCD(reqTaiKhoan.soCCCD())
                    .username(newS.toString())
                    .password(reqTaiKhoan.soCCCD())
                    .roleTaiKhoan(roleTaiKhoanRepository.findById(1).get())
                    .trangThai(true)
                    .create_at(LocalDateTime.now())
                    .build();
            if (taiKhoan != null) {
                soYeuLyLich = SoYeuLyLich.builder()
                        .hovaten(reqTaiKhoan.hoVaTen())
                        .soCCCD(reqTaiKhoan.soCCCD())
                        .create_at(taiKhoan.getCreate_at())
                        .build();
                soYeuLyLichRepository.save(soYeuLyLich);
                taiKhoan.setSoYeuLyLich(soYeuLyLich);
//            new ResTaiKhoan(
//                    taiKhoan.getId(),
//                    taiKhoan.getHoVaTen(),
//                    taiKhoan.getSoCCCD(),
//                    taiKhoan.getUsername(),
//                    taiKhoan.getSoYeuLyLich().getId(),
//                    taiKhoan.getRoleTaiKhoan().getTitle(),
//                    taiKhoan.isTrangThai()
//            );
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        taiKhoanRepository.save(taiKhoan)
                );
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            if (taiKhoan != null && soYeuLyLich != null) {
                SimpleMailMessage message = new SimpleMailMessage();
                message.setFrom("noreply-chinhphu@gmail.com");
                message.setTo(reqTaiKhoan.email());
                message.setSubject("CHÀO MỪNG NHÂN VIÊN CHÍNH PHỦ");
                message.setText(String.format("%s\n%s\n%s\n%s",
                        "THÔNG TIN TÀI KHOẢN",
                        "Tên đăng nhập: " + taiKhoan.getUsername(),
                        "Mật khẩu: " + taiKhoan.getPassword(),
                        "Mã sơ yếu lý lịch: " + soYeuLyLich.getId()
                ));
                javaMailSender.send(message);
            }
        }
        return new ResDTO<>(
                ResEnum.KHONG_HOP_LE.getStatusCode(),
                ResEnum.KHONG_HOP_LE,
                null
        );
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username);
//        if (taiKhoan == null) {
//            throw new UsernameNotFoundException("User not found with username: " + username);
//        }
//        return User
//                .withUsername(username)
//                .password(taiKhoan.getPassword())
//                .roles(taiKhoan.getRoleTaiKhoan().getTitle())
//                .build();
//    }

//
//    @Override
//    public TaiKhoanRes.ThgBaoTaiKhoan suaMathauTaiKhosn(int id, String matKhau) {
////        Pattern pattern = Pattern.compile("^[a-zA-Z0-9\\S]{6,15}$");
////        Pattern pattern = Pattern.compile("^[\\p{Lower}\\p{Upper}\\d\\S]{6,15}$");
////        Matcher matcher = pattern.matcher(matKhau);
////        if (matcher.matches()) {
////            System.out.println("ok");
////        } else System.out.printf("%s", "wrong");
//
//        //accept a-zA-Z0-9 lenght 6 - 15
//        Pattern pattern = Pattern.compile("^[\\p{Alnum}]{6,15}$");
//        Matcher matcher = pattern.matcher(matKhau);
//        Optional<TaiKhoan> taiKhoan = Optional.empty();
//        if (matcher.matches()) {
//            taiKhoan = taiKhoanRepository.findById(id);
//            if (taiKhoan.isPresent()) {
//                taiKhoan.get().setPassword(matKhau);
//                return new TaiKhoanRes.ThgBaoTaiKhoan<>(
//                        TaiKhoanRes.TAIKHOAN_UPDATE_MATKHAU, TaiKhoanRes.TAIKHOAN_UPDATE_MATKHAU.name(),
//                        taiKhoan.get()
//                );
//                // taiKhoanRepository.save(taiKhoan.get());
//            } else System.err.printf("!! %s !!", NotificationsServer.TAIKHOAN_NOTFOUND);
//        }
//        return new TaiKhoanRes.ThgBaoTaiKhoan<>(TaiKhoanRes.TAIKHOAN_NOTFOUND, TaiKhoanRes.TAIKHOAN_NOTFOUND.name(), taiKhoan);
//    }
//
//    @Override
//    public void xoaTaiKhoan() {
//
//    }
}
