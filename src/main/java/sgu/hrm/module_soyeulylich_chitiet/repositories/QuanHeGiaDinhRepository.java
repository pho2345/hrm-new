package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuanHeGiaDinhRepository extends JpaRepository<QuanHeGiaDinh, Integer> {
    @Query(value = "SELECT c FROM QuanHeGiaDinh c WHERE c.soYeuLyLich.id = ?1")
    List<QuanHeGiaDinh> listQuanHeGiaDinh(UUID id);
}
