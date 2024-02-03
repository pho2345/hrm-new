package sgu.hrm.module_soyeulylich.models;

import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqTinHoc;

import java.util.List;

public record ReqSoYeuLyLich(
        SoYeuLyLichDTO soYeuLyLichDTO,
        List<ReqBanThanCoLamViecChoCheDoCu> reqBanThanCoLamViecChoCheDoCus,
        List<ReqKhenThuong> thuong, List<ReqKienThucAnNinhQuocPhong> quocPhongs, List<ReqKyLuat> reqKyLuats,
        List<ReqLamViecONuocNgoai> reqLamViecONuocNgoais, List<ReqLuongBanThan> reqLuongBanThans,
        List<ReqLyLuanChinhTri> reqLyLuanChinhTris,
        List<ReqNghiepVuChuyenNganh> reqNghiepVuChuyenNganhs, List<ReqNgoaiNgu> reqNgoaiNgus,
        List<ReqPhuCapKhac> reqPhuCapKhacs,
        List<ReqQuanHeGiaDinh> reqQuanHeGiaDinhs, List<ReqQuaTrinhCongTac> reqQuaTrinhCongTacs,
        List<ReqTinHoc> reqTinHocs
) {
}
