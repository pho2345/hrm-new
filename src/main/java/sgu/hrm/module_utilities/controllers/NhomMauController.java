//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.NhomMau;
//import sgu.hrm.module_utilities.repositories.NhomMauRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/nhom-mau")
//public class NhomMauController {
//
//    private NhomMauRepository nhomMauRepository;
//
//    public NhomMauController(NhomMauRepository nhomMauRepository) {
//        this.nhomMauRepository = nhomMauRepository;
//    }
//
//    @GetMapping("")
//    public List<NhomMau> getAllNhomMau() {
//        return nhomMauRepository.findAll();
//    }
//
//}