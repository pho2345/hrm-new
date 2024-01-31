package sgu.hrm.module_soyeulylich_chitiet.models;

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

import java.util.List;

@Entity
@Table(name = "loai_so_yeu_ly_lich_chitiet")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoaiSoYeuLyLichChiTiet extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(length = 65, unique = true)
    String name;

    @OneToMany(mappedBy = "loaiSoYeuLyLichChiTiet")
    List<LyLuanChinhTri> lyLuanChinhTris;

}