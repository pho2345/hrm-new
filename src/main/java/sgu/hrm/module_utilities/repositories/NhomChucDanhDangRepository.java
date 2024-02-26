package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.NhomChucDanhDang;


@Repository
public interface NhomChucDanhDangRepository extends JpaRepository<NhomChucDanhDang, Integer> {
    @Query
    NhomChucDanhDang findByName(String name);
}
