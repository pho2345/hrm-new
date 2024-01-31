//package sgu.hrm.module_taikhoan.service;
//
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.stereotype.Service;
//import sgu.hrm.enums.NotificationsServer;
//import sgu.hrm.module_response.ResDTO;
//import sgu.hrm.module_response.ResEnum;
//import sgu.hrm.module_taikhoan.models.TaiKhoan;
//import sgu.hrm.module_taikhoan.models.dto.ReqTaiKhoanDTO;
//import sgu.hrm.module_taikhoan.models.dto.ResTaiKhoanDTO;
////import sgu.hrm.module_taikhoan.models.resopnse.TaiKhoanRes;
//import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;
//
//import java.text.Normalizer;
//import java.util.List;
//import java.util.Optional;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class TaiKhoanService implements ITaiKhoanService {
//
//    final TaiKhoanRepository taiKhoanRepository;
//
////    final SoYeuLyLichService soYeuLyLichService;
//
//    @Override
//    public ResDTO<List<ResTaiKhoanDTO>> xemTaiKhoan() {
//        List<TaiKhoan> taiKhoans = taiKhoanRepository.findAll();
//        List<ResTaiKhoanDTO> khoanResponseDTOs = taiKhoans.stream().map(taiKhoan -> new ResTaiKhoanDTO(
//                taiKhoan.getId(),
//                taiKhoan.getHoVaTen(),
//                taiKhoan.getUsername(),
//                taiKhoan.getSoYeuLyLich().getId(),
//                taiKhoan.isTrangThai()
//        )).toList();
////        ResDTO<>
////        TaiKhoanRes.ThgBaoTaiKhoan<List<TaiKhoanRes.TaiKhoanResDTO>> thongBaoTaiKhoan = new TaiKhoanRes.ThgBaoTaiKhoan<>(
////                TaiKhoanRes.TAIKHOAN_SUCCESS,
////                TaiKhoanRes.TAIKHOAN_SUCCESS.name(),
////                khoanResponseDTOs
////        );
//        return new ResDTO<>(
//                ResEnum.THANH_CONG.getStatusCode(),
//                ResEnum.THANH_CONG,
//                khoanResponseDTOs
//        );
//    }
//
//    @Override
//    public TaiKhoan xemTaiKhoanTheoSoCCCD(String soCCCD) {
//        return taiKhoanRepository.findBySoCCCD(soCCCD);
//    }
//
//    @Override
//    public ResDTO<TaiKhoan> themTaiKhoan(ReqTaiKhoanDTO reqTaiKhoanDTO) {
//        //tạo username
//        String hoVaTen = reqTaiKhoanDTO.hoVaTen();
//        String temp = Normalizer.normalize(hoVaTen, Normalizer.Form.NFD);
//        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
//        hoVaTen = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
//        String[] sSplit = hoVaTen.split(" "); // tách chuỗi
//        StringBuffer newS = new StringBuffer(); // tạo 1 chuỗi mới
//        // cho ca tu loew roi cho tu dau tien up
//        if (sSplit.length > 0) {
//            for (int i = 0; i < sSplit[sSplit.length - 1].length(); i++) {
//                if (i != 0) {
//                    newS.append(Character.toLowerCase(sSplit[sSplit.length - 1].charAt(i)));
//                    continue;
//                }
//                newS.append(sSplit[sSplit.length - 1].charAt(i));
//            }
//        }
//        for (int i = 0; i < sSplit.length - 1; i++) {
//            newS.append(sSplit[i].charAt(0));
//        }
//        //check trung username, co thi2 them so dang truoc
//        int checkUsername = taiKhoanRepository.findAll().stream().filter(taiKhoan -> taiKhoan.getUsername().contentEquals(newS)).toList().size();
//        if (checkUsername > 0) {
//            newS.append(checkUsername);
//        }
//        TaiKhoan taiKhoan = TaiKhoan.builder()
//                .hoVaTen(reqTaiKhoanDTO.hoVaTen())
//                .soCCCD(reqTaiKhoanDTO.soCCCD())
//                .username(newS.toString())
//                .password(reqTaiKhoanDTO.soCCCD())
//                .status(true)
//                .build();
//        return (taiKhoan != null) ?
//                new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan
//                ) :
//                new TaiKhoanRes.ThgBaoTaiKhoan<>(TaiKhoanRes.TAIKHOAN_CREATED_FAILD,
//                        TaiKhoanRes.TAIKHOAN_CREATED_FAILD.name(),
//                        new TaiKhoan()
//                );
//        new ResDTO<>(
//                ResEnum.THANH_CONG.getStatusCode(),
//                ResEnum.THANH_CONG,
//                taiKhoan
//        )
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
//
//}
