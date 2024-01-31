package sgu.hrm.module_soyeulylich_chitiet.services;


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

import java.util.List;

public interface ISoYeuLyLichChiTietServices {
    interface ILoaiSoYeuLyLichChiTietSefvice{
        List<LoaiSoYeuLyLichChiTiet> xemLoaiSoYeuLyLichChiTiet();
    }
    interface IBanThanCoLamViecChoCheDoCuSefvice{
        List<BanThanCoLamViecChoCheDoCu> xemBanThanCoLamViecChoCheDoCu();
    }
    interface IKhenThuongSefvice{
        List<KhenThuong> xemKhenThuong();
    }
    interface IKienThucAnNinhQuocPhongSefvice{
        List<KienThucAnNinhQuocPhong> xemKienThucAnNinhQuocPhong();
    }
    interface IKyLuatSefvice{
        List<KyLuat> xemKyLuat();
    }
    interface ILamViecONuocNgoaiSefvice{
        List<LamViecONuocNgoai> xemLamViecONuocNgoai();
    }
    interface ILuongBanThanSefvice{
        List<LuongBanThan> xemLuongBanThan();
    }
    interface ILyLuanChinhTriSefvice{
        List<LyLuanChinhTri> xemLyLuanChinhTri();
    }
    interface INghiepVuChuyenNganhSefvice{
        List<NghiepVuChuyenNganh> xemNghiepVuChuyenNganh();
    }
    interface INgoaiNguSefvice{
        List<NgoaiNgu> xemNgoaiNgu();
    }
    interface IPhuCapKhacSefvice{
        List<PhuCapKhac> xemPhuCapKhac();
    }
    interface IQuanHeGiaDinhSefvice{
        List<QuanHeGiaDinh> xemQuanHeGiaDinh();
    }
    interface IQuaTrinhCongTacSefvice{
        List<QuaTrinhCongTac> xemQuaTrinhCongTac();
    }
    interface ITinHocSefvice{
        List<TinHoc> xemTinHoc();
    }
}
