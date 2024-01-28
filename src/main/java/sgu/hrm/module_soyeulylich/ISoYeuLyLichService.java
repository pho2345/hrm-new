package sgu.hrm.module_soyeulylich;

import java.util.List;

public interface ISoYeuLyLichService {

    public List<SoYeuLyLich> xemSoYeuLyLich();
    public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO);
}
