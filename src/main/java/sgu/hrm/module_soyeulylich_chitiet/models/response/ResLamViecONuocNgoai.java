package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResLamViecONuocNgoai(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String toChucDiaChiCongViec,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
