package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;

@Repository
public interface CapBacLoaiQuanHamQuanDoiRepository extends JpaRepository<CapBacLoaiQuanHamQuanDoi, Integer> {
    @Query
    CapBacLoaiQuanHamQuanDoi findByName(String name);
}
