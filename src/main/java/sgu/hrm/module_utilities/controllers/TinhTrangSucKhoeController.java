//package sgu.hrm.module_utilities.controllers;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
//import sgu.hrm.module_utilities.repositories.TinhTrangSucKhoeRepository;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(value = "/api/v1/tinh-trang-suc-khoe")
//public class TinhTrangSucKhoeController {
//
//    private TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository;
//
//    public TinhTrangSucKhoeController(TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository) {
//        this.tinhTrangSucKhoeRepository = tinhTrangSucKhoeRepository;
//    }
//
//    @GetMapping("")
//    public List<TinhTrangSucKhoe> getAllTinhTrangSucKhoe() {
//        return tinhTrangSucKhoeRepository.findAll();
//    }
//
//}