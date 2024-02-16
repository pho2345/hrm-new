-- role_taikhoan
insert into `role_taikhoan` (id, title)
values (0, 'ADMIN'),
       (1, 'EMPLOYEE');
-- taikhoan
INSERT INTO taikhoan (`username`, `password`, `status`)
VALUES ('ThuNTM', '001225145523', 1),
       ('TaiNG', '001478111451', 1);
-- nhóm máu
INSERT INTO nhom_mau (id, name)
values (0, 'A'),
       (1, 'B'),
       (2, 'AB'),
       (3, 'O');
-- tinh_trang_suc_khoe
INSERT into tinh_trang_suc_khoe (title)
VALUES ('YẾU'),
       ('TRUNG BÌNH'),
       ('KHÁ'),
       ('TỐT'),
       ('KHỎE');
-- doi_tuong_chinh_sach
INSERT INTO doi_tuong_chinh_sach (name)
values ('Dân tộc thiểu số'),
       ('Con liệt sĩ');
-- trinh_do_giao_duc_pho_thong
INSERT INTO trinh_do_giao_duc_pho_thong (name)
values ('10/10'),
       ('12/12');
-- trinh_do_chuyen_mon
INSERT INTO trinh_do_chuyen_mon (name)
values ('Sơ cấp'),
       ('Trung cấp'),
       ('Cao đẳng'),
       ('Đại học'),
       ('Thạc sĩ'),
       ('Tiến sĩ');
-- học hàm
INSERT INTO hoc_ham (name)
values ('Không'),
       ('Giáo sư'),
       ('Phó giáo sư');
-- danh_hieu_nha_nuoc_phong_tang
INSERT INTO danh_hieu_nha_nuoc_phong_tang (name)
values ('Không'),
       ('Tỉnh Anh hùng'),
       ('Thành phố Anh hùng'),
       ('Bà mẹ Việt Nam Anh hùng'),
       ('Anh hùng Lực lượng vũ trang nhân dân'),
       ('Anh hùng Lao động'),
       ('Nhà giáo nhân dân'),
       ('Nhà giáo ưu tú');
-- dân tộc
INSERT INTO dan_toc (id, name)
VALUES (1, "Ba Na"),
       (2, "Bà Y"),
       (3, "Bố Y"),
       (4, "Brau"),
       (5, "Bru - Vân Kiều"),
       (6, "Chăm"),
       (7, "Chơ Ro"),
       (8, "Chứt"),
       (9, "Cơ Ho"),
       (10, "Cơ Tu"),
       (11, "Cống"),
       (12, "Coong"),
       (13, "Cờ Lao"),
       (14, "Ê Đê"),
       (15, "Gia Rai"),
       (16, "Giáy"),
       (17, "Hà Nhì"),
       (18, "Hrê"),
       (19, "Kháng"),
       (20, "Khơ Mú"),
       (21, "Khơ Lơ"),
       (22, "Kinh"),
       (23, "Krông"),
       (24, "Lào"),
       (25, "La Chí"),
       (26, "La Ha"),
       (27, "Lô Lô"),
       (28, "Mảng"),
       (29, "M'nông"),
       (30, "Mơ Nông"),
       (31, "Mường"),
       (32, "Nùng"),
       (33, "Ô Đu"),
       (34, "Pà Thẻn"),
       (35, "Phù Lá"),
       (36, "Pu Péo"),
       (37, "Rơ Măm"),
       (38, "Ra Glai"),
       (39, "Rục"),
       (40, "Sán Chay"),
       (41, "Sán Dìu"),
       (42, "Sán Rìu"),
       (43, "Si La"),
       (44, "Sơ Rếch"),
       (45, "Tày"),
       (46, "Tày Thái"),
       (47, "Thổ"),
       (48, "Thái"),
       (49, "Xinh Mun"),
       (50, "Xơ Đăng"),
       (51, "X' Tiêng"),
       (52, "Ya Chêng"),
       (53, "Ý Đình"),
       (54, "Zao");
-- giới tính
insert into gioi_tinh (id, name)
VALUES (0, 'Nam'),
       (1, 'Nữ');
-- tôn giáo
INSERT INTO ton_giao (id, name)
VALUES (0, 'Phật giáo'),
       (1, 'Công giáo'),
       (2, 'Tin Lành'),
       (3, 'Cao Đài'),
       (4, 'Phật giáo Hòa Hảo'),
       (5, 'Hồi giáo'),
       (6, 'Tôn giáo Baha`i'),
       (7, 'Tịnh độ Cư sỹ Phật hội'),
       (8, 'Cơ đốc Phục lâm'),
       (9, 'Phật giáo Tứ Ân Hiếu nghĩa'),
       (10, 'Minh Sư đạo'),
       (11, 'Ba-la-môn giáo'),
       (12, 'Mặc môn'),
       (13, 'Phật giáo Hiếu Nghĩa Tà Lơn'),
       (14, 'Bửu Sơn Kỳ Hương');

-- thành phần gia đình
insert into thanh_phan_gia_dinh (id, name)
VALUES (0, 'Cố nông'),
       (1, 'Bần nông'),
       (3, 'Trung nông'),
       (4, 'Phú nông/ Địa chủ'),
       (5, 'Công chức/ Viên chức'),
       (6, 'Nghèo đói'),
       (7, 'Tiểu thương'),
       (8, 'Tiểu chủ'),
       (9, 'Tư sản'),
       (10, 'Tiểu tư sản');
-- bac_luong
INSERT INTO bac_luong (name)
VALUES ('Bậc 1'),
       ('Bậc 2'),
       ('Bậc 3'),
       ('Bậc 4'),
       ('Bậc 5'),
       ('Bậc 6'),
       ('Bậc 7'),
       ('Bậc 8'),
       ('Bậc 9'),
       ('Bậc 10'),
       ('Bậc 11'),
       ('Bậc 12');
-- loai_vien_chuc
INSERT INTO loai_vien_chuc (id, name)
values (0, 'A3'),
       (1, 'A2'),
       (2, 'A1'),
       (3, 'A0'),
       (4, 'B');
-- loai_cong_chuc
INSERT INTO loai_cong_chuc (id, name)
values (0, 'A3'),
       (1, 'A2'),
       (2, 'A1'),
       (3, 'A0'),
       (4, 'B'),
       (5, 'C');
-- nhom_loai_vien_chuc
INSERT into nhom_loai_vien_chuc (name, loai_vien_chuc)
values ('A3.1', 0),
       ('A3.2', 0),
       ('A2.1', 1),
       ('A2.2', 1),
       ('A1', 2),
       ('A0', 3),
       ('B', 4);
-- nhom_loai_cong_chuc
INSERT into nhom_loai_cong_chuc (name, loai_cong_chuc)
values ('A3.1', 0),
       ('A3.2', 0),
       ('A2.1', 1),
       ('A2.2', 1),
       ('A1', 2),
       ('A0', 3),
       ('B', 4),
       ('C1', 5);
