package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.TrinhDoChuyenMon;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.repository.TrinhDoChuyenMonRepository;
import sgu.hrm.repository.TrinhDoGiaoDucPhoThongRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/trinh-do-giao-duc-pho-thong")
public class TrinhDoGiaoDucPhoThongController {

    private TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;

    public TrinhDoGiaoDucPhoThongController(TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository) {
        this.trinhDoGiaoDucPhoThongRepository = trinhDoGiaoDucPhoThongRepository;
    }

    @GetMapping("")
    public List<TrinhDoGiaoDucPhoThong> getAllTrinhDoGiaoDucPhoThong() {
        return trinhDoGiaoDucPhoThongRepository.findAll();
    }

}