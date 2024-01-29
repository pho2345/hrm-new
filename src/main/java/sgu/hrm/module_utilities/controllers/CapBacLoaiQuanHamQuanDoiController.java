//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
//import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/cap-bac-loai-quan-ham-quan-doi")
//public class CapBacLoaiQuanHamQuanDoiController {
//
//    private CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
//
//    public CapBacLoaiQuanHamQuanDoiController(CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository) {
//        this.capBacLoaiQuanHamQuanDoiRepository = capBacLoaiQuanHamQuanDoiRepository;
//    }
//
//    @GetMapping("")
//    public List<CapBacLoaiQuanHamQuanDoi> getAllCapBacLoaiQuanHamQuanDoi() {
//        return capBacLoaiQuanHamQuanDoiRepository.findAll();
//    }
//
//}