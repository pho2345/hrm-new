package sgu.hrm.module_soyeulylich_chitiet.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich_chitiet.models.BanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.KhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.KienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.KyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.LamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.LoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.LuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.LyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.NghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.NgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.PhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.QuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.TinHoc;

import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.request.ReqTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.response.ResTinHoc;
import sgu.hrm.module_soyeulylich_chitiet.repositories.BanThanCoLamViecChoCheDoCuRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KhenThuongRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KienThucAnNinhQuocPhongRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.KyLuatRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LamViecONuocNgoaiRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LoaiSoYeuLyLichChiTietRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LuongBanThanRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.LyLuanChinhTriRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.NghiepVuChuyenNganhRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.NgoaiNguRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.PhuCapKhacRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.QuaTrinhCongTacRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.QuanHeGiaDinhRepository;
import sgu.hrm.module_soyeulylich_chitiet.repositories.TinHocRepository;
import sgu.hrm.module_taikhoan.models.TaiKhoan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor // create constructor if field is set final or @notnull
public class SoYeuLyLichChiTietServices {
    //DI
    private final LoaiSoYeuLyLichChiTietRepository loaiSoYeuLyLichChiTietRepository;
    private final BanThanCoLamViecChoCheDoCuRepository banThanCoLamViecChoCheDoCuRepository;
    private final KhenThuongRepository khenThuongRepository;
    private final KienThucAnNinhQuocPhongRepository kienThucAnNinhQuocPhongRepository;
    private final KyLuatRepository kyLuatRepository;
    private final LamViecONuocNgoaiRepository lamViecONuocNgoaiRepository;
    private final LuongBanThanRepository luongBanThanRepository;
    private final LyLuanChinhTriRepository lyLuanChinhTriRepository;
    private final NghiepVuChuyenNganhRepository nghiepVuChuyenNganhRepository;
    private final NgoaiNguRepository ngoaiNguRepository;
    private final PhuCapKhacRepository phuCapKhacRepository;
    private final QuanHeGiaDinhRepository quanHeGiaDinhRepository;
    private final QuaTrinhCongTacRepository quaTrinhCongTacRepository;
    private final TinHocRepository tinHocRepository;

