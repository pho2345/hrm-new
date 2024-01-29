//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.GioiTinh;
//import sgu.hrm.module_utilities.repositories.GioiTinhRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/gioi-tinh")
//public class GioiTinhController {
//
//    private GioiTinhRepository gioiTinhRepository;
//
//    public GioiTinhController(GioiTinhRepository gioiTinhRepository) {
//        this.gioiTinhRepository = gioiTinhRepository;
//    }
//
//    @GetMapping("")
//    public List<GioiTinh> getAllGioiTinh() {
//        return gioiTinhRepository.findAll();
//    }
//
//}