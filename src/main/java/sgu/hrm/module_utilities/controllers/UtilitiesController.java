package sgu.hrm.module_utilities.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sgu.hrm.module_response.ResDTO;

import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.models.request.ReqCapBacQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.request.ReqUtilities;
import sgu.hrm.module_utilities.services.IUtilitiesService;

import java.util.List;

@RestController
//@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/utilities")
public class UtilitiesController {
    private final IUtilitiesService.IBacLuongService bacLuongService;
    private final IUtilitiesService.ILoaiQuanHamQuanDoiService loaiQuanHamQuanDoiService;
    private final IUtilitiesService.ICapBacLoaiQuanHamQuanDoiService capBacLoaiQuanHamQuanDoiService;
    private final IUtilitiesService.IDanhHieuNhaNuocPhongTangService danhHieuNhaNuocPhongTangService;
    private final IUtilitiesService.IDanTocService danTocService;
    private final IUtilitiesService.IDoiTuongChinhSachService doiTuongChinhSachService;
    private final IUtilitiesService.IGioiTinhService gioiTinhService;
    private final IUtilitiesService.IHocHamService hocHamService;
    private final IUtilitiesService.INhomMauService nhomMauService;
    private final IUtilitiesService.IThanhPhanGiaDinhService thanhPhanGiaDinhService;
    private final IUtilitiesService.ITinhTrangSucKhoeService tinhTrangSucKhoeService;
    private final IUtilitiesService.ITonGiaoService tonGiaoService;
    private final IUtilitiesService.ITrinhDoChuyenMonService trinhDoChuyenMonService;
    private final IUtilitiesService.ITrinhDoGiaoDucPhoThongService trinhDoGiaoDucPhoThongService;

    public UtilitiesController(
            IUtilitiesService.IBacLuongService bacLuongService, IUtilitiesService.ILoaiQuanHamQuanDoiService loaiQuanHamQuanDoiService,
            IUtilitiesService.ICapBacLoaiQuanHamQuanDoiService capBacLoaiQuanHamQuanDoiService,
            IUtilitiesService.IDanhHieuNhaNuocPhongTangService danhHieuNhaNuocPhongTangService,
            IUtilitiesService.IDanTocService danTocService, IUtilitiesService.IDoiTuongChinhSachService doiTuongChinhSachService,
            IUtilitiesService.IGioiTinhService gioiTinhService, IUtilitiesService.IHocHamService hocHamService,
            IUtilitiesService.INhomMauService nhomMauService, IUtilitiesService.IThanhPhanGiaDinhService thanhPhanGiaDinhService,
            IUtilitiesService.ITinhTrangSucKhoeService tinhTrangSucKhoeService, IUtilitiesService.ITonGiaoService tonGiaoService,
            IUtilitiesService.ITrinhDoChuyenMonService trinhDoChuyenMonService,
            IUtilitiesService.ITrinhDoGiaoDucPhoThongService trinhDoGiaoDucPhoThongService) {
        this.bacLuongService = bacLuongService;
        this.loaiQuanHamQuanDoiService = loaiQuanHamQuanDoiService;
        this.capBacLoaiQuanHamQuanDoiService = capBacLoaiQuanHamQuanDoiService;
        this.danhHieuNhaNuocPhongTangService = danhHieuNhaNuocPhongTangService;
        this.danTocService = danTocService;
        this.doiTuongChinhSachService = doiTuongChinhSachService;
        this.gioiTinhService = gioiTinhService;
        this.hocHamService = hocHamService;
        this.nhomMauService = nhomMauService;
        this.thanhPhanGiaDinhService = thanhPhanGiaDinhService;
        this.tinhTrangSucKhoeService = tinhTrangSucKhoeService;
        this.tonGiaoService = tonGiaoService;
        this.trinhDoChuyenMonService = trinhDoChuyenMonService;
        this.trinhDoGiaoDucPhoThongService = trinhDoGiaoDucPhoThongService;
    }

    @GetMapping("/bac-luong")
    public ResDTO<List<BacLuong>> getAllBacLuong() {
        return bacLuongService.xemBacLuong();
    }

