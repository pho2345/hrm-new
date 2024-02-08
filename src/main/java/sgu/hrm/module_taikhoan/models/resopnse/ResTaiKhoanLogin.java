package sgu.hrm.module_taikhoan.models.resopnse;

import java.util.UUID;

public record ResTaiKhoanLogin(
        ResTaiKhoan taikhoan,
        String token
) {
}
