package sgu.hrm.module_congchuc_vienchuc.services;

import sgu.hrm.module_congchuc_vienchuc.models.BacNgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.BacNgachVienChuc;
import sgu.hrm.module_congchuc_vienchuc.models.CongChucVienChucDTO;
import sgu.hrm.module_congchuc_vienchuc.models.NgachCongChuc;
import sgu.hrm.module_congchuc_vienchuc.models.NgachVienChuc;

import java.util.List;

public interface ICongChucVienChucService {
    interface IBacNgachCongChucService{
        abstract List<BacNgachCongChuc> xemBacNgachCongChuc();
    }
    interface IBacNgachVienChucService{
        abstract List<BacNgachVienChuc> xemBacNgachVienChuc();
    }
    interface INgachCongChucService{
        abstract List<NgachCongChuc> xemNgachCongChuc();
    }
    interface INgachVienChucService{
        abstract List<NgachVienChuc> xemNgachVienChuc();
    }
}
