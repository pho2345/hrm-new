package sgu.hrm.module_soyeulylich_chitiet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_soyeulylich.models.SoYeuLyLich;
import sgu.hrm.module_soyeulylich.repository.SoYeuLyLichRepository;
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

import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqBanThanCoLamViecChoCheDoCu;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKhenThuong;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKienThucAnNinhQuocPhong;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqKyLuat;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLamViecONuocNgoai;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLoaiSoYeuLyLichChiTiet;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLuongBanThan;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqLyLuanChinhTri;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqNghiepVuChuyenNganh;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqNgoaiNgu;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqPhuCapKhac;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuaTrinhCongTac;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqQuanHeGiaDinh;
import sgu.hrm.module_soyeulylich_chitiet.models.dto.ReqTinHoc;
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

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor // create constructor if field is set final or @notnull
public class SoYeuLyLichChiTietServices {
    //DI
    private final SoYeuLyLichRepository soYeuLyLichRepository;
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
    class BanThanCoLamViecChoCheDoCuService implements ISoYeuLyLichChiTietServices.IBanThanCoLamViecChoCheDoCuSefvice {
        @Override
        public ResDTO<List<BanThanCoLamViecChoCheDoCu>> xemBanThanCoLamViecChoCheDoCu() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        banThanCoLamViecChoCheDoCuRepository.findAll()
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
        public ResDTO<List<BanThanCoLamViecChoCheDoCu>> themBanThanCoLamViecChoCheDoCu(String loaisyllctName, String soCCCD, List<ReqBanThanCoLamViecChoCheDoCu> cuu) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCu = cuu.stream().map(
                        cu -> new BanThanCoLamViecChoCheDoCu(cu.batDau(), cu.ketThuc(), cu.chucDanhDonViDiaDiem(), chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        banThanCoLamViecChoCheDoCuRepository.saveAll(banThanCoLamViecChoCheDoCu)
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
        public ResDTO<BanThanCoLamViecChoCheDoCu> suaBanThanCoLamViecChoCheDoCu(int id, ReqBanThanCoLamViecChoCheDoCu cu) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(cu.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(cu.soYeuLyLich());
                Optional<BanThanCoLamViecChoCheDoCu> banThanCoLamViecChoCheDoCu = banThanCoLamViecChoCheDoCuRepository.findById(id);
                if (banThanCoLamViecChoCheDoCu.isPresent()) {
                    BanThanCoLamViecChoCheDoCu banThanCoLamViecChoCheDoCu1 = BanThanCoLamViecChoCheDoCu.builder()
                            .id(banThanCoLamViecChoCheDoCu.get().getId())
                            .batDau(cu.batDau())
                            .ketThuc(cu.ketThuc())
                            .chucDanhDonViDiaDiem(cu.chucDanhDonViDiaDiem())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    banThanCoLamViecChoCheDoCu1.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            banThanCoLamViecChoCheDoCuRepository.save(banThanCoLamViecChoCheDoCu1)
                    );
                } else return new ResDTO<>(
                        ResEnum.HONG_TIM_THAY.getStatusCode(),
                        ResEnum.HONG_TIM_THAY,
                        null
                );
            } catch (RuntimeException e) {
                e.getLocalizedMessage();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class KhenThuongService implements ISoYeuLyLichChiTietServices.IKhenThuongSefvice {

        @Override
        public ResDTO<List<KhenThuong>> xemKhenThuong() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        khenThuongRepository.findAll()
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
        public ResDTO<List<KhenThuong>> themKhenThuong(String loaisyllctName, String soCCCD, List<ReqKhenThuong> thuong) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<KhenThuong> khenThuongs = thuong.stream().map(
                        cu -> new KhenThuong(cu.nam(), cu.xepLoaiChuyenMon(), cu.xepLoaiThiDua(), cu.hinhThucKhenThuong(), chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        khenThuongRepository.saveAll(khenThuongs)
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
        public ResDTO<KhenThuong> suaKhenThuong(int id, ReqKhenThuong thuong) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(thuong.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(thuong.soYeuLyLich());
                Optional<KhenThuong> khenThuong = khenThuongRepository.findById(id);
                if (khenThuong.isPresent()) {
                    KhenThuong khenThuongNew = KhenThuong.builder()
                            .id(khenThuong.get().getId())
                            .nam(thuong.nam())
                            .xepLoaiChuyenMon(thuong.xepLoaiChuyenMon())
                            .xepLoaiThiDua(thuong.xepLoaiThiDua())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    khenThuongNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            khenThuongRepository.save(khenThuongNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class KienThucAnNinhQuocPhongService implements ISoYeuLyLichChiTietServices.IKienThucAnNinhQuocPhongSefvice {

        @Override
        public ResDTO<List<KienThucAnNinhQuocPhong>> xemKienThucAnNinhQuocPhong() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kienThucAnNinhQuocPhongRepository.findAll()
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
        public ResDTO<List<KienThucAnNinhQuocPhong>> themKienThucAnNinhQuocPhong(String loaisyllctName, String soCCCD, List<ReqKienThucAnNinhQuocPhong> quocPhongs) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<KienThucAnNinhQuocPhong> kienThucAnNinhQuocPhongs = quocPhongs.stream().map(
                        cu -> new KienThucAnNinhQuocPhong(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.tenCoSoDaoTao(),
                                cu.chungChiDuocCap(),
                                chiTiet,
                                soYeuLyLich
                        )).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kienThucAnNinhQuocPhongRepository.saveAll(kienThucAnNinhQuocPhongs)
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
        public ResDTO<KienThucAnNinhQuocPhong> suaKienThucAnNinhQuocPhong(int id, ReqKienThucAnNinhQuocPhong phong) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(phong.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(phong.soYeuLyLich());
                Optional<KienThucAnNinhQuocPhong> quocPhong = kienThucAnNinhQuocPhongRepository.findById(id);
                if (quocPhong.isPresent()) {
                    KienThucAnNinhQuocPhong kienThucAnNinhQuocPhongNew = KienThucAnNinhQuocPhong.builder()
                            .id(quocPhong.get().getId())
                            .batDau(phong.batDau())
                            .ketThuc(phong.ketThuc())
                            .chungChiDuocCap(phong.chungChiDuocCap())
                            .tenCoSoDaoTao(phong.tenCoSoDaoTao())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    kienThucAnNinhQuocPhongNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            kienThucAnNinhQuocPhongRepository.save(kienThucAnNinhQuocPhongNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class KyLuatService implements ISoYeuLyLichChiTietServices.IKyLuatSefvice {

        @Override
        public ResDTO<List<KyLuat>> xemKyLuat() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kyLuatRepository.findAll()
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
        public ResDTO<List<KyLuat>> themKyLuat(String loaisyllctName, String soCCCD, List<ReqKyLuat> luat) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<KyLuat> kyLuats = luat.stream().map(
                        cu -> new KyLuat(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.hinhThuc(),
                                cu.hanhViViPhamChinh(),
                                cu.coQuanQuyetDinh(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        kyLuatRepository.saveAll(kyLuats)
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
        public ResDTO<KyLuat> suaKyLuat(int id, ReqKyLuat kluat) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(kluat.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(kluat.soYeuLyLich());
                Optional<KyLuat> kyLuat = kyLuatRepository.findById(id);
                if (kyLuat.isPresent()) {
                    KyLuat kyLuatNew = KyLuat.builder()
                            .id(kyLuat.get().getId())
                            .batDau(kluat.batDau())
                            .ketThuc(kluat.ketThuc())
                            .hinhThuc(kluat.hinhThuc())
                            .hanhViViPhamChinh(kluat.hanhViViPhamChinh())
                            .coQuanQuyetDinh(kluat.coQuanQuyetDinh())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    kyLuatNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            kyLuatRepository.save(kyLuatNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class LamViecONuocNgoaiServcie implements ISoYeuLyLichChiTietServices.ILamViecONuocNgoaiSefvice {

        @Override
        public ResDTO<List<LamViecONuocNgoai>> xemLamViecONuocNgoai() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lamViecONuocNgoaiRepository.findAll()
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
        public ResDTO<List<LamViecONuocNgoai>> themLamViecONuocNgoai(String loaisyllctName, String soCCCD, List<ReqLamViecONuocNgoai> reqLamViecONuocNgoais) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<LamViecONuocNgoai> lamViecONuocNgoais = reqLamViecONuocNgoais.stream().map(
                        cu -> new LamViecONuocNgoai(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.toChucDiaChiCongViec(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lamViecONuocNgoaiRepository.saveAll(lamViecONuocNgoais)
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
        public ResDTO<LamViecONuocNgoai> suaLamViecONuocNgoai(int id, ReqLamViecONuocNgoai nuocNgoai) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(nuocNgoai.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(nuocNgoai.soYeuLyLich());
                Optional<LamViecONuocNgoai> lamViecONuocNgoai = lamViecONuocNgoaiRepository.findById(id);
                if (lamViecONuocNgoai.isPresent()) {
                    LamViecONuocNgoai lamViecONuocNgoaiNew = LamViecONuocNgoai.builder()
                            .id(lamViecONuocNgoai.get().getId())
                            .batDau(nuocNgoai.batDau())
                            .ketThuc(nuocNgoai.ketThuc())
                            .toChucDiaChiCongViec(nuocNgoai.toChucDiaChiCongViec())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    lamViecONuocNgoaiNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            lamViecONuocNgoaiRepository.save(lamViecONuocNgoaiNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }

    }

    @Service
    class LuongBanThanService implements ISoYeuLyLichChiTietServices.ILuongBanThanSefvice {

        @Override
        public ResDTO<List<LuongBanThan>> xemLuongBanThan() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        luongBanThanRepository.findAll()
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
        public ResDTO<List<LuongBanThan>> themLuongBanThan(String loaisyllctName, String soCCCD, List<ReqLuongBanThan> reqLuongBanThans) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<LuongBanThan> luongBanThans = reqLuongBanThans.stream().map(
                        cu -> new LuongBanThan(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.maSo(),
                                cu.bacLuong(),
                                cu.heSoLuong(),
                                cu.tienLuongTheoViTri(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        luongBanThanRepository.saveAll(luongBanThans)
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
        public ResDTO<LuongBanThan> suaLuongBanThan(int id, ReqLuongBanThan reqLuongBanThan) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqLuongBanThan.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqLuongBanThan.soYeuLyLich());
                Optional<LuongBanThan> luongBanThan = luongBanThanRepository.findById(id);
                if (luongBanThan.isPresent()) {
                    LuongBanThan luongBanThanNew = LuongBanThan.builder()
                            .id(luongBanThan.get().getId())
                            .batDau(reqLuongBanThan.batDau())
                            .ketThuc(reqLuongBanThan.ketThuc())
                            .maSo(reqLuongBanThan.maSo())
                            .bacLuong(reqLuongBanThan.bacLuong())
                            .heSoLuong(reqLuongBanThan.heSoLuong())
                            .tienLuongTheoViTri(reqLuongBanThan.tienLuongTheoViTri())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    luongBanThanNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            luongBanThanRepository.save(luongBanThanNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class LyLuanChinhTriService implements ISoYeuLyLichChiTietServices.ILyLuanChinhTriSefvice {

        @Override
        public ResDTO<List<LyLuanChinhTri>> xemLyLuanChinhTri() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lyLuanChinhTriRepository.findAll()
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
        public ResDTO<List<LyLuanChinhTri>> themLyLuanChinhTri(String loaisyllctName, String soCCCD, List<ReqLyLuanChinhTri> reqLyLuanChinhTris) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);

                List<LyLuanChinhTri> lyLuanChinhTris = reqLyLuanChinhTris.stream().map(cu ->
                        new LyLuanChinhTri(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.tenCoSoDaoTao(),
                                cu.hinhThucDaoTao(),
                                cu.vanBangDuocCap(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        lyLuanChinhTriRepository.saveAll(lyLuanChinhTris)
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
        public ResDTO<LyLuanChinhTri> suaLyLuanChinhTri(int id, ReqLyLuanChinhTri reqLyLuanChinhTri) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqLyLuanChinhTri.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqLyLuanChinhTri.soYeuLyLich());
                Optional<LyLuanChinhTri> lyLuanChinhTri = lyLuanChinhTriRepository.findById(id);
                if (lyLuanChinhTri.isPresent()) {
                    LyLuanChinhTri llyLuanChinhTriNew = LyLuanChinhTri.builder()
                            .id(lyLuanChinhTri.get().getId())
                            .batDau(reqLyLuanChinhTri.batDau())
                            .ketThuc(reqLyLuanChinhTri.ketThuc())
                            .tenCoSoDaoTao(reqLyLuanChinhTri.tenCoSoDaoTao())
                            .hinhThucDaoTao(reqLyLuanChinhTri.hinhThucDaoTao())
                            .vanBangDuocCap(reqLyLuanChinhTri.vanBangDuocCap())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    llyLuanChinhTriNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            lyLuanChinhTriRepository.save(llyLuanChinhTriNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class NghiepVuChuyenNganhService implements ISoYeuLyLichChiTietServices.INghiepVuChuyenNganhSefvice {

        @Override
        public ResDTO<List<NghiepVuChuyenNganh>> xemNghiepVuChuyenNganh() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        nghiepVuChuyenNganhRepository.findAll()
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
        public ResDTO<List<NghiepVuChuyenNganh>> themNghiepVuChuyenNganh(String loaisyllctName, String soCCCD, List<ReqNghiepVuChuyenNganh> reqNghiepVuChuyenNganhs) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<NghiepVuChuyenNganh> nghiepVuChuyenNganhs = reqNghiepVuChuyenNganhs.stream().map(cu ->
                        new NghiepVuChuyenNganh(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.tenCoSoDaoTao(),
                                cu.chungChiDuocCap(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        nghiepVuChuyenNganhRepository.saveAll(nghiepVuChuyenNganhs)
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
        public ResDTO<NghiepVuChuyenNganh> suaNghiepVuChuyenNganh(int id, ReqNghiepVuChuyenNganh reqNghiepVuChuyenNganh) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqNghiepVuChuyenNganh.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqNghiepVuChuyenNganh.soYeuLyLich());
                Optional<NghiepVuChuyenNganh> nghiepVuChuyenNganh = nghiepVuChuyenNganhRepository.findById(id);
                if (nghiepVuChuyenNganh.isPresent()) {
                    NghiepVuChuyenNganh nghiepVuChuyenNganhNew = NghiepVuChuyenNganh.builder()
                            .id(nghiepVuChuyenNganh.get().getId())
                            .batDau(reqNghiepVuChuyenNganh.batDau())
                            .ketThuc(reqNghiepVuChuyenNganh.ketThuc())
                            .tenCoSoDaoTao(reqNghiepVuChuyenNganh.tenCoSoDaoTao())
                            .chungChiDuocCap(reqNghiepVuChuyenNganh.chungChiDuocCap())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    nghiepVuChuyenNganhNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            nghiepVuChuyenNganhRepository.save(nghiepVuChuyenNganhNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class NgoaiNguService implements ISoYeuLyLichChiTietServices.INgoaiNguSefvice {

        @Override
        public ResDTO<List<NgoaiNgu>> xemNgoaiNgu() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ngoaiNguRepository.findAll()
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
        public ResDTO<List<NgoaiNgu>> themNgoaiNgu(String loaisyllctName, String soCCCD, List<ReqNgoaiNgu> reqNgoaiNgus) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<NgoaiNgu> ngoaiNgus = reqNgoaiNgus.stream().map(cu ->
                        new NgoaiNgu(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.tenCoSoDaoTao(),
                                cu.tenNgoaiNgu(),
                                cu.chungChiDuocCap(),
                                cu.diemSo(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        ngoaiNguRepository.saveAll(ngoaiNgus)
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
        public ResDTO<NgoaiNgu> suaNgoaiNgu(int id, ReqNgoaiNgu reqNgoaiNgu) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqNgoaiNgu.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqNgoaiNgu.soYeuLyLich());
                Optional<NgoaiNgu> ngoaiNgu = ngoaiNguRepository.findById(id);
                if (ngoaiNgu.isPresent()) {
                    NgoaiNgu ngoaiNguNew = NgoaiNgu.builder()
                            .id(ngoaiNgu.get().getId())
                            .batDau(reqNgoaiNgu.batDau())
                            .ketThuc(reqNgoaiNgu.ketThuc())
                            .tenCoSoDaoTao(reqNgoaiNgu.tenCoSoDaoTao())
                            .chungChiDuocCap(reqNgoaiNgu.chungChiDuocCap())
                            .diemSo(reqNgoaiNgu.diemSo())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    ngoaiNguNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            ngoaiNguRepository.save(ngoaiNguNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class PhuCapKhacService implements ISoYeuLyLichChiTietServices.IPhuCapKhacSefvice {

        @Override
        public ResDTO<List<PhuCapKhac>> xemPhuCapKhac() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        phuCapKhacRepository.findAll()
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
        public ResDTO<List<PhuCapKhac>> themPhuCapKhac(String loaisyllctName, String soCCCD, List<ReqPhuCapKhac> reqPhuCapKhacs) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<PhuCapKhac> phuCapKhacs = reqPhuCapKhacs.stream().map(cu ->
                        new PhuCapKhac(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.loaiPhuCap(),
                                cu.phanTramHuongPhuCap(),
                                cu.heSoPhuCap(),
                                cu.hinhThucThuong(),
                                cu.giaTri(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        phuCapKhacRepository.saveAll(phuCapKhacs)
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
        public ResDTO<PhuCapKhac> suaPhuCapKhac(int id, ReqPhuCapKhac reqPhuCapKhac) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqPhuCapKhac.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqPhuCapKhac.soYeuLyLich());
                Optional<PhuCapKhac> phuCapKhac = phuCapKhacRepository.findById(id);
                if (phuCapKhac.isPresent()) {
                    PhuCapKhac phuCapKhacNew = PhuCapKhac.builder()
                            .id(phuCapKhac.get().getId())
                            .batDau(reqPhuCapKhac.batDau())
                            .ketThuc(reqPhuCapKhac.ketThuc())
                            .loaiPhuCap(reqPhuCapKhac.loaiPhuCap())
                            .phanTramHuongPhuCap(reqPhuCapKhac.phanTramHuongPhuCap())
                            .heSoPhuCap(reqPhuCapKhac.heSoPhuCap())
                            .hinhThucThuong(reqPhuCapKhac.hinhThucThuong())
                            .giaTri(reqPhuCapKhac.giaTri())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    phuCapKhacNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            phuCapKhacRepository.save(phuCapKhacNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class QuanHeGiaDinhService implements ISoYeuLyLichChiTietServices.IQuanHeGiaDinhSefvice {

        @Override
        public ResDTO<List<QuanHeGiaDinh>> xemQuanHeGiaDinh() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quanHeGiaDinhRepository.findAll()
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
        public ResDTO<List<QuanHeGiaDinh>> themPQuanHeGiaDinh(String loaisyllctName, UUID id, List<ReqQuanHeGiaDinh> reqQuanHeGiaDinhs) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                Optional<SoYeuLyLich> soYeuLyLich = soYeuLyLichRepository.findById(id);
                if (soYeuLyLich.isPresent()) {
                    List<QuanHeGiaDinh> quanHeGiaDinhs = reqQuanHeGiaDinhs.stream().map(cu ->
                            new QuanHeGiaDinh(
                                    cu.moiQuanHe(),
                                    cu.hoVaTen(),
                                    cu.namSinh(),
                                    cu.thongTinThanNhan(),
                                    chiTiet, soYeuLyLich.get())).toList();

                    return new ResDTO<>(
                            ResEnum.CAP_NHAT_THANH_CONG.getStatusCode(),
                            ResEnum.CAP_NHAT_THANH_CONG,
                            quanHeGiaDinhRepository.saveAll(quanHeGiaDinhs)
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
        public ResDTO<QuanHeGiaDinh> suaQuanHeGiaDinh(int id, ReqQuanHeGiaDinh reqQuanHeGiaDinh) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqQuanHeGiaDinh.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqQuanHeGiaDinh.soYeuLyLich());
                Optional<QuanHeGiaDinh> quanHeGiaDinh = quanHeGiaDinhRepository.findById(id);
                if (quanHeGiaDinh.isPresent()) {
                    QuanHeGiaDinh quanHeGiaDinhNew = QuanHeGiaDinh.builder()
                            .id(quanHeGiaDinh.get().getId())
                            .moiQuanHe(reqQuanHeGiaDinh.moiQuanHe())
                            .hoVaTen(reqQuanHeGiaDinh.hoVaTen())
                            .namSinh(reqQuanHeGiaDinh.namSinh())
                            .thongTinThanNhan(reqQuanHeGiaDinh.thongTinThanNhan())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    quanHeGiaDinhNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            quanHeGiaDinhRepository.save(quanHeGiaDinhNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class QuaTrinhCongTacService implements ISoYeuLyLichChiTietServices.IQuaTrinhCongTacSefvice {

        @Override
        public ResDTO<List<QuaTrinhCongTac>> xemQuaTrinhCongTac() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quaTrinhCongTacRepository.findAll()
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
        public ResDTO<List<QuaTrinhCongTac>> themQuaTrinhCongTac(String loaisyllctName, String soCCCD, List<ReqQuaTrinhCongTac> reqQuaTrinhCongTacs) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<QuaTrinhCongTac> quaTrinhCongTacs = reqQuaTrinhCongTacs.stream().map(cu ->
                        new QuaTrinhCongTac(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.donViCongTac(),
                                cu.chucDanh(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        quaTrinhCongTacRepository.saveAll(quaTrinhCongTacs)
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
        public ResDTO<QuaTrinhCongTac> suaQuaTrinhCongTac(int id, ReqQuaTrinhCongTac reqQuaTrinhCongTac) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqQuaTrinhCongTac.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqQuaTrinhCongTac.soYeuLyLich());
                Optional<QuaTrinhCongTac> quaTrinhCongTac = quaTrinhCongTacRepository.findById(id);
                if (quaTrinhCongTac.isPresent()) {
                    QuaTrinhCongTac quaTrinhCongTacNew = QuaTrinhCongTac.builder()
                            .id(quaTrinhCongTac.get().getId())
                            .batDau(reqQuaTrinhCongTac.batDau())
                            .ketThuc(reqQuaTrinhCongTac.ketThuc())
                            .donViCongTac(reqQuaTrinhCongTac.donViCongTac())
                            .chucDanh(reqQuaTrinhCongTac.chucDanh())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    quaTrinhCongTacNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            quaTrinhCongTacRepository.save(quaTrinhCongTacNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

    @Service
    class TinHocService implements ISoYeuLyLichChiTietServices.ITinHocSefvice {

        @Override
        public ResDTO<List<TinHoc>> xemTinHoc() {
            try {
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tinHocRepository.findAll()
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
        public ResDTO<List<TinHoc>> themQTinHoc(String loaisyllctName, String soCCCD, List<ReqTinHoc> reqTinHocs) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(loaisyllctName);
                SoYeuLyLich soYeuLyLich = soYeuLyLichRepository.findFirstBySoCCCD(soCCCD);
                List<TinHoc> tinHocs = reqTinHocs.stream().map(cu ->
                        new TinHoc(
                                cu.batDau(),
                                cu.ketThuc(),
                                cu.tenCoSoDaoTao(),
                                cu.chungChiDuocCap(),
                                chiTiet, soYeuLyLich)).toList();
                return new ResDTO<>(
                        ResEnum.THANH_CONG.getStatusCode(),
                        ResEnum.THANH_CONG,
                        tinHocRepository.saveAll(tinHocs)
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
        public ResDTO<TinHoc> suaTinHoc(int id, ReqTinHoc reqTinHoc) {
            try {
                LoaiSoYeuLyLichChiTiet chiTiet = loaiSoYeuLyLichChiTietRepository.findByName(reqTinHoc.loaiSoYeuLyLichChiTiet());
                SoYeuLyLich lyLich = soYeuLyLichRepository.findFirstBySoCCCD(reqTinHoc.soYeuLyLich());
                Optional<TinHoc> tinHoc = tinHocRepository.findById(id);
                if (tinHoc.isPresent()) {
                    TinHoc tinHocNew = TinHoc.builder()
                            .id(tinHoc.get().getId())
                            .batDau(reqTinHoc.batDau())
                            .ketThuc(reqTinHoc.ketThuc())
                            .tenCoSoDaoTao(reqTinHoc.tenCoSoDaoTao())
                            .chungChiDuocCap(reqTinHoc.chungChiDuocCap())
                            .loaiSoYeuLyLichChiTiet(chiTiet)
                            .soYeuLyLich(lyLich)
                            .build();
                    tinHocNew.setUpdate_at();
                    return new ResDTO<>(
                            ResEnum.THANH_CONG.getStatusCode(),
                            ResEnum.THANH_CONG,
                            tinHocRepository.save(tinHocNew)
                    );
                }
            } catch (RuntimeException e) {
                e.printStackTrace();
            }
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }

}
