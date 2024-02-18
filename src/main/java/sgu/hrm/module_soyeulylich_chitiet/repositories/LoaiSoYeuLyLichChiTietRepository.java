package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;

@Repository
public interface LoaiSoYeuLyLichChiTietRepository extends JpaRepository<LoaiSoYeuLyLichChiTiet, Integer> {
    @Query
    LoaiSoYeuLyLichChiTiet findByName(String name);
}
