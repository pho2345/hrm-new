//package sgu.hrm.module_utilities.services;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
//import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor // tạo constructor khi field là final hoặc có annotation là not null
//public class DanhHieuNhaNuocPhongTangService implements IDanhHieuNhaNuocPhongTangService {
//
//    private final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
//    @Override
//    public List<DanhHieuNhaNuocPhongTang> xemDanhHieuNhaNuocPhongTang() {
//        return danhHieuNhaNuocPhongTangRepository.findAll();
//    }
//}
