package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;

import java.util.List;
import java.util.UUID;

@Repository
public interface LamViecONuocNgoaiRepository extends JpaRepository<LamViecONuocNgoai, Integer> {
    @Query(value = "SELECT c FROM LamViecONuocNgoai c WHERE c.soYeuLyLich.id = ?1")
    List<LamViecONuocNgoai> listLamViecONuocNgoai(UUID id);
}
