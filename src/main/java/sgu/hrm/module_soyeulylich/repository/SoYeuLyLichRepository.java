package sgu.hrm.module_soyeulylich.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;

import java.util.UUID;

@Repository
public interface SoYeuLyLichRepository extends JpaRepository<SoYeuLyLich, UUID> {
    @Query
    SoYeuLyLich findFirstBySoCCCD(String soCCCD);
}
