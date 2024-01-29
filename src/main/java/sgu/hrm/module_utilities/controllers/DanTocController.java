//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.services.DanTocService;
//import sgu.hrm.module_utilities.services.i_services.IDanTocService;
//import sgu.hrm.module_utilities.models.DanToc;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/dan-toc")
//public class DanTocController {
//
//    private final IDanTocService danTocService;
//
//    public DanTocController(DanTocService danTocService) {
//        this.danTocService = danTocService;
//    }
//
//    @GetMapping("")
//    public List<DanToc> getAllDanToc() {
//        return danTocService.xemDanToc();
//    }
//
//}