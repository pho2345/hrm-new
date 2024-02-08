package sgu.hrm.module_security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;
import sgu.hrm.module_taikhoan.models.request.ReqTaiKhoanLogin;
import sgu.hrm.module_taikhoan.service.ITaiKhoanService;
import sgu.hrm.module_taikhoan.service.TaiKhoanService;

@RestController
@RequiredArgsConstructor
public class SercurityController {

    private final ITaiKhoanService taiKhoanService;

    @GetMapping("/tu-choi")
    public ResDTO<String> getDenied() throws RuntimeException {
        return new ResDTO<>(
                ResEnum.TRUY_CAP_BI_CAM.getStatusCode(),
                ResEnum.TRUY_CAP_BI_CAM,
                null
        );
    }

    @PostMapping("/dang-nhap")
    public ResDTO<?> dangNhap(@RequestBody ReqTaiKhoanLogin reqTaiKhoanLogin) {
        return taiKhoanService.dangNhap(reqTaiKhoanLogin);
    }

    @GetMapping("/dang-xuat")
    public ResDTO<String> getLogout(HttpServletResponse response) throws Exception {
        try {
            return new ResDTO<>(
                    ResEnum.THANH_CONG.getStatusCode(),
                    ResEnum.THANH_CONG,
                    "Thoát thành công"
            );
        } catch (Exception e) {
            return new ResDTO<>(
                    ResEnum.KHONG_HOP_LE.getStatusCode(),
                    ResEnum.KHONG_HOP_LE,
                    null
            );
        }
    }
    //    @GetMapping("/login")
//    public void getSomething(HttpServletResponse response) throws Exception {
//        response.sendRedirect(" /api/v1/so-yeu-ly-lich");
//    }
}