-- he_so_luong_vien_chuc
INSERT into he_so_luong_vien_chuc (nhom_loai_vien_chuc, bac_luong, he_so)
values (1, 1, 6.2),
       (1, 2, 6.56),
       (1, 3, 6.92),
       (1, 4, 7.28),
       (1, 5, 7.64),
       (1, 6, 8.00),
       (2, 1, 5.75),
       (2, 2, 6.11),
       (2, 3, 6.47),
       (2, 4, 6.83),
       (2, 5, 7.19),
       (2, 6, 7.55),
       (3, 1, 4.4),
       (3, 2, 4.74),
       (3, 3, 5.08),
       (3, 4, 5.42),
       (3, 5, 5.76),
       (3, 6, 6.10),
       (3, 7, 6.44),
       (3, 8, 6.78),
       (4, 1, 4.0),
       (4, 2, 4.34),
       (4, 3, 4.68),
       (4, 4, 5.02),
       (4, 5, 5.36),
       (4, 6, 5.7),
       (4, 7, 6.04),
       (4, 8, 6.38),
       (5, 1, 2.34),
       (5, 2, 2.67),
       (5, 3, 3.00),
       (5, 4, 3.33),
       (5, 5, 3.66),
       (5, 6, 3.99),
       (5, 7, 4.32),
       (5, 8, 4.65),
       (5, 9, 4.98),
       (6, 1, 2.10),
       (6, 2, 2.41),
       (6, 3, 2.72),
       (6, 4, 3.03),
       (6, 5, 3.34),
       (6, 6, 3.65),
       (6, 7, 3.96),
       (6, 8, 4.27),
       (6, 9, 4.58),
       (6, 10, 4.89),
       (7, 1, 1.86),
       (7, 2, 2.06),
       (7, 3, 2.26),
       (7, 4, 2.46),
       (7, 5, 2.66),
       (7, 6, 2.86),
       (7, 7, 3.06),
       (7, 8, 3.26),
       (7, 9, 3.46),
       (7, 10, 3.66),
       (7, 11, 3.86),
       (7, 12, 4.06);
-- he_so_luong_cong_chuc
INSERT into he_so_luong_cong_chuc (nhom_loai_cong_chuc, bac_luong, he_so)
values (1, 1, 6.2),
       (1, 2, 6.56),
       (1, 3, 6.92),
       (1, 4, 7.28),
       (1, 5, 7.64),
       (1, 6, 8.00),
       (2, 1, 5.75),
       (2, 2, 6.11),
       (2, 3, 6.47),
       (2, 4, 6.83),
       (2, 5, 7.19),
       (2, 6, 7.55),
       (3, 1, 4.4),
       (3, 2, 4.74),
       (3, 3, 5.08),
       (3, 4, 5.42),
       (3, 5, 5.76),
       (3, 6, 6.10),
       (3, 7, 6.44),
       (3, 8, 6.78),
       (4, 1, 4.0),
       (4, 2, 4.34),
       (4, 3, 4.68),
       (4, 4, 5.02),
       (4, 5, 5.36),
       (4, 6, 5.7),
       (4, 7, 6.04),
       (4, 8, 6.38),
       (5, 1, 2.34),
       (5, 2, 2.67),
       (5, 3, 3.00),
       (5, 4, 3.33),
       (5, 5, 3.66),
       (5, 6, 3.99),
       (5, 7, 4.32),
       (5, 8, 4.65),
       (5, 9, 4.98),
       (6, 1, 2.10),
       (6, 2, 2.41),
       (6, 3, 2.72),
       (6, 4, 3.03),
       (6, 5, 3.34),
       (6, 6, 3.65),
       (6, 7, 3.96),
       (6, 8, 4.27),
       (6, 9, 4.58),
       (6, 10, 4.89),
       (7, 1, 1.86),
       (7, 2, 2.06),
       (7, 3, 2.26),
       (7, 4, 2.46),
       (7, 5, 2.66),
       (7, 6, 2.86),
       (7, 7, 3.06),
       (7, 8, 3.26),
       (7, 9, 3.46),
       (7, 10, 3.66),
       (7, 11, 3.86),
       (7, 12, 4.06),
       (8, 1, 1.65),
       (8, 2, 1.83),
       (8, 3, 2.01),
       (8, 4, 2.19),
       (8, 5, 2.37),
       (8, 6, 2.55),
       (8, 7, 2.73),
       (8, 8, 2.91),
       (8, 9, 3.09),
       (8, 10, 3.27),
       (8, 11, 3.45),
       (8, 12, 3.63);
-- nhom_chuc_danh_dang
INSERT INTO nhom_chuc_danh_dang (id, name)
values (0, 'Các chức danh lãnh đạo chủ chốt và lãnh đạo cấp cao của Đảng và Nhà nước'),
       (1, 'Chức danh cán bộ thuộc diện Bộ Chính trị, Ban Bí thư quản lý'),
       (2, 'Khung chức danh, chức vụ thuộc diện cấp ủy, tổ chức đảng, lãnh đạo cơ quan, đơn vị quản lý');

