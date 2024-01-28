package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.DanToc;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.repository.DanTocRepository;
import sgu.hrm.repository.TrinhDoGiaoDucPhoThongRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/dan-toc")
public class DanTocController {

    private DanTocRepository danTocRepository;

    public DanTocController(DanTocRepository danTocRepository) {
        this.danTocRepository = danTocRepository;
    }

    @GetMapping("")
    public List<DanToc> getAllDanToc() {
        return danTocRepository.findAll();
    }

}