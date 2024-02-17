package sgu.hrm.module_security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sgu.hrm.module_taikhoan.models.TaiKhoan;
import sgu.hrm.module_taikhoan.repository.TaiKhoanRepository;

@Service
public class TaiKhoanUserDetailsService implements UserDetailsService {
    final TaiKhoanRepository taiKhoanRepository;

    public TaiKhoanUserDetailsService(TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TaiKhoan taiKhoan = taiKhoanRepository.findByUsername(username);
        if (taiKhoan == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return taiKhoan;
    }

}
