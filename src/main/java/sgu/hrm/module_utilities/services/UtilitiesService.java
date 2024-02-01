package sgu.hrm.module_utilities.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_utilities.models.BacLuong;
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
import java.util.Optional;

@Service
@RequiredArgsConstructor // if field is set final or @not null
public class UtilitiesService {
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

//    public UtilitiesService(
//            BacLuongRepository bacLuongRepository, LoaiQuanHamQuanDoiRepository loaiQuanHamQuanDoiRepository,
//            CapBacLoaiQuanHamQuanDoiRepository capBacLoaiQuanHamQuanDoiRepository,
//            DanhHieuNhaNuocPhongTangRepository danhHieuNhaNuocPhongTangRepository,
//            DanTocRepository danTocRepository, DoiTuongChinhSachRepository doiTuongChinhSachRepository,
//            GioiTinhRepository gioiTinhRepository, HocHamRepository hocHamRepository,
//            NhomMauRepository nhomMauRepository, ThanhPhanGiaDinhRepository thanhPhanGiaDinhRepository,
//            TinhTrangSucKhoeRepository tinhTrangSucKhoeRepository, TonGiaoRepository tonGiaoRepository,
//            TrinhDoChuyenMonRepository trinhDoChuyenMonRepository,
//            TrinhDoGiaoDucPhoThongRepository trinhDoGiaoDucPhoThongRepository) {
//        this.bacLuongRepository = bacLuongRepository;
//        this.loaiQuanHamQuanDoiRepository = loaiQuanHamQuanDoiRepository;
//        this.capBacLoaiQuanHamQuanDoiRepository = capBacLoaiQuanHamQuanDoiRepository;
//        this.danhHieuNhaNuocPhongTangRepository = danhHieuNhaNuocPhongTangRepository;
//        this.danTocRepository = danTocRepository;
//        this.doiTuongChinhSachRepository = doiTuongChinhSachRepository;
//        this.gioiTinhRepository = gioiTinhRepository;
//        this.hocHamRepository = hocHamRepository;
//        this.nhomMauRepository = nhomMauRepository;
//        this.thanhPhanGiaDinhRepository = thanhPhanGiaDinhRepository;
//        this.tinhTrangSucKhoeRepository = tinhTrangSucKhoeRepository;
//        this.tonGiaoRepository = tonGiaoRepository;
//        this.trinhDoChuyenMonRepository = trinhDoChuyenMonRepository;
//        this.trinhDoGiaoDucPhoThongRepository = trinhDoGiaoDucPhoThongRepository;
//    }

    @Service
    public class BacLuongService implements IUtilitiesService.IBacLuongService {
        public ResDTO<List<BacLuong>> xemBacLuong() {
            //        return capBacLoaiQuanHamQuanDoiRepository.findAll();
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    bacLuongRepository.findAll()
            );
        }

