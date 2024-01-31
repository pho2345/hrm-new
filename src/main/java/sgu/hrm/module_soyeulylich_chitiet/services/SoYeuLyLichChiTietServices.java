package sgu.hrm.module_soyeulylich_chitiet.services;

import org.springframework.stereotype.Service;

import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
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

import sgu.hrm.module_soyeulylich_chitiet.repositories.BanThanCoLamViecChoCheDoCuRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KhenThuongRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KienThucAnNinhQuocPhongRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KyLuatRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LamViecONuocNgoaiRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LoaiSoYeuLyLichChiTietRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LuongBanThanRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LyLuanChinhTriRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.NghiepVuChuyenNganhRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.NgoaiNguRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.PhuCapKhacRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.QuaTrinhCongTacRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.QuanHeGiaDinhRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.TinHocRepository;

import java.util.List;

@Service
public class SoYeuLyLichChiTietServices implements
        ISoYeuLyLichChiTietServices.ILoaiSoYeuLyLichChiTietSefvice,
        ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice,
        ISoYeuLyLichChiTietServices.IKhenThuongSefvice,
        ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice,
        ISoYeuLyLichChiTietServices.IKyLuatSefvice,
        ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice,
        ISoYeuLyLichChiTietServices.ILuongBanThanSefvice,
        ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice,
        ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice,
        ISoYeuLyLichChiTietServices.INgoaiNguSefvice,
        ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice,
        ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice,
        ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice,
        ISoYeuLyLichChiTietServices.ITinHocSefvice {
    //DI
    private final LoaiSoYeuLyLichChiTietRepository loaiSoYeuLyLichChiTietRepository;
    private final BanThanCoLamViecChoCheDoCuRepository banThanCoLamViecChoCheDoCuRepository;
    private final KhenThuongRepository khenThuongRepository;
    private final KienThucAnNinhQuocPhongRepository kienThucAnNinhQuocPhongRepository;
    private final KyLuatRepository kyLuatRepository;
    private final LamViecONuocNgoaiRepository lamViecONuocNgoaiRepository;
    private final LuongBanThanRepository luongBanThanRepository;
    private final LyLuanChinhTriRepository lyLuanChinhTriRepository;
    private final NghiepVuChuyenNganhRepository nghiepVuChuyenNganhRepository;
    private final NgoaiNguRepository ngoaiNguRepository;
    private final PhuCapKhacRepository phuCapKhacRepository;
    private final QuanHeGiaDinhRepository quanHeGiaDinhRepository;
    private final QuaTrinhCongTacRepository quaTrinhCongTacRepository;
    private final TinHocRepository tinHocRepository;

    public SoYeuLyLichChiTietServices(BanThanCoLamViecChoCheDoCuRepository banThanCoLamViecChoCheDoCuRepository, LoaiSoYeuLyLichChiTietRepository loaiSoYeuLyLichChiTietRepository,
                                      KhenThuongRepository khenThuongRepository, KienThucAnNinhQuocPhongRepository kienThucAnNinhQuocPhongRepository,
                                      KyLuatRepository kyLuatRepository, LamViecONuocNgoaiRepository lamViecONuocNgoaiRepository,
                                      LuongBanThanRepository luongBanThanRepository, LyLuanChinhTriRepository lyLuanChinhTriRepository,
                                      NghiepVuChuyenNganhRepository nghiepVuChuyenNganhRepository, NgoaiNguRepository ngoaiNguRepository,
                                      PhuCapKhacRepository phuCapKhacRepository, QuanHeGiaDinhRepository quanHeGiaDinhRepository,
                                      QuaTrinhCongTacRepository quaTrinhCongTacRepository, TinHocRepository tinHocRepository) {
        this.loaiSoYeuLyLichChiTietRepository = loaiSoYeuLyLichChiTietRepository;
        this.banThanCoLamViecChoCheDoCuRepository = banThanCoLamViecChoCheDoCuRepository;
        this.khenThuongRepository = khenThuongRepository;
        this.kienThucAnNinhQuocPhongRepository = kienThucAnNinhQuocPhongRepository;
        this.kyLuatRepository = kyLuatRepository;
        this.lamViecONuocNgoaiRepository = lamViecONuocNgoaiRepository;
        this.luongBanThanRepository = luongBanThanRepository;
        this.lyLuanChinhTriRepository = lyLuanChinhTriRepository;
        this.nghiepVuChuyenNganhRepository = nghiepVuChuyenNganhRepository;
        this.ngoaiNguRepository = ngoaiNguRepository;
        this.phuCapKhacRepository = phuCapKhacRepository;
        this.quanHeGiaDinhRepository = quanHeGiaDinhRepository;
        this.quaTrinhCongTacRepository = quaTrinhCongTacRepository;
        this.tinHocRepository = tinHocRepository;
    }

    @Override
    public List<LoaiSoYeuLyLichChiTiet> xemLoaiSoYeuLyLichChiTiet() {
        return loaiSoYeuLyLichChiTietRepository.findAll();
    }

    @Override
    public List<BanThanCoLamViecChoCheDoCu> xemBanThanCoLamViecChoCheDoCu() {
        return banThanCoLamViecChoCheDoCuRepository.findAll();
    }

    @Override
    public List<KhenThuong> xemKhenThuong() {
        return khenThuongRepository.findAll();
    }

    @Override
    public List<KienThucAnNinhQuocPhong> xemKienThucAnNinhQuocPhong() {
        return kienThucAnNinhQuocPhongRepository.findAll();
    }

    @Override
    public List<KyLuat> xemKyLuat() {
        return kyLuatRepository.findAll();
    }

    @Override
    public List<LamViecONuocNgoai> xemLamViecONuocNgoai() {
        return lamViecONuocNgoaiRepository.findAll();
    }

    @Override
    public List<LuongBanThan> xemLuongBanThan() {
        return luongBanThanRepository.findAll();
    }

    @Override
    public List<LyLuanChinhTri> xemLyLuanChinhTri() {
        return lyLuanChinhTriRepository.findAll();
    }

    @Override
    public List<NghiepVuChuyenNganh> xemNghiepVuChuyenNganh() {
        return nghiepVuChuyenNganhRepository.findAll();
    }

    @Override
    public List<NgoaiNgu> xemNgoaiNgu() {
        return ngoaiNguRepository.findAll();
    }

    @Override
    public List<PhuCapKhac> xemPhuCapKhac() {
        return phuCapKhacRepository.findAll();
    }

    @Override
    public List<QuanHeGiaDinh> xemQuanHeGiaDinh() {
        return quanHeGiaDinhRepository.findAll();
    }

    @Override
    public List<QuaTrinhCongTac> xemQuaTrinhCongTac() {
        return quaTrinhCongTacRepository.findAll();
    }

    @Override
    public List<TinHoc> xemTinHoc() {
        return tinHocRepository.findAll();
    }
}
