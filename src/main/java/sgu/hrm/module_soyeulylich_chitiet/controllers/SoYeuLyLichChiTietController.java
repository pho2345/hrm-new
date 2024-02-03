package sgu.hrm.module_soyeulylich_chitiet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
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
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.services.ISoYeuLyLichChiTietServices;
import sgu.hrm.module_soyeulylich_chitiet.services.SoYeuLyLichChiTietServices;

import java.util.List;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
@RequestMapping(value = "/api/v1")
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
    public ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet() {
        return loaiSoYeuLyLichChiTietSefvice.xemLoaiSoYeuLyLichChiTiet();
    }

    @PostMapping("/loai-so-yeu-ly-lich-chi-tiet/them")
    public ResDTO<LoaiSoYeuLyLichChiTiet> addLoaiSoYeuLyLichChiTiet(@RequestBody ReqLoaiSoYeuLyLichChiTiet chiTiet) {
        return loaiSoYeuLyLichChiTietSefvice.themLoaiSoYeuLyLichChiTiet(chiTiet);
    }

    @PatchMapping("/loai-so-yeu-ly-lich-chi-tiet/sua")
    public ResDTO<LoaiSoYeuLyLichChiTiet> editLoaiSoYeuLyLichChiTiet(@RequestBody LoaiSoYeuLyLichChiTiet chiTiet) {
        return loaiSoYeuLyLichChiTietSefvice.suaLoaiSoYeuLyLichChiTiet(chiTiet);
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/quan-he-gia-dinh")
    public ResDTO<List<QuanHeGiaDinh>> xemQuanHeGiaDinh() {
        return quanHeGiaDinhSefvice.xemQuanHeGiaDinh();
    }

    @PostMapping("/quan-he-gia-dinh/{loai-syll}/them")
    public ResDTO<List<QuanHeGiaDinh>> addQuanHeGiaDinh(@RequestBody List<ReqQuanHeGiaDinh> giaDinh) {
        return quanHeGiaDinhSefvice.themPQuanHeGiaDinh(giaDinh.get(0).loaiSoYeuLyLichChiTiet(), giaDinh.get(0).soYeuLyLich(), giaDinh);
    }

//    @PatchMapping("/quan-he-gia-dinh/sua")
//    public ResDTO<QuanHeGiaDinh> editQuanHeGiaDinh(@RequestBody ReqQuanHeGiaDinh giaDinh) {
//        return quanHeGiaDinhSefvice.suaQuanHeGiaDinh(chiTiet);
//    }
}
