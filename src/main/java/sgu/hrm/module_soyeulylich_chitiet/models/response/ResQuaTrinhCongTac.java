package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResQuaTrinhCongTac(
        int id,
        LocalDateTime batDau,
        LocalDateTime ketThuc,
        String donViCongTac,
        String chucDanh,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
