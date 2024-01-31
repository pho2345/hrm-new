package sgu.hrm.module_utilities.models.resopnse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

public record UtilitiesResponse<T>(
        UtilitiesNotification status,
        int code,
        List<T> data
) {
    @Override
    public UtilitiesNotification status() {
        return status;
    }

    @Override
    public int code() {
        return status.statusCode;
    }

    @Override
    public List<T> data() {
        return data;
    }

    public enum UtilitiesNotification {
        UTILITIES_SUCCESS(200),
        UTILITIES_ERROR(400);
        final int statusCode;
        UtilitiesNotification(int statusCode) {
            this.statusCode = statusCode;
        }

    }
}
