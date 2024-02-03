package sgu.hrm.module_soyeulylich.services;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_soyeulylich.models.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLichDTO;

import java.util.List;
import java.util.UUID;

public interface ISoYeuLyLichService {

    public ResDTO<List<SoYeuLyLich>> xemSoYeuLyLich();

    // public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO);
    ResDTO<SoYeuLyLich> xemSoYeuLyLichTheoSoCCCDHoacID(String q);

    ResDTO<SoYeuLyLich> xemSoYeuLyLichTheoId(UUID id);

    public ResDTO<SoYeuLyLich> capNhatSoYeuLyLich(UUID id, SoYeuLyLichDTO soYeuLyLichDTO);
}
