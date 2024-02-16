//package sgu.hrm.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.ForeignKey;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;
//
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "chuyen_mon")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class ChuyenMon extends DateTimeObject {
//    @Id
//    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    int id;
//
//    @Column(name = "bat_dau", columnDefinition = "datetime")
//    LocalDateTime batDau;
//
//    @Column(name = "ket_thuc", columnDefinition = "datetime")
//    LocalDateTime ketThuc;
//
//    @Column(name = "ten_co_so_dao_tao", columnDefinition = "varchar(100)")
//    String tenCoSoDaoTao;
//
//    @Column(name = "chuyen_nganh_dao_tao", columnDefinition = "varchar(100)")
//    String chuyenNganhDaoTao;
//
//    @Column(name = "hinh_thuc_dao_tao", columnDefinition = "varchar(50)")
//    String hinhThucDaoTao;
//
//    @Column(name = "vanbang_trinhdo", columnDefinition = "varchar(50)")
//    String vanBangTrinhDo;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
//    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;
//}