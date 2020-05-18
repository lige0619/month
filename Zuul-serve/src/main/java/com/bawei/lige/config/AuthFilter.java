package com.bawei.lige.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AuthFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {

        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        HttpServletResponse response = currentContext.getResponse();
        String token = request.getParameter("token");
        if (StringUtils.isEmpty(token)) {
            //http状态码：认证错误
            currentContext.setResponseStatusCode(401);
            currentContext.setSendZuulResponse(false);
            try {
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().write("{\"message\":\"未授权\"}");
            } catch (Exception e) {

            }
        }
        return null;
    }
}
