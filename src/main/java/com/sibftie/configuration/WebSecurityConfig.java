package com.sibftie.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**", "/static/**", "/bootstrap/**", "/build/**", "/dist/**", "/img/**",
                            "/plugins/**").permitAll()
                    .antMatchers("/admin/**", "/proposal/hapus/**").hasAuthority("KETUABEM")
                    .antMatchers("/bendahara/**").hasAuthority("BENDAHARA")
                    .antMatchers("/ketua-devisi/**").hasAuthority("KETUADIVISI")
                    .antMatchers("/sekretaris/**").hasAuthority("SEKRETARIS")
                    .antMatchers("/user/proposal/**").hasAnyAuthority("KETUABEM", "KETUADIVISI")
                    .anyRequest().hasAnyAuthority("ANGGOTA", "KETUABEM", "BENDAHARA", "KETUADIVISI", "SEKRETARIS")
                .and()
                    .formLogin().loginPage("/user/login").defaultSuccessUrl("/")
                    .usernameParameter("email")
                    .passwordParameter("password")
                    .permitAll()
                .and()
                    .logout().
                    logoutRequestMatcher(new AntPathRequestMatcher("/user/logout")).
                    logoutSuccessUrl("/user/login").and().exceptionHandling()
                .and()
                    .exceptionHandling().accessDeniedPage("/403")
                .and().csrf().ignoringAntMatchers("/admin/**");
//                .defaultSuccessUrl("/direct")
//                .usernameParameter("email")
//                .passwordParameter("password")
//                .and().
//                logout().logoutSuccessUrl("/login?logout").and().exceptionHandling()
//                .accessDeniedPage("/access-denied")
//                .and().csrf();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }



}
