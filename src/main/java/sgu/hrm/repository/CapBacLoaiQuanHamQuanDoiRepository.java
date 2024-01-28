package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.CapBacLoaiQuanHamQuanDoi;

@Repository
public interface CapBacLoaiQuanHamQuanDoiRepository extends JpaRepository<CapBacLoaiQuanHamQuanDoi, Integer> {
    @Query
    CapBacLoaiQuanHamQuanDoi findByName(String name);
}
