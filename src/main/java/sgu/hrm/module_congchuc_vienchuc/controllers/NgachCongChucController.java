package sgu.hrm.module_congchuc_vienchuc.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachCongChucRepository;

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
