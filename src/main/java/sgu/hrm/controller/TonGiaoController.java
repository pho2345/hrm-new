package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.TinhTrangSucKhoe;
import sgu.hrm.models.TonGiao;
import sgu.hrm.repository.TinhTrangSucKhoeRepository;
import sgu.hrm.repository.TonGiaoRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ton-giao")
public class TonGiaoController {

    private TonGiaoRepository tonGiaoRepository;

    public TonGiaoController(TonGiaoRepository tonGiaoRepository) {
        this.tonGiaoRepository = tonGiaoRepository;
    }

    @GetMapping("")
    public List<TonGiao> getAllTonGiao() {
        return tonGiaoRepository.findAll();
    }

}