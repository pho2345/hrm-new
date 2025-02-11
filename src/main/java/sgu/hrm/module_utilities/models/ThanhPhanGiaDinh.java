package sgu.hrm.module_utilities.models;

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
@Table(name = "thanh_phan_gia_dinh")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ThanhPhanGiaDinh extends DateTimeObject {
    @Id
    @Column(columnDefinition = "tinyint")
    int id;

    @Column(length = 50, unique = true)
    String name;

    public ThanhPhanGiaDinh(String name) {
        this.name = name;
    }
}