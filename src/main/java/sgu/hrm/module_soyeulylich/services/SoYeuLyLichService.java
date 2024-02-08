package sgu.hrm.module_soyeulylich.services;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.response.ResDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.repositories.BacLuongRepository;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.repository.CoQuanToChucDonViTuyenDungRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.GioiTinhRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_utilities.repositories.TinhTrangSucKhoeRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor // tự tạo constructor với filed là final hoặc annotation not null
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SoYeuLyLichService implements ISoYeuLyLichService {
    final SoYeuLyLichRepository soYeuLyLichRepository;
    final GioiTinhRepository gioiTinhRepository;
    final DanTocRepository danTocRepository;
    final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    final CoQuanToChucDonViTuyenDungRepository coQuanToChucDonViTuyenDungRepository;
    final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
    final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;
    final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    final HocHamRepository hocHamRepository;
    final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
    final BacLuongRepository bacLuongRepository;
    final TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository;
    final NhomMauRepository nhomMauRepository;

    @Override
    public ResDTO<?> xemThongTinSoYeuLyLich() {
        try {
            SoYeuLyLich soYeuLyLich = get_Info_SoYeuLyLich();
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    soYeuLyLich != null ? mapToResSoYeuLyLich(soYeuLyLich) : null
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResSoYeuLyLich> capNhatSoYeuLyLich(ResSoYeuLyLich resSoYeuLyLich) {
        try {
            SoYeuLyLich soYeuLyLich = get_Info_SoYeuLyLich();
            if (soYeuLyLich != null) {
                SoYeuLyLich soYeuLyLichNew = mapToSoYeuLyLich(resSoYeuLyLich);
                soYeuLyLichNew.setId(soYeuLyLich.getId());
                soYeuLyLichNew.setCreate_at(soYeuLyLich.getCreate_at());
                soYeuLyLichNew.setUpdate_at();
                soYeuLyLichRepository.save(soYeuLyLichNew);
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        mapToResSoYeuLyLich(soYeuLyLichNew)
                );
            } else return new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    null
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> xemDanhSachSoYeuLyLich() {
        try {
            List<ResDSSoYeuLyLich> soYeuLyLichDTOS = soYeuLyLichRepository.findAll().stream().map(ISoYeuLyLichService::RES_DS_SO_YEU_LY_LICH).toList();
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    soYeuLyLichDTOS
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<ResDSSoYeuLyLich> xemSoYeuLyLichTheoSoCCCDHoacID(String q) {
        ResDSSoYeuLyLich resDSSoYeuLyLichSoCCCD = Optional.ofNullable(soYeuLyLichRepository.findFirstBySoCCCD(q)).map(
                syll -> ISoYeuLyLichService.RES_DS_SO_YEU_LY_LICH(syll)
        ).orElse(null);
        ResDSSoYeuLyLich resDSSoYeuLyLichId = soYeuLyLichRepository.findById(UUID.fromString(q)).map(ISoYeuLyLichService::RES_DS_SO_YEU_LY_LICH).orElse(null);
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                resDSSoYeuLyLichSoCCCD != null ? resDSSoYeuLyLichSoCCCD : resDSSoYeuLyLichId
        );
    }

    @Override
    public ResDTO<?> xemSoYeuLyLichTheoId(UUID id) {
        try {
            ResSoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(id).map(this::mapToResSoYeuLyLich).orElse(null);
            return new ResDTO<>(ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    soYeuLyLich
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    private SoYeuLyLich get_Info_SoYeuLyLich() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            return Optional.ofNullable((TaiKhoan) authentication.getPrincipal()).map(
                    TaiKhoan::getSoYeuLyLich
            ).orElse(null);
        } else return null;
    }

    private ResSoYeuLyLich mapToResSoYeuLyLich(SoYeuLyLich soYeuLyLich) {
        return ResSoYeuLyLich.builder()
                .hovaten(soYeuLyLich.getHovaten())
                .gioiTinh(Optional.ofNullable(soYeuLyLich.getGioiTinh()).map(GioiTinh::getName).orElse(""))
                .cacTenGoiKhac(soYeuLyLich.getCacTenGoiKhac())
                .sinhNgay(soYeuLyLich.getSinhNgay())
                .noiSinh(soYeuLyLich.getNoiSinh())
                .queQuan(soYeuLyLich.getQueQuan())
                .danToc(Optional.ofNullable(soYeuLyLich.getDanToc()).map(toc -> toc.getName()).orElse(""))
                .soCCCD(soYeuLyLich.getSoCCCD())
                .ngayCapCCCD(soYeuLyLich.getNgayCapCCCD())
                .soDienThoai(soYeuLyLich.getSoDienThoai())
                .soBHXH(soYeuLyLich.getSoBHXH())
                .soBHYT(soYeuLyLich.getSoBHYT())
                .noiOHienNay(soYeuLyLich.getNoiOHienNay())
                .thanhPhanGiaDinh(Optional.ofNullable(soYeuLyLich.getThanhPhanGiaDinh()).map(ThanhPhanGiaDinh::getName).orElse(""))
                .ngheNghiepTruocKhiTuyenDung(soYeuLyLich.getNgheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(soYeuLyLich.getNgayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(soYeuLyLich.getCoQuanToChucDonViTuyenDung() != null ? soYeuLyLich.getCoQuanToChucDonViTuyenDung().getName() : "")
                .ngayVaoCoQuanHienDangCongTac(soYeuLyLich.getNgayVaoCoQuanHienDangCongTac())
                .ngayVaoDangCongSanVietNam(soYeuLyLich.getNgayVaoDangCongSanVietNam())
                .ngayChinhThuc(soYeuLyLich.getNgayChinhThuc())
                .ngayThamGiaToChucChinhTriXaHoiDauTien(soYeuLyLich.getNgayThamGiaToChucChinhTriXaHoiDauTien())
                .ngayNhapNgu(soYeuLyLich.getNgayXuatNgu())
                .ngayXuatNgu(soYeuLyLich.getNgayNhapNgu())
                .capBacLoaiQuanHamQuanDoi(Optional.ofNullable(soYeuLyLich.getCapBacLoaiQuanHamQuanDoi()).map(CapBacLoaiQuanHamQuanDoi::getName).orElse(""))
                .doiTuongChinhSach(Optional.ofNullable(soYeuLyLich.getDoiTuongChinhSach()).map(DoiTuongChinhSach::getName).orElse(""))
                .trinhDoGiaoDucPhoThong(Optional.ofNullable(soYeuLyLich.getTrinhDoGiaoDucPhoThong()).map(TrinhDoGiaoDucPhoThong::getName).orElse(""))
                .trinhDoChuyenMon(Optional.ofNullable(soYeuLyLich.getTrinhDoChuyenMon()).map(TrinhDoChuyenMon::getName).orElse(""))
                .hocHam(Optional.ofNullable(soYeuLyLich.getHocHam()).map(HocHam::getName).orElse(""))
                .danhHieuNhaNuocPhongTang(Optional.ofNullable(soYeuLyLich.getDanhHieuNhaNuocPhongTang()).map(DanhHieuNhaNuocPhongTang::getName).orElse(""))
                .chucVuHienTai(soYeuLyLich.getChucVuHienTai())
                .ngayBoNhiem(soYeuLyLich.getNgayBoNhiem())
                .ngayBoNhiemLai(soYeuLyLich.getNgayBoNhiemLai())
                .duocQuyHoacChucDanh(soYeuLyLich.getDuocQuyHoacChucDanh())
                .chucVuKiemNhiem(soYeuLyLich.getChucVuKiemNhiem())
                .chucVuDangHienTai(soYeuLyLich.getChucVuDangHienTai())
                .chucVuDangKiemNhiem(soYeuLyLich.getChucVuDangKiemNhiem())
                .congVienChinhDuocGiao(soYeuLyLich.getCongVienChinhDuocGiao())
                .soTruongCongTac(soYeuLyLich.getSoTruongCongTac())
                .congViecLamLauNhat(soYeuLyLich.getCongViecLamLauNhat())
                .tienLuong(soYeuLyLich.getTienLuong())
                .ngachNgheNghiep(soYeuLyLich.getNgachNgheNghiep())
                .maSoNgachNgheNghiep(soYeuLyLich.getMaSoNgachNgheNghiep())
                .ngayBoNhiemNgachNgheNghiep(soYeuLyLich.getNgayBoNhiemNgachNgheNghiep())
                .bacLuong(Optional.ofNullable(soYeuLyLich.getBacLuong()).map(BacLuong::getName).orElse(""))
                .heSoLuongNgachNgheNghiep(soYeuLyLich.getHeSoLuongNgachNgheNghiep())
                .ngayHuongLuongNgachNgheNghiep(soYeuLyLich.getNgayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgachNgheNghiep(soYeuLyLich.getPhanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgachNgheNghiep(soYeuLyLich.getPhuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgachNgheNghiep(soYeuLyLich.getNgayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(soYeuLyLich.getPhuCapChucVu())
                .phuCapKiemNhiem(soYeuLyLich.getPhuCapKiemNhiem())
                .phuCapKhac(soYeuLyLich.getPhuCapKhac())
                .viTriViecLam(soYeuLyLich.getViTriViecLam())
                .maSoViTriViecLam(soYeuLyLich.getMaSoViTriViecLam())
                .bacLuongTriViecLam(soYeuLyLich.getBacLuongTriViecLam())
                .luongTheoMucTien(soYeuLyLich.getLuongTheoMucTien())
                .ngayHuongLuongTheoViTriViecLam(soYeuLyLich.getNgayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(soYeuLyLich.getPhamTramHuongLuong())
                .phuCapThamNienVuotKhung(soYeuLyLich.getPhuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(soYeuLyLich.getNgayHuongPCTNVK())
                .tinhTrangSucKhoe(Optional.ofNullable(soYeuLyLich.getTinhTrangSucKhoe()).map(TinhTrangSucKhoe::getTitle).orElse(""))
                .chieuCao(soYeuLyLich.getChieuCao())
                .canNang(soYeuLyLich.getCanNang())
                .nhomMau(Optional.ofNullable(soYeuLyLich.getNhomMau()).map(NhomMau::getName).orElse(""))
                .build();
    }

    private SoYeuLyLich mapToSoYeuLyLich(ResSoYeuLyLich resSoYeuLyLich) {
        GioiTinh gioiTinh = gioiTinhRepository.findByName(resSoYeuLyLich.gioiTinh());
        DanToc danToc = danTocRepository.findByName(resSoYeuLyLich.danToc());
        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findByName(resSoYeuLyLich.thanhPhanGiaDinh());
        CoQuanToChucDonViTuyenDung coQuanToChucDonViTuyenDung = coQuanToChucDonViTuyenDungRepository.findByName(resSoYeuLyLich.coQuanToChucDonViTuyenDung());
        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(resSoYeuLyLich.capBacLoaiQuanHamQuanDoi());
        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findByName(resSoYeuLyLich.doiTuongChinhSach());
        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findByName(resSoYeuLyLich.trinhDoGiaoDucPhoThong());
        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findByName(resSoYeuLyLich.trinhDoChuyenMon());
        HocHam hocHam = hocHamRepository.findByName(resSoYeuLyLich.hocHam());
        DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findByName(resSoYeuLyLich.danhHieuNhaNuocPhongTang());
        BacLuong bacLuong = bacLuongRepository.findByName(resSoYeuLyLich.bacLuong());
        TinhTrangSucKhoe tinhTrangSucKhoe = tinhTrangSucKhoeRepository.findByTitle(resSoYeuLyLich.tinhTrangSucKhoe());
        NhomMau nhomMau = nhomMauRepository.findByName(resSoYeuLyLich.nhomMau());
        SoYeuLyLich soYeuLyLich = SoYeuLyLich.builder()
                .hovaten(resSoYeuLyLich.hovaten())
                .gioiTinh(gioiTinh)
                .cacTenGoiKhac(resSoYeuLyLich.cacTenGoiKhac())
                .sinhNgay(resSoYeuLyLich.sinhNgay())
                .noiSinh(resSoYeuLyLich.noiSinh())
                .queQuan(resSoYeuLyLich.queQuan())
                .danToc(danToc)
                .soCCCD(resSoYeuLyLich.soCCCD())
                .ngayCapCCCD(resSoYeuLyLich.ngayCapCCCD())
                .soDienThoai(resSoYeuLyLich.soDienThoai())
                .soBHXH(resSoYeuLyLich.soBHXH())
                .soBHYT(resSoYeuLyLich.soBHYT())
                .noiOHienNay(resSoYeuLyLich.noiOHienNay())
                .thanhPhanGiaDinh(thanhPhanGiaDinh)
                .ngheNghiepTruocKhiTuyenDung(resSoYeuLyLich.ngheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(resSoYeuLyLich.ngayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(coQuanToChucDonViTuyenDung)
                .ngayVaoCoQuanHienDangCongTac(resSoYeuLyLich.ngayVaoCoQuanHienDangCongTac())
                .ngayVaoDangCongSanVietNam(resSoYeuLyLich.ngayVaoDangCongSanVietNam())
                .ngayChinhThuc(resSoYeuLyLich.ngayChinhThuc())
                .ngayThamGiaToChucChinhTriXaHoiDauTien(resSoYeuLyLich.ngayThamGiaToChucChinhTriXaHoiDauTien())
                .ngayNhapNgu(resSoYeuLyLich.ngayNhapNgu())
                .ngayXuatNgu(resSoYeuLyLich.ngayXuatNgu())
                .capBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi)
                .doiTuongChinhSach(doiTuongChinhSach)
                .trinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong)
                .trinhDoChuyenMon(trinhDoChuyenMon)
                .hocHam(hocHam)
                .danhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang)
                .chucVuHienTai(resSoYeuLyLich.chucVuHienTai())
                .ngayBoNhiem(resSoYeuLyLich.ngayBoNhiem())
                .ngayBoNhiemLai(resSoYeuLyLich.ngayBoNhiemLai())
                .duocQuyHoacChucDanh(resSoYeuLyLich.duocQuyHoacChucDanh())
                .chucVuKiemNhiem(resSoYeuLyLich.chucVuKiemNhiem())
                .chucVuDangHienTai(resSoYeuLyLich.chucVuDangHienTai())
                .chucVuDangKiemNhiem(resSoYeuLyLich.chucVuDangKiemNhiem())
                .congVienChinhDuocGiao(resSoYeuLyLich.congVienChinhDuocGiao())
                .soTruongCongTac(resSoYeuLyLich.soTruongCongTac())
                .congViecLamLauNhat(resSoYeuLyLich.congViecLamLauNhat())
                .tienLuong(resSoYeuLyLich.tienLuong())
                .ngachNgheNghiep(resSoYeuLyLich.ngachNgheNghiep())
                .maSoNgachNgheNghiep(resSoYeuLyLich.maSoNgachNgheNghiep())
                .ngayBoNhiemNgachNgheNghiep(resSoYeuLyLich.ngayBoNhiemNgachNgheNghiep())
                .bacLuong(bacLuong)
                .heSoLuongNgachNgheNghiep(resSoYeuLyLich.heSoLuongNgachNgheNghiep())
                .ngayHuongLuongNgachNgheNghiep(resSoYeuLyLich.ngayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgachNgheNghiep(resSoYeuLyLich.phanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgachNgheNghiep(resSoYeuLyLich.phuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgachNgheNghiep(resSoYeuLyLich.ngayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(resSoYeuLyLich.phuCapChucVu())
                .phuCapKiemNhiem(resSoYeuLyLich.phuCapKiemNhiem())
                .phuCapKhac(resSoYeuLyLich.phuCapKhac())
                .viTriViecLam(resSoYeuLyLich.viTriViecLam())
                .maSoViTriViecLam(resSoYeuLyLich.maSoViTriViecLam())
                .bacLuongTriViecLam(resSoYeuLyLich.bacLuongTriViecLam())
                .luongTheoMucTien(resSoYeuLyLich.luongTheoMucTien())
                .ngayHuongLuongTheoViTriViecLam(resSoYeuLyLich.ngayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(resSoYeuLyLich.phamTramHuongLuong())
                .phuCapThamNienVuotKhung(resSoYeuLyLich.phuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(resSoYeuLyLich.ngayHuongPCTNVK())
                .tinhTrangSucKhoe(tinhTrangSucKhoe)
                .chieuCao(resSoYeuLyLich.chieuCao())
                .canNang(resSoYeuLyLich.canNang())
                .nhomMau(nhomMau)
                .build();
        soYeuLyLich.setUpdate_at();
        return soYeuLyLich;
    }

    //    @Override
//    public ResDTO<?> capNhatTrangThaiSoYeuLyLich(boolean check, UUID id) {
//        try {
//            Optional<SoYeuLyLich> soYeuLyLich = soYeuLyLichRepository.findById(id);
//
//            ResDSSoYeuLyLich soYeuLyLichCrush = soYeuLyLichRepository.findById(id).map(ISoYeuLyLichService::RES_DS_SO_YEU_LY_LICH).orElse(null);
//            return new ResDTO<>(
//                    ResEnum.THANH_CONG.getStatusCode(),
//                    ResEnum.THANH_CONG,
//                    soYeuLyLichCrush
//            );
//        } catch (RuntimeException e) {
//            throw new RuntimeException(e.getCause());
//        }
//    }
//        if (soYeuLyLichSoCCCD != null) {
//            return new ResDTO<>(
//                    ResEnum.THANH_CONG.getStatusCode(),
//                    ResEnum.THANH_CONG,
//                    soYeuLyLichSoCCCD
//            );
//        }
//        Optional<SoYeuLyLich> soYeuLyLichID = soYeuLyLichRepository.findById(UUID.fromString(q));
//        if (soYeuLyLichID.isPresent()) {
//            return new ResDTO<>(
//                    ResEnum.THANH_CONG.getStatusCode(),
//                    ResEnum.THANH_CONG,
//                    soYeuLyLichID.get()
//            );
//        }
//        return new ResDTO<>(
//                ResEnum.THANH_CONG.getStatusCode(),
//                ResEnum.THANH_CONG,
//                null
//        );

    //            if (soYeuLyLich.isPresent()) {
//                soYeuLyLich.get().setTrangThai(check);
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        soYeuLyLich.get()
//                );
//            } else return new ResDTO<>(
//                    ResEnum.HONG_TIM_THAY.getStatusCode(),
//                    ResEnum.HONG_TIM_THAY,
//                    null
//            );

    //            List<SoYeuLyLichDTO> soYeuLyLichDTOS = soYeuLyLichRepository.findAll().stream().map(soYeuLyLich ->
//                    SoYeuLyLichDTO.builder()
//                            .hovaten(soYeuLyLich.getHovaten())
//                            .gioiTinh(Optional.ofNullable(soYeuLyLich.getGioiTinh()).map(GioiTinh::getName).orElse(""))
//                            .cacTenGoiKhac(soYeuLyLich.getCacTenGoiKhac())
//                            .sinhNgay(soYeuLyLich.getSinhNgay())
//                            .noiSinh(soYeuLyLich.getNoiSinh())
//                            .queQuan(soYeuLyLich.getQueQuan())
//                            .danToc(Optional.ofNullable(soYeuLyLich.getDanToc()).map(toc -> toc.getName()).orElse(""))
//                            .soCCCD(soYeuLyLich.getSoCCCD())
//                            .ngayCapCCCD(soYeuLyLich.getNgayCapCCCD())
//                            .soDienThoai(soYeuLyLich.getSoDienThoai())
//                            .soBHXH(soYeuLyLich.getSoBHXH())
//                            .soBHYT(soYeuLyLich.getSoBHYT())
//                            .noiOHienNay(soYeuLyLich.getNoiOHienNay())
//                            .thanhPhanGiaDinh(Optional.ofNullable(soYeuLyLich.getThanhPhanGiaDinh()).map(ThanhPhanGiaDinh::getName).orElse(""))
//                            .ngheNghiepTruocKhiTuyenDung(soYeuLyLich.getNgheNghiepTruocKhiTuyenDung())
//                            .ngayDuocTuyenDungLanDau(soYeuLyLich.getNgayDuocTuyenDungLanDau())
//                            .coQuanToChucDonViTuyenDung(soYeuLyLich.getCoQuanToChucDonViTuyenDung() != null ? soYeuLyLich.getCoQuanToChucDonViTuyenDung().getName() : "")
//                            .ngayVaoCoQuanHienDangCongTac(soYeuLyLich.getNgayVaoCoQuanHienDangCongTac())
//                            .ngayVaoDangCongSanVietNam(soYeuLyLich.getNgayVaoDangCongSanVietNam())
//                            .ngayChinhThuc(soYeuLyLich.getNgayChinhThuc())
//                            .ngayThamGiaToChucChinhTriXaHoiDauTien(soYeuLyLich.getNgayThamGiaToChucChinhTriXaHoiDauTien())
//                            .ngayNhapNgu(soYeuLyLich.getNgayXuatNgu())
//                            .ngayXuatNgu(soYeuLyLich.getNgayNhapNgu())
//                            .capBacLoaiQuanHamQuanDoi(Optional.ofNullable(soYeuLyLich.getCapBacLoaiQuanHamQuanDoi()).map(CapBacLoaiQuanHamQuanDoi::getName).orElse(""))
//                            .doiTuongChinhSach(Optional.ofNullable(soYeuLyLich.getDoiTuongChinhSach()).map(DoiTuongChinhSach::getName).orElse(""))
//                            .trinhDoGiaoDucPhoThong(Optional.ofNullable(soYeuLyLich.getTrinhDoGiaoDucPhoThong()).map(TrinhDoGiaoDucPhoThong::getName).orElse(""))
//                            .trinhDoChuyenMon(Optional.ofNullable(soYeuLyLich.getTrinhDoChuyenMon()).map(TrinhDoChuyenMon::getName).orElse(""))
//                            .hocHam(Optional.ofNullable(soYeuLyLich.getHocHam()).map(HocHam::getName).orElse(""))
//                            .danhHieuNhaNuocPhongTang(Optional.ofNullable(soYeuLyLich.getDanhHieuNhaNuocPhongTang()).map(DanhHieuNhaNuocPhongTang::getName).orElse(""))
//                            .chucVuHienTai(soYeuLyLich.getChucVuHienTai())
//                            .ngayBoNhiem(soYeuLyLich.getNgayBoNhiem())
//                            .ngayBoNhiemLai(soYeuLyLich.getNgayBoNhiemLai())
//                            .duocQuyHoacChucDanh(soYeuLyLich.getDuocQuyHoacChucDanh())
//                            .chucVuKiemNhiem(soYeuLyLich.getChucVuKiemNhiem())
//                            .chucVuDangHienTai(soYeuLyLich.getChucVuDangHienTai())
//                            .chucVuDangKiemNhiem(soYeuLyLich.getChucVuDangKiemNhiem())
//                            .congVienChinhDuocGiao(soYeuLyLich.getCongVienChinhDuocGiao())
//                            .soTruongCongTac(soYeuLyLich.getSoTruongCongTac())
//                            .congViecLamLauNhat(soYeuLyLich.getCongViecLamLauNhat())
//                            .tienLuong(soYeuLyLich.getTienLuong())
//                            .ngachNgheNghiep(soYeuLyLich.getNgachNgheNghiep())
//                            .maSoNgachNgheNghiep(soYeuLyLich.getMaSoNgachNgheNghiep())
//                            .ngayBoNhiemNgachNgheNghiep(soYeuLyLich.getNgayBoNhiemNgachNgheNghiep())
//                            .bacLuong(Optional.ofNullable(soYeuLyLich.getBacLuong()).map(BacLuong::getName).orElse(""))
//                            .heSoLuongNgachNgheNghiep(soYeuLyLich.getHeSoLuongNgachNgheNghiep())
//                            .ngayHuongLuongNgachNgheNghiep(soYeuLyLich.getNgayHuongLuongNgachNgheNghiep())
//                            .phanTramHuongLuongNgachNgheNghiep(soYeuLyLich.getPhanTramHuongLuongNgachNgheNghiep())
//                            .phuCapThamNienVuotKhungNgachNgheNghiep(soYeuLyLich.getPhuCapThamNienVuotKhungNgachNgheNghiep())
//                            .ngayHuongPCTNVKNgachNgheNghiep(soYeuLyLich.getNgayHuongPCTNVKNgachNgheNghiep())
//                            .phuCapChucVu(soYeuLyLich.getPhuCapChucVu())
//                            .phuCapKiemNhiem(soYeuLyLich.getPhuCapKiemNhiem())
//                            .phuCapKhac(soYeuLyLich.getPhuCapKhac())
//                            .viTriViecLam(soYeuLyLich.getViTriViecLam())
//                            .maSoViTriViecLam(soYeuLyLich.getMaSoViTriViecLam())
//                            .bacLuongTriViecLam(soYeuLyLich.getBacLuongTriViecLam())
//                            .luongTheoMucTien(soYeuLyLich.getLuongTheoMucTien())
//                            .ngayHuongLuongTheoViTriViecLam(soYeuLyLich.getNgayHuongLuongTheoViTriViecLam())
//                            .phamTramHuongLuong(soYeuLyLich.getPhamTramHuongLuong())
//                            .phuCapThamNienVuotKhung(soYeuLyLich.getPhuCapThamNienVuotKhung())
//                            .ngayHuongPCTNVK(soYeuLyLich.getNgayHuongPCTNVK())
//                            .tinhTrangSucKhoe(Optional.ofNullable(soYeuLyLich.getTinhTrangSucKhoe()).map(TinhTrangSucKhoe::getTitle).orElse(""))
//                            .chieuCao(soYeuLyLich.getChieuCao())
//                            .canNang(soYeuLyLich.getCanNang())
//                            .nhomMau(Optional.ofNullable(soYeuLyLich.getNhomMau()).map(NhomMau::getName).orElse(""))
//                            .build()


//            ).collect(Collectors.toList());
//    @Override
//    public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO) {
//        SoYeuLyLich soYeuLyLich = soYeuLyLichObject(soYeuLyLichDTO);
    //save
    //soYeuLyLichRepository.save(soYeuLyLich);

//        SoYeuLyLich soYeuLyLich = SoYeuLyLich.builder()
//                .hovaten(soYeuLyLichDTO.hovaten())
//                .gioiTinh(soYeuLyLichDTO.gioiTinh())
//                .cacTenGoiKhac(soYeuLyLichDTO.cacTenGoiKhac())
//                .sinhNgay(soYeuLyLichDTO.sinhNgay())
//                .noiSinh(soYeuLyLichDTO.noiSinh())
//                .queQuan(soYeuLyLichDTO.queQuan())
//                .danToc(soYeuLyLichDTO.danToc())
//                .soCCCD(soYeuLyLichDTO.soCCCD())
//                .ngayCapCCCD(soYeuLyLichDTO.ngayCapCCCD())
//                .soDienThoai(soYeuLyLichDTO.soDienThoai())
//                .soBHXH(soYeuLyLichDTO.soBHXH())
//                .soBHYT(soYeuLyLichDTO.soBHYT())
//                .noiOHienNay(soYeuLyLichDTO.noiOHienNay())
//                .thanhPhanGiaDinh(soYeuLyLichDTO.thanhPhanGiaDinh())
//                .ngheNghiepTruocKhiTuyenDung(soYeuLyLichDTO.ngheNghiepTruocKhiTuyenDung())
//                .ngayDuocTuyenDungLanDau(soYeuLyLichDTO.ngayDuocTuyenDungLanDau())
//                .coQuanToChucDonViTuyenDung(soYeuLyLichDTO.coQuanToChucDonViTuyenDung())
//                .ngayVaoCoQuanHienDangCongTac(soYeuLyLichDTO.ngayVaoCoQuanHienDangCongTac())
//                .ngayVaoDangCongSanVietNam(soYeuLyLichDTO.ngayVaoDangCongSanVietNam())
//                .ngayChinhThuc(soYeuLyLichDTO.ngayChinhThuc())
//                .ngayThamGiaToChucChinhTriXaHoiDauTien(soYeuLyLichDTO.ngayThamGiaToChucChinhTriXaHoiDauTien())
//                .ngayNhapNgu(soYeuLyLichDTO.ngayNhapNgu())
//                .ngayXuatNgu(soYeuLyLichDTO.ngayXuatNgu())
//                .capBacLoaiQuanHamQuanDoi(soYeuLyLichDTO.capBacLoaiQuanHamQuanDoi())
//                .doiTuongChinhSach(soYeuLyLichDTO.doiTuongChinhSach())
//                .trinhDoGiaoDucPhoThong(soYeuLyLichDTO.trinhDoGiaoDucPhoThong())
//                .trinhDoChuyenMon(soYeuLyLichDTO.trinhDoChuyenMon())
//                .hocHam(soYeuLyLichDTO.hocHam())
//                .danhHieuNhaNuocPhongTang(soYeuLyLichDTO.danhHieuNhaNuocPhongTang())
//                .chucVuHienTai(soYeuLyLichDTO.chucVuHienTai())
//                .ngayBoNhiem(soYeuLyLichDTO.ngayBoNhiem())
//                .ngayBoNhiemLai(soYeuLyLichDTO.ngayBoNhiemLai())
//                .duocQuyHoacChucDanh(soYeuLyLichDTO.duocQuyHoacChucDanh())
//                .chucVuKiemNhiem(soYeuLyLichDTO.chucVuKiemNhiem())
//                .chucVuDangHienTai(soYeuLyLichDTO.chucVuDangHienTai())
//                .chucVuDangKiemNhiem(soYeuLyLichDTO.chucVuDangKiemNhiem())
//                .congVienChinhDuocGiao(soYeuLyLichDTO.congVienChinhDuocGiao())
//                .soTruongCongTac(soYeuLyLichDTO.soTruongCongTac())
//                .congViecLamLauNhat(soYeuLyLichDTO.congViecLamLauNhat())
//                .tienLuong(soYeuLyLichDTO.tienLuong())
//                .ngachNgheNghiep(soYeuLyLichDTO.ngachNgheNghiep())
//                .maSoNgachNgheNghiep(soYeuLyLichDTO.maSoNgachNgheNghiep())
//                .ngayBoNhiemNgachNgheNghiep(soYeuLyLichDTO.ngayBoNhiemNgachNgheNghiep())
//                .bacLuong(soYeuLyLichDTO.bacLuong())
//                .heSoLuongNgachNgheNghiep(soYeuLyLichDTO.heSoLuongNgachNgheNghiep())
//                .ngayHuongLuongNgachNgheNghiep(soYeuLyLichDTO.ngayHuongLuongNgachNgheNghiep())
//                .phanTramHuongLuongNgachNgheNghiep(soYeuLyLichDTO.phanTramHuongLuongNgachNgheNghiep())
//                .phuCapThamNienVuotKhungNgachNgheNghiep(soYeuLyLichDTO.phuCapThamNienVuotKhungNgachNgheNghiep())
//                .ngayHuongPCTNVKNgachNgheNghiep(soYeuLyLichDTO.ngayHuongPCTNVKNgachNgheNghiep())
//                .phuCapChucVu(soYeuLyLichDTO.phuCapChucVu())
//                .phuCapKiemNhiem(soYeuLyLichDTO.phuCapKiemNhiem())
//                .phuCapKhac(soYeuLyLichDTO.phuCapKhac())
//                .viTriViecLam(soYeuLyLichDTO.viTriViecLam())
//                .maSoViTriViecLam(soYeuLyLichDTO.maSoViTriViecLam())
//                .bacLuongTriViecLam(soYeuLyLichDTO.bacLuongTriViecLam())
//                .luongTheoMucTien(soYeuLyLichDTO.luongTheoMucTien())
//                .ngayHuongLuongTheoViTriViecLam(soYeuLyLichDTO.ngayHuongLuongTheoViTriViecLam())
//                .phamTramHuongLuong(soYeuLyLichDTO.phamTramHuongLuong())
//                .phuCapThamNienVuotKhung(soYeuLyLichDTO.phuCapThamNienVuotKhung())
//                .ngayHuongPCTNVK(soYeuLyLichDTO.ngayHuongPCTNVK())
//                .tinhTrangSucKhoe(soYeuLyLichDTO.tinhTrangSucKhoe())
//                .chieuCao(soYeuLyLichDTO.chieuCao())
//                .canNang(soYeuLyLichDTO.canNang())
//                .nhomMau(soYeuLyLichDTO.nhomMau())
//                .build();
//    }
}
