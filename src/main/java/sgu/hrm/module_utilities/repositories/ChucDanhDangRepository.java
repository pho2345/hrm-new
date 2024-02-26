package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.ChucDanhDang;

@Repository
public interface ChucDanhDangRepository extends JpaRepository<ChucDanhDang, Integer> {
    @Query
    ChucDanhDang findByName(String name);
}
