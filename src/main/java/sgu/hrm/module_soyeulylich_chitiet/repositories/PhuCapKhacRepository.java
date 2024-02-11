package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhuCapKhacRepository extends JpaRepository<PhuCapKhac, Integer> {
    @Query(value = "SELECT c FROM PhuCapKhac c WHERE c.soYeuLyLich.id = ?1")
    List<PhuCapKhac> listPhuCapKhac(UUID id);
}
