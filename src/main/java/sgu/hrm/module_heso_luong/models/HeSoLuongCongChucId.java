package sgu.hrm.module_heso_luong.models;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

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
