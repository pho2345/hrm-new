package sgu.hrm.module_taikhoan.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.models.RoleTaiKhoan;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

@Entity
@Table(name = "taikhoan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "ho_va_ten")
    String hoVaTen;

    @Column(name = "so_CCCD", columnDefinition = "varchar(15) unique")
    String soCCCD;

    @Column(columnDefinition = "varchar(30) unique")
    String username;

    @Column(columnDefinition = "varchar(15)")
    String password;

    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "role_tai_khoan_fk"), name = "role", referencedColumnName = "id", columnDefinition = "tinyint")
    RoleTaiKhoan roleTaiKhoan;

    @OneToOne()
    @JoinColumn(name = "so_yeu_ly_lich", columnDefinition = "binary(16)")
    SoYeuLyLich soYeuLyLich;
}
