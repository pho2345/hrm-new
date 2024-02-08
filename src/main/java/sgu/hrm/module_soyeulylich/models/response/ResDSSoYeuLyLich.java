package sgu.hrm.module_soyeulylich.models.response;


import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public record ResDSSoYeuLyLich(
        UUID id,
        String so_cccd,
        int taikhoan,
        LocalDateTime create_at,
        LocalDateTime update_at,
        boolean trang_thai
) {
}
