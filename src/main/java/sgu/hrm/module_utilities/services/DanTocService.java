//package sgu.hrm.module_utilities.services;
//
//import org.springframework.stereotype.Service;
//import sgu.hrm.module_utilities.models.DanToc;
//import sgu.hrm.module_utilities.repositories.DanTocRepository;
//
//import java.util.List;
//
//@Service
//public class DanTocService implements IDanTocService {
//
//    private final DanTocRepository danTocRepository;
//
//    public DanTocService(DanTocRepository danTocRepository) {
//        this.danTocRepository = danTocRepository;
//    }
//
//    @Override
//    public List<DanToc> xemDanToc() {
//        return danTocRepository.findAll();
//    }
//}
