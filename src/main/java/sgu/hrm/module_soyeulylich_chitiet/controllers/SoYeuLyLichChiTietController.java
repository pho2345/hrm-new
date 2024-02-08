package sgu.hrm.module_soyeulylich_chitiet.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.services.ISoYeuLyLichChiTietServices;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor // create constructor if field set final or @not null
@RequestMapping(value = "")
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
    /* EMPLOYEE EMPLOYEE EMPLOYEE EMPLOYEE */
    @GetMapping("/tai-khoan/lam-viec-cho-che-do-cu")
    public ResDTO<List<?>> lam_viec_cho_che_do_cu() {
        return banThanCoLamViecChoCheDoCuSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/lam-viec-cho-che-do-cu/{id}")
    public ResDTO<?> id_lam_viec_cho_che_do_cu(@PathVariable int id) {
        return banThanCoLamViecChoCheDoCuSefvice.xemThongTin(id);
    }

    @PostMapping("/tai-khoan/lam-viec-cho-che-do-cu/them")
    public ResDTO<?> them_lam_viec_cho_che_do_cu(@RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
        return banThanCoLamViecChoCheDoCuSefvice.themThongTin(cu);
    }

    @PatchMapping("/tai-khoan/lam-viec-cho-che-do-cu/{id}/sua")
    public ResDTO<?> sua_lam_viec_cho_che_do_cu(@PathVariable int id, @RequestBody ReqBanThanCoLamViecChoCheDoCu cu) {
        return banThanCoLamViecChoCheDoCuSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/tai-khoan/lam-viec-cho-che-do-cu/{id}/xoa")
    public ResDTO<?> xoa_lam_viec_cho_che_do_cu(@PathVariable int id) {
        return banThanCoLamViecChoCheDoCuSefvice.xoaThongTin(id);
    }

    @GetMapping("/tai-khoan/khen-thuong")
    public ResDTO<List<?>> khen_thuong() {
        return khenThuongSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/kien-thuc-an-ninh-quoc-phong")
    public ResDTO<List<?>> kien_thuc_an_ninh_quoc_phong() {
        return kienThucAnNinhQuocPhongSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/ky-luat")
    public ResDTO<List<?>> ky_luat() {
        return kyLuatSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/lam-viec-o-nuoc-ngoai")
    public ResDTO<List<?>> lam_viec_o_nuoc_ngoai() {
        return lamViecONuocNgoaiSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/luong-ban-than")
    public ResDTO<List<?>> luong_ban_than() {
        return luongBanThanSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/luong-ban-than/{id}")
    public ResDTO<?> id_luong_ban_than(@PathVariable int id) {
        return luongBanThanSefvice.xemThongTin(id);
    }

    @PostMapping("/tai-khoan/luong-ban-than/them")
    public ResDTO<?> them_luong_ban_than(@RequestBody ReqLuongBanThan cu) {
        return luongBanThanSefvice.themThongTin(cu);
    }

    @PatchMapping("/tai-khoan/luong-ban-than/{id}/sua")
    public ResDTO<?> sua_luong_ban_than(@PathVariable int id, @RequestBody ReqLuongBanThan cu) {
        return luongBanThanSefvice.suaThongTin(id, cu);
    }

    @DeleteMapping("/tai-khoan/luong-ban-than/{id}/xoa")
    public ResDTO<?> xoa_luong_ban_than(@PathVariable int id) {
        return luongBanThanSefvice.xoaThongTin(id);
    }

    @GetMapping("/tai-khoan/ly-luan-chinh-tri")
    public ResDTO<List<?>> ly_luan_chinh_tri() {
        return lyLuanChinhTriSefvice.xemDanhSachThongTin();
    }

    @PostMapping("/tai-khoan/ly-luan-chinh-tri/them")
    public ResDTO<?> them_ly_luan_chinh_tri(@RequestBody ReqLyLuanChinhTri cu) {
        return lyLuanChinhTriSefvice.themThongTin(cu);
    }

    @GetMapping("/tai-khoan/nghiep-vu-chuyen-nganh")
    public ResDTO<List<?>> nghiep_vu_chuyen_nganh() {
        return nghiepVuChuyenNganhSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/ngoai-ngu")
    public ResDTO<List<?>> ngoai_ngu() {
        return ngoaiNguSefvice.xemDanhSachThongTin();
    }

    @PostMapping("/tai-khoan/ngoai-ngu/them")
    public ResDTO<?> them_ngoai_ngu(@RequestBody ReqNgoaiNgu cu) {
        return ngoaiNguSefvice.themThongTin(cu);
    }

    @GetMapping("/tai-khoan/phu-cap-khac")
    public ResDTO<List<?>> phu_cap_khac() {
        return phuCapKhacSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/quan-he-gia-dinh")
    public ResDTO<List<?>> quan_he_gia_dinh() {
        return quanHeGiaDinhSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/qua-trinh-cong-tac")
    public ResDTO<List<?>> qua_trinh_cong_tac() {
        return quaTrinhCongTacSefvice.xemDanhSachThongTin();
    }

    @GetMapping("/tai-khoan/tin-hoc")
    public ResDTO<List<?>> tin_hoc() {
        return tinHocSefvice.xemDanhSachThongTin();
    }


    /* EMPLOYEE EMPLOYEE EMPLOYEE EMPLOYEE EMPLOYEE EMPLOYEE */


//    @GetMapping("/quan-he-gia-dinh")
//    public ResDTO<List<?>> xemQuanHeGiaDinh() {
//        return quanHeGiaDinhSefvice.xemDanhSachThongTin();
//    }
//
//    @PostMapping("/quan-he-gia-dinh/{id-syll}/them")
//    public ResDTO<List<QuanHeGiaDinh>> addQuanHeGiaDinh(@PathVariable(name = "id-syll") UUID idSYLL, @RequestBody List<ReqQuanHeGiaDinh> giaDinh) {
//        return quanHeGiaDinhSefvice.themPQuanHeGiaDinh(giaDinh.get(0).loaiSoYeuLyLichChiTiet(), idSYLL, giaDinh);
//    }

//    @PatchMapping("/quan-he-gia-dinh/babac3ce-895e-4790-a397-b8fca6d2d897/cap-nhat")
//    public ResDTO<QuanHeGiaDinh> editQuanHeGiaDinh(@RequestBody ReqQuanHeGiaDinh giaDinh) {
//        return quanHeGiaDinhSefvice.suaQuanHeGiaDinh(chiTiet);
//    }
}
