package sgu.hrm.module_security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import javax.sql.DataSource;

//@EnableWebSecurity()
@Configuration
//@RequiredArgsConstructor
public class WebSecurityConfig {
    // basic auth
    /* InMemoryUserDetailsManager
     * Không cần làm cái gì hết
     * Chỉ cần tạo userdetails
     * {noop} cho phép lưu mật khẩu plain text không mã hóa
     * */
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails minhthu = User.builder()
                .username("ThuNTM")
                .password("{noop}123456")
                .roles("ADMIN").build();
        UserDetails tai = User.builder()
                .username("TaiNG")
                .password("{noop}123456")
                .roles("EMPLOYEE").build();
        return new InMemoryUserDetailsManager(minhthu, tai);
    }
    */
    //JDBC Authentication plain text
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
        security.csrf(csrf ->
                        csrf
                                .disable())
                .authorizeHttpRequests(configure ->
                                configure
//                                        .requestMatchers("/api/v1/so-yeu-ly-lich/**").hasRole("ADMIN")
//                                        .requestMatchers("/api/v1/cong-chuc-vien-chuc/**").hasRole("EMPLOYEE")
//                                        .requestMatchers(HttpMethod.GET, "/api/v1/utilities/**").permitAll()
                                        .anyRequest().permitAll()
                        //need form with post method
                        //and spring security magic will do the rest
                ).formLogin(flogin ->
                        flogin
                                .loginProcessingUrl("/authenticateTheUser").permitAll()
                ).logout(logout ->
                        logout
                                .logoutUrl("/api/v1/dang-xuat").permitAll()
                ).exceptionHandling(execHandle ->
                        execHandle
                                .accessDeniedPage("/api/v1/tu-choi")
                );
        return security.build();
    }
}
