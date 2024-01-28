package sgu.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.GioiTinh;
import sgu.hrm.models.TaiKhoan;
import sgu.hrm.repository.GioiTinhRepository;
import sgu.hrm.repository.TaiKhoanRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/gioi-tinh")
public class GioiTinhController {

    private GioiTinhRepository gioiTinhRepository;

    public GioiTinhController(GioiTinhRepository gioiTinhRepository) {
        this.gioiTinhRepository = gioiTinhRepository;
    }

    @GetMapping("")
    public List<GioiTinh> getAllGioiTinh() {
        return gioiTinhRepository.findAll();
    }

}