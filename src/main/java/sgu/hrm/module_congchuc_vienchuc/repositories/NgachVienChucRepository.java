package sgu.hrm.module_congchuc_vienchuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;

@Repository
public interface NgachVienChucRepository extends JpaRepository<NgachVienChuc, String> {
    @Query
    NgachVienChuc findByName(String name);
}
