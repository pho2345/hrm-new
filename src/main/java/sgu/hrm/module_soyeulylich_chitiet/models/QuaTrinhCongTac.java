package sgu.hrm.module_soyeulylich_chitiet.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

import java.time.LocalDateTime;

@Entity
@Table(name = "qua_trinh_cong_tac")
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QuaTrinhCongTac extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    int id;

    @Column(name = "bat_dau", columnDefinition = "datetime")
    LocalDateTime batDau;

    @Column(name = "ket_thuc", columnDefinition = "datetime")
    LocalDateTime ketThuc;

    @Column(name = "don_vi_cong_tac", columnDefinition = "varchar(100)")
    String donViCongTac;

    @Column(name = "chuc_danh", columnDefinition = "varchar(100)")
    String chucDanh;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_qtct_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_qtct_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;

    public QuaTrinhCongTac(LocalDateTime batDau, LocalDateTime ketThuc, String donViCongTac, String chucDanh, LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet, SoYeuLyLich soYeuLyLich) {
        super();
        this.batDau = batDau;
        this.ketThuc = ketThuc;
        this.donViCongTac = donViCongTac;
        this.chucDanh = chucDanh;
        this.loaiSoYeuLyLichChiTiet = loaiSoYeuLyLichChiTiet;
        this.soYeuLyLich = soYeuLyLich;
    }
}