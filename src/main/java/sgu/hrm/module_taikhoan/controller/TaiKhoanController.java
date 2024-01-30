package sgu.hrm.module_taikhoan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.dto.TaiKhoanDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tai-khoan")
public class TaiKhoanController {

    @Autowired
    private ITaiKhoanService taiKhoanService;

    @GetMapping("/all")
    public List<TaiKhoan> getAllTaiKhoan() {
        return taiKhoanService.xemTaiKhoan();
    }

    @PostMapping("/them")
    public void themTaiKhoan(@RequestBody TaiKhoanDTO taiKhoanDTO){
        taiKhoanService.themTaiKhoan(taiKhoanDTO);
    }

}
