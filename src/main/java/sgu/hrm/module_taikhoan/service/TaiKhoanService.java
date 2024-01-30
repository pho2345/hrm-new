package sgu.hrm.module_taikhoan.service;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import sgu.hrm.enums.NotificationsServer;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.models.dto.TaiKhoanDTO;
import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;

import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaiKhoanService implements ITaiKhoanService {

    final TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<TaiKhoan> xemTaiKhoan() {
        return taiKhoanRepository.findAll();
    }

    @Override
    public void themTaiKhoan(TaiKhoanDTO taiKhoanDTO) {
        //tạo username
        String hoVaTen = taiKhoanDTO.hoVaTen();
        String temp = Normalizer.normalize(hoVaTen, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        hoVaTen = pattern.matcher(temp).replaceAll("").replace('đ', 'd').replace('Đ', 'D');
        String[] sSplit = hoVaTen.split(" "); // tách chuỗi
        StringBuffer newS = new StringBuffer(); // tạo 1 chuỗi mới
        // cho ca tu loew roi cho tu dau tien up
        if (sSplit.length > 0) {
            for (int i = 0; i < sSplit[sSplit.length - 1].length(); i++) {
                if (i != 0) {
                    newS.append(Character.toLowerCase(sSplit[sSplit.length - 1].charAt(i)));
                    continue;
                }
                newS.append(sSplit[sSplit.length - 1].charAt(i));
            }
        }
        for (int i = 0; i < sSplit.length - 1; i++) {
            newS.append(sSplit[i].charAt(0));
        }
        //check trung username, co thi2 them so dang truoc
        int checkUsername = taiKhoanRepository.findAll().stream().filter(taiKhoan -> taiKhoan.getUsername().contentEquals(newS)).toList().size();
        if (checkUsername > 0) {
            newS.append(checkUsername);
        }
        TaiKhoan taiKhoan = TaiKhoan.builder()
                .hoVaTen(taiKhoanDTO.hoVaTen())
                .soCCCD(taiKhoanDTO.soCCCD())
                .username(newS.toString())
                .password(taiKhoanDTO.soCCCD())
                .status(true)
                .build();
//        return (taiKhoan != null) ? NotificationsServer.TAIKHOAN_CREATED : NotificationsServer.valueOf("huhuu");
    }

    @Override
    public void suaTaiKhoan() {

    }

    @Override
    public void xoaTaiKhoan() {

    }
}
