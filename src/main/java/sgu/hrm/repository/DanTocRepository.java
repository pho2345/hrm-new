package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.DanToc;

@Repository
public interface DanTocRepository extends JpaRepository<DanToc, Integer> {
    @Query
    public DanToc findByName(String name);
}
