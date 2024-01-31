package sgu.hrm.module_soyeulylich_chitiet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;

@Repository
public interface KhenThuongRepository extends JpaRepository<KhenThuong, Integer> {
}
