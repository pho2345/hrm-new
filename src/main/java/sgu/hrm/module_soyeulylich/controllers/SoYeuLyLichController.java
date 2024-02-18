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
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.services.ISoYeuLyLichService;


@RestController
@RequestMapping(value = "")
public class SoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public SoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    @GetMapping("/ca-nhan/so-yeu-ly-lich")
    public ResDTO<?> so_yeu_ly_lich() {
        return soYeuLyLichService.xemThongTinSoYeuLyLich();
    }

    @PatchMapping("/ca-nhan/so-yeu-ly-lich/cap-nhat")
    public ResDTO<?> so_yeu_ly_lich_cap_nhat(@RequestBody ReqSoYeuLyLich reqSoYeuLyLich) {
        return soYeuLyLichService.capNhatSoYeuLyLich(reqSoYeuLyLich);
    }

    //ADMIN --- ADMIN --- ADMIN
    @GetMapping("/nhan-vien/so-yeu-ly-lich")
    public ResDTO<?> getAllSoYeuLyLich() {
        return soYeuLyLichService.xemDanhSachSoYeuLyLich();
    }

    //find by String soCCCD and UUID id
    @GetMapping("/nhan-vien/so-yeu-ly-lich/tim-kiem")
    public ResDTO<ResDSSoYeuLyLich> getSoYeuLyLichSoCCCDOrId(@RequestParam(name = "q") String q) {
        return soYeuLyLichService.xemSoYeuLyLichTheoSoCCCDHoacID(q);
    }

    @GetMapping("/nhan-vien/so-yeu-ly-lich/{id}")
    public ResDTO<?> getSoYeuLyLichById(@PathVariable(name = "id") String id) {
        return soYeuLyLichService.xemSoYeuLyLichTheoId(id);
    }

    @PatchMapping("/nhan-vien/so-yeu-ly-lich/{id}/phe-duyet")
    @Transactional
    public ResDTO<?> editSoYeuLyLich(@PathVariable(name = "id") String id,
                                     @RequestBody ReqDSSoYeuLyLich reqDSSoYeuLyLich) {
        return soYeuLyLichService.pheDuyetSoYeuLyLich(id, reqDSSoYeuLyLich);
    }

    //can sua
//    @PatchMapping("/nhan-vien/so-yeu-ly-lich/{id}/phe-duyet")
//    public ResDTO<?> updateTrangThaiSoYeuLyLich(@PathVariable(name = "id") UUID id) {
//        return soYeuLyLichService.xemSoYeuLyLichTheoId(id);
//    }


//    @PatchMapping("/cap-nhat")
//    public void editSoYeuLyLich(@RequestBody SoYeuLyLichDTO soYeuLyLichDTO) {
//        soYeuLyLichService.themSoYeuLyLich(soYeuLyLichDTO);
//    }

//    @PostMapping("/them")
//    public void themSoYeuLyLich(@RequestBody SoYeuLyLichDTO soYeuLyLichDTO) {
//        soYeuLyLichService.themSoYeuLyLich(soYeuLyLichDTO);
//    }
}