package sgu.hrm.module_soyeulylich.models.request;

import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;

import java.util.List;

public record ReqSoYeuLyLich(
        ResSoYeuLyLich resSoYeuLyLich,
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
