package sgu.hrm.module_soyeulylich_chitiet.models.response;

import java.time.LocalDateTime;

public record ResKhenThuong(
        int id,
        LocalDateTime nam,
        String xepLoaiChuyenMon,
        String xepLoaiThiDua,
        String hinhThucKhenThuong,
        LocalDateTime create_at,
        LocalDateTime update_at
) {
}
