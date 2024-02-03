package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.RoleTaiKhoan;

@Repository
public interface RoleTaiKhoanRepository extends JpaRepository<RoleTaiKhoan, Integer> {
}
