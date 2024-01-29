//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.TonGiao;
//import sgu.hrm.module_utilities.repositories.TonGiaoRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/ton-giao")
//public class TonGiaoController {
//
//    private TonGiaoRepository tonGiaoRepository;
//
//    public TonGiaoController(TonGiaoRepository tonGiaoRepository) {
//        this.tonGiaoRepository = tonGiaoRepository;
//    }
//
//    @GetMapping("")
//    public List<TonGiao> getAllTonGiao() {
//        return tonGiaoRepository.findAll();
//    }
//
//}