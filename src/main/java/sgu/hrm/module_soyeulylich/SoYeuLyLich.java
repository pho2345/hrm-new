package sgu.hrm.module_soyeulylich;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
import sgu.hrm.models.DanToc;
import sgu.hrm.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.models.DoiTuongChinhSach;
import sgu.hrm.models.GioiTinh;
import sgu.hrm.models.HocHam;
import sgu.hrm.models.KhenThuong;
import sgu.hrm.models.KienThucAnNinhQuocPhong;
import sgu.hrm.models.KyLuat;
import sgu.hrm.models.LamViecONuocNgoai;
import sgu.hrm.models.LuongBanThan;
import sgu.hrm.models.LyLuanChinhTri;
import sgu.hrm.models.NghiepVuChuyenNganh;
import sgu.hrm.models.NgoaiNgu;
import sgu.hrm.models.NhomMau;
import sgu.hrm.models.PhuCapKhac;
import sgu.hrm.models.QuaTrinhCongTac;
import sgu.hrm.models.QuanHeGiaDinhRuot;
import sgu.hrm.models.QuanHeGiaDinhRuotBenVoHoacChong;
import sgu.hrm.models.ThanhPhanGiaDinh;
import sgu.hrm.models.TinHoc;
import sgu.hrm.models.TinhTrangSucKhoe;
import sgu.hrm.models.TrinhDoChuyenMon;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/*
 * xung đột khi khai báo biến
 * khi dùng columnDefinition trong annotation
 * */

