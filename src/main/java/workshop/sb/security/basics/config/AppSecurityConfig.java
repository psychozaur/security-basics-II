package workshop.sb.security.basics.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authBuilder) throws Exception {
        authBuilder
                .inMemoryAuthentication()
                .withUser("user")
// {noop}password: https://stackoverflow.com/questions/46999940/spring-boot-passwordencoder-error
                .password("{noop}password")
                .roles("USER");

    }

    /*
        TODO 1 nadpisz metodę:  public void configure(HttpSecurity http) throws Exception

        Zapoznaj się z kodem bazowej metody, skopiuj z niej kod (poniżej wyjaśnienie co się dzieje w metodzie bazowej):

        http
			.authorizeRequests().anyRequest().authenticated()           - wszystkie requesty będą potrzebowały autentykacji
				.and()
			.formLogin()                                                - domyślnie Spring generuje formularz do logowania
			    .and()
			.httpBasic();                                               - konfiguracja spring security z domyślnymi wartościami

     */

    /*
            TODO 2 Modyfikacja bazowego zachowania.
            Zmień implentację configure używając API obiektu HttpSecurity

            1. Logowanie użytkownikiem i hasłem ustawionym w configureGlobal
            2. usuwanie dostępne tylko dla użytkowników z rolą ROLE_ADMIN - użyj API antMatchers

      */

    /*
            TODO 3 uruchom aplikację - zaloguj się jako user, przetestuj operację delete
            Przy poprawnej konfiguracji powinien wyskoczyć błąd 403

     */
}
