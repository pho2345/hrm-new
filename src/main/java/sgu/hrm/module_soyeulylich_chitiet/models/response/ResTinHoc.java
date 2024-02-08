package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResTinHoc(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String chungChiDuocCap,
        LocalDateTime create_at,
        LocalDateTime update_at

) {
}