@Entity
@Table(name = "so_yeu_ly_lich")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLich extends DateTimeObject {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "ho_va_ten", columnDefinition = "varchar(50)")
    String hovaten;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "gioi_tinh_fk"), name = "gioi_tinh", referencedColumnName = "id", columnDefinition = "tinyint")
    GioiTinh gioiTinh;

    @Column(name = "cac_ten_goi_khac", columnDefinition = "varchar(50) default ''")
    String cacTenGoiKhac;

    @Column(name = "sinh_ngay", columnDefinition = "datetime")
    LocalDateTime sinhNgay;

    @Column(name = "noi_sinh", length = 100)
    String noiSinh;

    @Column(name = "que_quan", length = 100)
    String queQuan;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "dan_toc_fk"), name = "dan_toc", referencedColumnName = "id", columnDefinition = "int")
    DanToc danToc;

    @Column(name = "so_cccd", length = 12)
    String soCCCD;

    @Column(name = "ngay_cap_cccd", columnDefinition = "datetime")
    LocalDateTime ngayCapCCCD;

    @Column(name = "so_dien_thoai", length = 12)
    String soDienThoai;

    @Column(name = "so_bhxh", length = 10)
    String soBHXH;

    @Column(name = "so_bhyt", length = 15)
    String soBHYT;

    @Column(name = "noi_o_hien_nay", length = 100)
    String noiOHienNay;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "thanh_phan_gia_dinh_fk"), name = "thanh_phan_gia_dinh_xuat_than", referencedColumnName = "id", columnDefinition = "tinyint")
    ThanhPhanGiaDinh thanhPhanGiaDinh;

    @Column(name = "nghe_nghiep_truoc_khi_duoc_tuyen_dung", columnDefinition = "varchar(100) default 'Không nghề nghiệp'")
    String ngheNghiepTruocKhiTuyenDung;

    @Column(name = "ngay_duoc_tuyen_dung_lan_dau", columnDefinition = "datetime")
    LocalDateTime ngayDuocTuyenDungLanDau;
    // error
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "coquan_tochuc_donvi_tuyendung_fk"), name = "coquan_tochuc_donvi_tuyendung_syll", referencedColumnName = "id", columnDefinition = "tinyint")
    CoQuanToChucDonViTuyenDung coQuanToChucDonViTuyenDung;

    @Column(name = "ngay_vao_co_quan_hien_dang_cong_tac", columnDefinition = "datetime")
    LocalDateTime ngayVaoCoQuanHienDangCongTac;

    @Column(name = "ngay_vao_dang_cong_san_viet_nam", columnDefinition = "datetime")
    LocalDateTime ngayVaoDangCongSanVietNam;

    @Column(name = "ngay_chinh_thuc", columnDefinition = "datetime")
    LocalDateTime ngayChinhThuc;

    @Column(name = "ngay_tham_gia_to_chuc_chinh_tri_xa_hoi_dau_tien", columnDefinition = "datetime")
    LocalDateTime ngayThamGiaToChucChinhTriXaHoiDauTien;

    @Column(name = "ngay_nhap_ngu", columnDefinition = "datetime")
    LocalDateTime ngayNhapNgu;

    @Column(name = "ngay_xuat_ngu", columnDefinition = "datetime")
    LocalDateTime ngayXuatNgu;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "cap_bac_loai_quan_ham_quan_doi_fk"), name = "quan_ham_cao_nhat", referencedColumnName = "id", columnDefinition = "integer")
    CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "doi_tuong_chinh_sach_fk"), name = "doi_tuong_chinh_sach", referencedColumnName = "id", columnDefinition = "integer")
    DoiTuongChinhSach doiTuongChinhSach;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "trinh_do_giao_duc_pho_thong_fk"), name = "trinh_do_giao_duc_pho_thong", referencedColumnName = "id", columnDefinition = "integer")
    TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "trinh_do_chuyen_mon_fk"), name = "trinh_do_chuyen_mon_cao_nhat", referencedColumnName = "id", columnDefinition = "integer")
    TrinhDoChuyenMon trinhDoChuyenMon;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "hoc_ham_fk"), name = "hoc_ham", referencedColumnName = "id", columnDefinition = "integer")
    HocHam hocHam;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "danh_hieu_nha_nuoc_phong_tang_fk"), name = "danh_hieu_nha_nuoc_phong_tang", referencedColumnName = "id", columnDefinition = "integer")
    DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang;

    @Column(name = "chuc_vu_hien_tai", columnDefinition = "varchar(150)")
    String chucVuHienTai;

    @Column(name = "ngay_bo_nhiem", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiem;

    @Column(name = "ngay_bo_nhiem_lai", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemLai;

    @Column(name = "duoc_quy_hoach_chuc_danh", columnDefinition = "varchar(50) default ''")
    String duocQuyHoacChucDanh;

    @Column(name = "chuc_vu_kiem_nhiem", columnDefinition = "varchar(150) default ''")
    String chucVuKiemNhiem;

    //    fix !!!
    @Column(name = "chuc_vu_dang_hien_tai", columnDefinition = "varchar(100)")
    String chucVuDangHienTai;

    //    fix !!!
    @Column(name = "chuc_vu_dang_kiem_nhiem", columnDefinition = "varchar(100)")
    String chucVuDangKiemNhiem;

    @Column(name = "cong_viec_chinh_duoc_giao", columnDefinition = "varchar(150) default ''")
    String congVienChinhDuocGiao;

    @Column(name = "so_truong_cong_tac", columnDefinition = "varchar(150) default ''")
    String soTruongCongTac;

    @Column(name = "cong_viec_lam_lau_nhat", columnDefinition = "varchar(150) default ''")
    String congViecLamLauNhat;

    @Column(name = "tien_luong", columnDefinition = "double")
    double tienLuong;

    @Column(name = "ngach_nghe_nghiep", length = 100)
    String ngachNgheNghiep;

    @Column(name = "ma_so_ngach_nghe_nghiep", length = 10)
    String maSoNgachNgheNghiep;

    @Column(name = "ngay_bo_nhiem_ngach_nghe_nghiep", columnDefinition = "datetime")
    LocalDateTime ngayBoNhiemNgachNgheNghiep;

    @ManyToOne
    @JoinColumn(name = "bac_luong_ngach_nghe_nghiep", referencedColumnName = "id", columnDefinition = "INTEGER")
    BacLuong bacLuong;

    @Column(name = "he_so_luong_ngach_nghe_nghiep", columnDefinition = "float")
    float heSoLuongNgachNgheNghiep;

    @Column(name = "ngay_huong_luong_ngach_nghe_nghiep", columnDefinition = "datetime")
    LocalDateTime ngayHuongLuongNgachNgheNghiep;

    @Column(name = "phan_tram_huong_luong_ngach_nghe_nghiep", columnDefinition = "double")
    double phanTramHuongLuongNgachNgheNghiep;

    @Column(name = "phu_cap_tham_nien_vuot_khung_ngach_nghe_nghiep", columnDefinition = "float")
    float phuCapThamNienVuotKhungNgachNgheNghiep;

    @Column(name = "ngay_huong_PCTNVK_ngach_nghe_nghiep", columnDefinition = "datetime")
    LocalDateTime ngayHuongPCTNVKNgachNgheNghiep;

    @Column(name = "phu_cap_chuc_vu", columnDefinition = "float")
    float phuCapChucVu;

    @Column(name = "phu_cap_kiem_nhiem", columnDefinition = "float")
    float phuCapKiemNhiem;

    @Column(name = "phu_cap_khac", columnDefinition = "float")
    float phuCapKhac;

    @Column(name = "vi_tri_viec_lam", length = 50)
    String viTriViecLam;

    @Column(name = "ma_so_vi_tri_viec_lam", length = 10)
    String maSoViTriViecLam;

    @Column(name = "bac_luong_vi_tri_viec_lam", columnDefinition = "double")
    double bacLuongTriViecLam;

    @Column(name = "luong_theo_muc_tien", columnDefinition = "double")
    double luongTheoMucTien;

    @Column(name = "ngay_huong_luong_vi_tri_viec_lam", columnDefinition = "datetime")
    LocalDateTime ngayHuongLuongTheoViTriViecLam;

    @Column(name = "phan_tram_huong_luong", columnDefinition = "double")
    double phamTramHuongLuong;

    @Column(name = "phu_cap_tham_nien_vuot_khung", columnDefinition = "float")
    double phuCapThamNienVuotKhung;

    @Column(name = "ngay_huong_PCTNVK", columnDefinition = "datetime")
    LocalDateTime ngayHuongPCTNVK;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="tinh_trang_suc_khoe_fk"), name = "tinh_trang_suc_khoe", columnDefinition = "INTEGER")
    TinhTrangSucKhoe tinhTrangSucKhoe;

    @Column(name = "chieu_cao", columnDefinition = "float")
    double chieuCao;

    @Column(name = "can_nang", columnDefinition = "float")
    double canNang;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name="nhom_mau_fk"), name = "nhom_mau", columnDefinition = "tinyint")
    NhomMau nhomMau;

    // có chuyện môn nhưng tui làm bảng trung gian
    // chứa id SoYeuLyLich va ChuyenMon

    // liên kết 2 chiều
    // tai sao list thi lay ok ma set thi méo lấy
    @OneToMany(mappedBy = "soYeuLyLich")
    List<LyLuanChinhTri> lyLuanChinhTris;

    //liên kết 2 chiều
    @OneToMany(mappedBy = "soYeuLyLich")
    Set<NghiepVuChuyenNganh> nghiepVuChuyenNganhs;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<TinHoc> tinHocs;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<NgoaiNgu> ngoaiNgus;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<QuaTrinhCongTac> quaTrinhCongTacs;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<LamViecONuocNgoai> lamViecONuocNgoais;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<KhenThuong> khenThuongs;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<KyLuat> kyLuats;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<QuanHeGiaDinhRuot> quanHeGiaDinhRuots;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<QuanHeGiaDinhRuotBenVoHoacChong> quanHeGiaDinhRuotBenVoHoacChongs;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<LuongBanThan> luongBanThans;

    @OneToMany(mappedBy = "soYeuLyLich", cascade = CascadeType.ALL, orphanRemoval = true)
    Set<PhuCapKhac> phuCapKhacs;
}
