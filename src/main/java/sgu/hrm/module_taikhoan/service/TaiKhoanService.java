package sgu.hrm.module_taikhoan.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_security.jwt_utilities.JWTUtilities;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoanLogin;
import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;
import sgu.hrm.repository.RoleTaiKhoanRepository;


import java.time.LocalDateTime;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;

    final RoleTaiKhoanRepository roleTaiKhoanRepository;

    final SoYeuLyLichRepository soYeuLyLichRepository;

    final JavaMailSender javaMailSender;

    final JWTUtilities jwtUtilities;

    final PasswordEncoder passwordEncoder;

    final AuthenticationManager authenticationManager;

    @Override
    public ResDTO<ResTaiKhoan> xemThongTinTaiKhoan() {
        try {
            ResTaiKhoan resTaiKhoan = Optional.ofNullable(crush_em_t()).map(this::mapToResTaiKhoan).orElse(null);
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private ResTaiKhoan mapToResTaiKhoan(TaiKhoan taiKhoan) {
        return new ResTaiKhoan(
                taiKhoan.getId(),
                taiKhoan.getHoVaTen(),
                taiKhoan.getSoCCCD(),
                taiKhoan.getUsername(),
                taiKhoan.getSoYeuLyLich().getId(),
                (taiKhoan.getRoleTaiKhoan().getId() == 1) ? "EMPLOYEE" : "ADMIN",
                taiKhoan.isTrangThai());
    }

    private TaiKhoan crush_em_t() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return (TaiKhoan) authentication.getPrincipal();
        } else return null;
    }

    @Override
    public ResDTO<?> doiMatKhau(String matkhau) {
        try {
            TaiKhoan taiKhoan = crush_em_t();
            if (taiKhoan != null) {
                taiKhoan.setPassword(matkhau);
                taiKhoanRepository.save(taiKhoan);
            }
            ResTaiKhoan resTaiKhoan = Optional.ofNullable(taiKhoan).map(this::mapToResTaiKhoan).orElse(null);
            return new ResDTO<>(
                    ResEnum.DOI_MAT_KHAU_THANH_CONG.getStatusCode(),
                    ResEnum.DOI_MAT_KHAU_THANH_CONG,
                    ResEnum.DOI_MAT_KHAU_THANH_CONG.name()
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> xemDanhSachTaiKhoan() {
        try {
            List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
            List<ResTaiKhoan> khoanResponseDTOs = List.of();
            if (!taiKhoans.isEmpty()) {
                khoanResponseDTOs = taiKhoans.stream().map(this::mapToResTaiKhoan).toList();
            }
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    khoanResponseDTOs
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoSoCCCDOrUsername(String number) {
        try {
            ResTaiKhoan resTaiKhoan = null;
            TaiKhoan taiKhoanSoCCCD = taiKhoanRepository.findBySoCCCD(number);
            TaiKhoan taiKhoanUsername = taiKhoanRepository.findByUsername(number);

            if (taiKhoanSoCCCD != null) {
                resTaiKhoan = mapToResTaiKhoan(taiKhoanSoCCCD);
            }
            if (taiKhoanUsername != null) {
                resTaiKhoan = mapToResTaiKhoan(taiKhoanUsername);
            }

            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoId(int id) {
        try {
            ResTaiKhoan resTaiKhoan = taiKhoanRepository.findById(id).map(tk -> mapToResTaiKhoan(tk)).orElse(null);
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    resTaiKhoan
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<TaiKhoan> themTaiKhoan(ReqTaiKhoan reqTaiKhoan) {
        TaiKhoan taiKhoan = null;
        SoYeuLyLich soYeuLyLich = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        TaiKhoan principal = (TaiKhoan) authentication.getPrincipal();
        try {
            List<TaiKhoan> listUsername = taiKhoanRepository.findAll();
            //tạo username
            String hoVaTen = reqTaiKhoan.hoVaTen();
//            String temp = Normalizer.normalize(hoVaTen, Normalizer.Form.NFD);
//            Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//            hoVaTen = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
//            String[] sSplit = hoVaTen.split(" "); // tách chuỗi
//            StringBuffer newS = new StringBuffer(); // tạo 1 chuỗi mới
//            // cho ca tu loew roi cho tu dau tien up
//            if (sSplit.length > 0) {
//                for (int i = 0; i < sSplit[sSplit.length - 1].length(); i++) {
//                    if (i != 0) {
//                        newS.append(Character.toLowerCase(sSplit[sSplit.length - 1].charAt(i)));
//                        continue;
//                    }
//                    newS.append(sSplit[sSplit.length - 1].charAt(i));
//                }
//            }
//            for (int i = 0; i < sSplit.length - 1; i++) {
//                newS.append(sSplit[i].charAt(0));
//            }
//            //check trung username, co thi2 them so dang truoc
//            int checkUsername = taiKhoanRepository.findAll().stream().filter(tKhoan -> tKhoan.getUsername().contentEquals(newS)).toList().size();
//            if (checkUsername > 0) {
//                newS.append(checkUsername);
//            }
            String newUsername = ITaiKhoanService.createUsername(hoVaTen, listUsername);
            taiKhoan = TaiKhoan.builder()
                    .hoVaTen(reqTaiKhoan.hoVaTen())
                    .soCCCD(reqTaiKhoan.soCCCD())
                    .username(newUsername)
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
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        taiKhoanRepository.save(taiKhoan)
                );
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            if (taiKhoan != null && soYeuLyLich != null && principal != null) {
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

    @Override
    public ResDTO<?> dangNhap(ReqTaiKhoanLogin reqTaiKhoanLogin) {
        try {
            TaiKhoan taiKhoanLogin = taiKhoanRepository.findByUsername(reqTaiKhoanLogin.username());
            if (taiKhoanLogin != null) {
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(reqTaiKhoanLogin.username(), reqTaiKhoanLogin.password()));
                System.out.printf("USER IS: %s", taiKhoanLogin.getUsername());
                return new ResDTO<>(
                        ResEnum.DANG_NHAP_THANH_CONG.getStatusCode(),
                        ResEnum.DANG_NHAP_THANH_CONG,
                        new ResTaiKhoanLogin(
                                mapToResTaiKhoan(taiKhoanLogin),
                                jwtUtilities.generationToken(taiKhoanLogin)
                        )
                );
            }
            //không tạo refresh token ok
            return new ResDTO<>(
                    ResEnum.DANG_NHAP_THANH_CONG.getStatusCode(),
                    ResEnum.DANG_NHAP_THANH_CONG,
                    ResEnum.DANG_NHAP_THANH_CONG.name()
            );
        } catch (Exception e) {
            throw new RuntimeException(e.getCause());
        }
    }

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
