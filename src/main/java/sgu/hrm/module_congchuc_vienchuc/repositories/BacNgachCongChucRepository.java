package sgu.hrm.module_congchuc_vienchuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachCongChuc;

@Repository
public interface BacNgachCongChucRepository extends JpaRepository<BacNgachCongChuc, Integer> {
    @Query
    BacNgachCongChuc findByName(String name);
}
