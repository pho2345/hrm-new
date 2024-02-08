package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResLyLuanChinhTri(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String hinhThucDaoTao,
        String vanBangDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
}
