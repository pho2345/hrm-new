package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.TonGiao;
import sgu.hrm.models.TrinhDoChuyenMon;
import sgu.hrm.repository.TonGiaoRepository;
import sgu.hrm.repository.TrinhDoChuyenMonRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/trinh-do-chuyen-mon")
public class TrinhDoChuyenMonController {

    private TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;

    public TrinhDoChuyenMonController(TrinhDoChuyenMonRepository trinhDoChuyenMonRepository) {
        this.trinhDoChuyenMonRepository = trinhDoChuyenMonRepository;
    }

    @GetMapping("")
    public List<TrinhDoChuyenMon> getAllTrinhDoChuyenMon() {
        return trinhDoChuyenMonRepository.findAll();
    }

}