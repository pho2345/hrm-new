package sgu.hrm.module_soyeulylich_chitiet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.services.ISoYeuLyLichChiTietServices;

import java.util.List;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
@RequestMapping(value = "/api/v1/so-yeu-ly-lich-chi-tiet")
public class SoYeuLyLichChiTietController {
    private final ISoYeuLyLichChiTietServices.ILoaiSoYeuLyLichChiTietSefvice loaiSoYeuLyLichChiTietSefvice;
    private final ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice banThanCoLamViecChoCheDoCuSefvice;
    private final ISoYeuLyLichChiTietServices.IKhenThuongSefvice khenThuongSefvice;
    private final ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice kienThucAnNinhQuocPhongSefvice;
    private final ISoYeuLyLichChiTietServices.IKyLuatSefvice kyLuatSefvice;
    private final ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice lamViecONuocNgoaiSefvice;
    private final ISoYeuLyLichChiTietServices.ILuongBanThanSefvice luongBanThanSefvice;
    private final ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice lyLuanChinhTriSefvice;
    private final ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice nghiepVuChuyenNganhSefvice;
    private final ISoYeuLyLichChiTietServices.INgoaiNguSefvice ngoaiNguSefvice;
    private final ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice phuCapKhacSefvice;
    private final ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice quanHeGiaDinhSefvice;
    private final ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice quaTrinhCongTacSefvice;
    private final ISoYeuLyLichChiTietServices.ITinHocSefvice tinHocSefvice;

    @GetMapping("/loai-so-yeu-ly-lich-chi-tiet")
    public List<LoaiSoYeuLyLichChiTiet> getAllLoaiSoYeuLyLichChiTiet() {
        return loaiSoYeuLyLichChiTietSefvice.xemLoaiSoYeuLyLichChiTiet();
    }

    @GetMapping("/ban-than-co-lam-viec-cho-che-do-cu")
    public List<BanThanCoLamViecChoCheDoCu> getAllBanThanCoLamViecChoCheDoCu() {
        return banThanCoLamViecChoCheDoCuSefvice.xemBanThanCoLamViecChoCheDoCu();
    }
    @GetMapping("/khen-thuong")
    public List<KhenThuong> getAllKhenThuong() {
        return khenThuongSefvice.xemKhenThuong();
    }
    @GetMapping("/kien-thuc-an-ninh-quoc-phong")
    public List<KienThucAnNinhQuocPhong> getAllKienThucAnNinhQuocPhong() {
        return kienThucAnNinhQuocPhongSefvice.xemKienThucAnNinhQuocPhong();
    }
    @GetMapping("/ky-luat")
    public List<KyLuat> getAllKyLuat() {
        return kyLuatSefvice.xemKyLuat();
    }
    @GetMapping("/lam-viec-o-nuoc-ngoai")
    public List<LamViecONuocNgoai> getAllLamViecONuocNgoai() {
        return lamViecONuocNgoaiSefvice.xemLamViecONuocNgoai();
    }
    @GetMapping("/luong-ban-than")
    public List<LuongBanThan> getAllLuongBanThan() {
        return luongBanThanSefvice.xemLuongBanThan();
    }
    @GetMapping("/ly-luan-chinh-tri")
    public List<LyLuanChinhTri> getAllLyLuanChinhTri() {
        return lyLuanChinhTriSefvice.xemLyLuanChinhTri();
    }
    @GetMapping("/nghiep-vu-chuyen-nganh")
    public List<NghiepVuChuyenNganh> getAllNghiepVuChuyenNganh() {
        return nghiepVuChuyenNganhSefvice.xemNghiepVuChuyenNganh();
    }
    @GetMapping("/ngoai-ngu")
    public List<NgoaiNgu> getAllNgoaiNgu() {
        return ngoaiNguSefvice.xemNgoaiNgu();
    }
    @GetMapping("/phu-cap-khac")
    public List<PhuCapKhac> getAllPhuCapKhac() {
        return phuCapKhacSefvice.xemPhuCapKhac();
    }
    @GetMapping("/quan-he-gia-dinh")
    public List<QuanHeGiaDinh> getAllQuanHeGiaDinh() {
        return quanHeGiaDinhSefvice.xemQuanHeGiaDinh();
    }

    @GetMapping("/qua-trinh-cong-tac")
    public List<QuaTrinhCongTac> getAllQuaTrinhCongTac() {
        return quaTrinhCongTacSefvice.xemQuaTrinhCongTac();
    }
    @GetMapping("/tin-hoc")
    public List<TinHoc> getAllTinHoc() {
        return tinHocSefvice.xemTinHoc();
    }
}
