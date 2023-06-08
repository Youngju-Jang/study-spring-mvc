package hello.spring.filter;

import hello.spring.SessionConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.PatternMatchUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
public class LoginCheckFilter implements Filter {
     private static final String[] whitelist = {"/", "/members/add", "/signup","/login", "/logout", "/resources/*"};
     
     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          
          HttpServletRequest httpRequest = (HttpServletRequest) request;
          String requestURI = httpRequest.getRequestURI();
          
          HttpServletResponse httpResponse = (HttpServletResponse) response;
          
          try {
               log.info("인증 체크 필터 시작 {}", requestURI);
               
               if (isLoginCheckPath(requestURI)) {
                    log.info("인증 체크 로직 실행 {}", requestURI);
                    HttpSession session = httpRequest.getSession(false);
                    if (session == null || session.getAttribute(SessionConst.LOGIN_USER) == null) {
                         log.info("미인증 사용자 요청 {}", requestURI);
                         //로그인으로 redirect
                         httpResponse.sendRedirect("/login?redirectURL=" + requestURI);
                         return;
                    }
               }
               chain.doFilter(request, response);
          } catch (Exception e) {
               throw e; //예외 로깅 가능 하지만, 톰캣까지 예외를 보내주어야 함
          } finally {
               log.info("인증 체크 필터 종료 {} ", requestURI);
          }
          
     }
     
     /**
      * 화이트 리스트의 경우 인증 체크X
      */
     private boolean isLoginCheckPath(String requestURI) {
          return !PatternMatchUtils.simpleMatch(whitelist, requestURI);
     }
}
