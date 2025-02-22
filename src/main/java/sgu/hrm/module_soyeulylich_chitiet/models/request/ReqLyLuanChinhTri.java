package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqLyLuanChinhTri(
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        String loaiSoYeuLyLichChiTiet,
        String soYeuLyLich,
        LocalDateTime create_at

) {
}
