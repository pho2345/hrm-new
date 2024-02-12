package sgu.hrm.module_soyeulylich.models.request;

import java.time.LocalDateTime;
import java.util.UUID;

public record ReqDSSoYeuLyLich(
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
