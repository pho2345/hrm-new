package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.ThanhPhanGiaDinh;

@Repository
public interface ThanhPhanGiaDinhRepository extends JpaRepository<ThanhPhanGiaDinh, Integer> {
    @Query
    ThanhPhanGiaDinh findByName(String name);
}
