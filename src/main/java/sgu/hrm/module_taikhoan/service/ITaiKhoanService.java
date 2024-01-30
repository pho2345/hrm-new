package sgu.hrm.module_taikhoan.service;

import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.dto.TaiKhoanDTO;

import java.util.List;

public interface ITaiKhoanService {
    public List<TaiKhoan> xemTaiKhoan();
    public void themTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    public void suaTaiKhoan();
    public void xoaTaiKhoan();
}
