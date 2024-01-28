package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.BacLuong;

@Repository
public interface BacLuongRepository extends JpaRepository<BacLuong, Integer> {
    @Query
    BacLuong findByName(String name);
}
