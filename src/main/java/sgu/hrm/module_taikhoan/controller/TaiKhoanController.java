//package sgu.hrm.module_taikhoan.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PatchMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_response.ResDTO;
//import sgu.hrm.module_response.ResEnum;
//import sgu.hrm.module_taikhoan.models.dto.MatKhauDTO;
//import sgu.hrm.module_taikhoan.models.resopnse.TaiKhoanRes;
//import sgu.hrm.module_taikhoan.service.ITaiKhoanService;
//import sgu.hrm.module_taikhoan.models.TaiKhoan;
//import sgu.hrm.module_taikhoan.models.dto.ReqTaiKhoanDTO;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/tai-khoan")
//public class TaiKhoanController {
//
//    @Autowired
//    private ITaiKhoanService taiKhoanService;
//
//    @GetMapping("/test")
//    public ResDTO<List<String>> test() {
//        return new ResDTO<>(
//                ResEnum.THANH_CONG.getStatusCode(),
//                ResEnum.THANH_CONG,
//                List.of("1", "2", "3")
//        );
//    }
//
//    @GetMapping("/all")
//    public ResDTO<List<TaiKhoanRes.TaiKhoanResDTO>> getAllTaiKhoan() {
//        return taiKhoanService.xemTaiKhoan();
//    }
//
//    @GetMapping("/so-cccd")
//    public TaiKhoan getTaiKhoanBySoCCCD(@RequestParam(name = "soCCCD") String soCCCD) {
//        return taiKhoanService.xemTaiKhoanTheoSoCCCD(soCCCD);
//    }
//
//    @PostMapping("/them-tai-khoan")
//    public TaiKhoanRes.ThgBaoTaiKhoan themTaiKhoan(@RequestBody ReqTaiKhoanDTO reqTaiKhoanDTO) {
//        return taiKhoanService.themTaiKhoan(reqTaiKhoanDTO);
//    }
//
//    @PatchMapping("/thay-doi-mat-khau")
//    public TaiKhoanRes.ThgBaoTaiKhoan suaTaiKhoan(@RequestBody MatKhauDTO matKhauDTO) {
//        return taiKhoanService.suaMathauTaiKhosn(matKhauDTO.id(), matKhauDTO.matkhau());
//    }
//
//}
