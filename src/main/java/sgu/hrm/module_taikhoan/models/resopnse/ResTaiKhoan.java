package sgu.hrm.module_taikhoan.models.resopnse;

import java.util.UUID;

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
