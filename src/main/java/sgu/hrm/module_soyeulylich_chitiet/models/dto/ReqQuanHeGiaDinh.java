package sgu.hrm.module_soyeulylich_chitiet.models.dto;

import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;

public record ReqQuanHeGiaDinh(
        String moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
