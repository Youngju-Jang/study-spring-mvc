package hello.spring;

import hello.spring.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
     
     @Override
     public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new LoginCheckInterceptor())
               .order(1)
               .addPathPatterns("/**")
               .excludePathPatterns("/", "/members/add", "/login", "/logout", "/resources/*");
     }
}
