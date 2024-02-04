package sgu.hrm.module_security;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sgu.hrm.module_response.ResDTO;
import sgu.hrm.module_response.ResEnum;

@RestController
public class SercurityController {

//    @GetMapping("/login")
//    public void getSomething(HttpServletResponse response) throws Exception {
//        response.sendRedirect(" /api/v1/so-yeu-ly-lich");
//    }

    @GetMapping("/api/v1/tu-choi")
    public ResDTO<String> getDenied(HttpServletResponse response) throws Exception {
        try {
            return new ResDTO<>(
                    ResEnum.TRUY_CAP_BI_CAM.getStatusCode(),
                    ResEnum.TRUY_CAP_BI_CAM,
                    null
            );
        } catch (Exception e) {
            return new ResDTO<>(
                    ResEnum.TRUY_CAP_BI_CAM.getStatusCode(),
                    ResEnum.TRUY_CAP_BI_CAM,
                    null
            );
        }
    }

    @GetMapping("/api/v1/dang-xuat")
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
}
