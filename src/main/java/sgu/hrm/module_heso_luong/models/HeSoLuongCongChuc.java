package sgu.hrm.module_heso_luong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_utilities.models.BacLuong;

@Entity
@Table(name = "he_so_luong_cong_chuc")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@IdClass(HeSoLuongCongChucId.class)
public class HeSoLuongCongChuc extends DateTimeObject {
//    @EmbeddedId
//    HeSoLuongCongChucId heSoLuongCongChucId;

    @Id
    @ManyToOne
//    @MapsId("nhom_loai_cong_chuc")
    @JoinColumn(name = "nhom_loai_cong_chuc", columnDefinition = "INTEGER", referencedColumnName = "id")
//    @JsonIgnore
    @JsonIgnoreProperties({"trangThai", "id"})
    NhomLoaiCongChuc nhomLoaiCongChuc;

    @Id
    @ManyToOne
//    @MapsId("bac_luong")
    @JoinColumn(name = "bac_luong", columnDefinition = "INTEGER", referencedColumnName = "id")
//    @JsonIgnore
    @JsonIgnoreProperties({"trangThai", "id"})
    BacLuong bacLuong;

    @Column(name = "he_so", columnDefinition = "FLOAT")
    float heSo;
}