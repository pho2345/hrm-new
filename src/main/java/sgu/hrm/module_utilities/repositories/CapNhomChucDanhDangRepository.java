package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.CapNhomChucDanhDang;

@Repository
public interface CapNhomChucDanhDangRepository extends JpaRepository<CapNhomChucDanhDang, Integer> {
    @Query
    CapNhomChucDanhDang findByName(String name);
}
