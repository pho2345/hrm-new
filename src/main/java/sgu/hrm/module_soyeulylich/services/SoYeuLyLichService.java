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
import sgu.hrm.module_soyeulylich.models.request.ReqDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.request.ReqSoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResDSSoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.models.response.ResSoYeuLyLich;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
// import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
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
//import sgu.hrm.repository.CoQuanToChucDonViTuyenDungRepository;
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
//    final CoQuanToChucDonViTuyenDungRepository coQuanToChucDonViTuyenDungRepository;
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
    public ResDTO<ResSoYeuLyLich> capNhatSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
        try {
            SoYeuLyLich soYeuLyLich = get_Info_SoYeuLyLich();
            if (soYeuLyLich != null) {
                SoYeuLyLich soYeuLyLichNew = mapToSoYeuLyLich(reqSoYeuLyLich);
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
        try {
            SoYeuLyLich resDSSoYeuLyLichSoCCCD = soYeuLyLichRepository.findFirstBySoCCCD(q).orElse(null);
            if (resDSSoYeuLyLichSoCCCD != null) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ISoYeuLyLichService.RES_DS_SO_YEU_LY_LICH(resDSSoYeuLyLichSoCCCD)
                );
            }
            SoYeuLyLich resDSSoYeuLyLichId = soYeuLyLichRepository.findById(UUID.fromString(q)).orElse(null);
            if (resDSSoYeuLyLichId != null) {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ISoYeuLyLichService.RES_DS_SO_YEU_LY_LICH(resDSSoYeuLyLichId)
                );
            }
            return new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    null
            );
        } catch (IllegalArgumentException e) {
            return new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    null
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> xemSoYeuLyLichTheoId(String id) {
        try {
            SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(UUID.fromString(id)).orElse(null);
            return new ResDTO<>(ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    soYeuLyLich != null ? this.mapToResSoYeuLyLich(soYeuLyLich) : null
            );
        } catch (IllegalArgumentException e) {
            return new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    null
            );
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getCause());
        }
    }

    @Override
    public ResDTO<?> pheDuyetSoYeuLyLich(String id, ReqDSSoYeuLyLich reqDSSoYeuLyLich) {
        try {
            SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findById(UUID.fromString(id)).orElse(null);
            if (soYeuLyLich != null) {
                soYeuLyLich.setTrangThai(reqDSSoYeuLyLich.trang_thai());
                soYeuLyLichRepository.save(soYeuLyLich);
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ISoYeuLyLichService.RES_DS_SO_YEU_LY_LICH(soYeuLyLich)
                );
            }
            return new ResDTO<>(
                    ResEnum.HONG_TIM_THAY.getStatusCode(),
                    ResEnum.HONG_TIM_THAY,
                    null
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
                .danToc(Optional.ofNullable(soYeuLyLich.getDanToc()).map(DanToc::getName).orElse(""))
                .soCCCD(soYeuLyLich.getSoCCCD())
                .ngayCapCCCD(soYeuLyLich.getNgayCapCCCD())
                .soDienThoai(soYeuLyLich.getSoDienThoai())
                .soBHXH(soYeuLyLich.getSoBHXH())
                .soBHYT(soYeuLyLich.getSoBHYT())
                .noiOHienNay(soYeuLyLich.getNoiOHienNay())
                .thanhPhanGiaDinh(Optional.ofNullable(soYeuLyLich.getThanhPhanGiaDinh()).map(ThanhPhanGiaDinh::getName).orElse(""))
                .ngheNghiepTruocKhiTuyenDung(soYeuLyLich.getNgheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(soYeuLyLich.getNgayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(soYeuLyLich.getCoQuanToChucDonViTuyenDung() != null ? soYeuLyLich.getCoQuanToChucDonViTuyenDung() : "")
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

    private SoYeuLyLich mapToSoYeuLyLich(ReqSoYeuLyLich reqSoYeuLyLich) {
        GioiTinh gioiTinh = gioiTinhRepository.findByName(reqSoYeuLyLich.gioiTinh());
        DanToc danToc = danTocRepository.findByName(reqSoYeuLyLich.danToc());
        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findByName(reqSoYeuLyLich.thanhPhanGiaDinh());
//        CoQuanToChucDonViTuyenDung coQuanToChucDonViTuyenDung = coQuanToChucDonViTuyenDungRepository.findByName(reqSoYeuLyLich.coQuanToChucDonViTuyenDung());
        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(reqSoYeuLyLich.capBacLoaiQuanHamQuanDoi());
        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findByName(reqSoYeuLyLich.doiTuongChinhSach());
        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findByName(reqSoYeuLyLich.trinhDoGiaoDucPhoThong());
        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findByName(reqSoYeuLyLich.trinhDoChuyenMon());
        HocHam hocHam = hocHamRepository.findByName(reqSoYeuLyLich.hocHam());
        DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findByName(reqSoYeuLyLich.danhHieuNhaNuocPhongTang());
        BacLuong bacLuong = bacLuongRepository.findByName(reqSoYeuLyLich.bacLuong());
        TinhTrangSucKhoe tinhTrangSucKhoe = tinhTrangSucKhoeRepository.findByTitle(reqSoYeuLyLich.tinhTrangSucKhoe());
        NhomMau nhomMau = nhomMauRepository.findByName(reqSoYeuLyLich.nhomMau());
        SoYeuLyLich soYeuLyLich = SoYeuLyLich.builder()
                .hovaten(reqSoYeuLyLich.hovaten())
                .gioiTinh(gioiTinh)
                .cacTenGoiKhac(reqSoYeuLyLich.cacTenGoiKhac())
                .sinhNgay(reqSoYeuLyLich.sinhNgay())
                .noiSinh(reqSoYeuLyLich.noiSinh())
                .queQuan(reqSoYeuLyLich.queQuan())
                .danToc(danToc)
                .soCCCD(reqSoYeuLyLich.soCCCD())
                .ngayCapCCCD(reqSoYeuLyLich.ngayCapCCCD())
                .soDienThoai(reqSoYeuLyLich.soDienThoai())
                .soBHXH(reqSoYeuLyLich.soBHXH())
                .soBHYT(reqSoYeuLyLich.soBHYT())
                .noiOHienNay(reqSoYeuLyLich.noiOHienNay())
                .thanhPhanGiaDinh(thanhPhanGiaDinh)
                .ngheNghiepTruocKhiTuyenDung(reqSoYeuLyLich.ngheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(reqSoYeuLyLich.ngayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(reqSoYeuLyLich.coQuanToChucDonViTuyenDung())
                .ngayVaoCoQuanHienDangCongTac(reqSoYeuLyLich.ngayVaoCoQuanHienDangCongTac())
                .ngayVaoDangCongSanVietNam(reqSoYeuLyLich.ngayVaoDangCongSanVietNam())
                .ngayChinhThuc(reqSoYeuLyLich.ngayChinhThuc())
                .ngayThamGiaToChucChinhTriXaHoiDauTien(reqSoYeuLyLich.ngayThamGiaToChucChinhTriXaHoiDauTien())
                .ngayNhapNgu(reqSoYeuLyLich.ngayNhapNgu())
                .ngayXuatNgu(reqSoYeuLyLich.ngayXuatNgu())
                .capBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi)
                .doiTuongChinhSach(doiTuongChinhSach)
                .trinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong)
                .trinhDoChuyenMon(trinhDoChuyenMon)
                .hocHam(hocHam)
                .danhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang)
                .chucVuHienTai(reqSoYeuLyLich.chucVuHienTai())
                .ngayBoNhiem(reqSoYeuLyLich.ngayBoNhiem())
                .ngayBoNhiemLai(reqSoYeuLyLich.ngayBoNhiemLai())
                .duocQuyHoacChucDanh(reqSoYeuLyLich.duocQuyHoacChucDanh())
                .chucVuKiemNhiem(reqSoYeuLyLich.chucVuKiemNhiem())
                .chucVuDangHienTai(reqSoYeuLyLich.chucVuDangHienTai())
                .chucVuDangKiemNhiem(reqSoYeuLyLich.chucVuDangKiemNhiem())
                .congVienChinhDuocGiao(reqSoYeuLyLich.congVienChinhDuocGiao())
                .soTruongCongTac(reqSoYeuLyLich.soTruongCongTac())
                .congViecLamLauNhat(reqSoYeuLyLich.congViecLamLauNhat())
                .tienLuong(reqSoYeuLyLich.tienLuong())
                .ngachNgheNghiep(reqSoYeuLyLich.ngachNgheNghiep())
                .maSoNgachNgheNghiep(reqSoYeuLyLich.maSoNgachNgheNghiep())
                .ngayBoNhiemNgachNgheNghiep(reqSoYeuLyLich.ngayBoNhiemNgachNgheNghiep())
                .bacLuong(bacLuong)
                .heSoLuongNgachNgheNghiep(reqSoYeuLyLich.heSoLuongNgachNgheNghiep())
                .ngayHuongLuongNgachNgheNghiep(reqSoYeuLyLich.ngayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgachNgheNghiep(reqSoYeuLyLich.phanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgachNgheNghiep(reqSoYeuLyLich.phuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgachNgheNghiep(reqSoYeuLyLich.ngayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(reqSoYeuLyLich.phuCapChucVu())
                .phuCapKiemNhiem(reqSoYeuLyLich.phuCapKiemNhiem())
                .phuCapKhac(reqSoYeuLyLich.phuCapKhac())
                .viTriViecLam(reqSoYeuLyLich.viTriViecLam())
                .maSoViTriViecLam(reqSoYeuLyLich.maSoViTriViecLam())
                .bacLuongTriViecLam(reqSoYeuLyLich.bacLuongTriViecLam())
                .luongTheoMucTien(reqSoYeuLyLich.luongTheoMucTien())
                .ngayHuongLuongTheoViTriViecLam(reqSoYeuLyLich.ngayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(reqSoYeuLyLich.phamTramHuongLuong())
                .phuCapThamNienVuotKhung(reqSoYeuLyLich.phuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(reqSoYeuLyLich.ngayHuongPCTNVK())
                .tinhTrangSucKhoe(tinhTrangSucKhoe)
                .chieuCao(reqSoYeuLyLich.chieuCao())
                .canNang(reqSoYeuLyLich.canNang())
                .nhomMau(nhomMau)
                .build();
        soYeuLyLich.setUpdate_at();
        return soYeuLyLich;
    }


//    Optional<SoYeuLyLich> soYeuLyLichID = soYeuLyLichRepository.findById(UUID.fromString(q));
//        if(soYeuLyLichID.isPresent())
//
//    {
//        return new ResDTO<>(
//                ResEnum.THANH_CONG.getStatusCode(),
//                ResEnum.THANH_CONG,
//                soYeuLyLichID.get()
//        );
//    }
//        return new ResDTO<>(
//                ResEnum.THANH_CONG.getStatusCode(),
//    ResEnum.THANH_CONG,
//            null
//            );

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
