package sgu.hrm.module_soyeulylich_chitiet.models.request;

import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;

import java.time.LocalDateTime;

public record ReqQuaTrinhCongTac(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String donViCongTac,
        String chucDanh,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich,
        LocalDateTime create_at
) {
}
