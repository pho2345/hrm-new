package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.RoleTaiKhoan;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;

public interface RoleTaiKhoanRepository extends JpaRepository<RoleTaiKhoan, Integer> {
}
