package ma.enset.gestionStage.security.filters;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import ma.enset.gestionStage.security.utilities.JWTUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
public class JwtAuthorizationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me");
        if (request.getServletPath().equals("/refreshToken")) {
           filterChain.doFilter(request,response);
       } else {
           String authorizationToken = request.getHeader(JWTUtil.AUTH_HEADER);
           if (authorizationToken != null && authorizationToken.startsWith(JWTUtil.PREFIX)){
               try {
                   String jwt = authorizationToken.substring(JWTUtil.PREFIX.length());
                   Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET);
                   JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                   DecodedJWT decodedJWT = jwtVerifier.verify(jwt);
                   String username = decodedJWT.getSubject();
                   String[] roles = decodedJWT.getClaim("roles").asArray(String.class);
                   Collection<GrantedAuthority> authorities = new ArrayList<>();
                   for (String r:roles) {
                       authorities.add(new SimpleGrantedAuthority(r));
                   }
                   UsernamePasswordAuthenticationToken authenticationToken =
                           new UsernamePasswordAuthenticationToken(username,null,authorities);
                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                   filterChain.doFilter(request,response);
               } catch (Exception e){
                   response.setHeader("error-message", e.getMessage());
                   response.sendError(HttpServletResponse.SC_FORBIDDEN);
               }
           } else {
               filterChain.doFilter(request, response);
           }
       }
    }
}