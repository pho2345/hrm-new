package sgu.hrm.module_taikhoan.service;

import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.dto.ReqTaiKhoanDTO;
import sgu.hrm.module_taikhoan.models.dto.ResTaiKhoanDTO;
//import sgu.hrm.module_taikhoan.models.resopnse.TaiKhoanRes;

import java.util.List;

public interface ITaiKhoanService {
    public ResDTO<List<ResTaiKhoanDTO>> xemDanhSachTaiKhoan(); //admin
    public TaiKhoan xemTaiKhoanTheoSoCCCD(String soCCCD); //admin user
    void suaTrangThaiTaiKhoan(int id); //admin
    public ResDTO<TaiKhoan> themTaiKhoan(ReqTaiKhoanDTO reqTaiKhoanDTO);
    public ResDTO<TaiKhoan> suaMathauTaiKhosn(int id, String matKhau);
    public void xoaTaiKhoan();
}
