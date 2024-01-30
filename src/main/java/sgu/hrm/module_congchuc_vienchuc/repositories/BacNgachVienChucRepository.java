package sgu.hrm.module_congchuc_vienchuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_congchuc_vienchuc.models.BacNgachVienChuc;

@Repository
public interface BacNgachVienChucRepository extends JpaRepository<BacNgachVienChuc, Integer> {
    @Query
    BacNgachVienChuc findByName(String name);
}
