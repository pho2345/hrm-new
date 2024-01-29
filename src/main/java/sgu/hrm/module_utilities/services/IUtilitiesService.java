package sgu.hrm.module_utilities.services;

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

import java.util.List;

public interface IUtilitiesService {

    interface ICapBacLoaiQuanHamQuanDoiService{
        List<CapBacLoaiQuanHamQuanDoi> xemCapBacLoaiQuanHamQuanDoi();
    }
    interface IDanhHieuNhaNuocPhongTangService {
        List<DanhHieuNhaNuocPhongTang> xemDanhHieuNhaNuocPhongTang();
    }
    interface IDanTocService {
        List<DanToc> xemDanToc();
    }
    interface IDoiTuongChinhSachService {
        List<DoiTuongChinhSach> xemDoiTuongChinhSach();
    }
    interface IGioiTinhService {
        List<GioiTinh> xemGioiTinh();
    }
    interface IHocHamService {
        List<HocHam> xemHocHam();
    }
    interface INhomMauService {
        List<NhomMau> xemNhomMau();
    }
    interface IThanhPhanGiaDinhService {
        List<ThanhPhanGiaDinh> xemThanhPhanGiaDinh();
    }
    interface ITinhTrangSucKhoeService {
        List<TinhTrangSucKhoe> xemTinhTrangSucKhoe();
    }
    interface ITonGiaoService {
        List<TonGiao> xemTonGiao();
    }
    interface ITrinhDoChuyenMonService {
        List<TrinhDoChuyenMon> xemTrinhDoChuyenMon();
    }
    interface ITrinhDoGiaoDucPhoThongService {
        List<TrinhDoGiaoDucPhoThong> xemTrinhDoGiaoDucPhoThong();
    }
}
