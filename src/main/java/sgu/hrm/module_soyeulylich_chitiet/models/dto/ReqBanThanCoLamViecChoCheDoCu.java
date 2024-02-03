package sgu.hrm.module_soyeulylich_chitiet.models.dto;

import java.time.LocalDateTime;

public record ReqBanThanCoLamViecChoCheDoCu(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String chucDanhDonViDiaDiem,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich
) {
}
