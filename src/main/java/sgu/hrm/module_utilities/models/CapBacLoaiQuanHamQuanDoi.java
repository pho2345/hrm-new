package sgu.hrm.module_utilities.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

@Entity
@Table(name = "cap_bac_loai_quan_ham_quan_doi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CapBacLoaiQuanHamQuanDoi extends DateTimeObject {
    @Id
    @Column(columnDefinition = "integer auto_increment")
    int id;

    @Column(length = 50, unique = true)
    String name;

    @ManyToOne
    @JsonIgnore // khi goi thì sẽ không hiện trường này
    @JoinColumn(name = "loai_quan_ham_quan_doi", referencedColumnName = "id", columnDefinition = "tinyint")
    LoaiQuanHamQuanDoi loaiQuanHamQuanDoi;

    public CapBacLoaiQuanHamQuanDoi(String name, LoaiQuanHamQuanDoi loaiQuanHamQuanDoi) {
        this.name = name;
        this.loaiQuanHamQuanDoi = loaiQuanHamQuanDoi;
    }
}