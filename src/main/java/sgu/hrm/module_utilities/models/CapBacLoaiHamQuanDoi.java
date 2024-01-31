//package sgu.hrm.module_ultilities.models;
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
//import sgu.hrm.models.DateTimeObject;
//import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
//
//@Entity
//@Table(name = "cap_bac_loai_quan_ham_quan_doi")
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode(callSuper = true)
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class CapBacLoaiHamQuanDoi extends DateTimeObject {
//    @Id
//    @Column(columnDefinition = "tinyint")
//    int id;
//
//    @Column(columnDefinition = "varchar(50) unique")
//    String name;
//
//    @ManyToOne
//    @JoinColumn(name="loai_quan_ham_quan_doi", referencedColumnName = "id", columnDefinition = "tinyint")
//    LoaiQuanHamQuanDoi loaiQuanHamQuanDoi;
//}