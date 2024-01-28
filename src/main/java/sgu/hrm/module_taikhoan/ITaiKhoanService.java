package sgu.hrm.module_taikhoan;

import java.util.List;

public interface ITaiKhoanService {
    public List<TaiKhoan> xemTaiKhoan();
    public void themTaiKhoan(TaiKhoanDTO taiKhoanDTO);
    public void suaTaiKhoan();
    public void xoaTaiKhoan();
}
