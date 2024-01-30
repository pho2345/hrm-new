package sgu.hrm.module_congchuc_vienchuc.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.CongChucVienChucDTO;
import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.repositories.BacNgachCongChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.BacNgachVienChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachCongChucRepository;
import sgu.hrm.module_congchuc_vienchuc.repositories.NgachVienChucRepository;

import java.util.List;

@Service
@RequiredArgsConstructor // create constructor ig field i set final or @not null
public class CongChucVienChucService implements
        ICongChucVienChucService.IBacNgachCongChucService,
        ICongChucVienChucService.IBacNgachVienChucService,
        ICongChucVienChucService.INgachCongChucService,
        ICongChucVienChucService.INgachVienChucService {

    private final BacNgachCongChucRepository bacNgachCongChucRepository;
    private final BacNgachVienChucRepository bacNgachVienChucRepository;
    private final NgachCongChucRepository ngachCongChucRepository;
    private final NgachVienChucRepository ngachVienChucRepository;

    @Override
    public List<BacNgachCongChuc> xemBacNgachCongChuc() {
//        return bacNgachCongChucRepository.findAll().stream().map(BacNgachCongChuc::getName).toList();
//        return bacNgachCongChucRepository.findAll().stream().map(bacNgachCongChuc -> (bacNgachCongChuc.getName());
        return bacNgachCongChucRepository.findAll();
    }

    @Override
    public List<BacNgachVienChuc> xemBacNgachVienChuc() {
        return bacNgachVienChucRepository.findAll();
        //return bacNgachVienChucRepository.findAll().stream().map(bacNgachVienChuc -> new CongChucVienChucDTO(bacNgachVienChuc.getName())).toList();
    }

    @Override
    public List<NgachCongChuc> xemNgachCongChuc() {
        return ngachCongChucRepository.findAll();
//        return ngachCongChucRepository.findAll().stream().map(ngachCongChuc -> new CongChucVienChucDTO(ngachCongChuc.getName())).toList();
    }

    @Override
    public List<NgachVienChuc> xemNgachVienChuc() {
        return ngachVienChucRepository.findAll();
//        return ngachVienChucRepository.findAll().stream().map(ngachVienChuc -> new CongChucVienChucDTO(ngachVienChuc.getName())).toList();
    }
}
