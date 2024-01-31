package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;

@Repository
public interface LamViecONuocNgoaiRepository extends JpaRepository<LamViecONuocNgoai, Integer> {
}
