package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.NhomMau;
import sgu.hrm.models.ThanhPhanGiaDinh;
import sgu.hrm.repository.NhomMauRepository;
import sgu.hrm.repository.ThanhPhanGiaDinhRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/thanh-phan-gia-dinh")
public class ThanhPhanGiaDinhController {

    private ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;

    public ThanhPhanGiaDinhController(ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository) {
        this.thanhPhanGiaDinhRepository = thanhPhanGiaDinhRepository;
    }

    @GetMapping("")
    public List<ThanhPhanGiaDinh> getAllThanhPhanGiaDinh() {
        return thanhPhanGiaDinhRepository.findAll();
    }

}