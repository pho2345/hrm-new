package sgu.hrm.module_soyeulylich.controllers;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_soyeulylich.models.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLichDTO;
import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqTinHoc;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/so-yeu-ly-lich")
public class SoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public SoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    //cua admin
    @GetMapping("")
    public ResDTO<List<SoYeuLyLich>> getAllSoYeuLyLich() {
        return soYeuLyLichService.xemSoYeuLyLich();
    }

    //find by String soCCCD and UUID id
    @GetMapping("/tim-kiem")
    public ResDTO<SoYeuLyLich> getSoYeuLyLichSoCCCDOrId(@RequestParam(name = "q") String q) {
        return soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q);
    }

    @GetMapping("/{id}")
    public ResDTO<SoYeuLyLich> getSoYeuLyLichById(@PathVariable(name = "id") UUID id) {
        return soYeuLyLichService.xemSoYeuLyLichTheoId(id);
    }

    @PatchMapping("/{id}/phe-duyet")
    public ResDTO<SoYeuLyLich> updateTrangThaiSoYeuLyLich(@PathVariable(name = "id") UUID id) {
        return soYeuLyLichService.xemSoYeuLyLichTheoId(id);
    }

    @PatchMapping("/{id}/cap-nhat")
    @Transactional
    public ResDTO<SoYeuLyLich> editSoYeuLyLich(@PathVariable(name = "id") UUID id,
                                               @RequestBody SoYeuLyLichDTO soYeuLyLichDTO) {
        return soYeuLyLichService.capNhatSoYeuLyLich(id, soYeuLyLichDTO);
    }
//    @PatchMapping("/cap-nhat")
//    public void editSoYeuLyLich(@RequestBody SoYeuLyLichDTO soYeuLyLichDTO) {
//        soYeuLyLichService.themSoYeuLyLich(soYeuLyLichDTO);
//    }

//    @PostMapping("/them")
//    public void themSoYeuLyLich(@RequestBody SoYeuLyLichDTO soYeuLyLichDTO) {
//        soYeuLyLichService.themSoYeuLyLich(soYeuLyLichDTO);
//    }
}