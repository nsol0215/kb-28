package org.scoula.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = {"org.scoula.controller"})
// Spring MVC용 컴포넌트 등록을 위한 스캔 패키지


public class ServletConfig implements WebMvcConfigurer {
    // 스프링 내부테어 사숑하는 서블릿 (jsp)와 관련된 것을 설정하는 파일.

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // jsp에서 사용할 프론트용 자원들 (js, css, img 위치와 접근 주소 설정)
        registry
                .addResourceHandler("/resources/**")
                // url이 /resources/로 시작하는 모든 경로
                .addResourceLocations("/resources/");
        // webapp/resources/경로로 매핑
    }

    // jsp view resolver 설정
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();
        // 서버의 결과를 넣음 jsp 위치와 전체 경로를 결정
        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/views/");
        bean.setSuffix(".jsp");
        registry.viewResolver(bean);
        // /WEB-INF/views/  + view 이름 + .jsp
    }
}