-- INSERT INTO cap_nhom_chuc_danh_dang (name, nhom_chuc_danh_dang)
-- VALUES ('Lãnh đạo chủ chốt của Đảng và Nhà nước', 0),
--        ('Lãnh đạo cấp cao của Đảng, Nhà nước và Mặt trận Tổ quốc Việt Nam', 0),
--        ('Các chức danh thuộc diện Bộ Chính trị quản lý', 1),
--        ('Các chức danh diện Ban Bí thư quản lý', 1),
--        ('Tổng cục trưởng và tương đương', 2),
--        ('Phó Tổng cục trưởng và tương đương', 2),
--        ('Vụ trưởng và tương đương', 2),
--        ('Phó vụ trưởng và tương đương', 2),
--        ('Trưởng phòng và tương đương', 2),
--        ('Phó trưởng phòng và tương đương', 2),
--        ('Cán bộ xã, phường, thị trấn', 2);
--
-- INSERT INTO chuc_danh_dang (name, cap_nhom_chuc_danh_dang)
-- VALUES ('Tổng Bí thư', 1),
--        ('Chủ tịch nước', 1),
--        ('Thủ tướng Chính phủ', 1),
--        ('Chủ tịch Quốc hội', 1),
--        ('Thường trực Ban Bí thư', 2),
--        ('Ủy viên Bộ Chính trị', 2),
--        ('Ủy viên Ban Bí thư', 2),
--        ('Chủ tịch Ủy ban Trung ương Mặt trận Tổ quốc Việt Nam', 2),
--        ('Chánh án Toà án nhân dân tối cao', 2),
--        ('Viện trưởng Viện Kiểm sát nhân dân tối cao', 2),
--        ('Phó Chủ tịch nước', 2),
--        ('Phó Thủ tướng Chính phủ', 2),
--        ('Phó Chủ tịch Quốc hội', 2),
--        ('Ủy viên Trung ương Đảng chính thức', 3),
--        ('Trưởng ban, cơ quan đảng ở Trung ương', 3),
--        ('Giám đốc Học viện Chính trị quốc gia Hồ Chí Minh', 3),
--        ('Tổng Biên tập Báo Nhân Dân', 3),
--        ('Tổng Biên tập Tạp chí Cộng sản', 3),
--        ('Ủy viên Ủy ban Thường vụ Quốc hội', 3),
--        ('Bộ trưởng và thủ trưởng cơ quan ngang bộ', 3),
--        ('Chủ nhiệm Văn phòng Chủ tịch nước', 3),
--        ('Tổng Kiểm toán Nhà nước', 3),
--        ('Trưởng tổ chức chính trị - xã hội ở Trung ương', 3),
--        ('Phó Chủ tịch - Tổng Thư ký Ủy ban Trung ương Mặt trận Tổ quốc Việt Nam', 3),
--        ('Bí thư tỉnh ủy, thành ủy, đảng ủy khối trực thuộc Trung ương', 3),
--        ('Phó Bí thư Thành ủy Hà Nội', 3),
--        ('Phó Bí thư Thành ủy Thành phố Hồ Chí Minh', 3),
--        ('Chủ tịch Hội đồng nhân dân, Ủy ban nhân dân thành phố Hà Nội', 3),
--        ('Thành phố Hồ Chí Minh', 3),
--        ('Phó Chủ nhiệm Ủy ban Kiểm tra Trung ương', 3),
--        ('Chủ tịch Viện Hàn lâm Khoa học xã hội Việt Nam', 3),
--        ('Chủ tịch Viện Hàn lâm Khoa học công nghệ Việt Nam', 3),
--        ('Chủ tịch Ủy ban Quản lý vốn nhà nước tại doanh nghiệp', 3),
--        ('Tổng Giám đốc Thông tấn xã Việt Nam', 3),
--        ('Tổng Giám đốc Đài Tiếng nói Việt Nam', 3),
--        ('Tổng Giám đốc Đài Truyền hình Việt Nam', 3),
--        ('Phó trưởng ban, cơ quan đảng ở Trung ương', 3),
--        ('Phó Giám đốc Học viện Chính trị quốc gia Hồ Chí Minh', 3),
--        ('Phó Tổng Biên tập Báo Nhân Dân', 3),
--        ('Phó Tổng Biên tập Tạp chí Cộng sản', 3),
--        ('Phó Chủ tịch Ủy ban Trung ương Mặt trận Tổ quốc Việt Nam', 4),
--        ('Phó Chủ tịch Hội đồng Dân tộc', 4),
--        ('Phó Chủ nhiệm các Ủy ban của Quốc hội', 4),
--        ('Phó Chủ nhiệm Văn phòng Quốc hội', 4),
--        ('Phó Chánh án Toà án nhân dân tối cao', 4),
--        ('Phó Viện trưởng Viện Kiểm sát nhân dân tối cao', 4),
--        ('Thứ trưởng, phó thủ trưởng cơ quan ngang bộ', 4),
--        ('Phó Chủ nhiệm Văn phòng Chủ tịch nước', 4),
--        ('Phó Tổng Kiểm toán Nhà nước', 4),
--        ('Phó trưởng các tổ chức chính trị - xã hội ở Trung ương', 4),
--        ('Bí thư thường trực Trung ương Đoàn Thanh niên Cộng sản Hồ Chí Minh', 4),
--        ('Phó bí thư tỉnh ủy, thành ủy, đảng ủy khối trực thuộc Trung ương', 4),
--        ('Chủ tịch Hội đồng nhân dân, chủ tịch Ủy ban nhân dân tỉnh, thành phố trực thuộc Trung ương', 4),
--        ('Ủy viên Ủy ban Kiểm tra Trung ương', 4),
--        ('Giám đốc Nhà xuất bản Chính trị quốc gia Sự thật', 4),
--        ('Chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương', 4),
--        ('Trợ lý các đồng chí lãnh đạo chủ chốt của Đảng, Nhà nước', 4),
--        ('Trợ lý Thường trực Ban Bí thư', 4),
--        ('Viện trưởng Viện Nghiên cứu lập pháp thuộc Ủy ban Thường vụ Quốc hội', 4),
--        ('Giám đốc Đại học Quốc gia Hà Nội', 4),
--        ('Giám đốc Đại học Quốc gia Thành phố Hồ Chí Minh', 4),
--        ('Tổng Giám đốc Bảo hiểm xã hội Việt Nam', 4),
--        ('Trưởng Ban Quản lý Lăng Chủ tịch Hồ Chí Minh', 4),
--        ('Chủ tịch Ủy ban giám sát tài chính quốc gia', 4),
--        ('Phó Chủ tịch Ủy ban quản lý vốn nhà nước tại doanh nghiệp', 4),
--        ('Tổng cục trưởng', 5),
--        ('Phó Trưởng Ban Công tác đại biểu, Phó Trưởng Ban Dân nguyện thuộc Ủy ban Thường vụ Quốc hội', 5),
--        ('Phó Chủ tịch Viện Hàn lâm Khoa học xã hội Việt Nam', 5),
--        ('Phó Chủ tịch Viện Hàn lâm Khoa học công nghệ Việt Nam', 5),
--        ('Phó Tổng Giám đốc Thông tấn xã Việt Nam', 5),
--        ('Phó Tổng Giám đốc Đài Tiếng nói Việt Nam', 5),
--        ('Phó Tổng Giám đốc Đài Truyền hình Việt Nam', 5),
--        ('Bí thư Trung ương Đoàn Thanh niên Cộng sản Hồ Chí Minh', 5),
--        ('Ủy viên Thường trực Hội đồng Dân tộc', 5),
--        ('Ủy viên Thường trực các Ủy ban của Quốc hội', 5),
--        ('Ủy viên Ban Thường vụ Thành ủy Hà Nội', 5),
--        ('Thành ủy Thành phố Hồ Chí Minh', 5),
--        ('Ủy viên Thường trực Tiểu ban Bảo vệ chính trị nội bộ Trung ương', 5),
--        ('Trưởng đoàn đại biểu Quốc hội chuyên trách tỉnh', 5),
--        ('Phó Chủ tịch Hội đồng nhân dân', 5),
--        ('Ủy ban nhân dân thành phố Hà Nội', 5),
--        ('Thành phố Hồ Chí Minh', 5),
--        ('Ủy viên Ban Biên tập Báo Nhân dân', 5),
--        ('Ủy viên Ban Biên tập Tạp chí Cộng sản', 5),
--        ('Phó trưởng ban chuyên trách hoặc ủy viên chuyên trách các ban chỉ đạo ở Trung ương', 5),
--        ('Trợ lý các đồng chí lãnh đạo cấp cao của Đảng', 5),
--        ('Nhà nước', 5),
--        ('Tổng Biên tập Báo Điện tử Đảng Cộng sản Việt Nam', 5),
--        ('Tổng Biên tập Báo Đại biểu nhân dân', 5),
--        ('Giám đốc Truyền hình Quốc hội', 5),
--        ('Tổng Giám đốc Cổng thông tin điện tử Chính phủ', 5),
--        ('Phó Giám đốc Đại học Quốc gia Hà Nội', 5),
--        ('Phó Giám đốc Đại học Quốc gia Thành phố Hồ Chí Minh', 5),
--        ('Phó Tổng Giám đốc Bảo hiểm xã hội Việt Nam', 5),
--        ('Phó Chánh Văn phòng Ban cán sự đảng Chính phủ', 5),
--        ('Phó Chánh Văn phòng Đảng đoàn Quốc hội', 5),
--        ('Phó bí thư chuyên trách công tác đảng ở các Đảng ủy', 5),
--        ('Văn phòng Trung ương Đảng', 5),
--        ('Văn phòng Chính phủ', 5),
--        ('Văn phòng Quốc hội', 5),
--        ('Bộ Ngoại giao', 5),
--        ('Học viện Chính trị quốc gia Hồ Chí Minh', 5),
--        ('Phó Giám đốc Nhà xuất bản Chính trị quốc gia Sự thật', 6),
--        ('Phó Viện trưởng Viện Nghiên cứu lập pháp thuộc Ủy ban Thường vụ Quốc hội', 6),
--        ('Phó Trưởng Ban Quản lý Lăng Chủ tịch Hồ Chí Minh', 6),
--        ('Ủy viên chuyên trách Hội đồng Dân tộc và các Ủy ban của Quốc hội', 6),
--        ('Ủy viên ban thường vụ tỉnh ủy, thành ủy, đảng ủy khối trực thuộc Trung ương', 6),
--        ('Chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam tỉnh', 6),
--        ('Phó chủ tịch Hội đồng nhân dân', 6),
--        ('Ủy ban nhân dân tỉnh', 6),
--        ('Thành phố trực thuộc Trung ương', 6),
--        ('Phó Chủ tịch Ủy ban giám sát tài chính quốc gia', 6),
--        ('Phó trưởng đoàn đại biểu Quốc hội chuyên trách tỉnh', 6),
--        ('Phó Chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội có đảng đoàn)',
--         6),
--        ('Chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội không có đảng đoàn)',
--         6),
--        ('Phó Tổng Biên tập Báo Điện tử Đảng Cộng sản Việt Nam', 6),
--        ('Phó Tổng Biên tập Báo Đại biểu nhân dân', 6),
--        ('Phó Giám đốc Truyền hình Quốc hội', 6),
--        ('Phó Tổng Giám đốc Cổng thông tin điện tử Chính phủ', 6),
--        ('Chánh án Toà án nhân dân cấp cao', 6),
--        ('Viện trưởng Viện Kiểm sát nhân dân cấp cao', 6),
--        ('Giám đốc học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh', 6),
--        ('Vụ trưởng, cục trưởng, viện trưởng, trưởng ban và tương đương thuộc ban, cơ quan của Đảng; bộ, ngành, cơ quan ngang bộ; Mặt trận Tổ quốc Việt Nam và các tổ chức chính trị - xã hội ở Trung ương',
--         7),
--        ('Trưởng ban đảng, cơ quan trực thuộc tỉnh ủy, thành ủy', 7),
--        ('Ủy viên Hội đồng Biên tập Nhà xuất bản Chính trị quốc gia Sự thật', 7),
--        ('Tổng Thư ký Liên hiệp Hội ở Trung ương', 7),
--        ('Thư ký các đồng chí lãnh đạo chủ chốt, lãnh đạo cấp cao của Đảng, Nhà nước', 7),
--        ('Vụ trưởng, trưởng các cơ quan, đơn vị và tương đương của các cơ quan thuộc Chính phủ', 7),
--        ('Ủy viên ban chấp hành đảng bộ tỉnh, thành phố, đảng bộ khối trực thuộc Trung ương', 7),
--        ('Vụ trưởng và tương đương của Nhà xuất bản Chính trị quốc gia Sự thật, trưởng cơ quan, đơn vị của Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh',
--         7),
--        ('Phó Chánh án Toà án nhân dân cấp cao; Phó Viện trưởng Viện Kiểm sát nhân dân cấp cao', 7),
--        ('Phó giám đốc các học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh', 7),
--        ('Vụ trưởng, cục trưởng, trưởng cơ quan, đơn vị và tương đương thuộc tổng cục và tương đương tổng cục', 7),
--        ('Giám đốc sở, trưởng cơ quan, ban ngành, tổ chức chính trị - xã hội và tương đương cấp tỉnh', 7),
--        ('Bí thư quận, huyện, thị, thành ủy, đảng ủy trực thuộc tỉnh ủy', 7),
--        ('Phó tổng thư ký liên hiệp hội ở Trung ương; trưởng ban, đơn vị các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội có đảng đoàn)',
--         7),
--        ('Phó chủ tịch các hội quần chúng do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội không có đảng đoàn)',
--         7),
--        ('Phó trưởng ban đảng, cơ quan trực thuộc tỉnh ủy, thành ủy', 8),
--        ('Phó chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam tỉnh, thành phố', 8),
--        ('Thư ký các đồng chí Ủy viên Trung ương Đảng, bộ trưởng và tương đương, bí thư tỉnh ủy, thành ủy, đảng ủy trực thuộc Trung ương',
--         8),
--        ('Phó vụ trưởng, phó trưởng các cơ quan, đơn vị và tương đương của các cơ quan thuộc Chính phủ', 8),
--        ('Phó giám đốc sở, phó trưởng các cơ quan, ban, ngành, tổ chức chính trị - xã hội và tương đương ở cấp tỉnh', 8),
--        ('Phó bí thư quận, huyện, thị, thành ủy, đảng ủy trực thuộc tỉnh ủy, thành ủy; chủ tịch Hội đồng nhân dân, Ủy ban nhân dân cấp huyện',
--         8),
--        ('Ủy viên ủy ban kiểm tra tỉnh ủy, thành ủy trực thuộc Trung ương', 8),
--        ('Phó vụ trưởng và tương đương của Nhà xuất bản Chính trị quốc gia Sự thật, phó trưởng các cơ quan, đơn vị của Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh',
--         8),
--        ('Phó vụ trưởng, phó trưởng các cơ quan, đơn vị thuộc tổng cục và tương đương tổng cục', 8),
--        ('Phó trưởng ban, đơn vị các hội quần chúng có đảng đoàn do Đảng, Nhà nước giao nhiệm vụ ở Trung ương (đối với các tổ chức hội có đảng đoàn)',
--         8),
--        ('Trưởng các hội cấp tỉnh được giao biên chế', 8),
--        ('Trưởng phòng và tương đương của các cơ quan, đơn vị thuộc các ban, cơ quan của Đảng; bộ, ngành, cơ quan ngang bộ; Mặt trận Tổ quốc Việt Nam và các tổ chức chính trị - xã hội ở Trung ương.',
--         9),
--        ('Chi cục trưởng thuộc Cục.', 9),
--        ('Trưởng phòng và tương đương của các ban, cơ quan thuộc tỉnh ủy, thành ủy, văn phòng Hội đồng nhân dân, văn phòng Ủy ban nhân dân tỉnh, thành phố.',
--         9),
--        ('Ủy viên ban thường vụ huyện, quận, thành, thị ủy, đảng ủy cấp trên cơ sở trực thuộc tỉnh ủy, thành ủy.', 9),
--        ('Chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam cấp huyện.', 9),
--        ('Phó chủ tịch Hội đồng nhân dân, Ủy ban nhân dân cấp huyện.', 9),
--        ('Chi cục trưởng ở địa phương.', 9),
--        ('Trưởng phòng và tương đương của các cơ quan, đơn vị thuộc các cơ quan, đơn vị trực thuộc Chính phủ.', 9),
--        ('Trưởng phòng, khoa và tương đương trực thuộc các học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh; Nhà xuất bản Chính trị quốc gia Sự thật; các cơ quan, đơn vị thuộc Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh.',
--         9),
--        ('Trưởng phòng và tương đương của sở, các cơ quan ban, ngành, tổ chức chính trị - xã hội cấp tỉnh.', 9),
--        ('Ủy viên ban chấp hành đảng bộ huyện, quận, thành, thị xã, đảng bộ cấp trên cơ sở trực thuộc tỉnh ủy, thành ủy.',
--         9),
--        ('Trưởng phòng và tương đương của các cơ quan, đơn vị trực thuộc tổng cục và tương đương tổng cục.', 9),
--        ('Trưởng phòng, ban, cơ quan và tương đương trực thuộc huyện ủy, Ủy ban nhân dân huyện; trưởng các tổ chức chính trị - xã hội và tương đương ở cấp huyện.',
--         9),
--        ('Phó trưởng các hội cấp tỉnh được giao biên chế.', 9),
--        ('Phó trưởng phòng và tương đương của các cơ quan, đơn vị thuộc các ban, cơ quan của Đảng; bộ, ngành, cơ quan ngang bộ; Mặt trận Tổ quốc Việt Nam và các tổ chức chính trị - xã hội ở Trung ương.',
--         10),
--        ('Phó chi cục trưởng thuộc cục.', 10),
--        ('Phó trưởng phòng và tương đương của các ban, cơ quan thuộc tỉnh ủy, thành ủy, văn phòng Hội đồng nhân dân, văn phòng Ủy ban nhân dân tỉnh, thành phố.',
--         10),
--        ('Phó chủ tịch Ủy ban Mặt trận Tổ quốc Việt Nam cấp huyện.', 10),
--        ('Phó chi cục trưởng ở địa phương.', 10),
--        ('Phó trưởng phòng và tương đương của các cơ quan, đơn vị thuộc Chính phủ.', 10),
--        ('Phó trưởng phòng và tương đương của các học viện trực thuộc Học viện Chính trị quốc gia Hồ Chí Minh; Nhà xuất bản Chính trị quốc gia và các cơ quan, đơn vị thuộc Đại học Quốc gia Hà Nội, Đại học Quốc gia Thành phố Hồ Chí Minh.',
--         10),
--        ('Phó trưởng phòng và tương đương của sở, các cơ quan, ban ngành, tổ chức chính trị - xã hội cấp tỉnh; phó trưởng các đơn vị sự nghiệp trực thuộc sở, ngành cấp tỉnh.',
--         10),
--        ('Ủy viên Ủy ban kiểm tra huyện ủy, thị ủy, thành ủy, quận ủy.', 10),
--        ('Phó trưởng phòng và tương đương của cơ quan, đơn vị thuộc tổng cục và tương đương tổng cục.', 10),
--        ('Ủy viên Thường trực Ủy ban Mặt trận Tổ quốc cấp huyện.', 10),
--        ('Phó trưởng phòng và tương đương của cơ quan, đơn vị thuộc các đơn vị trực thuộc hội, liên hiệp hội.', 10),
--        ('Phó trưởng phòng, ban, cơ quan và tương đương trực thuộc huyện ủy, Ủy ban nhân dân huyện; phó trưởng các tổ chức chính trị - xã hội và tương đương ở cấp huyện.',
--         10),
--        ('Bí thư Đảng ủy: Tương đương chức vụ trưởng phòng, ban, cơ quan trực thuộc huyện ủy, Hội đồng nhân dân, Ủy ban nhân dân cấp huyện.',
--         11),
--        ('Phó bí thư đảng ủy; chủ tịch Hội đồng nhân dân, Ủy ban nhân dân xã, phường, thị trấn: Tương đương chức vụ phó trưởng phòng, ban, cơ quan trực thuộc huyện ủy, Ủy ban nhân dân cấp huyện.',
--         11),
--        ('Phó chủ tịch Hội đồng nhân dân, Ủy ban nhân dân xã, phường, thị trấn.', 11),
--        ('Chủ tịch Ủy ban Mặt trận Tổ quốc và trưởng các tổ chức chính trị - xã hội ở xã, phường, thị trấn.', 11);

