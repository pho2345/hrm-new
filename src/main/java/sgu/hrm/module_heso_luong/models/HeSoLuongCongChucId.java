package sgu.hrm.module_heso_luong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import sgu.hrm.module_utilities.models.BacLuong;

import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class HeSoLuongCongChucId implements Serializable {

//    @Column(name = "nhom_loai_cong_chuc")
    private int nhomLoaiCongChuc;

//    @Column(name = "bac_luong")
    private int bacLuong;

}
