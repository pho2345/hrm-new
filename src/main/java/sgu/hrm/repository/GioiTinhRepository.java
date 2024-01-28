package sgu.hrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sgu.hrm.models.GioiTinh;

@Repository
public interface GioiTinhRepository extends JpaRepository<GioiTinh, Integer> {
    @Query
    public GioiTinh findByName(String name);
}
