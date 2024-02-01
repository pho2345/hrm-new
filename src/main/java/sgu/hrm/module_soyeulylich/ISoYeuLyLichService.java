package sgu.hrm.module_soyeulylich;

import sgu.hrm.module_response.ResDTO;

import java.util.List;
import java.util.UUID;

public interface ISoYeuLyLichService {

    public List<SoYeuLyLichDTO> xemSoYeuLyLich();
    public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO);
    ResDTO<SoYeuLyLich> xemSoYeuLyLichSoCCCD(UUID uuid);
    public void suaSoYeuLyLich(UUID uuidSoYeuLyLich);
}
