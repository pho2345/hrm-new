package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.TaiKhoan;

public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
}