-- cap_nhom_chuc_danh_dang
-- INSERT INTO cap_nhom_chuc_danh_dang (id, name, nhom_chuc_danh_dang)
-- values (0, 'Lãnh đạo chủ chốt của Đảng và Nhà nước', 0),
--        (1, 'Lãnh đạo cấp cao của Đảng, Nhà nước và Mặt trận Tổ quốc Việt Nam', 0),
--        (2, 'Các chức danh thuộc diện Bộ Chính trị quản lý', 1),
--        (3, 'Các chức danh diện Ban Bí thư quản lý', 1),
--        (4, 'Tổng cục trưởng và tương đương', 2),
--        (5, 'Phó Tổng cục trưởng và tương đương', 2),
--        (6, 'Vụ trưởng và tương đương', 2),
--        (7, 'Phó vụ trưởng và tương đương', 2),
--        (8, 'Trưởng phòng và tương đương', 2),
--        (9, 'Phó trưởng phòng và tương đương', 2),
--        (10, 'Cán bộ xã, phường, thị trấn', 2);
-- coquan_tochuc_donvi_tuyendung
insert
into coquan_tochuc_donvi_tuyendung (id, name)
VALUES (0, 'Tòa án nhân dân tối cao'),
       (1, 'Viện kiểm sát nhân dân tối cao'),
       (3, 'Kiểm toán Nhà nước'),
       (4, 'Văn phòng Quốc hội'),
       (5, 'Văn phòng Chủ tịch nước'),
       (6, 'Ủy ban nhân dân cấp tỉnh'),
       (7, 'Cơ quan của Đảng Cộng sản Việt Nam'),
       (8, 'Cơ quan trung ương của Mặt trận Tổ quốc Việt Nam');
