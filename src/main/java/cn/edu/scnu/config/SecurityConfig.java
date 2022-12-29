package cn.edu.scnu.config;

////import javax.sql.DataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
////后台登录
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
////    private DataSource dataSource;
//    
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        
////        String userSQL = "select user_name,user_password from t_user where user_name=?";
////        String authoritySQL = "select user_name,user_type from t_user where user_name=?";
////        auth.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(userSQL)
////.authoritiesByUsernameQuery(authoritySQL);  
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/manage.html").hasRole("1").anyRequest().authenticated();
////        http.formLogin().loginPage("/login").permitAll().usernameParameter("username").passwordParameter("pwd").defaultSuccessUrl("/");
//        
//    }
//}
