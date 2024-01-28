//package sgu.hrm.models;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//import jakarta.persistence.Table;
//import lombok.AccessLevel;
//import lombok.AllArgsConstructor;
//import lombok.EqualsAndHashCode;
//import lombok.NoArgsConstructor;
//import lombok.experimental.FieldDefaults;
//
//@Entity
//@Table(name = "chuc_danh_dang")
//@NoArgsConstructor
//@AllArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE)
//@EqualsAndHashCode(callSuper = true)
//public class ChucDanhDang extends DateTimeObject {
//    @Id
//    @Column(columnDefinition = "tinyint")
//    int id;
//
//    @Column(length = 100, unique = true)
//    String name;
//
//    @ManyToOne
//    @JoinColumn(name = "cap_nhom_chuc_danh_dang", referencedColumnName = "id", columnDefinition = "tinyint")
//    CapNhomChucDanhDang nhomChucDanhDang;
//}
