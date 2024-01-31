//package sgu.hrm.module_taikhoan.models.resopnse;
//
//
//import java.util.UUID;
//
//public enum TaiKhoanRes {
//    TAIKHOAN_SUCCESS(200),
//    TAIKHOAN_CREATED_SUCCESS("Tài khoản tạo thành công"),
//    TAIKHOAN_CREATED_FAILD("Tài khoản tạo thành công"),
//    TAIKHOAN_NOTFOUND("Tài khoản không tìm thấy"),
//    TAIKHOAN_UPDATE_MATKHAU("Tài khoản thay đổi mật khẩu thành công");
//    private String name;
//    private int code;
//
//    //mặc định constructor trong enum là private
//    private TaiKhoanRes(String name) {
//        this.name = name;
//    }
//    private TaiKhoanRes(int code) {
//        this.code = code;
//    }
//    public record TaiKhoanResDTO(
//            int id,
//            String hoVaten,
//            String username,
////            String password,
//            UUID maSoYeuLyLich,
//            boolean trangThai){
//    }
//
//    public record ThgBaoTaiKhoan<T>(TaiKhoanRes statusCode, String message, T data) {
//        @Override
//        public TaiKhoanRes statusCode() {
//            return statusCode;
//        }
//
//        @Override
//        public String message() {
//            return statusCode.name;
//        }
//
//        @Override
//        public T data() {
//            return data;
//        }
//    }
//}
