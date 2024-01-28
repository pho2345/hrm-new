package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.BacNgachCongChuc;

public interface BacNgachCongChucRepository extends JpaRepository<BacNgachCongChuc, Integer> {
}