-- loai_quan_ham_quan_doi
insert into loai_quan_ham_quan_doi (id, name)
VALUES (0, 'Sĩ quan'),
       (1, 'Quân nhân chuyên nghiệp'),
       (2, 'Hạ sĩ quan'),
       (3, 'Binh sĩ');
-- cap_loai_quan_ham_quan_doi
-- insert into cap_loai_quan_ham_quan_doi (id, name, loai_quan_ham_quan_doi)
-- VALUES (0, 'Cấp tướng', 0),
--        (1, 'Cấp tá', 0),
--        (2, 'Cấp úy', 0),
--        (3, 'Cao cấp', 1),
--        (4, 'Trung cấp', 1),
--        (5, 'Sơ cấp', 1),
--        (6, 'Cao cấp I', 2),
--        (7, 'Trung cấp I', 2),
--        (8, 'Sơ cấp I', 2),
--        (9, 'Trung cấp II', 3),
--        (10, 'Sơ cấp II', 3);
-- cap_bac_cap_loai_quan_ham_quan_doi
-- insert into cap_bac_cap_loai_quan_ham_quan_doi (name, cap_loai_quan_ham_quan_doi)
-- VALUES ('Đại tướng', 0),
--        ('Thượng tướng', 0),
--        ('Trung tướng', 0),
--        ('Thiếu tướng', 0),
--        ('Đại tá', 0),
--        ('Thượng tá', 0),
--        ('Trung tá', 0),
--        ('Thiếu tá', 0);
-- cap_bac_loai_quan_ham_quan_doi
insert into cap_bac_loai_quan_ham_quan_doi (name, loai_quan_ham_quan_doi)
VALUES ('Đại tướng', 0),
       ('Thượng tướng', 0),
       ('Trung tướng', 0),
       ('Thiếu tướng', 0),
       ('Đại tá', 0),
       ('Thượng tá', 0),
       ('Trung tá', 0),
       ('Thiếu tá', 0),
       ('Đại úy', 0),
       ('Thượng úy', 0),
       ('Trung úy', 0),
       ('Thiếu úy', 0),
       ('Thượng tá quân nhân chuyên nghiệp', 1),
       ('Trung tá quân nhân chuyên nghiệp', 1),
       ('Thiếu tá quân nhân chuyên nghiệp', 1),
       ('Đại úy quân nhân chuyên nghiệp', 1),
       ('Thượng úy quân nhân chuyên nghiệp', 1),
       ('Trung úy quân nhân chuyên nghiệp', 1),
       ('Thiếu úy quân nhân chuyên nghiệp', 1),
       ('Thượng sĩ', 2),
       ('Trung sĩ', 2),
       ('Hạ sĩ', 2),
       ('Binh nhất', 3),
       ('Binh nhì', 3);
