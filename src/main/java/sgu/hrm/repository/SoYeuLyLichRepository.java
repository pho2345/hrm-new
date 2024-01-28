package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.SoYeuLyLich;

import java.util.UUID;

public interface SoYeuLyLichRepository extends JpaRepository<SoYeuLyLich, UUID> {
}
