package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.models.TaiKhoan;
import sgu.hrm.repository.DanhHieuNhaNuocPhongTangRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/danh-hieu-nha-nuoc-phong-tang")
public class DanhHieuNhaNuocPhongTangController {

    private DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;

    public DanhHieuNhaNuocPhongTangController(DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository) {
        this.danhHieuNhaNuocPhongTangRepository = danhHieuNhaNuocPhongTangRepository;
    }

    @GetMapping("")
    public List<DanhHieuNhaNuocPhongTang> getAllDanhHieuNhaNuocPhongTang() {
        return danhHieuNhaNuocPhongTangRepository.findAll();
    }

}
