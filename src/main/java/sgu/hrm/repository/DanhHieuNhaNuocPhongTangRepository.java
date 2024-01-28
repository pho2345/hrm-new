package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.models.DanhHieuNhaNuocPhongTang;

@Repository
public interface DanhHieuNhaNuocPhongTangRepository extends JpaRepository<DanhHieuNhaNuocPhongTang, Integer> {
    @Query
    DanhHieuNhaNuocPhongTang findByName(String name);
}
