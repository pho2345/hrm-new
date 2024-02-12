package sgu.hrm.module_utilities.controllers;

import lombok.RequiredArgsConstructor;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

@RestController
@RequiredArgsConstructor
public class UtilitiesController {
    private final IUtilitiesService<BacLuong> bacLuongService;
    private final IUtilitiesService<LoaiQuanHamQuanDoi> loaiQuanHamQuanDoiService;
    private final IUtilitiesService<CapBacLoaiQuanHamQuanDoi> capBacLoaiQuanHamQuanDoiService;
    private final IUtilitiesService<DanhHieuNhaNuocPhongTang> danhHieuNhaNuocPhongTangService;
    private final IUtilitiesService<DanToc> danTocService;
    private final IUtilitiesService<DoiTuongChinhSach> doiTuongChinhSachService;
    private final IUtilitiesService<GioiTinh> gioiTinhService;
    private final IUtilitiesService<HocHam> hocHamService;
    private final IUtilitiesService<NhomMau> nhomMauService;
    private final IUtilitiesService<ThanhPhanGiaDinh> thanhPhanGiaDinhService;
    private final IUtilitiesService<TinhTrangSucKhoe> tinhTrangSucKhoeService;
    private final IUtilitiesService<TonGiao> tonGiaoService;
    private final IUtilitiesService<TrinhDoChuyenMon> trinhDoChuyenMonService;
    private final IUtilitiesService<TrinhDoGiaoDucPhoThong> trinhDoGiaoDucPhoThongService;

    @RestController
    class BacLuongController {
        @GetMapping("/bac-luong")
        public ResDTO<?> getAllBacLuong() {
            return bacLuongService.xemDS();
        }

        @PostMapping("/bac-luong/them")
        public ResDTO<?> addBacLuong(@RequestBody ReqUtilities utilities) {
            return bacLuongService.them(utilities.name());
        }

        // khong co requestbody van ok, van hieu do la request body
        @PatchMapping("/bac-luong/sua")
        public ResDTO<?> editBacLuong(@RequestBody BacLuong luong) {
            return bacLuongService.sua(luong);
        }
    }

    @RestController
    class LoaiQuanHamQuanDoiController {
        @GetMapping("/loai-quan-ham-quan-doi")
        public ResDTO<?> getAllLoaiQuanHamQuanDoi() {
            return loaiQuanHamQuanDoiService.xemDS();
        }

        @PostMapping("/loai-quan-ham-quan-doi/them")
        public ResDTO<?> addLoaiQuanHamQuanDoi(@RequestBody ReqUtilities utilities) {
            return loaiQuanHamQuanDoiService.them(utilities.name());
        }

        @PatchMapping("/loai-quan-ham-quan-doi/sua")
        public ResDTO<?> editLoaiQuanHamQuanDoi(@RequestBody LoaiQuanHamQuanDoi loaiQuanHamQuanDoi) {
            return loaiQuanHamQuanDoiService.sua(loaiQuanHamQuanDoi);
        }
    }

    @RestController
    class CapBacLoaiQuanHamQuanDoiController {
        @GetMapping("/cap-bac-loai-quan-ham-quan-doi")
        public ResDTO<?> getAllCapBacLoaiQuanHamQuanDoi() {
            return capBacLoaiQuanHamQuanDoiService.xemDS();
        }

        @PostMapping("/cap-bac-loai-quan-ham-quan-doi/them")
        public ResDTO<?> addCapBacLoaiQuanHamQuanDoi(@RequestBody ReqCapBacQuanHamQuanDoi capBacQuanHamQuanDoi) {
            return capBacLoaiQuanHamQuanDoiService.themCapBacLoaiQuanHamQuanDoi(capBacQuanHamQuanDoi.capBacQuanHamQuanDoi(),
                    capBacQuanHamQuanDoi.nameLoaiQuanHam());
        }

        @PatchMapping("/cap-bac-loai-quan-ham-quan-doi/sua")
        public ResDTO<?> editCapBacLoaiQuanHamQuanDoi(CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi) {
            return capBacLoaiQuanHamQuanDoiService.sua(capBacLoaiQuanHamQuanDoi);
        }
    }

    @RestController
    class DanhHieuNhaNuocPhongTangController {
        @GetMapping("/danh-hieu-nha-nuoc-phong")
        public ResDTO<?> getAllDanhHieuNhaNuocPhongTang() {
            return danhHieuNhaNuocPhongTangService.xemDS();
        }

        @PostMapping("/danh-hieu-nha-nuoc-phong/them")
        public ResDTO<?> addDanhHieuNhaNuocPhongTang(@RequestBody ReqUtilities utilities) {
            return danhHieuNhaNuocPhongTangService.them(utilities.name());
        }

        @PatchMapping("/danh-hieu-nha-nuoc-phong/sua")
        public ResDTO<?> editDanhHieuNhaNuocPhongTang(DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang) {
            return danhHieuNhaNuocPhongTangService.sua(danhHieuNhaNuocPhongTang);
        }
    }

    @RestController
    class DanTocController {
        @GetMapping("/dan-toc")
        public ResDTO<?> getAllDanToc() {
            return danTocService.xemDS();
        }

        @PostMapping("/dan-toc/them")
        public ResDTO<?> addDanToc(@RequestBody ReqUtilities utilities) {
            return danTocService.them(utilities.name());
        }

        @PatchMapping("/dan-toc/sua")
        public ResDTO<?> editDanToc(DanToc toc) {
            return danTocService.sua(toc);
        }

    }

    @RestController
    class DoiTuongChinhSachController {
        @GetMapping("/doi-tuong-chinh-sach")
        public ResDTO<?> getAllDoiTuongChinhSach() {
            return doiTuongChinhSachService.xemDS();
        }

