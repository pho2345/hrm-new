package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;

@Repository
public interface LoaiQuanHamQuanDoiRepository extends JpaRepository<LoaiQuanHamQuanDoi, Integer> {
}
