package ProductDetails.JaiSuriyaSuperMarket;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.stream.Stream;

@Configuration
@EnableWebSecurity
public class Myappconfiguration
{
    @Bean
    public PasswordEncoder crepter()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userdetails()
    {
        UserDetails  user1= User.withUsername("Yusuf").
                password(crepter().encode("yusuf123")).
                roles("Manager").build();

        UserDetails user2=  User.withUsername("Mohanavel").
                password(crepter().encode("mohanavel123")).
                roles("Executer").build();

        Collection<UserDetails> myusers= Stream.of(user1,user2).toList();

        return new InMemoryUserDetailsManager(myusers);
    }


    @Bean
    @Deprecated
    public SecurityFilterChain  connection(HttpSecurity hp) throws Exception
    {
//        hp.authorizeHttpRequests().anyRequest().permitAll(); security not need for my project

//        hp.authorizeHttpRequests().anyRequest().authenticated();//any supermarket req will be need security

        hp.authorizeHttpRequests().
                requestMatchers("/Supermarket/**").authenticated();
        hp.csrf().disable();
//        csrf-cross site request forgery  -a web attack exploits loopholes
        hp.cors();
//        cors-cross origin resource sharing
        hp.httpBasic();
        hp.formLogin();

        return hp.build();

    }



}
