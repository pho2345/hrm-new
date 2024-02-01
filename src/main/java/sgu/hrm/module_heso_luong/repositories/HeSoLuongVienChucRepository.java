package sgu.hrm.module_heso_luong.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_heso_luong.models.HeSoLuongVienChuc;
import sgu.hrm.module_heso_luong.models.HeSoLuongVienChucId;

@Repository
public interface HeSoLuongVienChucRepository extends JpaRepository<HeSoLuongVienChuc, HeSoLuongVienChucId> {
}
