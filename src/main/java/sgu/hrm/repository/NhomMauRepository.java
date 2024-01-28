package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sgu.hrm.models.NhomMau;


@Repository
public interface NhomMauRepository extends JpaRepository<NhomMau, Integer> {
    @Query
    NhomMau findByName(String name);
}
