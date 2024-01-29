//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
//import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/thanh-phan-gia-dinh")
//public class ThanhPhanGiaDinhController {
//
//    private ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
//
//    public ThanhPhanGiaDinhController(ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository) {
//        this.thanhPhanGiaDinhRepository = thanhPhanGiaDinhRepository;
//    }
//
//    @GetMapping("")
//    public List<ThanhPhanGiaDinh> getAllThanhPhanGiaDinh() {
//        return thanhPhanGiaDinhRepository.findAll();
//    }
//
//}