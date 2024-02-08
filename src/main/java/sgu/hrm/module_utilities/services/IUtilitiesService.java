package sgu.hrm.module_utilities.services;

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

import java.util.List;

public interface IUtilitiesService<T> {
    abstract ResDTO<?> xem();

    default ResDTO<?> them(String name) {
        return null;
    }
    default ResDTO<?> sua(T object) {
        return null;
    }
    default ResDTO<?> themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName) {
        return null;
    }

//    interface IBacLuongService {
//        ResDTO<?> xemBacLuong();
//
//        ResDTO<?> themBacLuong(String name);
//
//        ResDTO<?> suaBacLuong(BacLuong bacLuong);
//    }

//    interface ILoaiQuanHamQuanDoiService {
//        ResDTO<List<LoaiQuanHamQuanDoi>> xemLoaiQuanHamQuanDoi();
//
//        ResDTO<LoaiQuanHamQuanDoi> themLoaiQuanHamQuanDoi(String name);
//
//        ResDTO<LoaiQuanHamQuanDoi> suaLoaiQuanHamQuanDoi(LoaiQuanHamQuanDoi loaiQuanHamQuanDoi);
//    }

//    interface ICapBacLoaiQuanHamQuanDoiService {
//        ResDTO<List<CapBacLoaiQuanHamQuanDoi>> xemCapBacLoaiQuanHamQuanDoi();
//
//        ResDTO<CapBacLoaiQuanHamQuanDoi> themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName);
//
//        ResDTO<CapBacLoaiQuanHamQuanDoi> suaCapBacLoaiQuanHamQuanDoi(CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi);
//    }
//
//    interface IDanhHieuNhaNuocPhongTangService {
//        ResDTO<List<DanhHieuNhaNuocPhongTang>> xemDanhHieuNhaNuocPhongTang();
//
//        ResDTO<DanhHieuNhaNuocPhongTang> themDanhHieuNhaNuocPhongTang(String name);
//
//        ResDTO<DanhHieuNhaNuocPhongTang> suaDanhHieuNhaNuocPhongTang(DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang);
//    }
//
//    interface IDanTocService {
//        ResDTO<List<DanToc>> xemDanToc();
//
//        ResDTO<DanToc> themDanToc(String name);
//
//        ResDTO<DanToc> suaDanToc(DanToc toc);
//    }
//
//    interface IDoiTuongChinhSachService {
//        ResDTO<List<DoiTuongChinhSach>> xemDoiTuongChinhSach();
//
//        ResDTO<DoiTuongChinhSach> themDoiTuongChinhSach(String name);
//
//        ResDTO<DoiTuongChinhSach> suaDoiTuongChinhSach(DoiTuongChinhSach doiTuongChinhSach);
//    }
//
//    interface IGioiTinhService {
//        ResDTO<List<GioiTinh>> xemGioiTinh();
//    }
//
//    interface IHocHamService {
//        ResDTO<List<HocHam>> xemHocHam();
//
//        ResDTO<HocHam> themHocHam(String name);
//
//        ResDTO<HocHam> suaHocHam(HocHam hocHam);
//    }
//
//    interface INhomMauService {
//        ResDTO<List<NhomMau>> xemNhomMau();
//
//        ResDTO<NhomMau> themNhomMau(String name);
//
//        ResDTO<NhomMau> suaNhomMau(NhomMau nhomMau);
//    }
//
//    interface IThanhPhanGiaDinhService {
//        ResDTO<List<ThanhPhanGiaDinh>> xemThanhPhanGiaDinh();
//
//        ResDTO<ThanhPhanGiaDinh> themThanhPhanGiaDinh(String name);
//
//        ResDTO<ThanhPhanGiaDinh> suaThanhPhanGiaDinh(ThanhPhanGiaDinh thanhPhanGiaDinh);
//    }
//
//    interface ITinhTrangSucKhoeService {
//        ResDTO<List<TinhTrangSucKhoe>> xemTinhTrangSucKhoe();
//
//        ResDTO<TinhTrangSucKhoe> themTinhTrangSucKhoe(String name);
//
//        ResDTO<TinhTrangSucKhoe> suaTinhTrangSucKhoe(TinhTrangSucKhoe tinhTrangSucKhoe);
//    }
//
//    interface ITonGiaoService {
//        ResDTO<List<TonGiao>> xemTonGiao();
//
//        ResDTO<TonGiao> themTonGiao(String name);
//
//        ResDTO<TonGiao> suaTonGiao(TonGiao tonGiao);
//    }
//
//    interface ITrinhDoChuyenMonService {
//        ResDTO<List<TrinhDoChuyenMon>> xemTrinhDoChuyenMon();
//
//        ResDTO<TrinhDoChuyenMon> themTrinhDoChuyenMon(String name);
//
//        ResDTO<TrinhDoChuyenMon> suaTrinhDoChuyenMon(TrinhDoChuyenMon trinhDoChuyenMon);
//    }
//
//    interface ITrinhDoGiaoDucPhoThongService {
//        ResDTO<List<TrinhDoGiaoDucPhoThong>> xemTrinhDoGiaoDucPhoThong();
//
//        ResDTO<TrinhDoGiaoDucPhoThong> themTrinhDoGiaoDucPhoThong(String name);
//
//        ResDTO<TrinhDoGiaoDucPhoThong> suaTrinhDoGiaoDucPhoThong(TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong);
//    }
}
