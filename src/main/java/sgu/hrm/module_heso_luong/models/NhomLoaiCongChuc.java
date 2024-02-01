package sgu.hrm.module_heso_luong.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_heso_luong.models.LoaiCongChuc;

import java.util.List;

@Entity
@Table(name = "nhom_loai_cong_chuc")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhomLoaiCongChuc extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 6, unique = true)
    String name;

//    @OneToMany(mappedBy = "nhomLoaiCongChuc")
//    List<HeSoLuongCongChuc> heSoLuongCongChucs;

    @ManyToOne
    @JsonIgnore
    //name là tên cột chứa khóa ngoại tron sql
    //referencedColumnName nghĩa là lấy theo tên của trường trong class
    @JoinColumn(name = "loai_cong_chuc", referencedColumnName = "id", columnDefinition = "VARCHAR(10)")
    LoaiCongChuc loaiCongChuc;
}