    private TaiKhoan crush_em_T() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return (TaiKhoan) auth.getPrincipal();
        } else return null;
    }

    @Service
    class LoaiSoYeuLyLichChiTietService implements ISoYeuLyLichChiTietServices.ILoaiSoYeuLyLichChiTietSefvice {

        @Override
        public ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        loaiSoYeuLyLichChiTietRepository.findAll()
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
        public ResDTO<LoaiSoYeuLyLichChiTiet> themLoaiSoYeuLyLichChiTiet(ReqLoaiSoYeuLyLichChiTiet name) {
            LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet = new LoaiSoYeuLyLichChiTiet(name.name());
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        loaiSoYeuLyLichChiTietRepository.save(loaiSoYeuLyLichChiTiet)
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
        public ResDTO<LoaiSoYeuLyLichChiTiet> suaLoaiSoYeuLyLichChiTiet(LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet) {
            Optional<LoaiSoYeuLyLichChiTiet> loaiSoYeuLyLichChiTiet1 = loaiSoYeuLyLichChiTietRepository.findById(loaiSoYeuLyLichChiTiet.getId());
            if (loaiSoYeuLyLichChiTiet1.isPresent()) {
                loaiSoYeuLyLichChiTiet.setUpdate_at(); //update thoi gian sua entity nay, ok
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        loaiSoYeuLyLichChiTietRepository.save(loaiSoYeuLyLichChiTiet)
                );
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    public class BanThanCoLamViecChoCheDoCuService extends ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice {
        private ResBanThanCoLamViecChoCheDoCu mapToResBanThanCoLamViecChoCheDoCu(BanThanCoLamViecChoCheDoCu cu) {
            return new ResBanThanCoLamViecChoCheDoCu(
                    cu.getId(),
                    cu.getBatDau(),
                    cu.getKetThuc(),
                    cu.getChucDanhDonViDiaDiem(),
                    cu.getCreate_at(),
                    cu.getUpdate_at()
            );
        }

        private BanThanCoLamViecChoCheDoCu mapToBanThanCoLamViecChoCheDoCu(int check, SoYeuLyLich syll, ReqBanThanCoLamViecChoCheDoCu cu) {
            return check == 1 ? BanThanCoLamViecChoCheDoCu.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .chucDanhDonViDiaDiem(cu.chucDanhDonViDiaDiem())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new BanThanCoLamViecChoCheDoCu(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.chucDanhDonViDiaDiem(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResBanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCus = new ArrayList<>();
                if (taiKhoan != null) {
                    banThanCoLamViecChoCheDoCus = taiKhoan.getSoYeuLyLich().getBanThanCoLamViecChoCheDoCus().stream().map(
                            this::mapToResBanThanCoLamViecChoCheDoCu
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        banThanCoLamViecChoCheDoCus
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResBanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCus = null;
                if (taiKhoan != null) {
                    banThanCoLamViecChoCheDoCus = taiKhoan.getSoYeuLyLich().getBanThanCoLamViecChoCheDoCus().stream().map(
                            this::mapToResBanThanCoLamViecChoCheDoCu
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        banThanCoLamViecChoCheDoCus
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqBanThanCoLamViecChoCheDoCu cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                BanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCu = null;
                if (taiKhoan != null) {
                    banThanCoLamViecChoCheDoCu = mapToBanThanCoLamViecChoCheDoCu(-1, taiKhoan.getSoYeuLyLich(), cu);
                    //banThanCoLamViecChoCheDoCuRepository.save(banThanCoLamViecChoCheDoCu);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        banThanCoLamViecChoCheDoCu != null ? mapToResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCu) : null
                );

            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqBanThanCoLamViecChoCheDoCu cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                BanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCu = null;
                if (taiKhoan != null) {
                    banThanCoLamViecChoCheDoCu = mapToBanThanCoLamViecChoCheDoCu(1, taiKhoan.getSoYeuLyLich(), cu);
                    banThanCoLamViecChoCheDoCu.setId(id);
                    banThanCoLamViecChoCheDoCuRepository.save(banThanCoLamViecChoCheDoCu);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        banThanCoLamViecChoCheDoCu != null ? mapToResBanThanCoLamViecChoCheDoCu(banThanCoLamViecChoCheDoCu) : null
                );

            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                BanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCu = null;
                if (taiKhoan != null) {
                    banThanCoLamViecChoCheDoCu = taiKhoan.getSoYeuLyLich().getBanThanCoLamViecChoCheDoCus().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    banThanCoLamViecChoCheDoCuRepository.delete(banThanCoLamViecChoCheDoCu);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<BanThanCoLamViecChoCheDoCu>> xemBanThanCoLamViecChoCheDoCu() {
//            try {
//                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//                if (!(auth instanceof AnonymousAuthenticationToken)) {
//                    TaiKhoan taiKhoan = (TaiKhoan) auth.getPrincipal();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            taiKhoan.getSoYeuLyLich().getBanThanCoLamViecChoCheDoCus()
//                    );
//                }
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<BanThanCoLamViecChoCheDoCu>> themBanThanCoLamViecChoCheDoCu(String loaisyllctName, String soCCCD, List<ReqBanThanCoLamViecChoCheDoCu> cuu) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCu = cuu.stream().map(
//                        cu -> new BanThanCoLamViecChoCheDoCu(cu.batDau(), cu.ketThuc(), cu.chucDanhDonViDiaDiem(), chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        banThanCoLamViecChoCheDoCuRepository.saveAll(banThanCoLamViecChoCheDoCu)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<BanThanCoLamViecChoCheDoCu> suaBanThanCoLamViecChoCheDoCu(int id, ReqBanThanCoLamViecChoCheDoCu cu) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(cu.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(cu.soYeuLyLich());
//                Optional<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCu = banThanCoLamViecChoCheDoCuRepository.findById(id);
//                if (banThanCoLamViecChoCheDoCu.isPresent()) {
//                    BanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCu1 = BanThanCoLamViecChoCheDoCu.builder()
//                            .id(banThanCoLamViecChoCheDoCu.get().getId())
//                            .batDau(cu.batDau())
//                            .ketThuc(cu.ketThuc())
//                            .chucDanhDonViDiaDiem(cu.chucDanhDonViDiaDiem())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    banThanCoLamViecChoCheDoCu1.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            banThanCoLamViecChoCheDoCuRepository.save(banThanCoLamViecChoCheDoCu1)
//                    );
//                } else return new ResDTO<>(
//                        ResEnum.HONG_TIM_THAY.getStatusCode(),
//                        ResEnum.HONG_TIM_THAY,
//                        null
//                );
//            } catch (RuntimeException e) {
//                e.getLocalizedMessage();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class KhenThuongService extends ISoYeuLyLichChiTietServices.IKhenThuongSefvice {
        //        @Override
//        public ResDTO<List<KhenThuong>> xemKhenThuong() {
//            try {
//                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//                TaiKhoan taiKhoan = (TaiKhoan) auth.getPrincipal();
//                if (!(auth instanceof AnonymousAuthenticationToken)) {
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            taiKhoan.getSoYeuLyLich().getKhenThuongs()
//                    );
//                }
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<KhenThuong>> themKhenThuong(String loaisyllctName, String soCCCD, List<ReqKhenThuong> thuong) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<KhenThuong> khenThuongs = thuong.stream().map(
//                        cu -> new KhenThuong(cu.nam(), cu.xepLoaiChuyenMon(), cu.xepLoaiThiDua(), cu.hinhThucKhenThuong(), chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        khenThuongRepository.saveAll(khenThuongs)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<KhenThuong> suaKhenThuong(int id, ReqKhenThuong thuong) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(thuong.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(thuong.soYeuLyLich());
//                Optional<KhenThuong> khenThuong = khenThuongRepository.findById(id);
//                if (khenThuong.isPresent()) {
//                    KhenThuong khenThuongNew = KhenThuong.builder()
//                            .id(khenThuong.get().getId())
//                            .nam(thuong.nam())
//                            .xepLoaiChuyenMon(thuong.xepLoaiChuyenMon())
//                            .xepLoaiThiDua(thuong.xepLoaiThiDua())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    khenThuongNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            khenThuongRepository.save(khenThuongNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
        private ResKhenThuong mapToResKhenThuong(KhenThuong thuong) {
            return new ResKhenThuong(
                    thuong.getId(),
                    thuong.getNam(),
                    thuong.getXepLoaiChuyenMon(),
                    thuong.getXepLoaiThiDua(),
                    thuong.getHinhThucKhenThuong(),
                    thuong.getCreate_at(),
                    thuong.getUpdate_at()
            );
        }

        private KhenThuong mapToKhenThuong(int check, SoYeuLyLich syll, ReqKhenThuong cu) {
            return check == 1 ? KhenThuong.builder()
                    .nam(cu.nam())
                    .xepLoaiChuyenMon(cu.xepLoaiChuyenMon())
                    .xepLoaiThiDua(cu.xepLoaiThiDua())
                    .hinhThucKhenThuong(cu.hinhThucKhenThuong())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new KhenThuong(
                            cu.nam(),
                            cu.xepLoaiChuyenMon(),
                            cu.xepLoaiThiDua(),
                            cu.hinhThucKhenThuong(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResKhenThuong> khenThuongs = new ArrayList<>();
                if (taiKhoan != null) {
                    khenThuongs = taiKhoan.getSoYeuLyLich().getKhenThuongs().stream().map(thuong -> mapToResKhenThuong(thuong)).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        khenThuongs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResKhenThuong khenThuong = null;
                if (taiKhoan != null) {
                    khenThuong = taiKhoan.getSoYeuLyLich().getKhenThuongs().stream().map(
                            this::mapToResKhenThuong
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        khenThuong
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqKhenThuong khenThuong) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KhenThuong thuong = null;
                if (taiKhoan != null) {
                    thuong = mapToKhenThuong(-1, taiKhoan.getSoYeuLyLich(), khenThuong);
                    khenThuongRepository.save(thuong);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqKhenThuong thuong) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KhenThuong khenThuong = null;
                if (taiKhoan != null) {
                    khenThuong = mapToKhenThuong(1, taiKhoan.getSoYeuLyLich(), thuong);
                    khenThuong.setId(id);
                    khenThuongRepository.save(khenThuong);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        khenThuong != null ? mapToResKhenThuong(khenThuong) : null
                );

            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KhenThuong thuong = null;
                if (taiKhoan != null) {
                    thuong = taiKhoan.getSoYeuLyLich().getKhenThuongs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    khenThuongRepository.delete(thuong);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KienThucAnNinhQuocPhongService extends ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice {

        //        @Override
//        public ResDTO<List<KienThucAnNinhQuocPhong>> xemKienThucAnNinhQuocPhong() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getKienThucAnNinhQuocPhongs() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<KienThucAnNinhQuocPhong>> themKienThucAnNinhQuocPhong(String loaisyllctName, String soCCCD, List<ReqKienThucAnNinhQuocPhong> quocPhongs) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs = quocPhongs.stream().map(
//                        cu -> new KienThucAnNinhQuocPhong(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.tenCoSoDaoTao(),
//                                cu.chungChiDuocCap(),
//                                chiTiet,
//                                soYeuLyLich
//                        )).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        kienThucAnNinhQuocPhongRepository.saveAll(kienThucAnNinhQuocPhongs)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<KienThucAnNinhQuocPhong> suaKienThucAnNinhQuocPhong(int id, ReqKienThucAnNinhQuocPhong phong) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(phong.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(phong.soYeuLyLich());
//                Optional<KienThucAnNinhQuocPhong> quocPhong = kienThucAnNinhQuocPhongRepository.findById(id);
//                if (quocPhong.isPresent()) {
//                    KienThucAnNinhQuocPhong kienThucAnNinhQuocPhongNew = KienThucAnNinhQuocPhong.builder()
//                            .id(quocPhong.get().getId())
//                            .batDau(phong.batDau())
//                            .ketThuc(phong.ketThuc())
//                            .chungChiDuocCap(phong.chungChiDuocCap())
//                            .tenCoSoDaoTao(phong.tenCoSoDaoTao())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    kienThucAnNinhQuocPhongNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            kienThucAnNinhQuocPhongRepository.save(kienThucAnNinhQuocPhongNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
        private ResKienThucAnNinhQuocPhong mapToResKienThucAnNinhQuocPhong(KienThucAnNinhQuocPhong phong) {
            return new ResKienThucAnNinhQuocPhong(
                    phong.getId(),
                    phong.getBatDau(),
                    phong.getKetThuc(),
                    phong.getTenCoSoDaoTao(),
                    phong.getChungChiDuocCap(),
                    phong.getCreate_at(),
                    phong.getUpdate_at()
            );
        }

        private KienThucAnNinhQuocPhong mapToKienThucAnNinhQuocPhong(int check, SoYeuLyLich syll, ReqKienThucAnNinhQuocPhong cu) {
            return check == 1 ? KienThucAnNinhQuocPhong.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new KienThucAnNinhQuocPhong(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.chungChiDuocCap(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResKienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs = new ArrayList<>();
                if (taiKhoan != null) {
                    kienThucAnNinhQuocPhongs = taiKhoan.getSoYeuLyLich().getKienThucAnNinhQuocPhongs().stream().map(
                            this::mapToResKienThucAnNinhQuocPhong
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kienThucAnNinhQuocPhongs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResKienThucAnNinhQuocPhong phong = null;
                if (taiKhoan != null) {
                    phong = taiKhoan.getSoYeuLyLich().getKienThucAnNinhQuocPhongs().stream().map(
                            this::mapToResKienThucAnNinhQuocPhong
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        phong
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqKienThucAnNinhQuocPhong cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KienThucAnNinhQuocPhong phong = null;
                if (taiKhoan != null) {
                    phong = mapToKienThucAnNinhQuocPhong(-1, taiKhoan.getSoYeuLyLich(), cu);
                    kienThucAnNinhQuocPhongRepository.save(phong);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqKienThucAnNinhQuocPhong cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KienThucAnNinhQuocPhong phong = null;
                if (taiKhoan != null) {
                    phong = mapToKienThucAnNinhQuocPhong(1, taiKhoan.getSoYeuLyLich(), cu);
                    phong.setId(id);
                    kienThucAnNinhQuocPhongRepository.save(phong);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        phong != null ? mapToResKienThucAnNinhQuocPhong(phong) : null
                );

            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KienThucAnNinhQuocPhong phong = null;
                if (taiKhoan != null) {
                    phong = taiKhoan.getSoYeuLyLich().getKienThucAnNinhQuocPhongs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    kienThucAnNinhQuocPhongRepository.delete(phong);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    @Service
    public class KyLuatService extends ISoYeuLyLichChiTietServices.IKyLuatSefvice {
        private ResKyLuat mapToResKyLuat(KyLuat luat) {
            return new ResKyLuat(
                    luat.getId(),
                    luat.getBatDau(),
                    luat.getKetThuc(),
                    luat.getHinhThuc(),
                    luat.getHanhViViPhamChinh(),
                    luat.getCoQuanQuyetDinh(),
                    luat.getCreate_at(),
                    luat.getUpdate_at()
            );
        }

        private KyLuat mapToKyLuat(int check, SoYeuLyLich syll, ReqKyLuat cu) {
            return check == 1 ? KyLuat.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .hinhThuc(cu.hinhThuc())
                    .hanhViViPhamChinh(cu.hanhViViPhamChinh())
                    .coQuanQuyetDinh(cu.coQuanQuyetDinh())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new KyLuat(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.hinhThuc(),
                            cu.hanhViViPhamChinh(),
                            cu.coQuanQuyetDinh(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResKyLuat> kyLuats = new ArrayList<>();
                if (taiKhoan != null) {
                    kyLuats = taiKhoan.getSoYeuLyLich().getKyLuats().stream().map(
                            this::mapToResKyLuat
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kyLuats
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResKyLuat kyLuat = null;
                if (taiKhoan != null) {
                    kyLuat = taiKhoan.getSoYeuLyLich().getKyLuats().stream().map(
                            this::mapToResKyLuat
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kyLuat
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqKyLuat cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KyLuat kyLuat = null;
                if (taiKhoan != null) {
                    kyLuat = mapToKyLuat(-1, taiKhoan.getSoYeuLyLich(), cu);
                    kyLuatRepository.save(kyLuat);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqKyLuat cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KyLuat kyLuat = null;
                if (taiKhoan != null) {
                    kyLuat = mapToKyLuat(1, taiKhoan.getSoYeuLyLich(), cu);
                    kyLuat.setId(id);
                    kyLuatRepository.save(kyLuat);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        kyLuat != null ? mapToResKyLuat(kyLuat) : null
                );

            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                KyLuat kyLuat = null;
                if (taiKhoan != null) {
                    kyLuat = taiKhoan.getSoYeuLyLich().getKyLuats().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    kyLuatRepository.delete(kyLuat);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<KyLuat>> xemKyLuat() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getKyLuats() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<KyLuat>> themKyLuat(String loaisyllctName, String soCCCD, List<ReqKyLuat> luat) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<KyLuat> kyLuats = luat.stream().map(
//                        cu -> new KyLuat(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.hinhThuc(),
//                                cu.hanhViViPhamChinh(),
//                                cu.coQuanQuyetDinh(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        kyLuatRepository.saveAll(kyLuats)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<KyLuat> suaKyLuat(int id, ReqKyLuat kluat) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(kluat.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(kluat.soYeuLyLich());
//                Optional<KyLuat> kyLuat = kyLuatRepository.findById(id);
//                if (kyLuat.isPresent()) {
//                    KyLuat kyLuatNew = KyLuat.builder()
//                            .id(kyLuat.get().getId())
//                            .batDau(kluat.batDau())
//                            .ketThuc(kluat.ketThuc())
//                            .hinhThuc(kluat.hinhThuc())
//                            .hanhViViPhamChinh(kluat.hanhViViPhamChinh())
//                            .coQuanQuyetDinh(kluat.coQuanQuyetDinh())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    kyLuatNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            kyLuatRepository.save(kyLuatNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class LamViecONuocNgoaiServcie extends ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice {
        private ResLamViecONuocNgoai mapToResLamViecONuocNgoai(LamViecONuocNgoai ngoai) {
            return new ResLamViecONuocNgoai(
                    ngoai.getId(),
                    ngoai.getBatDau(),
                    ngoai.getKetThuc(),
                    ngoai.getToChucDiaChiCongViec(),
                    ngoai.getCreate_at(),
                    ngoai.getUpdate_at()
            );
        }

        private LamViecONuocNgoai mapToLamViecONuocNgoai(int check, SoYeuLyLich syll, ReqLamViecONuocNgoai cu) {
            return check == 1 ? LamViecONuocNgoai.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .toChucDiaChiCongViec(cu.toChucDiaChiCongViec())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new LamViecONuocNgoai(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.toChucDiaChiCongViec(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResLamViecONuocNgoai> lamViecONuocNgoais = new ArrayList<>();
                if (taiKhoan != null) {
                    lamViecONuocNgoais = taiKhoan.getSoYeuLyLich().getLamViecONuocNgoais().stream().map(
                            this::mapToResLamViecONuocNgoai
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lamViecONuocNgoais
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResLamViecONuocNgoai ngoai = null;
                if (taiKhoan != null) {
                    ngoai = taiKhoan.getSoYeuLyLich().getLamViecONuocNgoais().stream().map(
                            this::mapToResLamViecONuocNgoai
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ngoai
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqLamViecONuocNgoai cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LamViecONuocNgoai ngoai = null;
                if (taiKhoan != null) {
                    ngoai = mapToLamViecONuocNgoai(-1, taiKhoan.getSoYeuLyLich(), cu);
                    lamViecONuocNgoaiRepository.save(ngoai);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqLamViecONuocNgoai cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LamViecONuocNgoai ngoai = null;
                if (taiKhoan != null) {
                    ngoai = mapToLamViecONuocNgoai(1, taiKhoan.getSoYeuLyLich(), cu);
                    ngoai.setId(id);
                    lamViecONuocNgoaiRepository.save(ngoai);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        ngoai != null ? mapToResLamViecONuocNgoai(ngoai) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LamViecONuocNgoai ngoai = null;
                if (taiKhoan != null) {
                    ngoai = taiKhoan.getSoYeuLyLich().getLamViecONuocNgoais().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    lamViecONuocNgoaiRepository.delete(ngoai);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<LamViecONuocNgoai>> xemLamViecONuocNgoai() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getLamViecONuocNgoais() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<LamViecONuocNgoai>> themLamViecONuocNgoai(String loaisyllctName, String soCCCD, List<ReqLamViecONuocNgoai> reqLamViecONuocNgoais) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<LamViecONuocNgoai> lamViecONuocNgoais = reqLamViecONuocNgoais.stream().map(
//                        cu -> new LamViecONuocNgoai(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.toChucDiaChiCongViec(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        lamViecONuocNgoaiRepository.saveAll(lamViecONuocNgoais)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<LamViecONuocNgoai> suaLamViecONuocNgoai(int id, ReqLamViecONuocNgoai nuocNgoai) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(nuocNgoai.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(nuocNgoai.soYeuLyLich());
//                Optional<LamViecONuocNgoai> lamViecONuocNgoai = lamViecONuocNgoaiRepository.findById(id);
//                if (lamViecONuocNgoai.isPresent()) {
//                    LamViecONuocNgoai lamViecONuocNgoaiNew = LamViecONuocNgoai.builder()
//                            .id(lamViecONuocNgoai.get().getId())
//                            .batDau(nuocNgoai.batDau())
//                            .ketThuc(nuocNgoai.ketThuc())
//                            .toChucDiaChiCongViec(nuocNgoai.toChucDiaChiCongViec())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    lamViecONuocNgoaiNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            lamViecONuocNgoaiRepository.save(lamViecONuocNgoaiNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }

    }

    @Service
    public class LuongBanThanService extends ISoYeuLyLichChiTietServices.ILuongBanThanSefvice {
        private ResLuongBanThan mapToResLuongBanThan(LuongBanThan than) {
            return new ResLuongBanThan(
                    than.getId(),
                    than.getBatDau(),
                    than.getKetThuc(),
                    than.getMaSo(),
                    than.getBacLuong(),
                    than.getHeSoLuong(),
                    than.getTienLuongTheoViTri(),
                    than.getCreate_at(),
                    than.getUpdate_at()
            );
        }

        private LuongBanThan mapToLuongBanThan(int check, SoYeuLyLich syll, ReqLuongBanThan cu) {
            return check == 1 ? LuongBanThan.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .maSo(cu.maSo())
                    .bacLuong(cu.bacLuong())
                    .heSoLuong(cu.heSoLuong())
                    .tienLuongTheoViTri(cu.tienLuongTheoViTri())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new LuongBanThan(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.maSo(),
                            cu.bacLuong(),
                            cu.heSoLuong(),
                            cu.tienLuongTheoViTri(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResLuongBanThan> luongBanThans = new ArrayList<>();
                if (taiKhoan != null) {
                    luongBanThans = taiKhoan.getSoYeuLyLich().getLuongBanThans().stream().map(
                            this::mapToResLuongBanThan
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        luongBanThans
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResLuongBanThan luongBanThan = null;
                if (taiKhoan != null) {
                    luongBanThan = taiKhoan.getSoYeuLyLich().getLuongBanThans().stream().map(
                            this::mapToResLuongBanThan
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        luongBanThan
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqLuongBanThan cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LuongBanThan luongBanThan = null;
                if (taiKhoan != null) {
                    luongBanThan = mapToLuongBanThan(-1, taiKhoan.getSoYeuLyLich(), cu);
                    luongBanThanRepository.save(luongBanThan);
                }
                return new ResDTO<>(
                        ResEnum.TAO_THANH_CONG.getStatusCode(),
                        ResEnum.TAO_THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqLuongBanThan cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LuongBanThan luongBanThan = null;
                if (taiKhoan != null) {
                    luongBanThan = mapToLuongBanThan(1, taiKhoan.getSoYeuLyLich(), cu);
                    luongBanThan.setId(id);
                    luongBanThanRepository.save(luongBanThan);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        luongBanThan != null ? mapToResLuongBanThan(luongBanThan) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LuongBanThan luongBanThan = null;
                if (taiKhoan != null) {
                    luongBanThan = taiKhoan.getSoYeuLyLich().getLuongBanThans().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    luongBanThanRepository.delete(luongBanThan);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
//        @Override
//        public ResDTO<List<LuongBanThan>> xemLuongBanThan() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getLuongBanThans() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<LuongBanThan>> themLuongBanThan(String loaisyllctName, String soCCCD, List<ReqLuongBanThan> reqLuongBanThans) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<LuongBanThan> luongBanThans = reqLuongBanThans.stream().map(
//                        cu -> new LuongBanThan(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.maSo(),
//                                cu.bacLuong(),
//                                cu.heSoLuong(),
//                                cu.tienLuongTheoViTri(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        luongBanThanRepository.saveAll(luongBanThans)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<LuongBanThan> suaLuongBanThan(int id, ReqLuongBanThan reqLuongBanThan) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqLuongBanThan.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqLuongBanThan.soYeuLyLich());
//                Optional<LuongBanThan> luongBanThan = luongBanThanRepository.findById(id);
//                if (luongBanThan.isPresent()) {
//                    LuongBanThan luongBanThanNew = LuongBanThan.builder()
//                            .id(luongBanThan.get().getId())
//                            .batDau(reqLuongBanThan.batDau())
//                            .ketThuc(reqLuongBanThan.ketThuc())
//                            .maSo(reqLuongBanThan.maSo())
//                            .bacLuong(reqLuongBanThan.bacLuong())
//                            .heSoLuong(reqLuongBanThan.heSoLuong())
//                            .tienLuongTheoViTri(reqLuongBanThan.tienLuongTheoViTri())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    luongBanThanNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            luongBanThanRepository.save(luongBanThanNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class LyLuanChinhTriService extends ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice {
        private ResLyLuanChinhTri mapToResLyLuanChinhTri(LyLuanChinhTri tri) {
            return new ResLyLuanChinhTri(
                    tri.getId(),
                    tri.getBatDau(),
                    tri.getKetThuc(),
                    tri.getTenCoSoDaoTao(),
                    tri.getHinhThucDaoTao(),
                    tri.getVanBangDuocCap(),
                    tri.getCreate_at(),
                    tri.getUpdate_at()
            );
        }

        private LyLuanChinhTri mapToLyLuanChinhTri(int check, SoYeuLyLich syll, ReqLyLuanChinhTri cu) {
            return check == 1 ? LyLuanChinhTri.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .hinhThucDaoTao(cu.hinhThucDaoTao())
                    .vanBangDuocCap(cu.vanBangDuocCap())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new LyLuanChinhTri(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.hinhThucDaoTao(),
                            cu.vanBangDuocCap(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResLyLuanChinhTri> lyLuanChinhTris = new ArrayList<>();
                if (taiKhoan != null) {
                    lyLuanChinhTris = taiKhoan.getSoYeuLyLich().getLyLuanChinhTris().stream().map(
                            this::mapToResLyLuanChinhTri
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lyLuanChinhTris
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResLyLuanChinhTri lyLuanChinhTris = null;
                if (taiKhoan != null) {
                    lyLuanChinhTris = taiKhoan.getSoYeuLyLich().getLyLuanChinhTris().stream().map(
                            this::mapToResLyLuanChinhTri
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lyLuanChinhTris
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqLyLuanChinhTri cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LyLuanChinhTri lyLuanChinhTri = null;
                if (taiKhoan != null) {
                    lyLuanChinhTri = mapToLyLuanChinhTri(-1, taiKhoan.getSoYeuLyLich(), cu);
                    lyLuanChinhTriRepository.save(lyLuanChinhTri);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqLyLuanChinhTri cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LyLuanChinhTri lyLuanChinhTri = null;
                if (taiKhoan != null) {
                    lyLuanChinhTri = mapToLyLuanChinhTri(1, taiKhoan.getSoYeuLyLich(), cu);
                    lyLuanChinhTri.setId(id);
                    lyLuanChinhTriRepository.save(lyLuanChinhTri);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        lyLuanChinhTri != null ? mapToResLyLuanChinhTri(lyLuanChinhTri) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                LyLuanChinhTri lyLuanChinhTri = null;
                if (taiKhoan != null) {
                    lyLuanChinhTri = taiKhoan.getSoYeuLyLich().getLyLuanChinhTris().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    lyLuanChinhTriRepository.delete(lyLuanChinhTri);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
//        @Override
//        public ResDTO<List<LyLuanChinhTri>> xemLyLuanChinhTri() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getLyLuanChinhTris() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<LyLuanChinhTri>> themLyLuanChinhTri(String loaisyllctName, String soCCCD, List<ReqLyLuanChinhTri> reqLyLuanChinhTris) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//
//                List<LyLuanChinhTri> lyLuanChinhTris = reqLyLuanChinhTris.stream().map(cu ->
//                        new LyLuanChinhTri(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.tenCoSoDaoTao(),
//                                cu.hinhThucDaoTao(),
//                                cu.vanBangDuocCap(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        lyLuanChinhTriRepository.saveAll(lyLuanChinhTris)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<LyLuanChinhTri> suaLyLuanChinhTri(int id, ReqLyLuanChinhTri reqLyLuanChinhTri) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqLyLuanChinhTri.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqLyLuanChinhTri.soYeuLyLich());
//                Optional<LyLuanChinhTri> lyLuanChinhTri = lyLuanChinhTriRepository.findById(id);
//                if (lyLuanChinhTri.isPresent()) {
//                    LyLuanChinhTri llyLuanChinhTriNew = LyLuanChinhTri.builder()
//                            .id(lyLuanChinhTri.get().getId())
//                            .batDau(reqLyLuanChinhTri.batDau())
//                            .ketThuc(reqLyLuanChinhTri.ketThuc())
//                            .tenCoSoDaoTao(reqLyLuanChinhTri.tenCoSoDaoTao())
//                            .hinhThucDaoTao(reqLyLuanChinhTri.hinhThucDaoTao())
//                            .vanBangDuocCap(reqLyLuanChinhTri.vanBangDuocCap())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    llyLuanChinhTriNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            lyLuanChinhTriRepository.save(llyLuanChinhTriNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class NghiepVuChuyenNganhService extends ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice {
        private ResNghiepVuChuyenNganh mapToResNghiepVuChuyenNganh(NghiepVuChuyenNganh nganh) {
            return new ResNghiepVuChuyenNganh(
                    nganh.getId(),
                    nganh.getBatDau(),
                    nganh.getKetThuc(),
                    nganh.getTenCoSoDaoTao(),
                    nganh.getChungChiDuocCap(),
                    nganh.getCreate_at(),
                    nganh.getUpdate_at()
            );
        }

        private NghiepVuChuyenNganh mapToNghiepVuChuyenNganh(int check, SoYeuLyLich syll, ReqNghiepVuChuyenNganh cu) {
            return check == 1 ? NghiepVuChuyenNganh.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new NghiepVuChuyenNganh(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.chungChiDuocCap(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResNghiepVuChuyenNganh> nghiepVuChuyenNganhs = new ArrayList<>();
                if (taiKhoan != null) {
                    nghiepVuChuyenNganhs = taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs().stream().map(
                            this::mapToResNghiepVuChuyenNganh
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        nghiepVuChuyenNganhs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResNghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs().stream().map(
                            this::mapToResNghiepVuChuyenNganh
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        nghiepVuChuyenNganh
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqNghiepVuChuyenNganh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = mapToNghiepVuChuyenNganh(-1, taiKhoan.getSoYeuLyLich(), cu);
                    nghiepVuChuyenNganhRepository.save(nghiepVuChuyenNganh);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqNghiepVuChuyenNganh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = mapToNghiepVuChuyenNganh(1, taiKhoan.getSoYeuLyLich(), cu);
                    nghiepVuChuyenNganh.setId(id);
                    nghiepVuChuyenNganhRepository.save(nghiepVuChuyenNganh);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        nghiepVuChuyenNganh != null ? mapToResNghiepVuChuyenNganh(nghiepVuChuyenNganh) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NghiepVuChuyenNganh nghiepVuChuyenNganh = null;
                if (taiKhoan != null) {
                    nghiepVuChuyenNganh = taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    nghiepVuChuyenNganhRepository.delete(nghiepVuChuyenNganh);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
//
//        @Override
//        public ResDTO<List<NghiepVuChuyenNganh>> xemNghiepVuChuyenNganh() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getNghiepVuChuyenNganhs() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<NghiepVuChuyenNganh>> themNghiepVuChuyenNganh(String loaisyllctName, String soCCCD, List<ReqNghiepVuChuyenNganh> reqNghiepVuChuyenNganhs) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<NghiepVuChuyenNganh> nghiepVuChuyenNganhs = reqNghiepVuChuyenNganhs.stream().map(cu ->
//                        new NghiepVuChuyenNganh(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.tenCoSoDaoTao(),
//                                cu.chungChiDuocCap(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        nghiepVuChuyenNganhRepository.saveAll(nghiepVuChuyenNganhs)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<NghiepVuChuyenNganh> suaNghiepVuChuyenNganh(int id, ReqNghiepVuChuyenNganh reqNghiepVuChuyenNganh) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqNghiepVuChuyenNganh.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqNghiepVuChuyenNganh.soYeuLyLich());
//                Optional<NghiepVuChuyenNganh> nghiepVuChuyenNganh = nghiepVuChuyenNganhRepository.findById(id);
//                if (nghiepVuChuyenNganh.isPresent()) {
//                    NghiepVuChuyenNganh nghiepVuChuyenNganhNew = NghiepVuChuyenNganh.builder()
//                            .id(nghiepVuChuyenNganh.get().getId())
//                            .batDau(reqNghiepVuChuyenNganh.batDau())
//                            .ketThuc(reqNghiepVuChuyenNganh.ketThuc())
//                            .tenCoSoDaoTao(reqNghiepVuChuyenNganh.tenCoSoDaoTao())
//                            .chungChiDuocCap(reqNghiepVuChuyenNganh.chungChiDuocCap())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    nghiepVuChuyenNganhNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            nghiepVuChuyenNganhRepository.save(nghiepVuChuyenNganhNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class NgoaiNguService extends ISoYeuLyLichChiTietServices.INgoaiNguSefvice {
        private ResNgoaiNgu mapToResNgoaiNgu(NgoaiNgu ngu) {
            return new ResNgoaiNgu(
                    ngu.getId(),
                    ngu.getBatDau(),
                    ngu.getKetThuc(),
                    ngu.getTenCoSoDaoTao(),
                    ngu.getTenNgoaiNgu(),
                    ngu.getChungChiDuocCap(),
                    ngu.getDiemSo(),
                    ngu.getCreate_at(),
                    ngu.getUpdate_at()
            );
        }

        private NgoaiNgu mapToNgoaiNgu(int check, SoYeuLyLich syll, ReqNgoaiNgu cu) {
            return check == 1 ? NgoaiNgu.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .tenNgoaiNgu(cu.tenNgoaiNgu())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .diemSo(cu.diemSo())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new NgoaiNgu(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.tenNgoaiNgu(),
                            cu.chungChiDuocCap(),
                            cu.diemSo(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResNgoaiNgu> ngoaiNgus = new ArrayList<>();
                if (taiKhoan != null) {
                    ngoaiNgus = taiKhoan.getSoYeuLyLich().getNgoaiNgus().stream().map(
                            this::mapToResNgoaiNgu
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ngoaiNgus
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResNgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = taiKhoan.getSoYeuLyLich().getNgoaiNgus().stream().map(
                            this::mapToResNgoaiNgu
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ngoaiNgu
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqNgoaiNgu cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = mapToNgoaiNgu(-1, taiKhoan.getSoYeuLyLich(), cu);
                    ngoaiNguRepository.save(ngoaiNgu);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqNgoaiNgu cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = mapToNgoaiNgu(1, taiKhoan.getSoYeuLyLich(), cu);
                    ngoaiNgu.setId(id);
                    ngoaiNguRepository.save(ngoaiNgu);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        ngoaiNgu != null ? mapToResNgoaiNgu(ngoaiNgu) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                NgoaiNgu ngoaiNgu = null;
                if (taiKhoan != null) {
                    ngoaiNgu = taiKhoan.getSoYeuLyLich().getNgoaiNgus().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    ngoaiNguRepository.delete(ngoaiNgu);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<NgoaiNgu>> xemNgoaiNgu() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getNgoaiNgus() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<NgoaiNgu>> themNgoaiNgu(String loaisyllctName, String soCCCD, List<ReqNgoaiNgu> reqNgoaiNgus) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<NgoaiNgu> ngoaiNgus = reqNgoaiNgus.stream().map(cu ->
//                        new NgoaiNgu(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.tenCoSoDaoTao(),
//                                cu.tenNgoaiNgu(),
//                                cu.chungChiDuocCap(),
//                                cu.diemSo(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        ngoaiNguRepository.saveAll(ngoaiNgus)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<NgoaiNgu> suaNgoaiNgu(int id, ReqNgoaiNgu reqNgoaiNgu) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqNgoaiNgu.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqNgoaiNgu.soYeuLyLich());
//                Optional<NgoaiNgu> ngoaiNgu = ngoaiNguRepository.findById(id);
//                if (ngoaiNgu.isPresent()) {
//                    NgoaiNgu ngoaiNguNew = NgoaiNgu.builder()
//                            .id(ngoaiNgu.get().getId())
//                            .batDau(reqNgoaiNgu.batDau())
//                            .ketThuc(reqNgoaiNgu.ketThuc())
//                            .tenCoSoDaoTao(reqNgoaiNgu.tenCoSoDaoTao())
//                            .chungChiDuocCap(reqNgoaiNgu.chungChiDuocCap())
//                            .diemSo(reqNgoaiNgu.diemSo())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    ngoaiNguNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            ngoaiNguRepository.save(ngoaiNguNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class PhuCapKhacService extends ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice {
        private ResPhuCapKhac mapToResPhuCapKhac(PhuCapKhac khac) {
            return new ResPhuCapKhac(
                    khac.getId(),
                    khac.getBatDau(),
                    khac.getKetThuc(),
                    khac.getLoaiPhuCap(),
                    khac.getPhanTramHuongPhuCap(),
                    khac.getHeSoPhuCap(),
                    khac.getHinhThucThuong(),
                    khac.getGiaTri(),
                    khac.getCreate_at(),
                    khac.getUpdate_at()
            );
        }

        private PhuCapKhac mapToPhuCapKhac(int check, SoYeuLyLich syll, ReqPhuCapKhac cu) {
            return check == 1 ? PhuCapKhac.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .loaiPhuCap(cu.loaiPhuCap())
                    .phanTramHuongPhuCap(cu.phanTramHuongPhuCap())
                    .heSoPhuCap(cu.heSoPhuCap())
                    .hinhThucThuong(cu.hinhThucThuong())
                    .giaTri(cu.giaTri())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new PhuCapKhac(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.loaiPhuCap(),
                            cu.phanTramHuongPhuCap(),
                            cu.heSoPhuCap(),
                            cu.hinhThucThuong(),
                            cu.giaTri(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResPhuCapKhac> phuCapKhacs = new ArrayList<>();
                if (taiKhoan != null) {
                    phuCapKhacs = taiKhoan.getSoYeuLyLich().getPhuCapKhacs().stream().map(
                            this::mapToResPhuCapKhac
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        phuCapKhacs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResPhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = taiKhoan.getSoYeuLyLich().getPhuCapKhacs().stream().map(
                            this::mapToResPhuCapKhac
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        phuCapKhac
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqPhuCapKhac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                PhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = mapToPhuCapKhac(-1, taiKhoan.getSoYeuLyLich(), cu);
                    phuCapKhacRepository.save(phuCapKhac);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqPhuCapKhac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                PhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = mapToPhuCapKhac(1, taiKhoan.getSoYeuLyLich(), cu);
                    phuCapKhac.setId(id);
                    phuCapKhacRepository.save(phuCapKhac);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        phuCapKhac != null ? mapToResPhuCapKhac(phuCapKhac) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                PhuCapKhac phuCapKhac = null;
                if (taiKhoan != null) {
                    phuCapKhac = taiKhoan.getSoYeuLyLich().getPhuCapKhacs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    phuCapKhacRepository.delete(phuCapKhac);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<PhuCapKhac>> xemPhuCapKhac() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getPhuCapKhacs() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<PhuCapKhac>> themPhuCapKhac(String loaisyllctName, String soCCCD, List<ReqPhuCapKhac> reqPhuCapKhacs) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<PhuCapKhac> phuCapKhacs = reqPhuCapKhacs.stream().map(cu ->
//                        new PhuCapKhac(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.loaiPhuCap(),
//                                cu.phanTramHuongPhuCap(),
//                                cu.heSoPhuCap(),
//                                cu.hinhThucThuong(),
//                                cu.giaTri(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        phuCapKhacRepository.saveAll(phuCapKhacs)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<PhuCapKhac> suaPhuCapKhac(int id, ReqPhuCapKhac reqPhuCapKhac) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqPhuCapKhac.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqPhuCapKhac.soYeuLyLich());
//                Optional<PhuCapKhac> phuCapKhac = phuCapKhacRepository.findById(id);
//                if (phuCapKhac.isPresent()) {
//                    PhuCapKhac phuCapKhacNew = PhuCapKhac.builder()
//                            .id(phuCapKhac.get().getId())
//                            .batDau(reqPhuCapKhac.batDau())
//                            .ketThuc(reqPhuCapKhac.ketThuc())
//                            .loaiPhuCap(reqPhuCapKhac.loaiPhuCap())
//                            .phanTramHuongPhuCap(reqPhuCapKhac.phanTramHuongPhuCap())
//                            .heSoPhuCap(reqPhuCapKhac.heSoPhuCap())
//                            .hinhThucThuong(reqPhuCapKhac.hinhThucThuong())
//                            .giaTri(reqPhuCapKhac.giaTri())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    phuCapKhacNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            phuCapKhacRepository.save(phuCapKhacNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class QuanHeGiaDinhService extends ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice {
        private ResQuanHeGiaDinh mapToResQuanHeGiaDinh(QuanHeGiaDinh dinh) {
            return new ResQuanHeGiaDinh(
                    dinh.getId(),
                    dinh.getMoiQuanHe(),
                    dinh.getHoVaTen(),
                    dinh.getNamSinh(),
                    dinh.getThongTinThanNhan(),
                    dinh.getCreate_at(),
                    dinh.getUpdate_at()
            );
        }

        private QuanHeGiaDinh mapToQuanHeGiaDinh(int check, SoYeuLyLich syll, ReqQuanHeGiaDinh cu) {
            return check == 1 ? QuanHeGiaDinh.builder()
                    .moiQuanHe(cu.moiQuanHe())
                    .hoVaTen(cu.hoVaTen())
                    .namSinh(cu.namSinh())
                    .thongTinThanNhan(cu.thongTinThanNhan())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new QuanHeGiaDinh(
                            cu.moiQuanHe(),
                            cu.hoVaTen(),
                            cu.namSinh(),
                            cu.thongTinThanNhan(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResQuanHeGiaDinh> quanHeGiaDinhs = new ArrayList<>();
                if (taiKhoan != null) {
                    quanHeGiaDinhs = taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs().stream().map(
                            this::mapToResQuanHeGiaDinh
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quanHeGiaDinhs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResQuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs().stream().map(
                            this::mapToResQuanHeGiaDinh
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quanHeGiaDinh
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqQuanHeGiaDinh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = mapToQuanHeGiaDinh(-1, taiKhoan.getSoYeuLyLich(), cu);
                    quanHeGiaDinhRepository.save(quanHeGiaDinh);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqQuanHeGiaDinh cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = mapToQuanHeGiaDinh(1, taiKhoan.getSoYeuLyLich(), cu);
                    quanHeGiaDinh.setId(id);
                    quanHeGiaDinhRepository.save(quanHeGiaDinh);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        quanHeGiaDinh != null ? mapToResQuanHeGiaDinh(quanHeGiaDinh) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuanHeGiaDinh quanHeGiaDinh = null;
                if (taiKhoan != null) {
                    quanHeGiaDinh = taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    quanHeGiaDinhRepository.delete(quanHeGiaDinh);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<QuanHeGiaDinh>> xemQuanHeGiaDinh() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getQuanHeGiaDinhs() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<QuanHeGiaDinh>> themPQuanHeGiaDinh(String loaisyllctName, UUID id, List<ReqQuanHeGiaDinh> reqQuanHeGiaDinhs) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                Optional<SoYeuLyLich> soYeuLyLich = soYeuLyLichRepository.findById(id);
//                if (soYeuLyLich.isPresent()) {
//                    List<QuanHeGiaDinh> quanHeGiaDinhs = reqQuanHeGiaDinhs.stream().map(cu ->
//                            new QuanHeGiaDinh(
//                                    cu.moiQuanHe(),
//                                    cu.hoVaTen(),
//                                    cu.namSinh(),
//                                    cu.thongTinThanNhan(),
//                                    chiTiet, soYeuLyLich.get())).toList();
//
//                    return new ResDTO<>(
//                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
//                            ResEnum.CAP_NHAT_THANH_CONG,
//                            quanHeGiaDinhRepository.saveAll(quanHeGiaDinhs)
//                    );
//                } else return new ResDTO<>(
//                        ResEnum.HONG_TIM_THAY.getStatusCode(),
//                        ResEnum.HONG_TIM_THAY,
//                        null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<QuanHeGiaDinh> suaQuanHeGiaDinh(int id, ReqQuanHeGiaDinh reqQuanHeGiaDinh) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqQuanHeGiaDinh.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqQuanHeGiaDinh.soYeuLyLich());
//                Optional<QuanHeGiaDinh> quanHeGiaDinh = quanHeGiaDinhRepository.findById(id);
//                if (quanHeGiaDinh.isPresent()) {
//                    QuanHeGiaDinh quanHeGiaDinhNew = QuanHeGiaDinh.builder()
//                            .id(quanHeGiaDinh.get().getId())
//                            .moiQuanHe(reqQuanHeGiaDinh.moiQuanHe())
//                            .hoVaTen(reqQuanHeGiaDinh.hoVaTen())
//                            .namSinh(reqQuanHeGiaDinh.namSinh())
//                            .thongTinThanNhan(reqQuanHeGiaDinh.thongTinThanNhan())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    quanHeGiaDinhNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            quanHeGiaDinhRepository.save(quanHeGiaDinhNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class QuaTrinhCongTacService extends ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice {
        private ResQuaTrinhCongTac mapToResQuaTrinhCongTac(QuaTrinhCongTac tac) {
            return new ResQuaTrinhCongTac(
                    tac.getId(),
                    tac.getBatDau(),
                    tac.getKetThuc(),
                    tac.getDonViCongTac(),
                    tac.getChucDanh(),
                    tac.getCreate_at(),
                    tac.getUpdate_at()
            );
        }

        private QuaTrinhCongTac mapToQuaTrinhCongTac(int check, SoYeuLyLich syll, ReqQuaTrinhCongTac cu) {
            return check == 1 ? QuaTrinhCongTac.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .donViCongTac(cu.donViCongTac())
                    .chucDanh(cu.chucDanh())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new QuaTrinhCongTac(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.donViCongTac(),
                            cu.chucDanh(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResQuaTrinhCongTac> quaTrinhCongTacs = new ArrayList<>();
                if (taiKhoan != null) {
                    quaTrinhCongTacs = taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs().stream().map(
                            this::mapToResQuaTrinhCongTac
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quaTrinhCongTacs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResQuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs().stream().map(
                            this::mapToResQuaTrinhCongTac
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quaTrinhCongTac
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqQuaTrinhCongTac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = mapToQuaTrinhCongTac(-1, taiKhoan.getSoYeuLyLich(), cu);
                    quaTrinhCongTacRepository.save(quaTrinhCongTac);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quaTrinhCongTac
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqQuaTrinhCongTac cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = mapToQuaTrinhCongTac(1, taiKhoan.getSoYeuLyLich(), cu);
                    quaTrinhCongTac.setId(id);
                    quaTrinhCongTacRepository.save(quaTrinhCongTac);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        quaTrinhCongTac != null ? mapToResQuaTrinhCongTac(quaTrinhCongTac) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                QuaTrinhCongTac quaTrinhCongTac = null;
                if (taiKhoan != null) {
                    quaTrinhCongTac = taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    quaTrinhCongTacRepository.delete(quaTrinhCongTac);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }
//        @Override
//        public ResDTO<List<QuaTrinhCongTac>> xemQuaTrinhCongTac() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getQuaTrinhCongTacs() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<QuaTrinhCongTac>> themQuaTrinhCongTac(String loaisyllctName, String soCCCD, List<ReqQuaTrinhCongTac> reqQuaTrinhCongTacs) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<QuaTrinhCongTac> quaTrinhCongTacs = reqQuaTrinhCongTacs.stream().map(cu ->
//                        new QuaTrinhCongTac(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.donViCongTac(),
//                                cu.chucDanh(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        quaTrinhCongTacRepository.saveAll(quaTrinhCongTacs)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<QuaTrinhCongTac> suaQuaTrinhCongTac(int id, ReqQuaTrinhCongTac reqQuaTrinhCongTac) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqQuaTrinhCongTac.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqQuaTrinhCongTac.soYeuLyLich());
//                Optional<QuaTrinhCongTac> quaTrinhCongTac = quaTrinhCongTacRepository.findById(id);
//                if (quaTrinhCongTac.isPresent()) {
//                    QuaTrinhCongTac quaTrinhCongTacNew = QuaTrinhCongTac.builder()
//                            .id(quaTrinhCongTac.get().getId())
//                            .batDau(reqQuaTrinhCongTac.batDau())
//                            .ketThuc(reqQuaTrinhCongTac.ketThuc())
//                            .donViCongTac(reqQuaTrinhCongTac.donViCongTac())
//                            .chucDanh(reqQuaTrinhCongTac.chucDanh())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    quaTrinhCongTacNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            quaTrinhCongTacRepository.save(quaTrinhCongTacNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }

    @Service
    public class TinHocService extends ISoYeuLyLichChiTietServices.ITinHocSefvice {
        private ResTinHoc mapToResTinHoc(TinHoc hoc) {
            return new ResTinHoc(
                    hoc.getId(),
                    hoc.getBatDau(),
                    hoc.getKetThuc(),
                    hoc.getTenCoSoDaoTao(),
                    hoc.getChungChiDuocCap(),
                    hoc.getCreate_at(),
                    hoc.getUpdate_at()
            );
        }

        private TinHoc mapToTinHoc(int check, SoYeuLyLich syll, ReqTinHoc cu) {
            return check == 1 ? TinHoc.builder()
                    .batDau(cu.batDau())
                    .ketThuc(cu.ketThuc())
                    .tenCoSoDaoTao(cu.tenCoSoDaoTao())
                    .chungChiDuocCap(cu.chungChiDuocCap())
                    .soYeuLyLich(syll)
                    .create_at(cu.create_at())
                    .update_at(LocalDateTime.now())
                    .build() :
                    new TinHoc(
                            cu.batDau(),
                            cu.ketThuc(),
                            cu.tenCoSoDaoTao(),
                            cu.chungChiDuocCap(),
                            null,
                            syll);
        }

        @Override
        public ResDTO<List<?>> xemDanhSachThongTin() {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                List<ResTinHoc> tinHocs = new ArrayList<>();
                if (taiKhoan != null) {
                    tinHocs = taiKhoan.getSoYeuLyLich().getTinHocs().stream().map(
                            this::mapToResTinHoc
                    ).toList();
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tinHocs
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xemThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                ResTinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = taiKhoan.getSoYeuLyLich().getTinHocs().stream().map(
                            this::mapToResTinHoc
                    ).filter(
                            cu -> cu.id() == id
                    ).findFirst().orElse(null);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tinHoc
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> themThongTin(ReqTinHoc cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                TinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = mapToTinHoc(-1, taiKhoan.getSoYeuLyLich(), cu);
                    tinHocRepository.save(tinHoc);
                }
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tinHoc
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> suaThongTin(int id, ReqTinHoc cu) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                TinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = mapToTinHoc(1, taiKhoan.getSoYeuLyLich(), cu);
                    tinHoc.setId(id);
                    tinHocRepository.save(tinHoc);
                }
                return new ResDTO<>(
                        ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                        ResEnum.CAP_NHAT_THANH_CONG,
                        tinHoc != null ? mapToResTinHoc(tinHoc) : null
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

        @Override
        public ResDTO<?> xoaThongTin(int id) {
            try {
                TaiKhoan taiKhoan = crush_em_T();
                TinHoc tinHoc = null;
                if (taiKhoan != null) {
                    tinHoc = taiKhoan.getSoYeuLyLich().getTinHocs().stream().filter(
                            cu -> cu.getId() == id
                    ).findFirst().orElseThrow(() -> new RuntimeException("Khong tin thay"));
                    tinHocRepository.delete(tinHoc);
                }
                return new ResDTO<>(
                        ResEnum.XOA_THANH_CONG.getStatusCode(),
                        ResEnum.XOA_THANH_CONG,
                        ResEnum.XOA_THANH_CONG.name()
                );
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getCause());
            }
        }

//        @Override
//        public ResDTO<List<TinHoc>> xemTinHoc() {
//            try {
//                TaiKhoan taiKhoan = crush_em_T();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        taiKhoan != null ? taiKhoan.getSoYeuLyLich().getTinHocs() : null
//                );
//            } catch (RuntimeException e) {
//                throw new RuntimeException(e.getCause());
//            }
//        }
//
//        @Override
//        public ResDTO<List<TinHoc>> themQTinHoc(String loaisyllctName, String soCCCD, List<ReqTinHoc> reqTinHocs) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
//                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
//                List<TinHoc> tinHocs = reqTinHocs.stream().map(cu ->
//                        new TinHoc(
//                                cu.batDau(),
//                                cu.ketThuc(),
//                                cu.tenCoSoDaoTao(),
//                                cu.chungChiDuocCap(),
//                                chiTiet, soYeuLyLich)).toList();
//                return new ResDTO<>(
//                        ResEnum.THANH_CONG.getStatusCode(),
//                        ResEnum.THANH_CONG,
//                        tinHocRepository.saveAll(tinHocs)
//                );
//            } catch (RuntimeException e) {
//                return new ResDTO<>(
//                        ResEnum.KHONG_HOP_LE.getStatusCode(),
//                        ResEnum.KHONG_HOP_LE,
//                        null
//                );
//            }
//        }
//
//        @Override
//        public ResDTO<TinHoc> suaTinHoc(int id, ReqTinHoc reqTinHoc) {
//            try {
//                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqTinHoc.loaiSoYeuLyLichChiTiet());
//                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqTinHoc.soYeuLyLich());
//                Optional<TinHoc> tinHoc = tinHocRepository.findById(id);
//                if (tinHoc.isPresent()) {
//                    TinHoc tinHocNew = TinHoc.builder()
//                            .id(tinHoc.get().getId())
//                            .batDau(reqTinHoc.batDau())
//                            .ketThuc(reqTinHoc.ketThuc())
//                            .tenCoSoDaoTao(reqTinHoc.tenCoSoDaoTao())
//                            .chungChiDuocCap(reqTinHoc.chungChiDuocCap())
//                            .loaiSoYeuLyLichChiTiet(chiTiet)
//                            .soYeuLyLich(lyLich)
//                            .build();
//                    tinHocNew.setUpdate_at();
//                    return new ResDTO<>(
//                            ResEnum.THANH_CONG.getStatusCode(),
//                            ResEnum.THANH_CONG,
//                            tinHocRepository.save(tinHocNew)
//                    );
//                }
//            } catch (RuntimeException e) {
//                e.printStackTrace();
//            }
//            return new ResDTO<>(
//                    ResEnum.KHONG_HOP_LE.getStatusCode(),
//                    ResEnum.KHONG_HOP_LE,
//                    null
//            );
//        }
    }
}