-- bac_ngach_cong_chuc
INSERT INTO bac_ngach_cong_chuc (id, name)
values (5, 'Khác'),
       (4, 'Nhân viên'),
       (0, 'Chuyên viên cao cấp'),
       (1, 'Chuyên viên chính'),
       (2, 'Chuyên viên'),
       (3, 'Cán sự- Trung cấp');
--bac_ngach_vien_chuc
INSERT INTO bac_ngach_vien_chuc (id, name)
values (0, 'Ngạch viên chức cấp cao'),
       (1, 'Ngạch viên chức chính'),
       (2, 'Viên chức'),
       (3, 'Ngạch viên chức cán sự'),
       (4, 'Ngạch nhân viên');
-- -- chuc_danh_nghe_nghiep_cong_chuc
-- INSERT INTO chuc_danh_nghe_nghiep_cong_chuc (id, name, bac_ngach_cong_chuc)
-- values ('01.001', 'Chuyên viên cao cấp', 0),
--        ('04.023', 'Thanh tra viên cao cấp', 0);
-- -- chuc_danh_nghe_nghiep_vien_chuc
-- INSERT INTO chuc_danh_nghe_nghiep_vien_chuc (id, name, bac_ngach_vien_chuc)
-- values ('V.07.01.01', 'Giảng viên cao cấp (hạng I)', 0),
--        ('V.07.01.02', 'Giảng viên chính (hạng II)', 1);
--ngach/chuc_danh_nghe_nghiep_cong_chuc
INSERT INTO ngach_cong_chuc (id, name, bac_ngach_cong_chuc)
values ('01.001', 'Chuyên viên cao cấp', 0),
       ('04.023', 'Thanh tra viên cao cấp', 0),
       ('06.029', 'Kế toán viên cao cấp', 0),
       ('06.036', 'Kiểm tra viên cao cấp thuế', 0),
       ('08.049', 'Kiểm tra viên cao cấp hải quan', 0),
       ('07.044', 'Kiểm soát viên cao cấp ngân hàng', 0),
       ('06.041', 'Kiểm toán viên cao cấp', 0),
       ('03.299', 'Chấp hành viên cao cấp', 0),
       ('03.230', 'Thẩm tra viên cao cấp', 0),
       ('21.187', 'Kiểm soát viên cao cấp thị trường', 0),
       ('01.002', 'Chuyên viên chính', 1),
       ('04.024', 'Thanh tra viên chính', 1),
       ('06.030', 'Kế toán viên chính', 1),
       ('06.037', 'Kiểm tra viên chính thuế', 1),
       ('08.050', 'Kiểm tra viên chính hải quan', 1),
       ('19.220', 'Kỹ thuật viên bảo quản chính', 1),
       ('07.045', 'Kiểm soát viên chính ngân hàng', 1),
       ('06.042', 'Kiểm toán viên chính', 1),
       ('03.300', 'Chấp hành viên trung cấp', 1),
       ('03.231', 'Thẩm tra viên chính', 1),
       ('21.188', 'Kiểm soát viên chính thị trường', 1),
       ('09.315', 'Kiểm dịch viên chính động vật', 1),
       ('09.318', 'Kiểm dịch viên chính thực vật', 1),
       ('11.081', 'Kiểm soát viên chính đê điều', 1),
       ('10.225', 'Kiểm lâm viên chính', 1),
       ('25.309', 'Kiểm ngư viên chính', 1),
       ('25.312', 'Thuyền viên kiểm ngư chính', 1),
       ('02.006', 'Văn thư chính', 1),
       ('01.003', 'Chuyên viên', 2),
       ('04.025', 'Thanh tra viên', 2),
       ('06.031', 'Kế toán viên', 2),
       ('06.038', 'Kiểm tra viên thuế', 2),
       ('08.051', 'Kiểm tra viên hải quan', 2),
       ('19.221', 'Kỹ thuật viên bảo quản', 2),
       ('07.046', 'Kiểm soát viên ngân hàng', 2),
       ('06.043', 'Kiểm toán viên', 2),
       ('03.301', 'Chấp hành viên sơ cấp', 2),
       ('03.232', 'Thẩm tra viên', 2),
       ('03.302', 'Thư ký thi hành án', 2),
       ('21.189', 'Kiểm soát viên thị trường', 2),
       ('09.316', 'Kiểm dịch viên động vật', 2),
       ('09.319', 'Kiểm dịch viên thực vật', 2),
       ('11.082', 'Kiểm soát viên đê điều', 2),
       ('10.226', 'Kiểm lâm viên', 2),
       ('25.310', 'Kiểm ngư viên', 2),
       ('25.313', 'Thuyền viên kiểm ngư', 2),
       ('02.007', 'Văn thư', 2),
       ('01.004', 'Cán sự', 3),
       ('06.032', 'Kế toán viên trung cấp', 3),
       ('06.039', 'Kiểm tra viên trung cấp thuế', 3),
       ('08.052', 'Kiểm tra viên trung cấp hải quan', 3),
       ('21.190', 'Kiểm soát viên trung cấp thị trường', 3),
       ('19.222', 'Kỹ thuật viên bảo quản trung cấp', 3),
       ('19.223', 'Thủ kho bảo quản', 3),
       ('01.005', 'Nhân viên (văn thư, bảo vệ, lái xe, phục vụ, lễ tân, kỹ thuật và các nhiệm vụ khác…)', 4),
       ('06.040', 'Nhân viên thuế', 4),
       ('08.053', 'Nhân viên hải quan', 4),
       ('07.048', 'Thủ kho ngân hàng', 4),
       ('06.034', 'Thủ quỹ ngân hàng', 4),
       ('07.047', 'Kiểm ngân', 4),
       ('03.303', 'Thư ký trung cấp thi hành án', 4),
       ('09.317', 'Kỹ thuật viên kiểm dịch động vật', 4),
       ('09.320', 'Kỹ thuật viên kiểm dịch thực vật', 4),
       ('11.083', 'Kiểm soát viên trung cấp đê điều', 4),
       ('10.228', 'Kiểm lâm viên trung cấp', 4),
       ('25.311', 'Kiểm ngư viên trung cấp', 4),
       ('25.314', 'Thuyền viên kiểm ngư trung cấp', 4),
       ('02.008', 'Văn thư trung cấp', 4),
       ('06.035', 'Thủ quỹ cơ quan, đơn vị', 4),
       ('19.186', 'Bảo vệ, tuần tra canh gác', 4),
       ('19.224', 'Nhân viên bảo vệ kho dự trữ (Công chức loại C1)', 5);
