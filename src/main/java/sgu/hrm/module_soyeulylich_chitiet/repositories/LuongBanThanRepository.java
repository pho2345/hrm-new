package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;

import java.util.List;
import java.util.UUID;

@Repository
public interface LuongBanThanRepository extends JpaRepository<LuongBanThan, Integer> {
    @Query(value = "SELECT c FROM LuongBanThan c WHERE c.soYeuLyLich.id = ?1")
    List<LuongBanThan> listLuongBanThan(UUID id);
}
