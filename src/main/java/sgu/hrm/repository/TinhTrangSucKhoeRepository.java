package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.models.TinhTrangSucKhoe;

@Repository
public interface TinhTrangSucKhoeRepository extends JpaRepository<TinhTrangSucKhoe, Integer> {
    @Query
    TinhTrangSucKhoe findByTitle(String title);
}
