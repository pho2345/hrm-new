package sgu.hrm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.models.LyLuanChinhTri;
import sgu.hrm.repository.LyLuanChinhTriRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/ly-luan-chinh-tri")
public class LyLuanChinhTriController {

    private final LyLuanChinhTriRepository lyLuanChinhTriRepository;

    public LyLuanChinhTriController(LyLuanChinhTriRepository lyLuanChinhTriRepository) {
        this.lyLuanChinhTriRepository = lyLuanChinhTriRepository;
    }

    @GetMapping("")
    public List<LyLuanChinhTri> getAllSoYeuLyLich() {
        return lyLuanChinhTriRepository.findAll();
    }

}