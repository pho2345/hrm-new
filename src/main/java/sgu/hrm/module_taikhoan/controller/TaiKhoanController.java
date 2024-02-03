package sgu.hrm.module_taikhoan.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tai-khoan")
public class TaiKhoanController {

    @Autowired
    private ITaiKhoanService taiKhoanService;

    @GetMapping("/test")
    public ResDTO<List<String>> test() {
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                List.of("1", "2", "3")
        );
    }

    @GetMapping("")
    public ResDTO<List<ResTaiKhoan>> getAllTaiKhoan() {
        return taiKhoanService.xemDanhSachTaiKhoan();
    }

    @GetMapping("/tim-kiem")
    public ResDTO<ResTaiKhoan> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        return taiKhoanService.xemTaiKhoanTheoSoCCCDOrUsername(number);
    }

    @GetMapping("/{id}")
    public ResDTO<TaiKhoan> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        return taiKhoanService.xemTaiKhoanTheoId(id);
    }

    //    @GetMapping("/user-name")
//    public ResDTO<ResTaiKhoan> getTaiKhoanByUsername(@RequestParam(name = "username") String username) {
//        return taiKhoanService.xemTaiKhoanTheoUsername(username);
//    }
//
    @PostMapping("/them")
    @Transactional
    public ResDTO<TaiKhoan> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        return taiKhoanService.themTaiKhoan(reqTaiKhoan);
    }
//
//    @PatchMapping("/thay-doi-mat-khau")
//    public TaiKhoanRes.ThgBaoTaiKhoan suaTaiKhoan(@RequestBody MatKhauDTO matKhauDTO) {
//        return taiKhoanService.suaMathauTaiKhosn(matKhauDTO.id(), matKhauDTO.matkhau());
//    }

}
