package sgu.hrm.module_taikhoan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_taikhoan.models.TaiKhoan;

@Repository
public interface TaiKhoanRepository extends JpaRepository<TaiKhoan, Integer> {
    @Query
    TaiKhoan findBySoCCCD(String soCCCD);

//    @Query
//    TaiKhoan updateTaiKhoanStatusWhere(boolean soCCCD);
}
