//package sgu.hrm.module_utilities.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor // create constructor when field has properties final or @not null
//@RequestMapping(value = "/api/v1/danh-hieu-nha-nuoc-phong-tang")
//public class DanhHieuNhaNuocPhongTangController {
//
//    private final IDanhHieuNhaNuocPhongTangService danhHieuNhaNuocPhongTangService;
//
//    @GetMapping("")
//    public List<DanhHieuNhaNuocPhongTang> getAllDanhHieuNhaNuocPhongTang() {
//        return danhHieuNhaNuocPhongTangService.xemDanhHieuNhaNuocPhongTang();
//    }
//
//}
