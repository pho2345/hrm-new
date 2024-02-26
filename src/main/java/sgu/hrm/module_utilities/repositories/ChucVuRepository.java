package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.ChucVu;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu, Integer> {
    @Query
    ChucVu findByName(String name);
}
