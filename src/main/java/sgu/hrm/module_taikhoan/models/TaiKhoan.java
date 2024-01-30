package sgu.hrm.module_taikhoan.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;
import sgu.hrm.models.DateTimeObject;
import sgu.hrm.models.RoleTaiKhoan;

@Entity
@Table(name = "taikhoan")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoan extends DateTimeObject {
    @Id
    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name ="ho_va_ten")
    String hoVaTen;

    @Column(name = "so_CCCD", columnDefinition = "varchar(15) unique")
    String soCCCD;

    @Column(columnDefinition = "varchar(30) unique")
    String username;

    @Column(columnDefinition = "varchar(15)")
    String password;

    boolean status;

    @ManyToOne
    @JoinColumn(name = "role", referencedColumnName = "id", columnDefinition = "tinyint")
    RoleTaiKhoan roleTaiKhoan;
}
