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
//import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
//
//@Entity
//@Table(name = "quan_he_gia_dinh_ruot_ben_vo_hoac_chong")
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class QuanHeGiaDinhRuotBenVoHoacChong extends DateTimeObject{
//    @Id
//    @Column(columnDefinition = "INTEGER AUTO_INCREMENT")
//    int id;
//
//    @Column(name = "moi_quan_he", columnDefinition = "varchar(50)")
//    String moiQuanHe;
//
//    @Column(name = "ho_va_ten", columnDefinition = "varchar(50)")
//    String hoVaTen;
//
//    @Column(name = "nam_sinh", columnDefinition = "SMALLINT")
//    short namSinh;
//
//    @Column(name = "thong_tin_than_nhan", columnDefinition = "text")
//    String thongTinThanNhan;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "loai_so_yeu_ly_lich_chitiet_qhgdrbvhc_fk"), name = "loai_so_yeu_ly_lich_chitiet", referencedColumnName = "id", columnDefinition = "INTEGER")
//    LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet;
//
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "so_yeu_ly_lich_qhgdrbvhc_fk"), name = "so_yeu_ly_lich", referencedColumnName = "id", columnDefinition = "binary(16)")
//    SoYeuLyLich soYeuLyLich;
//}
