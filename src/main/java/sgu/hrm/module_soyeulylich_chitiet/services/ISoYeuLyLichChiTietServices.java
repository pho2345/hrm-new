package sgu.hrm.module_soyeulylich_chitiet.services;

import sgu.hrm.module_response.ResDTO;
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


import java.util.List;

public interface ISoYeuLyLichChiTietServices {
    interface ILoaiSoYeuLyLichChiTietSefvice {
        ResDTO<List<LoaiSoYeuLyLichChiTiet>> xemLoaiSoYeuLyLichChiTiet();

        ResDTO<LoaiSoYeuLyLichChiTiet> themLoaiSoYeuLyLichChiTiet(ReqLoaiSoYeuLyLichChiTiet reqLoaiSoYeuLyLichChiTiet);

        ResDTO<LoaiSoYeuLyLichChiTiet> suaLoaiSoYeuLyLichChiTiet(LoaiSoYeuLyLichChiTiet loaiSoYeuLyLichChiTiet);

    }

    interface IBanThanCoLamViecChoCheDoCuSefvice {
        ResDTO<List<BanThanCoLamViecChoCheDoCu>> xemBanThanCoLamViecChoCheDoCu();

        ResDTO<List<BanThanCoLamViecChoCheDoCu>> themBanThanCoLamViecChoCheDoCu(String loaisyllctName, String soCCCD, List<ReqBanThanCoLamViecChoCheDoCu> cu);

        ResDTO<BanThanCoLamViecChoCheDoCu> suaBanThanCoLamViecChoCheDoCu(int id, ReqBanThanCoLamViecChoCheDoCu cu);

    }

    interface IKhenThuongSefvice {
        ResDTO<List<KhenThuong>> xemKhenThuong();

        ResDTO<List<KhenThuong>> themKhenThuong(String loaisyllctName, String soCCCD, List<ReqKhenThuong> thuong);

        ResDTO<KhenThuong> suaKhenThuong(int id, ReqKhenThuong thuong);
    }

    interface IKienThucAnNinhQuocPhongSefvice {
        ResDTO<List<KienThucAnNinhQuocPhong>> xemKienThucAnNinhQuocPhong();

        ResDTO<List<KienThucAnNinhQuocPhong>> themKienThucAnNinhQuocPhong(String loaisyllctName, String soCCCD, List<ReqKienThucAnNinhQuocPhong> quocPhongs);

        ResDTO<KienThucAnNinhQuocPhong> suaKienThucAnNinhQuocPhong(int id, ReqKienThucAnNinhQuocPhong phong);
    }

    interface IKyLuatSefvice {
        ResDTO<List<KyLuat>> xemKyLuat();

        ResDTO<List<KyLuat>> themKyLuat(String loaisyllctName, String soCCCD, List<ReqKyLuat> luat);

        ResDTO<KyLuat> suaKyLuat(int id, ReqKyLuat thuong);
    }

    interface ILamViecONuocNgoaiSefvice {
        ResDTO<List<LamViecONuocNgoai>> xemLamViecONuocNgoai();

        ResDTO<List<LamViecONuocNgoai>> themLamViecONuocNgoai(String loaisyllctName, String soCCCD, List<ReqLamViecONuocNgoai> reqLamViecONuocNgoais);

        ResDTO<LamViecONuocNgoai> suaLamViecONuocNgoai(int id, ReqLamViecONuocNgoai nuocNgoai);
    }

    interface ILuongBanThanSefvice {
        ResDTO<List<LuongBanThan>> xemLuongBanThan();

        ResDTO<List<LuongBanThan>> themLuongBanThan(String loaisyllctName, String soCCCD, List<ReqLuongBanThan> reqLuongBanThans);

        ResDTO<LuongBanThan> suaLuongBanThan(int id, ReqLuongBanThan reqLuongBanThan);
    }

    interface ILyLuanChinhTriSefvice {
        ResDTO<List<LyLuanChinhTri>> xemLyLuanChinhTri();

        ResDTO<List<LyLuanChinhTri>> themLyLuanChinhTri(String loaisyllctName, String soCCCD, List<ReqLyLuanChinhTri> reqLyLuanChinhTris);

        ResDTO<LyLuanChinhTri> suaLyLuanChinhTri(int id, ReqLyLuanChinhTri reqLyLuanChinhTri);
    }

    interface INghiepVuChuyenNganhSefvice {
        ResDTO<List<NghiepVuChuyenNganh>> xemNghiepVuChuyenNganh();

        ResDTO<List<NghiepVuChuyenNganh>> themNghiepVuChuyenNganh(String loaisyllctName, String soCCCD, List<ReqNghiepVuChuyenNganh> reqNghiepVuChuyenNganhs);

        ResDTO<NghiepVuChuyenNganh> suaNghiepVuChuyenNganh(int id, ReqNghiepVuChuyenNganh reqNghiepVuChuyenNganh);
    }

    interface INgoaiNguSefvice {
        ResDTO<List<NgoaiNgu>> xemNgoaiNgu();

        ResDTO<List<NgoaiNgu>> themNgoaiNgu(String loaisyllctName, String soCCCD, List<ReqNgoaiNgu> reqNgoaiNgus);

        ResDTO<NgoaiNgu> suaNgoaiNgu(int id, ReqNgoaiNgu reqNgoaiNgu);
    }

    interface IPhuCapKhacSefvice {
        ResDTO<List<PhuCapKhac>> xemPhuCapKhac();

        ResDTO<List<PhuCapKhac>> themPhuCapKhac(String loaisyllctName, String soCCCD, List<ReqPhuCapKhac> reqPhuCapKhacs);

        ResDTO<PhuCapKhac> suaPhuCapKhac(int id, ReqPhuCapKhac reqPhuCapKhac);
    }

    interface IQuanHeGiaDinhSefvice {
        ResDTO<List<QuanHeGiaDinh>> xemQuanHeGiaDinh();

        ResDTO<List<QuanHeGiaDinh>> themPQuanHeGiaDinh(String loaisyllctName, String soCCCD, List<ReqQuanHeGiaDinh> reqQuanHeGiaDinhs);

        ResDTO<QuanHeGiaDinh> suaQuanHeGiaDinh(int id, ReqQuanHeGiaDinh reqQuanHeGiaDinh);
    }

    interface IQuaTrinhCongTacSefvice {
        ResDTO<List<QuaTrinhCongTac>> xemQuaTrinhCongTac();

        ResDTO<List<QuaTrinhCongTac>> themQuaTrinhCongTac(String loaisyllctName, String soCCCD, List<ReqQuaTrinhCongTac> reqQuaTrinhCongTacs);

        ResDTO<QuaTrinhCongTac> suaQuaTrinhCongTac(int id, ReqQuaTrinhCongTac reqQuaTrinhCongTac);
    }

    interface ITinHocSefvice {
        ResDTO<List<TinHoc>> xemTinHoc();

        ResDTO<List<TinHoc>> themQTinHoc(String loaisyllctName, String soCCCD, List<ReqTinHoc> reqTinHocs);

        ResDTO<TinHoc> suaTinHoc(int id, ReqTinHoc reqTinHoc);
    }
}
