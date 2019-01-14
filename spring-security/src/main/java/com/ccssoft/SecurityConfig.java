package com.ccssoft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  @Autowired(required = false)
  SsoAuthenticationConfig customerAuthenticationConfig;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.requestMatchers()
        .anyRequest()
        .and()
        .authorizeRequests()
        .antMatchers("/oauth/token/*", "/login")
        .permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/index")
        .and()
        .apply(customerAuthenticationConfig);
  
    http.exceptionHandling()
        .defaultAuthenticationEntryPointFor(
            new Http403ForbiddenEntryPoint(), new AntPathRequestMatcher("/login"));
  }

  /*@Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(casAuthenticationProvider());
  }

  @Bean
  public CasAuthenticationFilter casAuthenticationFilter(ServiceProperties sP) throws Exception {
    CasAuthenticationFilter filter = new CasAuthenticationFilter();
    filter.setServiceProperties(sP);
    filter.setAuthenticationManager(authenticationManager());
    return filter;
  }

  @Bean
  public SecurityContextLogoutHandler securityContextLogoutHandler() {
    return new SecurityContextLogoutHandler();
  }

  @Bean
  public LogoutFilter logoutFilter() {
    LogoutFilter logoutFilter =
        new LogoutFilter("http://localhost:8080/cas/logout", securityContextLogoutHandler());
    logoutFilter.setFilterProcessesUrl("/logout/cas");
    return logoutFilter;
  }

  @Bean
  public SingleSignOutFilter singleSignOutFilter() {
    SingleSignOutFilter singleSignOutFilter = new SingleSignOutFilter();
    singleSignOutFilter.setCasServerUrlPrefix("http://localhost:8080/cas");
    singleSignOutFilter.setIgnoreInitConfiguration(true);
    return singleSignOutFilter;
  }

  @EventListener
  public SingleSignOutHttpSessionListener singleSignOutHttpSessionListener(HttpSessionEvent event) {
    return new SingleSignOutHttpSessionListener();
  }


  @Bean
  public ServiceProperties serviceProperties() {
    ServiceProperties serviceProperties = new ServiceProperties();
    serviceProperties.setService("http://localhost:9000/");
    serviceProperties.setSendRenew(false);
    return serviceProperties;
  }

  @Bean
  @Primary
  public AuthenticationEntryPoint authenticationEntryPoint(ServiceProperties sP) {

    CasAuthenticationEntryPoint entryPoint = new CasAuthenticationEntryPoint();
    entryPoint.setLoginUrl("http://localhost:8080/cas/login");
    entryPoint.setServiceProperties(sP);
    return entryPoint;
  }

  @Bean
  public TicketValidator ticketValidator() {
    return new Cas30ServiceTicketValidator("http://localhost:8080/cas");
  }

  @Bean
  public CasAuthenticationProvider casAuthenticationProvider() {

    CasAuthenticationProvider provider = new CasAuthenticationProvider();
    provider.setServiceProperties(serviceProperties());
    provider.setTicketValidator(ticketValidator());
    provider.setUserDetailsService(new CustomUserDetatilService());
    provider.setKey("CAS_PROVIDER_LOCALHOST_9000");
    return provider;
  }*/
}
