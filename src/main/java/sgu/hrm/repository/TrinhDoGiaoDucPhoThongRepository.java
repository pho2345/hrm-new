package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sgu.hrm.models.TrinhDoChuyenMon;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;

public interface TrinhDoGiaoDucPhoThongRepository extends JpaRepository<TrinhDoGiaoDucPhoThong, Integer> {
}
