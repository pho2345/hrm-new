package sgu.hrm.module_soyeulylich;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/so-yeu-ly-lich")
public class SoYeuLyLichController {

    private final ISoYeuLyLichService soYeuLyLichService;

    public SoYeuLyLichController(ISoYeuLyLichService soYeuLyLichService) {
        this.soYeuLyLichService = soYeuLyLichService;
    }

    @GetMapping("/{soCCCD}")
    public ResDTO<SoYeuLyLich> getSoYeuLyLichSoCCCD(@PathVariable(name = "soCCCD") UUID uuid) {
        return soYeuLyLichService.xemSoYeuLyLichSoCCCD(uuid);
    }

    @GetMapping("")
    public List<SoYeuLyLichDTO> getAllSoYeuLyLich() {
        return soYeuLyLichService.xemSoYeuLyLich();
    }

    @PostMapping("/them")
    public void themSoYeuLyLich(@RequestBody SoYeuLyLichDTO soYeuLyLichDTO) {
        soYeuLyLichService.themSoYeuLyLich(soYeuLyLichDTO);
    }

}