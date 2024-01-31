package sgu.hrm.module_response;

public enum ResEnum {
    THANH_CONG(201),
    KHONG_HOP_LE(400),
    KHONG_DUOC_UY_QUYEN(401),
    TRUY_CAP_BI_CAM(403),
    HONG_TIM_THAY(403);
    private int statusCode;

    ResEnum(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
 //1 dto de ghi gia tri
//    public record resDTO<T>(
//            int statusCode,
//            ResEnum message,
//            T data
//
//    ) {
////
//    }
}
