package sgu.hrm.module_taikhoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_taikhoan.models.RoleTaiKhoan;

@Repository
public interface RoleTaiKhoanRepository extends JpaRepository<RoleTaiKhoan, Integer> {
}
