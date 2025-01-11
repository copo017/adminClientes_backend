package orlando.admclientes.config;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String origin = httpServletRequest.getHeader("Origin");

        // Configura dinámicamente el encabezado Access-Control-Allow-Origin
        if (origin != null && (origin.equals("http://localhost:3000") ||
                origin.equals("https://adminclientes-front.onrender.com") ||
                origin.equals("https://relaxed-cascaron-ec2b28.netlify.app")
        )) {
            httpServletResponse.setHeader("Access-Control-Allow-Origin", origin);
        }

        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, X-Requested-With");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // Maneja las solicitudes OPTIONS
        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
            return;
        }

        // Continúa con el filtro si no es OPTIONS
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Método de inicialización, puedes dejarlo vacío
    }

    @Override
    public void destroy() {
        // Método de limpieza, puedes dejarlo vacío
    }
}
