package net.xdclass.demoproject.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.xdclass.demoproject.domain.User;
import net.xdclass.demoproject.service.impl.UserServiceImpl;
import net.xdclass.demoproject.utils.JsonData;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/api/v1/pri/*", filterName = "loginFilter")
public class LoginFilter implements Filter {
    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LoginFilter.doFilter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            token = request.getParameter("token");
        }
        if (!StringUtils.isEmpty(token)) {
            User user = UserServiceImpl.tokenMap.get(token);
            if (user != null) {
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                JsonData jsonData = JsonData.buildError("登录失败.token无效", -2);
                String jsonStr = objectMapper.writeValueAsString(jsonData);
                renderJson(response, jsonStr);
            }
        } else {
            JsonData jsonData = JsonData.buildError("未登录", -3);
            String jsonStr = objectMapper.writeValueAsString(jsonData);
            renderJson(response, jsonStr);
        }
    }

    private void renderJson(HttpServletResponse response, String json) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        try (PrintWriter writer = response.getWriter()) {
            writer.print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter.destroy");
    }
}
