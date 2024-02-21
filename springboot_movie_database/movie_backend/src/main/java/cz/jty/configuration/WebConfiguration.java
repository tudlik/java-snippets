package cz.jty.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        WebMvcConfigurer.super.addCorsMappings(registry);
        registry.addMapping("/**") //addMapping(...) nastavujeme, pro jaké akce se mají pravidla níže aplikovat. Pomocí /** říkáme, že upravujeme chování akcí začínajících na / (tedy úplně všech akcí).
                .allowedMethods("HEAD", "GET", "PUT", "DELETE", "OPTIONS") //nastavujeme, že chceme dané pravidla aplikovat pro všechny HTTP metody
                .allowedOriginPatterns("**") //  nastavujeme, jaké "cizí" URL adresy má server povolovat (všechny
                .allowCredentials(true); // nastavujeme, že povolujeme, aby server mohl posílat "cizí" URL adrese cookies. Přes ty se například implementují autentizace uživatelů
    }
}
