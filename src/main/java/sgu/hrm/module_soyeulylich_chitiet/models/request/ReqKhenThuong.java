package sgu.hrm.module_soyeulylich_chitiet.models.request;

import java.time.LocalDateTime;

public record ReqKhenThuong(LocalDateTime nam,
                            String xepLoaiChuyenMon,
                            String xepLoaiThiDua,
                            String hinhThucKhenThuong,
                            String loaiSoYeuLyLichChiTiet,
                            String soYeuLyLich,
                            LocalDateTime create_at
) {
}
