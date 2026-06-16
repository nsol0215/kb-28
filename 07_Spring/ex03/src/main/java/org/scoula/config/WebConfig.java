package org.scoula.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;


public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
    //  스프링 설정 파일 중 위 클래스를 상속받은 클래스를 찾음.
    // 다른 설정용 클래스를 지정함

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{RootConfig.class};
        // 사용할 파일 배열로 넣어주는 것
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{ServletConfig.class};
    }

    // 프론트 컨트롤러 호출 주소 설정
    // @webServlet("/")와 같은 역할
    // 스프링의 FrontController인 DispatcherServlet이 담당할 Url 매핑 패턴
    // "/" : 모든 요청에 대해 매핑
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // POST body 문자 인코딩 필터 설정 - UTF-8 설정
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return new Filter[] {characterEncodingFilter};
    }
}