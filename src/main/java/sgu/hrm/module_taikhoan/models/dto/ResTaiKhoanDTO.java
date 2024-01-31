package sgu.hrm.module_taikhoan.models.dto;

import java.util.UUID;

public record ResTaiKhoanDTO(
        int id,
        String hoVaten,
        String username,
//            String password,
        UUID maSoYeuLyLich,
        boolean trangThai
) {
}
