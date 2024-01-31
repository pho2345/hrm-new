package sgu.hrm.module_utilities.services;

import org.springframework.stereotype.Service;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_utilities.models.BacLuong;
import sgu.hrm.module_utilities.models.resopnse.UtilitiesResponse;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.LoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.repositories.BacLuongRepository;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.GioiTinhRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.LoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_utilities.repositories.TinhTrangSucKhoeRepository;
import sgu.hrm.module_utilities.repositories.TonGiaoRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;

import java.util.List;

@Service
public class UtilitiesService implements
        IUtilitiesService.IBacLuongService,
        IUtilitiesService.ILoaiQuanHamQuanDoiService,
        IUtilitiesService.ICapBacLoaiQuanHamQuanDoiService,
        IUtilitiesService.IDanhHieuNhaNuocPhongTangService, IUtilitiesService.IDanTocService,
        IUtilitiesService.IDoiTuongChinhSachService, IUtilitiesService.IGioiTinhService,
        IUtilitiesService.IHocHamService, IUtilitiesService.INhomMauService,
        IUtilitiesService.IThanhPhanGiaDinhService, IUtilitiesService.ITinhTrangSucKhoeService,
        IUtilitiesService.ITonGiaoService, IUtilitiesService.ITrinhDoChuyenMonService,
        IUtilitiesService.ITrinhDoGiaoDucPhoThongService {
    private final BacLuongRepository bacLuongRepository;
    private final LoaiQuanHamQuanDoiRepository loaiQuanHamQuanDoiRepository;
    private final CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository;
    private final DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository;
    private final DanTocRepository danTocRepository;
    private final DoiTuongChinhSachRepository doiTuongChinhSachRepository;
    private final GioiTinhRepository gioiTinhRepository;
    private final HocHamRepository hocHamRepository;
    private final NhomMauRepository nhomMauRepository;
    private final ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository;
    private final TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository;
    private final TonGiaoRepository tonGiaoRepository;
    private final TrinhDoChuyenMonRepository trinhDoChuyenMonRepository;
    private final TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository;

    // nếu dùng này thì lỗi, vì sao ? vì constructor gán giá trị khi tạo đối tượng
    //kể cả hằng số nghĩa là khi dùng từ khóa neu để khởi tạo thì field có final sẽ được
    //constructor gán giá trị đúng 1 lần
//    public UtilitiesService() {
//    }

    public UtilitiesService(
            BacLuongRepository bacLuongRepository,
            LoaiQuanHamQuanDoiRepository loaiQuanHamQuanDoiRepository,
            CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository,
            DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository,
            DanTocRepository danTocRepository, DoiTuongChinhSachRepository doiTuongChinhSachRepository,
            GioiTinhRepository gioiTinhRepository, HocHamRepository hocHamRepository,
            NhomMauRepository nhomMauRepository, ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository,
            TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository, TonGiaoRepository tonGiaoRepository,
            TrinhDoChuyenMonRepository trinhDoChuyenMonRepository,
            TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository) {
        this.bacLuongRepository = bacLuongRepository;
        this.loaiQuanHamQuanDoiRepository = loaiQuanHamQuanDoiRepository;
        this.capBacLoaiQuanHamQuanDoiRepository = capBacLoaiQuanHamQuanDoiRepository;
        this.danhHieuNhaNuocPhongTangRepository = danhHieuNhaNuocPhongTangRepository;
        this.danTocRepository = danTocRepository;
        this.doiTuongChinhSachRepository = doiTuongChinhSachRepository;
        this.gioiTinhRepository = gioiTinhRepository;
        this.hocHamRepository = hocHamRepository;
        this.nhomMauRepository = nhomMauRepository;
        this.thanhPhanGiaDinhRepository = thanhPhanGiaDinhRepository;
        this.tinhTrangSucKhoeRepository = tinhTrangSucKhoeRepository;
        this.tonGiaoRepository = tonGiaoRepository;
        this.trinhDoChuyenMonRepository = trinhDoChuyenMonRepository;
        this.trinhDoGiaoDucPhoThongRepository = trinhDoGiaoDucPhoThongRepository;
    }

    public ResDTO<List<BacLuong>> xemBacLuong() {
//        return capBacLoaiQuanHamQuanDoiRepository.findAll();
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                bacLuongRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<LoaiQuanHamQuanDoi>> xemLoaiQuanHamQuanDoi() {
//        return capBacLoaiQuanHamQuanDoiRepository.findAll();
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                loaiQuanHamQuanDoiRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<CapBacLoaiQuanHamQuanDoi>> xemCapBacLoaiQuanHamQuanDoi() {
//        return capBacLoaiQuanHamQuanDoiRepository.findAll();
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                capBacLoaiQuanHamQuanDoiRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<DanhHieuNhaNuocPhongTang>> xemDanhHieuNhaNuocPhongTang() {
//        return danhHieuNhaNuocPhongTangRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                danhHieuNhaNuocPhongTangRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                danhHieuNhaNuocPhongTangRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<DanToc>> xemDanToc() {
//        return danTocRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                danTocRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                danTocRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<DoiTuongChinhSach>> xemDoiTuongChinhSach() {
//        return doiTuongChinhSachRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                doiTuongChinhSachRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                doiTuongChinhSachRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<GioiTinh>> xemGioiTinh() {
//        return gioiTinhRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                gioiTinhRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                gioiTinhRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<HocHam>> xemHocHam() {
//        return hocHamRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                hocHamRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                hocHamRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<NhomMau>> xemNhomMau() {
//        return nhomMauRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                nhomMauRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                nhomMauRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<ThanhPhanGiaDinh>> xemThanhPhanGiaDinh() {
//        return thanhPhanGiaDinhRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                thanhPhanGiaDinhRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                thanhPhanGiaDinhRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<TinhTrangSucKhoe>> xemTinhTrangSucKhoe() {
//        return tinhTrangSucKhoeRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                tinhTrangSucKhoeRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                tinhTrangSucKhoeRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<TonGiao>> xemTonGiao() {
//        return tonGiaoRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                tonGiaoRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                tonGiaoRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<TrinhDoChuyenMon>> xemTrinhDoChuyenMon() {
//        return trinhDoChuyenMonRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                trinhDoChuyenMonRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                trinhDoChuyenMonRepository.findAll()
        );
    }

    @Override
    public ResDTO<List<TrinhDoGiaoDucPhoThong>> xemTrinhDoGiaoDucPhoThong() {
//        return trinhDoGiaoDucPhoThongRepository.findAll();
//        return new UtilitiesResponse<>(UtilitiesResponse.UtilitiesNotification.UTILITIES_SUCCESS,
//                200,
//                trinhDoGiaoDucPhoThongRepository.findAll()
//        );
        return new ResDTO<>(
                ResEnum.THANH_CONG.getStatusCode(),
                ResEnum.THANH_CONG,
                trinhDoGiaoDucPhoThongRepository.findAll()
        );
    }


}
