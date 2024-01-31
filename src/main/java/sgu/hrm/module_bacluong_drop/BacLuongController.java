//package sgu.hrm.module_bacluong;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import sgu.hrm.module_utilities.models.DanToc;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor //tự tạo constructor khi field là final hoặc có @ not null
//@RequestMapping(value = "/api/v1/bac-luong")
//public class BacLuongController {
//
//    private final IBacLuongService bacLuongService;
//
//    @GetMapping("")
//    public List<BacLuong> getAllBacLuong() {
//        return bacLuongService.xemBacLuong();
//    }
//
//}