package kr.co.fastcampus.eatgo.config.security;

import io.jsonwebtoken.Claims;
import kr.co.fastcampus.eatgo.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {


    private JwtUtil jwtUtil;


    public JwtAuthenticationFilter(AuthenticationManager authenticationManager,JwtUtil jwtUtil) {
        super(authenticationManager);
        this.jwtUtil = jwtUtil;
    }



    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws IOException, ServletException {

        // TODO: 실제로 JWT 분석 필요함
        Authentication authentication = getAuthentication(request);
        if(authentication != null){

            // TODO: 실제로 우리가 사용하고 있는 context를 사용 가능, SecurityContextHolder.getContext()는 singleton
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(authentication);
        }

        chain.doFilter(request,response);
    }

    private Authentication getAuthentication(HttpServletRequest request){
        // TODO: Header에서 jwt를 받아 authentication을 생성
        String token = request.getHeader("Authorization");
        if(token == null){
            return null;
        }
        // TODO: UsernamePasswordAuthenticationToken은 SpringBoot 내에서 사용되는 간편한 Token
        // 여기서는 간단하게 principal = claim = 사용자 정보 만 사용하여 토큰 생성

        // TODO: Claim은 JWT 토큰에서 얻을 수 있다.
        Claims claims = jwtUtil.getClaims(token.substring("Bearer ".length()));
        Authentication authentication = new UsernamePasswordAuthenticationToken(claims, null);
        return authentication;
    }
}
