package sgu.hrm.module_congchuc_vienchuc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
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
import sgu.hrm.module_heso_luong.models.HeSoLuongCongChuc;

@Entity
@Table(name = "ngach_cong_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties({"bacNgachCongChuc"}) // an thuoc tinh nay di
// vi ben BacNgachCongChuc se goi den no
public class NgachCongChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "varchar(6)")
    String id;

    @Column(length = 100, unique = true)
    String name;

    @ManyToOne
    @JoinColumn(name = "bac_ngach_cong_chuc", referencedColumnName = "id", columnDefinition = "TINYINT")
    BacNgachCongChuc bacNgachCongChuc;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "he_so_luong_cong_chuc_fk"), name = "he_so_luong_cong_chuc", referencedColumnName = "id", columnDefinition = "integer")
    HeSoLuongCongChuc heSoLuongCongChuc;
}
