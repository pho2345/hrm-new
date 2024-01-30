package sgu.hrm.module_soyeulylich;

import java.util.List;
import java.util.UUID;

public interface ISoYeuLyLichService {

    public List<SoYeuLyLich> xemSoYeuLyLich();
    public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO);

    public void suaSoYeuLyLich(UUID uuidSoYeuLyLich);
}
