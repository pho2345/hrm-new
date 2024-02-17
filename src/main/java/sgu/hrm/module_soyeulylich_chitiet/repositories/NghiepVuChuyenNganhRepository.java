package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;

import java.util.List;
import java.util.UUID;

@Repository
public interface NghiepVuChuyenNganhRepository extends JpaRepository<NghiepVuChuyenNganh, Integer> {
    @Query(value = "SELECT c FROM NghiepVuChuyenNganh c WHERE c.soYeuLyLich.id = ?1")
    List<NghiepVuChuyenNganh> listNghiepVuChuyenNganh(UUID id);
}
