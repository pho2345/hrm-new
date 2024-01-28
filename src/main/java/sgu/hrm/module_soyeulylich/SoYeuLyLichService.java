package sgu.hrm.module_soyeulylich;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import sgu.hrm.models.BacLuong;
import sgu.hrm.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.models.CoQuanToChucDonViTuyenDung;
import sgu.hrm.models.DanToc;
import sgu.hrm.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.models.DoiTuongChinhSach;
import sgu.hrm.models.GioiTinh;
import sgu.hrm.models.HocHam;
import sgu.hrm.models.NhomMau;
import sgu.hrm.models.ThanhPhanGiaDinh;
import sgu.hrm.models.TinhTrangSucKhoe;
import sgu.hrm.models.TrinhDoChuyenMon;
import sgu.hrm.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.repository.BacLuongRepository;
import sgu.hrm.repository.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.repository.CoQuanToChucDonViTuyenDungRepository;
import sgu.hrm.repository.DanTocRepository;
import sgu.hrm.repository.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.repository.DoiTuongChinhSachRepository;
import sgu.hrm.repository.GioiTinhRepository;
import sgu.hrm.repository.HocHamRepository;
import sgu.hrm.repository.NhomMauRepository;
import sgu.hrm.repository.ThanhPhanGiaDinhRepository;
import sgu.hrm.repository.TinhTrangSucKhoeRepository;
import sgu.hrm.repository.TrinhDoChuyenMonRepository;
import sgu.hrm.repository.TrinhDoGiaoDucPhoThongRepository;

import java.util.List;

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

    @Override
    public void themSoYeuLyLich(SoYeuLyLichDTO soYeuLyLichDTO) {
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
}
