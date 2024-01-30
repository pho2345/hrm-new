package sgu.hrm.module_congchuc_vienchuc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;

@Entity
@Table(name = "bac_ngach_vien_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BacNgachVienChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "tinyint")
    int id;

    @Column(length = 100, unique = true)
    String name;
}
