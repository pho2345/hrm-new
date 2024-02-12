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
    abstract ResDTO<?> xemDS();

    default ResDTO<?> them(String name) {
        return null;
    }

    default ResDTO<?> sua(T object) {
        return null;
    }

    default ResDTO<?> xoa(T object) {
        return null;
    }

    default ResDTO<?> themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName) {
        return null;
    }
}
