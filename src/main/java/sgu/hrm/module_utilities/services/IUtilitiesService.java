package sgu.hrm.module_utilities.services;

import sgu.hrm.module_response.ResDTO;

public interface IUtilitiesService<T> {
    ResDTO<?> xemDS();

    default ResDTO<?> them(String name) {
        return null;
    }

    ResDTO<?> sua(T object);

    default ResDTO<?> xoa(T object) {
        return null;
    }

    default ResDTO<?> themCapBacLoaiQuanHamQuanDoi(String name, String loaiQuanHamName) {
        return null;
    }
}
