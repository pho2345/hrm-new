package sgu.hrm.module_soyeulylich;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/so-yeu-ly-lich")
public class SoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public SoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    @GetMapping("")
    public List<SoYeuLyLichDTO> getAllSoYeuLyLich() {
        return soYeuLyLichService.xemSoYeuLyLich();
    }

    @PostMapping("/them")
    public void themSoYeuLyLich(@RequestBody SoYeuLyLichDTO soYeuLyLichDTO){
        soYeuLyLichService.themSoYeuLyLich(soYeuLyLichDTO);
    }

}