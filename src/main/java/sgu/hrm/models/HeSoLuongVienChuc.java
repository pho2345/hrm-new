package sgu.hrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.DanToc;

@Entity
@Table(name = "he_so_luong_vien_chuc")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeSoLuongVienChuc extends DateTimeObject{
    @Id
    @ManyToOne
//    @MapsId("nhom_loai_vien_chuc")
    @JoinColumn(name = "nhom_loai_vien_chuc", columnDefinition = "INTEGER", referencedColumnName = "id")
    NhomLoaiVienChuc nhomLoaiVienChuc;

    @Id
    @ManyToOne
//    @MapsId("bac_luong")
    @JoinColumn(name = "bac_luong", columnDefinition = "INTEGER", referencedColumnName = "id")
    BacLuong bacLuong;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;
}
