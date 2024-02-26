package sgu.hrm.models;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@SuperBuilder
@AllArgsConstructor
@MappedSuperclass //class cha không phải là entity
//@JsonIgnoreProperties({"create_at", "update_at"}) //ân 2 thuộc tính này trên toàn bộ class
public class DateTimeObject {
    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime create_at;

    @Getter
    private LocalDateTime update_at;

    @Column(columnDefinition = "boolean default 1")
    private boolean trangThai;

    public DateTimeObject(LocalDateTime create_at, LocalDateTime update_at) {
        this.create_at = create_at;
        this.update_at = update_at;
    }

    //
    public DateTimeObject() {
        this.create_at = LocalDateTime.now();
        this.trangThai = true;
    }


    public void setUpdate_at() {
        this.update_at = LocalDateTime.parse(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
    }
}
