package com.assessment.demo.filter;

import java.io.IOException;
import java.util.Enumeration;

import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RequestLoggingFilter implements Filter {



    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(httpRequest);
        ContentCachingResponseWrapper wrappedResponse = new ContentCachingResponseWrapper(httpResponse);

        chain.doFilter(wrappedRequest, wrappedResponse);

        // Log request and response
        logRequest(wrappedRequest);
        logResponse(wrappedResponse);

        wrappedResponse.copyBodyToResponse();
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed
    }

    private void logRequest(ContentCachingRequestWrapper request) throws IOException {
    	
        String requestBody = new String(request.getContentAsByteArray(), request.getCharacterEncoding());
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Request Method: " + request.getMethod());
        System.out.println("Request Headers : ");
        for (Enumeration<?> e = request.getHeaderNames(); e.hasMoreElements();) {
            String nextHeaderName = (String) e.nextElement();
            String headerValue = request.getHeader(nextHeaderName);

            System.out.println("	" + nextHeaderName +" : "+headerValue);
        }
        System.out.println("Request Query : " + request.getQueryString());
        System.out.println("Request Body: " + requestBody);
    }

    private void logResponse(ContentCachingResponseWrapper response) throws IOException {
        String responseBody = new String(response.getContentAsByteArray(), response.getCharacterEncoding());
        System.out.println("Response Body: " + responseBody);
        System.out.println("");
    }

	
}
