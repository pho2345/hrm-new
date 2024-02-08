package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResNgoaiNgu(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String tenCoSoDaoTao,
        String tenNgoaiNgu,
        String chungChiDuocCap,
        float diemSo,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
