package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.models.NgachCongChuc;
import sgu.hrm.repository.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.repository.NgachCongChucRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ngach-cong-chuc")
public class NgachCongChucController {

    private NgachCongChucRepository ngachCongChucRepository;

    public NgachCongChucController(NgachCongChucRepository ngachCongChucRepository) {
        this.ngachCongChucRepository = ngachCongChucRepository;
    }

    @GetMapping("")
    public List<NgachCongChuc> getAllNgachCongChuc() {
        return ngachCongChucRepository.findAll();
    }

}
