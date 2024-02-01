package sgu.hrm.module_utilities.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;

import java.util.List;

@Entity
@Table(name = "loai_quan_ham_quan_doi")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiQuanHamQuanDoi extends DateTimeObject {
    @Id
    @Column(columnDefinition = "tinyint")
    int id;

    @Column(length = 50, unique = true)
    String name;

    @OneToMany(mappedBy = "loaiQuanHamQuanDoi")
    @JsonProperty(value = "capBac")
    List<CapBacLoaiQuanHamQuanDoi> capBacLoaiQuanHamQuanDois;

    public LoaiQuanHamQuanDoi(String name) {
        this.name = name;
    }
}