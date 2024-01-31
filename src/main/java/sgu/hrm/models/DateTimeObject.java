package sgu.hrm.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Getter
@AllArgsConstructor
@MappedSuperclass //class cha không phải là entity
@JsonIgnoreProperties({"create_at", "update_at"}) //ân 2 thuộc tính này trên toàn bộ class
public class DateTimeObject {
    @Column(columnDefinition = "datetime DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime create_at;
    private LocalDateTime update_at;

    @Column(columnDefinition = "boolean default 1")
    private boolean trangThai;
}
