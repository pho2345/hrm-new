package sgu.hrm.module_soyeulylich_chitiet.models.dto;

import java.time.LocalDateTime;

public record ReqLyLuanChinhTri(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich

) {
}
