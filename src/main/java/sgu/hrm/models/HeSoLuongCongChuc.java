package sgu.hrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "he_so_luong_cong_chuc")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HeSoLuongCongChuc extends DateTimeObject{
    @Id
    @ManyToOne
//    @MapsId("nhom_loai_cong_chuc")
    @JoinColumn(name = "nhom_loai_cong_chuc", columnDefinition = "INTEGER", referencedColumnName = "id")
    NhomLoaiCongChuc nhomLoaiCongChuc;

    @Id
    @ManyToOne
//    @MapsId("bac_luong")
    @JoinColumn(name = "bac_luong", columnDefinition = "INTEGER", referencedColumnName = "id")
    BacLuong bacLuong;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;
}