package sgu.hrm.module_soyeulylich;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich.SoYeuLyLich;

import java.util.UUID;

@Repository
public interface SoYeuLyLichRepository extends JpaRepository<SoYeuLyLich, UUID> {
}
