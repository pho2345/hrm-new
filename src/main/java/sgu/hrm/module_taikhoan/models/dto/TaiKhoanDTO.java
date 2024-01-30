package sgu.hrm.module_taikhoan.models.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.models.RoleTaiKhoan;

@Builder
public record TaiKhoanDTO(String hoVaTen, String soCCCD, String email) {
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

