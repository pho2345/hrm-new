package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.DanToc;

@Repository
public interface BacLuongRepository extends JpaRepository<BacLuong, Integer> {
    @Query
    BacLuong findByName(String name);
}
