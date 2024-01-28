package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.LoaiCongChuc;

public interface LoaiCongChucRepository extends JpaRepository<LoaiCongChuc, String> {
}
