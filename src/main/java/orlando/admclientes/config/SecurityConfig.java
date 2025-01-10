package orlando.admclientes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.cors.CorsConfigurationSource;
import orlando.admclientes.services.UsuarioDetailsServiceImpl;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
public class SecurityConfig {

    private final UsuarioDetailsServiceImpl usuarioDetailsService;

    public SecurityConfig(UsuarioDetailsServiceImpl usuarioDetailsService) {
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:3000"); // Permitir solicitudes del frontend
        configuration.addAllowedMethod("*"); // Permitir todos los métodos (GET, POST, OPTIONS, etc.)
        configuration.addAllowedHeader("*"); // Permitir todos los encabezados
        configuration.setAllowCredentials(true); // Permitir credenciales

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Permitir acceso público a Swagger
                        .requestMatchers(HttpMethod.GET, "/favicon.ico").permitAll()
                        .requestMatchers("/api/auth/login").permitAll() // Permitir el endpoint de login personalizado
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/api/clientes").hasAnyRole("ADMIN", "USUARIO")
                        .requestMatchers("/api/clientes/**").hasRole("ADMIN") // Solo ROLE_ADMIN puede acceder al CRUD de clientes
                        .requestMatchers(HttpMethod.GET,"/api/weather/**").hasAnyRole("ADMIN", "USUARIO")
                        .anyRequest().authenticated() // Todas las demás solicitudes requieren autenticación

                )
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Aplicar configuración de CORS
                .httpBasic(withDefaults()); // Habilitar autenticación básica

        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Utilizar BCrypt para almacenar contraseñas
    }
}
