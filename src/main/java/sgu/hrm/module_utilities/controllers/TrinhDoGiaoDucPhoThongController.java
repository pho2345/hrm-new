//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
//import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/trinh-do-giao-duc-pho-thong")
//public class TrinhDoGiaoDucPhoThongController {
//
//    private TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
//
//    public TrinhDoGiaoDucPhoThongController(TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository) {
//        this.trinhDoGiaoDucPhoThongRepository = trinhDoGiaoDucPhoThongRepository;
//    }
//
//    @GetMapping("")
//    public List<TrinhDoGiaoDucPhoThong> getAllTrinhDoGiaoDucPhoThong() {
//        return trinhDoGiaoDucPhoThongRepository.findAll();
//    }
//
//}