package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.DanToc;

public interface DanTocRepository extends JpaRepository<DanToc, Integer> {
}
