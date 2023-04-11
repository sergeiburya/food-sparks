package team.project.foodsparks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import team.project.foodsparks.security.JwtConfigurer;
import team.project.foodsparks.security.JwtTokenProvider;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public SecurityConfig(UserDetailsService userDetailsService,
                          PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors()
                .and()
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-resources/**", "/v3/api-docs/**", "/swagger-ui/**")
                .permitAll()
                .antMatchers("/register", "/login", "/verify")
                .permitAll()
                .antMatchers("/recipes", "/recipes/{id}",
                        "/recipes/byRegions", "/recipes/byDishType")
                .permitAll()
                .antMatchers("/products", "/products/{id}")
                .permitAll()
                .antMatchers("/gender")
                .permitAll()
                .antMatchers("/dish-types")
                .permitAll()
                .antMatchers("/complexities")
                .permitAll()
                .antMatchers("/cuisine-regions")
                .permitAll()
                .antMatchers("/cuisine-regions")
                .permitAll()
                .antMatchers(HttpMethod.DELETE, "/products/{id}", "/users/{id}")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user/by-email", "/address/by-user")
                .hasAnyRole("ADMIN, USER")
                .antMatchers(HttpMethod.GET, "/user/all")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/address/add")
                .hasAnyRole("ADMIN, USER")
                .antMatchers(HttpMethod.PUT, "user/update", "/udate-address-user")
                .hasAnyRole("ADMIN, USER")
                .antMatchers(HttpMethod.DELETE, "/user/{id}")
                .hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "user/delete", "/address/delete")
                .hasAnyRole("ADMIN, USER")
                .anyRequest()
                .authenticated()
                .and()
                .apply(new JwtConfigurer(jwtTokenProvider))
                .and()
                .headers().frameOptions().disable();
    }
}
