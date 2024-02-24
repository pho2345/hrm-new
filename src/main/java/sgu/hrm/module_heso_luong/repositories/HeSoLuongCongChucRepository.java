package sgu.hrm.module_heso_luong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_heso_luong.models.HeSoLuongCongChuc;
import sgu.hrm.module_heso_luong.models.HeSoLuongCongChucId;

@Repository
public interface HeSoLuongCongChucRepository extends JpaRepository<HeSoLuongCongChuc, Integer> {
}
