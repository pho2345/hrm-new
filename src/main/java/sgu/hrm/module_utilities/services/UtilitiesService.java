package sgu.hrm.module_utilities.services;

import org.springframework.stereotype.Service;
import sgu.hrm.module_utilities.models.CapBacLoaiQuanHamQuanDoi;
import sgu.hrm.module_utilities.models.DanToc;
import sgu.hrm.module_utilities.models.DanhHieuNhaNuocPhongTang;
import sgu.hrm.module_utilities.models.DoiTuongChinhSach;
import sgu.hrm.module_utilities.models.GioiTinh;
import sgu.hrm.module_utilities.models.HocHam;
import sgu.hrm.module_utilities.models.NhomMau;
import sgu.hrm.module_utilities.models.ThanhPhanGiaDinh;
import sgu.hrm.module_utilities.models.TinhTrangSucKhoe;
import sgu.hrm.module_utilities.models.TonGiao;
import sgu.hrm.module_utilities.models.TrinhDoChuyenMon;
import sgu.hrm.module_utilities.models.TrinhDoGiaoDucPhoThong;
import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
import sgu.hrm.module_utilities.repositories.DanTocRepository;
import sgu.hrm.module_utilities.repositories.DanhHieuNhaNuocPhongTangRepository;
import sgu.hrm.module_utilities.repositories.DoiTuongChinhSachRepository;
import sgu.hrm.module_utilities.repositories.GioiTinhRepository;
import sgu.hrm.module_utilities.repositories.HocHamRepository;
import sgu.hrm.module_utilities.repositories.NhomMauRepository;
import sgu.hrm.module_utilities.repositories.ThanhPhanGiaDinhRepository;
import sgu.hrm.module_utilities.repositories.TinhTrangSucKhoeRepository;
import sgu.hrm.module_utilities.repositories.TonGiaoRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoChuyenMonRepository;
import sgu.hrm.module_utilities.repositories.TrinhDoGiaoDucPhoThongRepository;

import java.util.List;

@Service
public class UtilitiesService implements IUtilitiesService.ICapBacLoaiQuanHamQuanDoiService,
        IUtilitiesService.IDanhHieuNhaNuocPhongTangService, IUtilitiesService.IDanTocService,
        IUtilitiesService.IDoiTuongChinhSachService, IUtilitiesService.IGioiTinhService,
        IUtilitiesService.IHocHamService, IUtilitiesService.INhomMauService,
        IUtilitiesService.IThanhPhanGiaDinhService, IUtilitiesService.ITinhTrangSucKhoeService,
        IUtilitiesService.ITonGiaoService, IUtilitiesService.ITrinhDoChuyenMonService,
        IUtilitiesService.ITrinhDoGiaoDucPhoThongService {
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

    public UtilitiesService(CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository,
                            DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository,
                            DanTocRepository danTocRepository, DoiTuongChinhSachRepository doiTuongChinhSachRepository,
                            GioiTinhRepository gioiTinhRepository, HocHamRepository hocHamRepository,
                            NhomMauRepository nhomMauRepository, ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository,
                            TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository, TonGiaoRepository tonGiaoRepository,
                            TrinhDoChuyenMonRepository trinhDoChuyenMonRepository,
                            TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository) {
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

    @Override
    public List<CapBacLoaiQuanHamQuanDoi> xemCapBacLoaiQuanHamQuanDoi() {
        return capBacLoaiQuanHamQuanDoiRepository.findAll();
    }

    @Override
    public List<DanhHieuNhaNuocPhongTang> xemDanhHieuNhaNuocPhongTang() {
        return danhHieuNhaNuocPhongTangRepository.findAll();
    }

    @Override
    public List<DanToc> xemDanToc() {
        return danTocRepository.findAll();
    }

    @Override
    public List<DoiTuongChinhSach> xemDoiTuongChinhSach() {
        return doiTuongChinhSachRepository.findAll();
    }

    @Override
    public List<GioiTinh> xemGioiTinh() {
        return gioiTinhRepository.findAll();
    }

    @Override
    public List<HocHam> xemHocHam() {
        return hocHamRepository.findAll();
    }

    @Override
    public List<NhomMau> xemNhomMau() {
        return nhomMauRepository.findAll();
    }

    @Override
    public List<ThanhPhanGiaDinh> xemThanhPhanGiaDinh() {
        return thanhPhanGiaDinhRepository.findAll();
    }

    @Override
    public List<TinhTrangSucKhoe> xemTinhTrangSucKhoe() {
        return tinhTrangSucKhoeRepository.findAll();
    }

    @Override
    public List<TonGiao> xemTonGiao() {
        return tonGiaoRepository.findAll();
    }

    @Override
    public List<TrinhDoChuyenMon> xemTrinhDoChuyenMon() {
        return trinhDoChuyenMonRepository.findAll();
    }

    @Override
    public List<TrinhDoGiaoDucPhoThong> xemTrinhDoGiaoDucPhoThong() {
        return trinhDoGiaoDucPhoThongRepository.findAll();
    }
}
