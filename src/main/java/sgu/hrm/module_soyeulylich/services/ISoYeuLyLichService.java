package sgu.hrm.module_soyeulylich.services;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_soyeulylich.models.response.ResDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;

import java.util.Optional;
import java.util.UUID;

public interface ISoYeuLyLichService {
    ResDTO<?> xemThongTinSoYeuLyLich();

    public ResDTO<ResSoYeuLyLich> capNhatSoYeuLyLich(ResSoYeuLyLich resSoYeuLyLich);

    public ResDTO<?> xemDanhSachSoYeuLyLich();

    ResDTO<ResDSSoYeuLyLich> xemSoYeuLyLichTheoSoCCCDHoacID(String q);

    ResDTO<?> xemSoYeuLyLichTheoId(UUID id);

    default ResDTO<?> capNhatTrangThaiSoYeuLyLich(boolean check, UUID id) {
        return null;
    }

    static ResDSSoYeuLyLich RES_DS_SO_YEU_LY_LICH(SoYeuLyLich soYeuLyLich) {
        return new ResDSSoYeuLyLich(
                soYeuLyLich.getId(),
                soYeuLyLich.getSoCCCD(),
                Optional.ofNullable(soYeuLyLich.getTaiKhoan()).map(TaiKhoan::getId).orElse(-1),
                soYeuLyLich.getCreate_at(),
                soYeuLyLich.getUpdate_at(),
                soYeuLyLich.isTrangThai()
        );
    }
}
