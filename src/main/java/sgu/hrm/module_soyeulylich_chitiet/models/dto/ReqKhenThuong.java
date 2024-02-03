package sgu.hrm.module_soyeulylich_chitiet.models.dto;

import java.time.LocalDateTime;

public record ReqKhenThuong(LocalDateTime nam,
                            String xepLoaiChuyenMon,
                            String xepLoaiThiDua,
                            String hinhThucKhenThuong,
                            String loaiSoYeuLyLichChiTiet,
                            String soYeuLyLich
) {
}
