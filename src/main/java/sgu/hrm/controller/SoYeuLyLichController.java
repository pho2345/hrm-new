package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.SoYeuLyLich;
import sgu.hrm.repository.SoYeuLyLichRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/so-yeu-ly-lich")
public class SoYeuLyLichController {

    private SoYeuLyLichRepository soYeuLyLichRepository;

    public SoYeuLyLichController(SoYeuLyLichRepository soYeuLyLichRepository) {
        this.soYeuLyLichRepository = soYeuLyLichRepository;
    }

    @GetMapping("")
    public List<SoYeuLyLich> getAllSoYeuLyLich() {
        return soYeuLyLichRepository.findAll();
    }

}