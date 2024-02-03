package sgu.hrm.module_taikhoan.service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoan;
import sgu.hrm.module_taikhoan.models.resopnse.ResTaiKhoan;
//import sgu.hrm.module_taikhoan.models.resopnse.TaiKhoanRes;

import java.util.List;

public interface ITaiKhoanService {
    public ResDTO<List<ResTaiKhoan>> xemDanhSachTaiKhoan(); //admin

    public ResDTO<ResTaiKhoan> xemTaiKhoanTheoSoCCCDOrUsername(String soCCCD); //admin user
    ResDTO<TaiKhoan> xemTaiKhoanTheoId(int id); //admin user
    ResDTO<TaiKhoan> themTaiKhoan(ReqTaiKhoan taiKhoan);


//    void suaTrangThaiTaiKhoan(int id); //admin
//    public ResDTO<TaiKhoan> suaMathauTaiKhosn(int id, String matKhau);
//    public void xoaTaiKhoan();
}
