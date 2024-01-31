//package sgu.hrm.module_bacluong;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import sgu.hrm.module_utilities.models.DanToc;
//import sgu.hrm.module_utilities.repositories.CapBacLoaiQuanHamQuanDoiRepository;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor // tao constructor khi field la final hoặc có @not null
//public class BacLuongService implements IBacLuongService {
//    final CapBacLoaiQuanHamQuanDoiRepository.BacLuongRepository bacLuongRepository;
//
//    @Override
//    public List<DanToc.BacLuong> xemBacLuong() {
//        return bacLuongRepository.findAll();
//    }
//}
