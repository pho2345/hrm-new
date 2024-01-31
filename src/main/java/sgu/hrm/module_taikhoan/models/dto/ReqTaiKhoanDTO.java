package sgu.hrm.module_taikhoan.models.dto;

import lombok.Builder;

@Builder
public record ReqTaiKhoanDTO(String hoVaTen, String soCCCD, String email) {
    @Override
    public String hoVaTen() {
        return hoVaTen;
    }

    @Override
    public String soCCCD() {
        return soCCCD;
    }

    @Override
    public String email() {
        return email;
    }
}

