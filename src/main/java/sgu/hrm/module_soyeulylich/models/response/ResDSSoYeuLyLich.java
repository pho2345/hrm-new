package sgu.hrm.module_soyeulylich.models.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResDSSoYeuLyLich(
        UUID id,
        String ho_va_ten,
        LocalDateTime sinhNgay,
        String chucVuHienTai,
        String trinhDoChuyenMon,
        String ngachNgheNghiep,
        LocalDateTime create_at,
        LocalDateTime update_at,
        boolean trang_thai
) {
}