    @PostMapping("/bac-luong/them")
    public ResDTO<BacLuong> addBacLuong(@RequestBody ReqUtilities utilities) {
        return bacLuongService.themBacLuong(utilities.name());
    }
    // khong co requestbody van ok, van hieu do la request body
    @PatchMapping("/bac-luong/sua")
    public ResDTO<BacLuong> editBacLuong(@RequestBody BacLuong luong) {
        return bacLuongService.suaBacLuong(luong);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/loai-quan-ham-quan-doi")
    public ResDTO<List<LoaiQuanHamQuanDoi>> getAllLoaiQuanHamQuanDoi() {
        return loaiQuanHamQuanDoiService.xemLoaiQuanHamQuanDoi();
    }

    @PostMapping("/loai-quan-ham-quan-doi/them")
    public ResDTO<LoaiQuanHamQuanDoi> addLoaiQuanHamQuanDoi(@RequestBody ReqUtilities utilities) {
        return loaiQuanHamQuanDoiService.themLoaiQuanHamQuanDoi(utilities.name());
    }

    @PatchMapping("/loai-quan-ham-quan-doi/sua")
    public ResDTO<LoaiQuanHamQuanDoi> editLoaiQuanHamQuanDoi(@RequestBody LoaiQuanHamQuanDoi loaiQuanHamQuanDoi) {
        return loaiQuanHamQuanDoiService.suaLoaiQuanHamQuanDoi(loaiQuanHamQuanDoi);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/cap-bac-loai-quan-ham-quan-doi")
    public ResDTO<List<CapBacLoaiQuanHamQuanDoi>> getAllCapBacLoaiQuanHamQuanDoi() {
        return capBacLoaiQuanHamQuanDoiService.xemCapBacLoaiQuanHamQuanDoi();
    }

    @PostMapping("/cap-bac-loai-quan-ham-quan-doi/them")
    public ResDTO<CapBacLoaiQuanHamQuanDoi> addCapBacLoaiQuanHamQuanDoi(@RequestBody ReqCapBacQuanHamQuanDoi capBacQuanHamQuanDoi) {
        return capBacLoaiQuanHamQuanDoiService.themCapBacLoaiQuanHamQuanDoi(capBacQuanHamQuanDoi.capBacQuanHamQuanDoi(),
                capBacQuanHamQuanDoi.nameLoaiQuanHam());
    }

    @PatchMapping("/cap-bac-loai-quan-ham-quan-doi/sua")
    public ResDTO<CapBacLoaiQuanHamQuanDoi> editCapBacLoaiQuanHamQuanDoi(CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi) {
        return capBacLoaiQuanHamQuanDoiService.suaCapBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/danh-hieu-nha-nuoc-phong")
    public ResDTO<List<DanhHieuNhaNuocPhongTang>> getAllDanhHieuNhaNuocPhongTang() {
        return danhHieuNhaNuocPhongTangService.xemDanhHieuNhaNuocPhongTang();
    }

    @PostMapping("/danh-hieu-nha-nuoc-phong/them")
    public ResDTO<DanhHieuNhaNuocPhongTang> addDanhHieuNhaNuocPhongTang(@RequestBody ReqUtilities utilities) {
        return danhHieuNhaNuocPhongTangService.themDanhHieuNhaNuocPhongTang(utilities.name());
    }

    @PatchMapping("/danh-hieu-nha-nuoc-phong/sua")
    public ResDTO<DanhHieuNhaNuocPhongTang> editDanhHieuNhaNuocPhongTang(DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang) {
        return danhHieuNhaNuocPhongTangService.suaDanhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/dan-toc")
    public ResDTO<List<DanToc>> getAllDanToc() {
        return danTocService.xemDanToc();
    }

    @PostMapping("/dan-toc/them")
    public ResDTO<DanToc> addDanToc(@RequestBody ReqUtilities utilities) {
        return danTocService.themDanToc(utilities.name());
    }

    @PatchMapping("/dan-toc/sua")
    public ResDTO<DanToc> editDanToc(DanToc toc) {
        return danTocService.suaDanToc(toc);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/doi-tuong-chinh-sach")
    public ResDTO<List<DoiTuongChinhSach>> getAllDoiTuongChinhSach() {
        return doiTuongChinhSachService.xemDoiTuongChinhSach();
    }

    @PostMapping("/doi-tuong-chinh-sach/them")
    public ResDTO<DoiTuongChinhSach> addDoiTuongChinhSach(@RequestBody ReqUtilities utilities) {
        return doiTuongChinhSachService.themDoiTuongChinhSach(utilities.name());
    }

    @PatchMapping("/doi-tuong-chinh-sach/sua")
    public ResDTO<DoiTuongChinhSach> editDoiTuongChinhSach(DoiTuongChinhSach tuongChinhSach) {
        return doiTuongChinhSachService.suaDoiTuongChinhSach(tuongChinhSach);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/gioi-tinh")
    public ResDTO<List<GioiTinh>> getAllGioiTinh() {
        return gioiTinhService.xemGioiTinh();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/hoc-ham")
    public ResDTO<List<HocHam>> getAllHocHam() {
        return hocHamService.xemHocHam();
    }

    @PostMapping("/hoc-ham/them")
    public ResDTO<HocHam> addHocHam(@RequestBody ReqUtilities utilities) {
        return hocHamService.themHocHam(utilities.name());
    }

    @PatchMapping("/hoc-ham/sua")
    public ResDTO<HocHam> editHocHam(HocHam ham) {
        return hocHamService.suaHocHam(ham);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/nhom-mau")
    public ResDTO<List<NhomMau>> getAllNhomMau() {
        return nhomMauService.xemNhomMau();
    }

    @PostMapping("/nhom-mau/them")
    public ResDTO<NhomMau> addNhomMau(@RequestBody ReqUtilities utilities) {
        return nhomMauService.themNhomMau(utilities.name());
    }

    @PatchMapping("/nhom-mau/sua")
    public ResDTO<NhomMau> editNhomMau(NhomMau mau) {
        return nhomMauService.suaNhomMau(mau);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/thanh-phan-gia-dinh")
    public ResDTO<List<ThanhPhanGiaDinh>> getAllThanhPhanGiaDinh() {
        return thanhPhanGiaDinhService.xemThanhPhanGiaDinh();
    }

    @PostMapping("/thanh-phan-gia-dinh/them")
    public ResDTO<ThanhPhanGiaDinh> addThanhPhanGiaDinh(@RequestBody ReqUtilities utilities) {
        return thanhPhanGiaDinhService.themThanhPhanGiaDinh(utilities.name());
    }

    @PatchMapping("/thanh-phan-gia-dinh/sua")
    public ResDTO<ThanhPhanGiaDinh> editThanhPhanGiaDinh(ThanhPhanGiaDinh thanhPhanGiaDinh) {
        return thanhPhanGiaDinhService.suaThanhPhanGiaDinh(thanhPhanGiaDinh);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/tinh-trang-suc-khoe")
    public ResDTO<List<TinhTrangSucKhoe>> getAllTinhTrangSucKhoe() {
        return tinhTrangSucKhoeService.xemTinhTrangSucKhoe();
    }

    @PostMapping("/tinh-trang-suc-khoe/them")
    public ResDTO<TinhTrangSucKhoe> addTinhTrangSucKhoe(@RequestBody ReqUtilities utilities) {
        return tinhTrangSucKhoeService.themTinhTrangSucKhoe(utilities.name());
    }

    @PatchMapping("/tinh-trang-suc-khoe/sua")
    public ResDTO<TinhTrangSucKhoe> editTinhTrangSucKhoe(@RequestBody TinhTrangSucKhoe tinhTrangSucKhoe) {
        return tinhTrangSucKhoeService.suaTinhTrangSucKhoe(tinhTrangSucKhoe);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/ton-giao")
    public ResDTO<List<TonGiao>> getAllTonGiao() {
        return tonGiaoService.xemTonGiao();
    }

    @PostMapping("/ton-giao/them")
    public ResDTO<TonGiao> addTonGiao(@RequestBody ReqUtilities utilities) {
        return tonGiaoService.themTonGiao(utilities.name());
    }

    @PatchMapping("/ton-giao/sua")
    public ResDTO<TonGiao> editTonGiao(@RequestBody TonGiao tonGiao) {
        return tonGiaoService.suaTonGiao(tonGiao);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/trinh-do-chuyen-mon")
    public ResDTO<List<TrinhDoChuyenMon>> getAllTrinhDoChuyenMon() {
        return trinhDoChuyenMonService.xemTrinhDoChuyenMon();
    }

    @PostMapping("/trinh-do-chuyen-mon/them")
    public ResDTO<TrinhDoChuyenMon> addTrinhDoChuyenMon(@RequestBody ReqUtilities utilities) {
        return trinhDoChuyenMonService.themTrinhDoChuyenMon(utilities.name());
    }

    @PatchMapping("/trinh-do-chuyen-mon/sua")
    public ResDTO<TrinhDoChuyenMon> editTrinhDoChuyenMon(@RequestBody TrinhDoChuyenMon trinhDoChuyenMon) {
        return trinhDoChuyenMonService.suaTrinhDoChuyenMon(trinhDoChuyenMon);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/trinh-do-giao-duc-pho-thong")
    public ResDTO<List<TrinhDoGiaoDucPhoThong>> getAllTrinhDoGiaoDucPhoThong() {
        return trinhDoGiaoDucPhoThongService.xemTrinhDoGiaoDucPhoThong();
    }

    @PostMapping("/trinh-do-giao-duc-pho-thong/them")
    public ResDTO<TrinhDoGiaoDucPhoThong> addTrinhDoGiaoDucPhoThong(@RequestBody ReqUtilities utilities) {
        return trinhDoGiaoDucPhoThongService.themTrinhDoGiaoDucPhoThong(utilities.name());
    }

    @PatchMapping("/trinh-do-giao-duc-pho-thong/sua")
    public ResDTO<TrinhDoGiaoDucPhoThong> editTrinhDoGiaoDucPhoThong(@RequestBody TrinhDoGiaoDucPhoThong thong) {
        return trinhDoGiaoDucPhoThongService.suaTrinhDoGiaoDucPhoThong(thong);
    }
}
