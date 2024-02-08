package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResQuanHeGiaDinh(
        int id,
        String moiQuanHe,
        String hoVaTen,
        short namSinh,
        String thongTinThanNhan,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
