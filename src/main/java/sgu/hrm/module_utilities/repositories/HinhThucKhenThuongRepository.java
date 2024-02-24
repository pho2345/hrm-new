package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.HinhThucKhenThuong;

@Repository
public interface HinhThucKhenThuongRepository extends JpaRepository<HinhThucKhenThuong, Integer> {
    @Query
    HinhThucKhenThuong findByName(String name);
}
