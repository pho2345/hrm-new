package sgu.hrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import java.util.UUID;

@Embeddable
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChuyenMonSYLLPK implements Serializable {

    @Column(name = "so_yeu_ly_lich_id")
    UUID soYeuLyLich;

    @Column(name = "chuyen_mon_id")
    int chuyenMon;
}
