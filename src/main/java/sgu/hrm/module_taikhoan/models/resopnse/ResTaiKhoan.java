package sgu.hrm.module_taikhoan.models.resopnse;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ResTaiKhoan(
        int id,
        String hoVaten,
        String soCCCD,
        String username,
        UUID maSoYeuLyLich,
        String role,
        boolean trangThai
) {
}
