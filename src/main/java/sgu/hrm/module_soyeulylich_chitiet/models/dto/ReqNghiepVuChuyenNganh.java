package sgu.hrm.module_soyeulylich_chitiet.models.dto;

import java.time.LocalDateTime;

public record ReqNghiepVuChuyenNganh(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String chungChiDuocCap,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich

) {
}