        @Override
        public ResDTO<BacLuong> themBacLuong(String name) {
            BacLuong bacLuong = new BacLuong(name);
            try {
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        bacLuongRepository.save(bacLuong)
                );
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Override
        public ResDTO<BacLuong> suaBacLuong(BacLuong luong) {
            Optional<BacLuong> bacLuong = bacLuongRepository.findById(luong.getId());
            try {
                if (bacLuong.isPresent()) {
                    luong.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            bacLuongRepository.save(luong));
                }
                return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null);
            } catch (RuntimeException e) {
                return new ResDTO<>(
                        ResEnum.KHONG_HOP_LE.getStatusCode(),
                        ResEnum.KHONG_HOP_LE,
                        null
                );
            }
        }

        @Service
        public class LoaiQuanHamQuanDoiService implements IUtilitiesService.ILoaiQuanHamQuanDoiService {
            @Override
            public ResDTO<List<LoaiQuanHamQuanDoi>> xemLoaiQuanHamQuanDoi() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        loaiQuanHamQuanDoiRepository.findAll()
                );
            }

            @Override
            public ResDTO<LoaiQuanHamQuanDoi> themLoaiQuanHamQuanDoi(String name) {
                LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = new LoaiQuanHamQuanDoi(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            loaiQuanHamQuanDoiRepository.save(loaiQuanHamQuanDoi)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<LoaiQuanHamQuanDoi> suaLoaiQuanHamQuanDoi(LoaiQuanHamQuanDoi loaiQuanHamQuanDoi) {
                Optional<LoaiQuanHamQuanDoi> loaiQuanHamQuanDoi1 = loaiQuanHamQuanDoiRepository.findById(loaiQuanHamQuanDoi.getId());
                try {
                    if (loaiQuanHamQuanDoi1.isPresent()) {
                        loaiQuanHamQuanDoi.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                loaiQuanHamQuanDoiRepository.save(loaiQuanHamQuanDoi));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class CapBacLoaiQuanHamQuanDoiService implements IUtilitiesService.ICapBacLoaiQuanHamQuanDoiService {
            @Override
            public ResDTO<List<CapBacLoaiQuanHamQuanDoi>> xemCapBacLoaiQuanHamQuanDoi() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        capBacLoaiQuanHamQuanDoiRepository.findAll()
                );
            }

            @Override
            public ResDTO<CapBacLoaiQuanHamQuanDoi> themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName) {
                LoaiQuanHamQuanDoi loaiQuanHamQuanDoi = loaiQuanHamQuanDoiRepository.findByName(loaiQuanHamName);
                CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi = new CapBacLoaiQuanHamQuanDoi(name, loaiQuanHamQuanDoi);
                try {
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            capBacLoaiQuanHamQuanDoiRepository.save(capBacLoaiQuanHamQuanDoi)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            null
                    );
                }
            }

            @Override
            public ResDTO<CapBacLoaiQuanHamQuanDoi> suaCapBacLoaiQuanHamQuanDoi(CapBacLoaiQuanHamQuanDoi capBacLoaiQuanHamQuanDoi) {
                Optional<CapBacLoaiQuanHamQuanDoi> capBacLoaiQuanHamQuanDoi1 = capBacLoaiQuanHamQuanDoiRepository.findById(capBacLoaiQuanHamQuanDoi.getId());
                try {
                    if (capBacLoaiQuanHamQuanDoi1.isPresent()) {
                        capBacLoaiQuanHamQuanDoi.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                capBacLoaiQuanHamQuanDoiRepository.save(capBacLoaiQuanHamQuanDoi));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class DanhHieuNhaNuocPhongTangService implements IUtilitiesService.IDanhHieuNhaNuocPhongTangService {
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
            public ResDTO<DanhHieuNhaNuocPhongTang> themDanhHieuNhaNuocPhongTang(String name) {
                DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang = new DanhHieuNhaNuocPhongTang(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            danhHieuNhaNuocPhongTangRepository.save(danhHieuNhaNuocPhongTang)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<DanhHieuNhaNuocPhongTang> suaDanhHieuNhaNuocPhongTang(DanhHieuNhaNuocPhongTang danhHieuNhaNuocPhongTang) {
                Optional<DanhHieuNhaNuocPhongTang> danhHieuNhaNuocPhongTang1 = danhHieuNhaNuocPhongTangRepository.findById(danhHieuNhaNuocPhongTang.getId());
                try {
                    if (danhHieuNhaNuocPhongTang1.isPresent()) {
                        danhHieuNhaNuocPhongTang.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                danhHieuNhaNuocPhongTangRepository.save(danhHieuNhaNuocPhongTang));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class DanTocService implements IUtilitiesService.IDanTocService {
            @Override
            public ResDTO<List<DanToc>> xemDanToc() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        danTocRepository.findAll()
                );
            }

            @Override
            public ResDTO<DanToc> themDanToc(String name) {
                DanToc danToc = new DanToc();
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            danTocRepository.save(danToc)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<DanToc> suaDanToc(DanToc toc) {
                Optional<DanToc> danToc = danTocRepository.findById(toc.getId());
                try {
                    if (danToc.isPresent()) {
                        toc.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                danTocRepository.save(toc));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class DoiTuongChinhSachService implements IUtilitiesService.IDoiTuongChinhSachService {
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
            public ResDTO<DoiTuongChinhSach> themDoiTuongChinhSach(String name) {
                DoiTuongChinhSach doiTuongChinhSach = new DoiTuongChinhSach(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            doiTuongChinhSachRepository.save(doiTuongChinhSach)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<DoiTuongChinhSach> suaDoiTuongChinhSach(DoiTuongChinhSach doiTuongChinhSach) {
                Optional<DoiTuongChinhSach> doiTuongChinhSach1 = doiTuongChinhSachRepository.findById(doiTuongChinhSach.getId());
                try {
                    if (doiTuongChinhSach1.isPresent()) {
                        doiTuongChinhSach.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                doiTuongChinhSachRepository.save(doiTuongChinhSach));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class GioiTinhService implements IUtilitiesService.IGioiTinhService {
            @Override
            public ResDTO<List<GioiTinh>> xemGioiTinh() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        gioiTinhRepository.findAll()
                );
            }
        }

        @Service
        public class HocHamService implements IUtilitiesService.IHocHamService {
            @Override
            public ResDTO<List<HocHam>> xemHocHam() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        hocHamRepository.findAll()
                );
            }

            @Override
            public ResDTO<HocHam> themHocHam(String name) {
                HocHam hocHam = new HocHam(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            hocHamRepository.save(hocHam)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<HocHam> suaHocHam(HocHam hocHam) {
                Optional<HocHam> hocHam1 = hocHamRepository.findById(hocHam.getId());
                try {
                    if (hocHam1.isPresent()) {
                        hocHam.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                hocHamRepository.save(hocHam));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class NhomMauService implements IUtilitiesService.INhomMauService {
            @Override
            public ResDTO<List<NhomMau>> xemNhomMau() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        nhomMauRepository.findAll()
                );
            }

            @Override
            public ResDTO<NhomMau> themNhomMau(String name) {
                NhomMau nhomMau = new NhomMau();
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            nhomMauRepository.save(nhomMau)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<NhomMau> suaNhomMau(NhomMau nhomMau) {
                Optional<NhomMau> nhomMau1 = nhomMauRepository.findById(nhomMau.getId());
                try {
                    if (nhomMau1.isPresent()) {
                        nhomMau.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                nhomMauRepository.save(nhomMau));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class ThanhPhanGiaDinhService implements IUtilitiesService.IThanhPhanGiaDinhService {
            @Override
            public ResDTO<List<ThanhPhanGiaDinh>> xemThanhPhanGiaDinh() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        thanhPhanGiaDinhRepository.findAll()
                );
            }

            @Override
            public ResDTO<ThanhPhanGiaDinh> themThanhPhanGiaDinh(String name) {
                ThanhPhanGiaDinh thanhPhanGiaDinh = new ThanhPhanGiaDinh(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            thanhPhanGiaDinhRepository.save(thanhPhanGiaDinh)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<ThanhPhanGiaDinh> suaThanhPhanGiaDinh(ThanhPhanGiaDinh thanhPhanGiaDinh) {
                Optional<ThanhPhanGiaDinh> thanhPhanGiaDinh1 = thanhPhanGiaDinhRepository.findById(thanhPhanGiaDinh.getId());
                try {
                    if (thanhPhanGiaDinh1.isPresent()) {
                        thanhPhanGiaDinh.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                thanhPhanGiaDinhRepository.save(thanhPhanGiaDinh));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class TinhTrangSucKhoeService implements IUtilitiesService.ITinhTrangSucKhoeService {
            @Override
            public ResDTO<List<TinhTrangSucKhoe>> xemTinhTrangSucKhoe() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tinhTrangSucKhoeRepository.findAll()
                );
            }

            @Override
            public ResDTO<TinhTrangSucKhoe> themTinhTrangSucKhoe(String name) {
                TinhTrangSucKhoe tinhTrangSucKhoe = new TinhTrangSucKhoe(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            tinhTrangSucKhoeRepository.save(tinhTrangSucKhoe)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<TinhTrangSucKhoe> suaTinhTrangSucKhoe(TinhTrangSucKhoe tinhTrangSucKhoe) {
                Optional<TinhTrangSucKhoe> tinhTrangSucKhoe1 = tinhTrangSucKhoeRepository.findById(tinhTrangSucKhoe.getId());
                try {
                    if (tinhTrangSucKhoe1.isPresent()) {
                        tinhTrangSucKhoe.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                tinhTrangSucKhoeRepository.save(tinhTrangSucKhoe));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class TonGiaoService implements IUtilitiesService.ITonGiaoService {
            @Override
            public ResDTO<List<TonGiao>> xemTonGiao() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tonGiaoRepository.findAll()
                );
            }

            @Override
            public ResDTO<TonGiao> themTonGiao(String name) {
                TonGiao tonGiao = new TonGiao(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            tonGiaoRepository.save(tonGiao)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<TonGiao> suaTonGiao(TonGiao tonGiao) {
                Optional<TonGiao> tonGiao1 = tonGiaoRepository.findById(tonGiao.getId());
                try {
                    if (tonGiao1.isPresent()) {
                        tonGiao.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                tonGiaoRepository.save(tonGiao));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class TrinhDoChuyenMonService implements IUtilitiesService.ITrinhDoChuyenMonService {
            @Override
            public ResDTO<List<TrinhDoChuyenMon>> xemTrinhDoChuyenMon() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        trinhDoChuyenMonRepository.findAll()
                );
            }

            @Override
            public ResDTO<TrinhDoChuyenMon> themTrinhDoChuyenMon(String name) {
                TrinhDoChuyenMon trinhDoChuyenMon = new TrinhDoChuyenMon(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            trinhDoChuyenMonRepository.save(trinhDoChuyenMon)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<TrinhDoChuyenMon> suaTrinhDoChuyenMon(TrinhDoChuyenMon trinhDoChuyenMon) {
                Optional<TrinhDoChuyenMon> trinhDoChuyenMon1 = trinhDoChuyenMonRepository.findById(trinhDoChuyenMon.getId());
                try {
                    if (trinhDoChuyenMon1.isPresent()) {
                        trinhDoChuyenMon.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                trinhDoChuyenMonRepository.save(trinhDoChuyenMon));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }

        @Service
        public class TrinhDoGiaoDucPhoThongService implements IUtilitiesService.ITrinhDoGiaoDucPhoThongService {
            @Override
            public ResDTO<List<TrinhDoGiaoDucPhoThong>> xemTrinhDoGiaoDucPhoThong() {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        trinhDoGiaoDucPhoThongRepository.findAll()
                );
            }

            @Override
            public ResDTO<TrinhDoGiaoDucPhoThong> themTrinhDoGiaoDucPhoThong(String name) {
                TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong = new TrinhDoGiaoDucPhoThong(name);
                try {
                    return new ResDTO<>(
                            ResEnum.TAO_THANH_CONG.getStatusCode(),
                            ResEnum.TAO_THANH_CONG,
                            trinhDoGiaoDucPhoThongRepository.save(trinhDoGiaoDucPhoThong)
                    );
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }

            @Override
            public ResDTO<TrinhDoGiaoDucPhoThong> suaTrinhDoGiaoDucPhoThong(TrinhDoGiaoDucPhoThong trinhDoGiaoDucPhoThong) {
                Optional<TrinhDoGiaoDucPhoThong> trinhDoGiaoDucPhoThong1 = trinhDoGiaoDucPhoThongRepository.findById(trinhDoGiaoDucPhoThong.getId());
                try {
                    if (trinhDoGiaoDucPhoThong1.isPresent()) {
                        trinhDoGiaoDucPhoThong.setUpdate_at();
                        return new ResDTO<>(
                                ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                                ResEnum.CAP_NHAT_THANH_CONG,
                                trinhDoGiaoDucPhoThongRepository.save(trinhDoGiaoDucPhoThong));
                    }
                    return new ResDTO<>(
                            ResEnum.HONG_TIM_THAY.getStatusCode(),
                            ResEnum.HONG_TIM_THAY,
                            null);
                } catch (RuntimeException e) {
                    return new ResDTO<>(
                            ResEnum.KHONG_HOP_LE.getStatusCode(),
                            ResEnum.KHONG_HOP_LE,
                            null
                    );
                }
            }
        }
    }
}
