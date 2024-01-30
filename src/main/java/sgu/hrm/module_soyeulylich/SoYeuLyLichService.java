package sgu.hrm.module_soyeulylich;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import sgu.hrm.module_bacluong.BacLuong;
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
import sgu.hrm.module_bacluong.BacLuongRepository;
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
    public List<SoYeuLyLich> xemSoYeuLyLich() {
        return soYeuLyLichRepository.findAll();
    }

    private SoYeuLyLich soYeuLyLichObject(SoYeuLyLichDTO soYeuLyLichDTO) {
        GioiTinh gioiTinh = gioiTinhRepository.findByName(soYeuLyLichDTO.gioiTinh());
        DanToc danToc = danTocRepository.findByName(soYeuLyLichDTO.danToc());
        ThanhPhanGiaDinh thanhPhanGiaDinh = thanhPhanGiaDinhRepository.findByName(soYeuLyLichDTO.thanhPhanGiaDinh());
        CoQuanToChucDonViTuyenDung coQuanToChucDonViTuyenDung = coQuanToChucDonViTuyenDungRepository.findByName(soYeuLyLichDTO.coQuanToChucDonViTuyenDung());
        CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = capBacLoaiQuanHamQuanDoiRepository.findByName(soYeuLyLichDTO.capBacLoaiQuanHamQuanDoi());
        DoiTuongChinhSach doiTuongChinhSach = doiTuongChinhSachRepository.findByName(soYeuLyLichDTO.doiTuongChinhSach());
        TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = trinhDoGiaoDucPhoThongRepository.findByName(soYeuLyLichDTO.trinhDoGiaoDucPhoThong());
        TrinhDoChuyenMon trinhDoChuyenMon = trinhDoChuyenMonRepository.findByName(soYeuLyLichDTO.trinhDoChuyenMon());
        HocHam hocHam = hocHamRepository.findByName(soYeuLyLichDTO.hocHam());
        DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = danhHieuNhaNuocPhongTangRepository.findByName(soYeuLyLichDTO.danhHieuNhaNuocPhongTang());
        BacLuong bacLuong = bacLuongRepository.findByName(soYeuLyLichDTO.bacLuong());
        TinhTrangSucKhoe tinhTrangSucKhoe = tinhTrangSucKhoeRepository.findByTitle(soYeuLyLichDTO.tinhTrangSucKhoe());
        NhomMau nhomMau = nhomMauRepository.findByName(soYeuLyLichDTO.nhomMau());
        SoYeuLyLich soYeuLyLich = SoYeuLyLich.builder()
                .hovaten(soYeuLyLichDTO.hovaten())
                .gioiTinh(gioiTinh)
                .cacTenGoiKhac(soYeuLyLichDTO.cacTenGoiKhac())
                .sinhNgay(soYeuLyLichDTO.sinhNgay())
                .noiSinh(soYeuLyLichDTO.noiSinh())
                .queQuan(soYeuLyLichDTO.queQuan())
                .danToc(danToc)
                .soCCCD(soYeuLyLichDTO.soCCCD())
                .ngayCapCCCD(soYeuLyLichDTO.ngayCapCCCD())
                .soDienThoai(soYeuLyLichDTO.soDienThoai())
                .soBHXH(soYeuLyLichDTO.soBHXH())
                .soBHYT(soYeuLyLichDTO.soBHYT())
                .noiOHienNay(soYeuLyLichDTO.noiOHienNay())
                .thanhPhanGiaDinh(thanhPhanGiaDinh)
                .ngheNghiepTruocKhiTuyenDung(soYeuLyLichDTO.ngheNghiepTruocKhiTuyenDung())
                .ngayDuocTuyenDungLanDau(soYeuLyLichDTO.ngayDuocTuyenDungLanDau())
                .coQuanToChucDonViTuyenDung(coQuanToChucDonViTuyenDung)
                .ngayVaoCoQuanHienDangCongTac(soYeuLyLichDTO.ngayVaoCoQuanHienDangCongTac())
                .ngayVaoDangCongSanVietNam(soYeuLyLichDTO.ngayVaoDangCongSanVietNam())
                .ngayChinhThuc(soYeuLyLichDTO.ngayChinhThuc())
                .ngayThamGiaToChucChinhTriXaHoiDauTien(soYeuLyLichDTO.ngayThamGiaToChucChinhTriXaHoiDauTien())
                .ngayNhapNgu(soYeuLyLichDTO.ngayNhapNgu())
                .ngayXuatNgu(soYeuLyLichDTO.ngayXuatNgu())
                .capBacLoaiQuanHamQuanDoi(capBacLoaiQuanHamQuanDoi)
                .doiTuongChinhSach(doiTuongChinhSach)
                .trinhDoGiaoDucPhoThong(trinhDoGiaoDucPhoThong)
                .trinhDoChuyenMon(trinhDoChuyenMon)
                .hocHam(hocHam)
                .danhHieuNhaNuocPhongTang(danhHieuNhaNuocPhongTang)
                .chucVuHienTai(soYeuLyLichDTO.chucVuHienTai())
                .ngayBoNhiem(soYeuLyLichDTO.ngayBoNhiem())
                .ngayBoNhiemLai(soYeuLyLichDTO.ngayBoNhiemLai())
                .duocQuyHoacChucDanh(soYeuLyLichDTO.duocQuyHoacChucDanh())
                .chucVuKiemNhiem(soYeuLyLichDTO.chucVuKiemNhiem())
                .chucVuDangHienTai(soYeuLyLichDTO.chucVuDangHienTai())
                .chucVuDangKiemNhiem(soYeuLyLichDTO.chucVuDangKiemNhiem())
                .congVienChinhDuocGiao(soYeuLyLichDTO.congVienChinhDuocGiao())
                .soTruongCongTac(soYeuLyLichDTO.soTruongCongTac())
                .congViecLamLauNhat(soYeuLyLichDTO.congViecLamLauNhat())
                .tienLuong(soYeuLyLichDTO.tienLuong())
                .ngachNgheNghiep(soYeuLyLichDTO.ngachNgheNghiep())
                .maSoNgachNgheNghiep(soYeuLyLichDTO.maSoNgachNgheNghiep())
                .ngayBoNhiemNgachNgheNghiep(soYeuLyLichDTO.ngayBoNhiemNgachNgheNghiep())
                .bacLuong(bacLuong)
                .heSoLuongNgachNgheNghiep(soYeuLyLichDTO.heSoLuongNgachNgheNghiep())
                .ngayHuongLuongNgachNgheNghiep(soYeuLyLichDTO.ngayHuongLuongNgachNgheNghiep())
                .phanTramHuongLuongNgachNgheNghiep(soYeuLyLichDTO.phanTramHuongLuongNgachNgheNghiep())
                .phuCapThamNienVuotKhungNgachNgheNghiep(soYeuLyLichDTO.phuCapThamNienVuotKhungNgachNgheNghiep())
                .ngayHuongPCTNVKNgachNgheNghiep(soYeuLyLichDTO.ngayHuongPCTNVKNgachNgheNghiep())
                .phuCapChucVu(soYeuLyLichDTO.phuCapChucVu())
                .phuCapKiemNhiem(soYeuLyLichDTO.phuCapKiemNhiem())
                .phuCapKhac(soYeuLyLichDTO.phuCapKhac())
                .viTriViecLam(soYeuLyLichDTO.viTriViecLam())
                .maSoViTriViecLam(soYeuLyLichDTO.maSoViTriViecLam())
                .bacLuongTriViecLam(soYeuLyLichDTO.bacLuongTriViecLam())
                .luongTheoMucTien(soYeuLyLichDTO.luongTheoMucTien())
                .ngayHuongLuongTheoViTriViecLam(soYeuLyLichDTO.ngayHuongLuongTheoViTriViecLam())
                .phamTramHuongLuong(soYeuLyLichDTO.phamTramHuongLuong())
                .phuCapThamNienVuotKhung(soYeuLyLichDTO.phuCapThamNienVuotKhung())
                .ngayHuongPCTNVK(soYeuLyLichDTO.ngayHuongPCTNVK())
                .tinhTrangSucKhoe(tinhTrangSucKhoe)
                .chieuCao(soYeuLyLichDTO.chieuCao())
                .canNang(soYeuLyLichDTO.canNang())
                .nhomMau(nhomMau)
                .build();
        return soYeuLyLich;
    }

    @Override
    public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO) {
        SoYeuLyLich soYeuLyLich = soYeuLyLichObject(soYeuLyLichDTO);
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
    }

    @Override
    public void suaSoYeuLyLich(UUID uuidSoYeuLyLich) {
        Optional<SoYeuLyLich> soYeuLyLichCheck = soYeuLyLichRepository.findById(uuidSoYeuLyLich);
        if (soYeuLyLichCheck.isPresent()) {

        }

    }
}
