package sgu.hrm.enums;

public enum NotificationsServer {

    //tai-khoan
    /*** Tạo tài khoản thành công*/
    TAIKHOAN_CREATED("Tạo tài khoản thành công"),

    /*** Cập nhật tài khoản thành công*/
    TAIKHOAN_UPDATED("Cập nhật tài khoản thành công"),

    /*** Xóa tài khoản thành công*/
    TAIKHOAN_DELETED("Xóa tài khoản thành công"),

    /*** Tài khoản bị vô hiệu hóa*/
    TAIKHOAN_INACTIVE("Tài khoản bị vô hiệu hóa"),

    /*** Tài khoản bị khóa*/
    TAIKHOAN_LOCKED("Tài khoản bị khóa"),

    /*** Tài khoản được mở khóa*/
    TAIKHOAN_UNLOCKED("Tài khoản được mở khóa"),

    /*** Tài khoản bị tạm ngưng*/
    TAIKHOAN_SUSPENDED("Tài khoản bị tạm ngưng"),

    /*** Tài khoản được tiếp tục hoạt động*/
    TAIKHOAN_UNSUSPENDED("Tài khoản được tiếp tục hoạt động"),

    TAIKHOAN_NOTFOUND("Tài khoản không tìm thấy");

    String name;

    NotificationsServer(String name) {
        this.name = name;
    }

}
