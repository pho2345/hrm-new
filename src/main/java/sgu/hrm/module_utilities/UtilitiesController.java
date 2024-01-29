package sgu.hrm.module_utilities;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.services.IUtilitiesService;
import sgu.hrm.module_utilities.services.UtilitiesService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/utilities")
public class UtilitiesController {
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

    public UtilitiesController(IUtilitiesService.ICapBacLoaiQuanHamQuanDoiService capBacLoaiQuanHamQuanDoiService,
                               IUtilitiesService.IDanhHieuNhaNuocPhongTangService danhHieuNhaNuocPhongTangService,
                               IUtilitiesService.IDanTocService danTocService, IUtilitiesService.IDoiTuongChinhSachService doiTuongChinhSachService,
                               IUtilitiesService.IGioiTinhService gioiTinhService, IUtilitiesService.IHocHamService hocHamService,
                               IUtilitiesService.INhomMauService nhomMauService, IUtilitiesService.IThanhPhanGiaDinhService thanhPhanGiaDinhService,
                               IUtilitiesService.ITinhTrangSucKhoeService tinhTrangSucKhoeService, IUtilitiesService.ITonGiaoService tonGiaoService,
                               IUtilitiesService.ITrinhDoChuyenMonService trinhDoChuyenMonService, IUtilitiesService.ITrinhDoGiaoDucPhoThongService trinhDoGiaoDucPhoThongService) {
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

    @GetMapping("/cap-bac-loai-quan-ham-quan-doi")
    public List<CapBacLoaiQuanHamQuanDoi> getAllCapBacLoaiQuanHamQuanDoi() {
        return capBacLoaiQuanHamQuanDoiService.xemCapBacLoaiQuanHamQuanDoi();
    }

    @GetMapping("/danh-hieu-nha-nuoc-phong")
    public List<DanhHieuNhaNuocPhongTang> getAllDanhHieuNhaNuocPhongTang() {
        return danhHieuNhaNuocPhongTangService.xemDanhHieuNhaNuocPhongTang();
    }

    @GetMapping("/dan-toc")
    public List<DanToc> getAllDanToc() {
        return danTocService.xemDanToc();
    }

    @GetMapping("/doi-tuong-chinh-sach")
    public List<DoiTuongChinhSach> getAllDoiTuongChinhSach() {
        return doiTuongChinhSachService.xemDoiTuongChinhSach();
    }

    @GetMapping("/gioi-tinh")
    public List<GioiTinh> getAllGioiTinh() {
        return gioiTinhService.xemGioiTinh();
    }

    @GetMapping("/hoc-ham")
    public List<HocHam> getAllHocHam() {
        return hocHamService.xemHocHam();
    }

    @GetMapping("/nhom-mau")
    public List<NhomMau> getAllNhomMau() {
        return nhomMauService.xemNhomMau();
    }

    @GetMapping("/thanh-phan-gia-dinh")
    public List<ThanhPhanGiaDinh> getAllThanhPhanGiaDinh() {
        return thanhPhanGiaDinhService.xemThanhPhanGiaDinh();
    }

    @GetMapping("/tinh-trang-suc-khoe")
    public List<TinhTrangSucKhoe> getAllTinhTrangSucKhoe() {
        return tinhTrangSucKhoeService.xemTinhTrangSucKhoe();
    }

    @GetMapping("/ton-giao")
    public List<TonGiao> getAllTonGiao() {
        return tonGiaoService.xemTonGiao();
    }

    @GetMapping("/trinh-do-chuyen-mon")
    public List<TrinhDoChuyenMon> getAllTrinhDoChuyenMon() {
        return trinhDoChuyenMonService.xemTrinhDoChuyenMon();
    }

    @GetMapping("/trinh-do-giao-duc-pho-thong")
    public List<TrinhDoGiaoDucPhoThong> getAllTrinhDoGiaoDucPhoThong() {
        return trinhDoGiaoDucPhoThongService.xemTrinhDoGiaoDucPhoThong();
    }
    //    @RestController
//    @RequestMapping(value = "/dan-toc")
//    class DanTocController{
//        @GetMapping("")
//        public List<DanToc> getAllDanToc() {
//            return null;
//        }
//    }
}
