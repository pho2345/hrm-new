package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;

import java.util.List;

@Repository
public interface LyLuanChinhTriRepository extends JpaRepository<LyLuanChinhTri, Integer> {
//    @Query(nativeQuery = true, value = "")
//    List<LyLuanChinhTri> findAllByLoaiSoYeuLyLichChiTiet();
}
