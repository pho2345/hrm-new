package sgu.hrm.module_congchuc_vienchuc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;

@Repository
public interface NgachCongChucRepository extends JpaRepository<NgachCongChuc, String> {
    @Query
    NgachCongChuc findByName(String name);
}
