//package poly.datn;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import poly.datn.entity.Account;
//import poly.datn.service.AccountService;
//
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    AccountService aService;
//    @Autowired
//    BCryptPasswordEncoder pe;
//
//    //Cấp Nguồn DL đăg nhập
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username ->{
//            try {
//                Account user = aService.findById(username);
//                String password = pe.encode(user.getPassword());
//                String[] roles= user.getAuthorities().stream()
//                        .map(er -> er.getRoleId().getId())
//                        .collect(Collectors.toList()).toArray(new String[0]);
//
//                return User.withUsername(username).password(password).roles(roles).build();
//            } catch ( NoSuchElementException e) {
//                throw new UsernameNotFoundException(username + "not found!");
//            }
//
//        });
//    }
//
//
//    //Phân Quyền SD
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests()
//                .antMatchers("/admin/**").authenticated()
//                .antMatchers("/admin/**").hasAnyRole("1","3")
//                .anyRequest().permitAll();
//
//        http.formLogin()
//                .loginPage("/security/login/form")
//                .loginProcessingUrl("/security/login")
//                .defaultSuccessUrl("/security/login/success",false)
//                .failureUrl("/security/login/error");
//        http.rememberMe()
//                .tokenValiditySeconds(86400);
//        http.logout()
//                .logoutUrl("/security/logoff")
//                .logoutSuccessUrl("/security/logoff/success");
//    }
//
//    // Cơ chế mã hóa mật khẩu
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Cho phép truy cập REST API từ bên ngoài (domain khác)
//    @Override
//    public void configure(WebSecurity web) throws Exception{
//        web.ignoring().antMatchers(HttpMethod.OPTIONS,"/**");
//    }
//}
