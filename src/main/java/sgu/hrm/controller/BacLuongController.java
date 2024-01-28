package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.repository.BacLuongRepository;
import sgu.hrm.repository.CapBacLoaiQuanHamQuanDoiRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/bac-luong")
public class BacLuongController {

    private BacLuongRepository bacLuongRepository;

    public BacLuongController(BacLuongRepository bacLuongRepository) {
        this.bacLuongRepository = bacLuongRepository;
    }

    @GetMapping("")
    public List<BacLuong> getAllBacLuong() {
        return bacLuongRepository.findAll();
    }

}