package sgu.hrm.module_response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResDTO<T> {
    final int status_code;
    final ResEnum message;
    final T data;
    final LocalDateTime time_stamp = LocalDateTime.now();

    public ResDTO(int status_code, ResEnum message, T data) {
        this.status_code = status_code;
        this.message = message;
        this.data = data;
    }
//    final String time_stamp = String.format("%tY-%tm-%tdT%tH:%tM:%tS", LocalDateTime.now().getYear(),
//            LocalDateTime.now().getMonth(),
//            LocalDateTime.now().getDayOfMonth(),
//            LocalDateTime.now().getHour(),
//            LocalDateTime.now().getMinute(),
//            LocalDateTime.now().getSecond()
//    );
}
