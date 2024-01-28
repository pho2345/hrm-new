package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.HocHam;
import sgu.hrm.models.TinhTrangSucKhoe;
import sgu.hrm.repository.HocHamRepository;
import sgu.hrm.repository.TinhTrangSucKhoeRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/hoc-ham")
public class HocHamController {

    private HocHamRepository hocHamRepository;

    public HocHamController(HocHamRepository hocHamRepository) {
        this.hocHamRepository = hocHamRepository;
    }

    @GetMapping("")
    public List<HocHam> getAllHocHam() {
        return hocHamRepository.findAll();
    }

}