package sgu.hrm.module_soyeulylich_chitiet.services;

import org.springframework.stereotype.Service;
import sgu.hrm.module_response.ResDTO;
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
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResTinHoc;


import java.util.List;
import java.util.UUID;

public interface ISoYeuLyLichChiTietServices<T, H> {
    ResDTO<List<?>> xemDanhSachThongTin();

    ResDTO<?> xemThongTin(int id);

    ResDTO<?> themThongTin(H cu);

    ResDTO<?> suaThongTin(int id, H cu);

    ResDTO<?> xoaThongTin(int id);

    default ResDTO<?> xemDanhSach() {
        return null;
    }


    interface ILoaiSoYeuLyLichChiTietSefvice {
        ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet();

        ResDTO<LoaiSoYeuLyLichChiTiet> themLoaiSoYeuLyLichChiTiet(ReqLoaiSoYeuLyLichChiTiet reqLoaiSoYeuLyLichChiTiet);

        ResDTO<LoaiSoYeuLyLichChiTiet> suaLoaiSoYeuLyLichChiTiet(LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet);

    }

    abstract class IBanThanCoLamViecChoCheDoCuSefvice implements ISoYeuLyLichChiTietServices<BanThanCoLamViecChoCheDoCu, ReqBanThanCoLamViecChoCheDoCu> {
    }

    abstract class IKhenThuongSefvice implements ISoYeuLyLichChiTietServices<KhenThuong, ReqKhenThuong> {
    }

    abstract class IKienThucAnNinhQuocPhongSefvice implements ISoYeuLyLichChiTietServices<KienThucAnNinhQuocPhong, ReqKienThucAnNinhQuocPhong> {
    }

    abstract class IKyLuatSefvice implements ISoYeuLyLichChiTietServices<KyLuat, ReqKyLuat> {
    }

    abstract class ILamViecONuocNgoaiSefvice implements ISoYeuLyLichChiTietServices<LamViecONuocNgoai, ReqLamViecONuocNgoai> {
    }

    abstract class ILuongBanThanSefvice implements ISoYeuLyLichChiTietServices<LuongBanThan, ReqLuongBanThan> {
    }

    abstract class ILyLuanChinhTriSefvice implements ISoYeuLyLichChiTietServices<LyLuanChinhTri, ReqLyLuanChinhTri> {
    }

    abstract class INghiepVuChuyenNganhSefvice implements ISoYeuLyLichChiTietServices<NghiepVuChuyenNganh, ReqNghiepVuChuyenNganh> {
    }

    abstract class INgoaiNguSefvice implements ISoYeuLyLichChiTietServices<NgoaiNgu, ReqNgoaiNgu> {
    }

    abstract class IPhuCapKhacSefvice implements ISoYeuLyLichChiTietServices<PhuCapKhac, ReqPhuCapKhac> {
    }

    abstract class IQuanHeGiaDinhSefvice implements ISoYeuLyLichChiTietServices<QuanHeGiaDinh, ReqQuanHeGiaDinh> {
    }

    abstract class IQuaTrinhCongTacSefvice implements ISoYeuLyLichChiTietServices<QuaTrinhCongTac, ReqQuaTrinhCongTac> {
    }

    abstract class ITinHocSefvice implements ISoYeuLyLichChiTietServices<TinHoc, ReqTinHoc> {
    }
}
