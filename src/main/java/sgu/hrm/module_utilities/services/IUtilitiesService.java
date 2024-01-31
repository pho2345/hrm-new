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

public interface IUtilitiesService {
    interface IBacLuongService{
        ResDTO<List<BacLuong>> xemBacLuong();
    }
    interface ILoaiQuanHamQuanDoiService{
        ResDTO<List<LoaiQuanHamQuanDoi>> xemLoaiQuanHamQuanDoi();
    }
    interface ICapBacLoaiQuanHamQuanDoiService{
        ResDTO<List<CapBacLoaiQuanHamQuanDoi>> xemCapBacLoaiQuanHamQuanDoi();
    }
    interface IDanhHieuNhaNuocPhongTangService {
        ResDTO<List<DanhHieuNhaNuocPhongTang>> xemDanhHieuNhaNuocPhongTang();
    }
    interface IDanTocService {
        ResDTO<List<DanToc>> xemDanToc();
    }
    interface IDoiTuongChinhSachService {
        ResDTO<List<DoiTuongChinhSach>> xemDoiTuongChinhSach();
    }
    interface IGioiTinhService {
        ResDTO<List<GioiTinh>> xemGioiTinh();
    }
    interface IHocHamService {
        ResDTO<List<HocHam>> xemHocHam();
    }
    interface INhomMauService {
        ResDTO<List<NhomMau>> xemNhomMau();
    }
    interface IThanhPhanGiaDinhService {
        ResDTO<List<ThanhPhanGiaDinh>> xemThanhPhanGiaDinh();
    }
    interface ITinhTrangSucKhoeService {
        ResDTO<List<TinhTrangSucKhoe>> xemTinhTrangSucKhoe();
    }
    interface ITonGiaoService {
        ResDTO<List<TonGiao>> xemTonGiao();
    }
    interface ITrinhDoChuyenMonService {
        ResDTO<List<TrinhDoChuyenMon>> xemTrinhDoChuyenMon();
    }
    interface ITrinhDoGiaoDucPhoThongService {
        ResDTO<List<TrinhDoGiaoDucPhoThong>> xemTrinhDoGiaoDucPhoThong();
    }
}
