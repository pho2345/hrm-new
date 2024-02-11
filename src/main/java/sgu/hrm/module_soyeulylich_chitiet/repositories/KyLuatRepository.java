package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;

import java.util.List;
import java.util.UUID;

@Repository
public interface KyLuatRepository extends JpaRepository<KyLuat, Integer> {
    @Query(value = "SELECT c FROM KyLuat c WHERE c.soYeuLyLich.id = ?1")
    List<KyLuat> listKyLuat(UUID id);
}
