package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.CapBacLoaiQuanHamQuanDoi;

public interface CapBacLoaiQuanHamQuanDoiRepository extends JpaRepository<CapBacLoaiQuanHamQuanDoi, Integer> {
}
