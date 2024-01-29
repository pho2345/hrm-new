package sgu.hrm.module_utilities.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;

@Repository
public interface TonGiaoRepository extends JpaRepository<TonGiao, Integer> {
    @Query
    TonGiao findByName(String name);
}