--ngach/chuc_danh_nghe_nghiep vien chuc
INSERT INTO ngach_vien_chuc (id, name, bac_ngach_vien_chuc)
values ('V.07.01.01', 'Giảng viên cao cấp (hạng I)', 0),
       ('V.07.08.20', 'Giảng viên cao đẳng sư phạm cao cấp (hạng I)', 0),
       ('V.09.02.01', 'Giảng viên giáo dục nghề nghiệp cao cấp (hạng I)', 0),
       ('V.09.02.05', 'Giáo viên giáo dục nghề nghiệp hạng I', 0),
       ('V.08.01.01', 'Bác sĩ cao cấp (hạng I)', 0),
       ('V.08.02.04', 'Bác sĩ y học dự phòng cao cấp (hạng I)', 0),
       ('V.08.08.20', 'Dược sĩ cao cấp (hạng I)', 0),
       ('V.08.04.08', 'Y tế công cộng cao cấp (hạng I)', 0),
       ('V.10.03.08', 'Đạo diễn nghệ thuật hạng I', 0),
       ('V.10.04.12', 'Diễn viên hạng I', 0),
       ('V.10.01.01', 'Huấn luyện viên cao cấp (Hạng I)', 0),
       ('V.05.01.01', 'Nghiên cứu viên cao cấp (Hạng I)', 0),
       ('V.05.02.05', 'Kỹ sư cao cấp (Hạng I)', 0),
       ('V11.09.23', 'Âm thanh viên hạng I', 0),
       ('V11.10.27', 'Phát thanh viên hạng I', 0),
       ('V11.11.31', 'Kỹ thuật dựng phim hạng I', 0),
       ('V11.12.35', 'Quay phim hạng I', 0),
       ('V.11.01.01', 'Biên tập viên hạng I', 0),
       ('V.11.02.04', 'Phóng viên hạng I', 0),
       ('V.11.03.07', 'Biên dịch viên hạng I', 0),
       ('V.11.04.10', 'Đạo diễn truyền hình hạng I', 0),
       ('V.04.01.01', 'Kiến trúc sư Hạng I', 0),
       ('V.04.02.04', 'Thẩm kế viên hạng I', 0),
       ('V.10.08.25', 'Họa sĩ hạng I', 0),
       ('V.07.01.02', 'Giảng viên chính (hạng II)', 1),
       ('V.07.07.17', 'Giáo viên dự bị đại học hạng I', 1),
       ('V.07.07.18', 'Giáo viên dự bị đại học hạng II', 1),
       ('V.07.08.21', 'Giảng viên cao đẳng sư phạm cao cấp (hạng II)', 1),
       ('V.09.02.02', 'Giảng viên giáo dục nghề nghiệp chính (hạng II)', 1),
       ('V.09.02.06', 'Giáo viên giáo dục nghề nghiệp hạng II', 1),
       ('V.07.05.13', 'Giáo viên trung học phổ thông (hạng I)', 1),
       ('V.07.05.14', 'Giáo viên trung học phổ thông (hạng II)', 1),
       ('V.07.04.30', 'Giáo viên trung học cơ sở hạng I', 1),
       ('V.07.04.31', 'Giáo viên trung học cơ sở hạng II', 1),
       ('V.07.03.27', 'Giáo viên tiểu học hạng I', 1),
       ('V.07.03.28', 'Giáo viên tiểu học hạng II', 1),
       ('V.07.02.24', 'Giáo viên mầm non hạng I', 1),
       ('V.08.02.05', 'Bác sĩ y học dự phòng chính (hạng II)', 1),
       ('V.08.01.02', 'Bác sĩ chính (hạng II)', 1),
       ('V.08.08.21', 'Dược sĩ chính (hạng II)', 1),
       ('V.08.05.11', 'Điều dưỡng hạng II', 1),
       ('V.08.06.14', 'Hộ sinh hạng II', 1),
       ('V.08.07.17', 'Kỹ thuật y hạng II', 1),
       ('V.08.04.09', 'Y tế công cộng chính (hạng II)', 1),
       ('V.09.03.01', 'Kiểm định viên chính kỹ thuật an toàn lao động (hạng II)', 1),
       ('V.09.04.01', 'Công tác xã hội viên chính (hạng II)', 1),
       ('V.10.03.09', 'Đạo diễn nghệ thuật hạng II', 1),
       ('V.10.04.13', 'Diễn viên hạng II', 1),
       ('V.10.05.16', 'Di sản viên hạng II', 1),
       ('V.10.01.02', 'Huấn luyện viên chính (hạng II)', 1),
       ('V.05.01.02', 'Nghiên cứu viên chính (Hạng II)', 1),
       ('V.05.02.06', 'Kỹ sư chính (Hạng II)', 1),
       ('V11.09.24', 'Âm thanh viên hạng II', 1),
       ('V11.10.28', 'Phát thanh viên hạng II', 1),
       ('V11.11.32', 'Kỹ thuật dựng phim hạng II', 1),
       ('V11.12.36', 'Quay phim hạng II', 1),
       ('V.11.01.02', 'Biên tập viên hạng II', 1),
       ('V.11.02.05', 'Phóng viên hạng II', 1),
       ('V.11.03.08', 'Biên dịch viên hạng II', 1),
       ('V.11.04.11', 'Đạo diễn truyền hình hạng II', 1),
       ('V.04.01.02', 'Kiến trúc sư Hạng II', 1),
       ('V.04.02.05', 'Thẩm kế viên hạng II', 1),
       ('V.10.08.26', 'Họa sĩ hạng II', 1),
       ('V.03.04.10', 'Chẩn đoán viên bệnh động vật hạng II', 1),
       ('V.03.05.13', 'Kiểm tra viên vệ sinh thú y hạng II', 1),
       ('V.03.06.16', 'Kiểm nghiệm viên thuốc thú y hạng II', 1),
       ('V.03.07.19', 'Kiểm nghiệm viên chăn nuôi hạng II', 1),
       ('V.03.01.01', 'Bảo vệ viên bảo vệ thực vật hạng II', 1),
       ('V.03.02.04', 'Giám định viên thuốc bảo vệ thực vật hạng II', 1),
       ('V.03.03.07', 'Kiểm nghiệm viên cây trồng hạng II', 1),
       ('V.06.03.07', 'Dự báo viên khí tượng thủy văn hạng II', 1),
       ('V.10.06.19', 'Phương pháp viên hạng II', 1),
       ('V.10.07.22', 'Hướng dẫn viên văn hóa hạng II', 1),
       ('V.01.02.01', 'Lưu trữ viên chính (hạng II)', 1),
       ('02.006', 'Văn thư chính', 1),
       ('V.10.02.05', 'Thư viện viên hạng II', 1),
       ('V.06.05.13', 'Quan trắc viên tài nguyên môi trường hạng II', 1),
       ('V.07.01.03', 'Giảng viên (hạng III)', 2),
       ('V.07.01.23', 'Trợ giảng (Hạng III)', 2),
       ('V.07.07.19', 'Giáo viên dự bị đại học hạng III', 2),
       ('V.07.08.22', 'Giảng viên cao đẳng sư phạm cao cấp (hạng III)', 2),
       ('V.09.02.03', 'Giảng viên giáo dục nghề nghiệp lý thuyết (hạng III)', 2),
       ('V.09.02.07', 'Giáo viên giáo dục nghề nghiệp lý thuyết hạng III', 2),
       ('V.07.05.15', 'Giáo viên trung học phổ thông hạng III', 2),
       ('V.07.04.32', 'Giáo viên trung học cơ sở hạng III', 2),
       ('V.07.03.29', 'Giáo viên tiểu học hạng III', 2),
       ('07.02.25', 'Giáo viên mầm non hạng II', 2),
       ('V.08.01.03', 'Bác sĩ (hạng III)', 2),
       ('V.08.02.06', 'Bác sĩ y học dự phòng (hạng III)', 2),
       ('V.08.08.22', 'Dược sĩ (hạng III)', 2),
       ('V.08.05.12', 'Điều dưỡng hạng III', 2),
       ('V.08.06.15', 'Hộ sinh hạng III', 2),
       ('V.08.07.18', 'Kỹ thuật y hạng III', 2),
       ('V.08.04.10', 'Y tế công cộng (hạng III)', 2),
       ('V.09.03.02', 'Kiểm định viên kỹ thuật an toàn lao động (hạng III)', 2),
       ('V.09.04.02', 'Công tác xã hội viên (hạng III)', 2),
       ('V.10.03.10', 'Đạo diễn nghệ thuật hạng III', 2),
       ('V.10.04.14', 'Diễn viên hạng III', 2),
       ('V.10.05.17', 'Di sản viên hạng III', 2),
       ('V.10.01.03', 'Huấn luyện viên (hạng III)', 2),
       ('V.05.01.03', 'Nghiên cứu viên (Hạng III)', 2),
       ('V.05.02.07', 'Kỹ sư (Hạng III)', 2),
       ('V11.09.25', 'Âm thanh viên hạng III', 2),
       ('V11.10.29', 'Phát thanh viên hạng III', 2),
       ('V11.11.33', 'Kỹ thuật dựng phim hạng III', 2),
       ('V11.12.37', 'Quay phim hạng III', 2),
       ('V.11.01.03', 'Biên tập viên hạng III', 2),
       ('V.11.02.06', 'Phóng viên hạng III', 2),
       ('V.11.03.09', 'Biên dịch viên hạng III', 2),
       ('V.11.04.12', 'Đạo diễn truyền hình hạng III', 2),
       ('V.04.01.03', 'Kiến trúc sư Hạng III', 2),
       ('V.04.02.06', 'Thẩm kế viên hạng III', 2),
       ('V.10.08.27', 'Họa sĩ hạng III', 2),
       ('V.03.04.11', 'Chẩn đoán viên bệnh động vật hạng III', 2),
       ('V.03.05.14', 'Kiểm tra viên vệ sinh thú y hạng III', 2),
       ('V.03.06.15', 'Kiểm nghiệm viên thuốc thú y hạng III', 2),
       ('V.03.07.20', 'Kiểm nghiệm viên chăn nuôi hạng III', 2),
       ('V.03.01.02', 'Bảo vệ viên bảo vệ thực vật hạng III', 2),
       ('V.03.02.05', 'Giám định viên thuốc bảo vệ thực vật hạng III', 2),
       ('V.03.03.08', 'Kiểm nghiệm viên cây trồng hạng III', 2),
       ('V.06.03.08', 'Dự báo viên khí tượng thủy văn hạng III', 2),
       ('V.10.06.20', 'Phương pháp viên hạng III', 2),
       ('V.10.07.23', 'Hướng dẫn viên văn hóa hạng III', 2),
       ('V.01.02.02', 'Lưu trữ viên (hạng II)', 2),
       ('02.007', 'Văn thư', 2),
       ('V.10.02.06', 'Thư viện viên hạng III', 2),
       ('V.06.05.14', 'Quan trắc viên tài nguyên môi trường hạng III', 2);

-- loai_so_yeu_ly_lich_chitiet
INSERT into loai_so_yeu_ly_lich_chitiet (name)
VALUES ('QUÁ TRÌNH ĐÀO TẠO, BỒI DƯỠNG'),
       ('TÓM TẮT QUÁ TRÌNH CÔNG TÁC'),
       ('ĐẶC ĐIỂM LỊCH SỬ BẢN THÂN'),
       ('KHEN THƯỞNG, KỶ LUẬT'),
       ('QUAN HỆ GIA ĐÌNH'),
       ('HOÀN CẢNH KINH TẾ GIA ĐÌNH'),
       ('NHẬN XÉT, ĐÁNH GIÁ CỦA CƠ QUAN, TỔ CHỨC, ĐƠN VỊ SỬ DỤNG');