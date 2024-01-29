package sgu.hrm.module_bacluong;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // tao constructor khi field la final hoặc có @not null
public class BacLuongService implements IBacLuongService {
    final BacLuongRepository bacLuongRepository;

    @Override
    public List<BacLuong> xemBacLuong() {
        return bacLuongRepository.findAll();
    }
}
