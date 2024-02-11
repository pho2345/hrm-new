package sgu.hrm.module_taikhoan.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqMatKhau;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;

import java.security.Principal;
import java.util.List;

@RestController
public class TaiKhoanController {

    private final ITaiKhoanService taiKhoanService;

    public TaiKhoanController(ITaiKhoanService taiKhoanService) {
        this.taiKhoanService = taiKhoanService;
    }

    //thong-tin-ca-nhan
    @GetMapping("/ca-nhan/tai-khoan")
    @Transactional
    public ResDTO<ResTaiKhoan> thong_tin_ca_nhan() {
        return taiKhoanService.xemThongTinTaiKhoan();
    }

    //doi-mat-khau
    @PatchMapping("/ca-nhan/tai-khoan/doi-mat-khau")
    @Transactional
    public ResDTO<?> doi_mat_khau(@RequestBody ReqMatKhau reqMatKhau) {
        return taiKhoanService.doiMatKhau(reqMatKhau.matkhau());
    }

    /*
     * ADMIN
     * ADMIN
     * ADMIN
     * */
    @GetMapping("/nhan-vien/tai-khoan")
    public ResDTO<?> getAllTaiKhoan() {
        return taiKhoanService.xemDanhSachTaiKhoan();
    }

    @GetMapping("/nhan-vien/tai-khoan/tim-kiem")
    public ResDTO<ResTaiKhoan> getTaiKhoanBySoCCCD(@RequestParam(name = "q") String number) {
        return taiKhoanService.xemTaiKhoanTheoSoCCCDOrUsername(number);
    }

    @GetMapping("/nhan-vien/tai-khoan/{id}")
    public ResDTO<ResTaiKhoan> getTaiKhoanBySoCCCD(@PathVariable(name = "id") int id) {
        return taiKhoanService.xemTaiKhoanTheoId(id);
    }

    @PostMapping("/nhan-vien/them")
    @Transactional
    public ResDTO<?> addTaiKhoan(@RequestBody ReqTaiKhoan reqTaiKhoan) {
        return taiKhoanService.themTaiKhoan(reqTaiKhoan);
    }
}