        @PostMapping("/doi-tuong-chinh-sach/them")
        public ResDTO<?> addDoiTuongChinhSach(@RequestBody ReqUtilities utilities) {
            return doiTuongChinhSachService.them(utilities.name());
        }

        @PatchMapping("/doi-tuong-chinh-sach/sua")
        public ResDTO<?> editDoiTuongChinhSach(DoiTuongChinhSach tuongChinhSach) {
            return doiTuongChinhSachService.sua(tuongChinhSach);
        }

    }

    @RestController
    class GioiTinhController {
        @GetMapping("/gioi-tinh")
        public ResDTO<?> getAllGioiTinh() {
            return gioiTinhService.xemDS();
        }

    }

    @RestController
    class HocHamController {
        @GetMapping("/hoc-ham")
        public ResDTO<?> getAllHocHam() {
            return hocHamService.xemDS();
        }

        @PostMapping("/hoc-ham/them")
        public ResDTO<?> addHocHam(@RequestBody ReqUtilities utilities) {
            return hocHamService.them(utilities.name());
        }

        @PatchMapping("/hoc-ham/sua")
        public ResDTO<?> editHocHam(HocHam ham) {
            return hocHamService.sua(ham);
        }

    }

    @RestController
    class NhomMauController {
        @GetMapping("/nhom-mau")
        public ResDTO<?> getAllNhomMau() {
            return nhomMauService.xemDS();
        }

        @PostMapping("/nhom-mau/them")
        public ResDTO<?> addNhomMau(@RequestBody ReqUtilities utilities) {
            return nhomMauService.them(utilities.name());
        }

        @PatchMapping("/nhom-mau/sua")
        public ResDTO<?> editNhomMau(NhomMau mau) {
            return nhomMauService.sua(mau);
        }

    }

    @RestController
    class ThanhPhanGiaDinhController {
        @GetMapping("/thanh-phan-gia-dinh")
        public ResDTO<?> getAllThanhPhanGiaDinh() {
            return thanhPhanGiaDinhService.xemDS();
        }

        @PostMapping("/thanh-phan-gia-dinh/them")
        public ResDTO<?> addThanhPhanGiaDinh(@RequestBody ReqUtilities utilities) {
            return thanhPhanGiaDinhService.them(utilities.name());
        }

        @PatchMapping("/thanh-phan-gia-dinh/sua")
        public ResDTO<?> editThanhPhanGiaDinh(ThanhPhanGiaDinh thanhPhanGiaDinh) {
            return thanhPhanGiaDinhService.sua(thanhPhanGiaDinh);
        }

    }

    @RestController
    class TinhTrangSucKhoeController {
        @GetMapping("/tinh-trang-suc-khoe")
        public ResDTO<?> getAllTinhTrangSucKhoe() {
            return tinhTrangSucKhoeService.xemDS();
        }

        @PostMapping("/tinh-trang-suc-khoe/them")
        public ResDTO<?> addTinhTrangSucKhoe(@RequestBody ReqUtilities utilities) {
            return tinhTrangSucKhoeService.them(utilities.name());
        }

        @PatchMapping("/tinh-trang-suc-khoe/sua")
        public ResDTO<?> editTinhTrangSucKhoe(@RequestBody TinhTrangSucKhoe tinhTrangSucKhoe) {
            return tinhTrangSucKhoeService.sua(tinhTrangSucKhoe);
        }

    }

    @RestController
    class TonGiaoController {
        @GetMapping("/ton-giao")
        public ResDTO<?> getAllTonGiao() {
            return tonGiaoService.xemDS();
        }

        @PostMapping("/ton-giao/them")
        public ResDTO<?> addTonGiao(@RequestBody ReqUtilities utilities) {
            return tonGiaoService.them(utilities.name());
        }

        @PatchMapping("/ton-giao/sua")
        public ResDTO<?> editTonGiao(@RequestBody TonGiao tonGiao) {
            return tonGiaoService.sua(tonGiao);
        }

    }

    @RestController
    class TrinhDoChuyenMonController {
        @GetMapping("/trinh-do-chuyen-mon")
        public ResDTO<?> getAllTrinhDoChuyenMon() {
            return trinhDoChuyenMonService.xemDS();
        }

        @PostMapping("/trinh-do-chuyen-mon/them")
        public ResDTO<?> addTrinhDoChuyenMon(@RequestBody ReqUtilities utilities) {
            return trinhDoChuyenMonService.them(utilities.name());
        }

        @PatchMapping("/trinh-do-chuyen-mon/sua")
        public ResDTO<?> editTrinhDoChuyenMon(@RequestBody TrinhDoChuyenMon trinhDoChuyenMon) {
            return trinhDoChuyenMonService.sua(trinhDoChuyenMon);
        }
    }

    @RestController
    class TrinhDoGiaoDucPhoThongController {
        @GetMapping("/trinh-do-giao-duc-pho-thong")
        public ResDTO<?> getAllTrinhDoGiaoDucPhoThong() {
            return trinhDoGiaoDucPhoThongService.xemDS();
        }

        @PostMapping("/trinh-do-giao-duc-pho-thong/them")
        public ResDTO<?> addTrinhDoGiaoDucPhoThong(@RequestBody ReqUtilities utilities) {
            return trinhDoGiaoDucPhoThongService.them(utilities.name());
        }

        @PatchMapping("/trinh-do-giao-duc-pho-thong/sua")
        public ResDTO<?> editTrinhDoGiaoDucPhoThong(@RequestBody TrinhDoGiaoDucPhoThong thong) {
            return trinhDoGiaoDucPhoThongService.sua(thong);
        }
    }
}
