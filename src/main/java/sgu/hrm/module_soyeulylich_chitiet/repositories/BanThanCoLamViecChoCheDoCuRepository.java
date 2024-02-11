package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;

import java.util.List;
import java.util.UUID;

@Repository
public interface BanThanCoLamViecChoCheDoCuRepository extends JpaRepository<BanThanCoLamViecChoCheDoCu, Integer> {
    //JPQL
    @Query(value = "SELECT c FROM BanThanCoLamViecChoCheDoCu c WHERE c.soYeuLyLich.id = ?1")
    List<BanThanCoLamViecChoCheDoCu> listBanThanCoLamViecChoCheDoCu(UUID id);
}
