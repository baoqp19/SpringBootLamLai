package com.example.ProjectSpringboot.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;

import com.example.ProjectSpringboot.domain.Permission;
import com.example.ProjectSpringboot.domain.Role;
import com.example.ProjectSpringboot.domain.User;
import com.example.ProjectSpringboot.service.UserService;
import com.example.ProjectSpringboot.util.SecurityUtil;
import com.example.ProjectSpringboot.util.error.IdInvalidException;
import com.example.ProjectSpringboot.util.error.PermissionException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PermissionInterceptor implements HandlerInterceptor {
    @Autowired
    UserService userService;

    @Override
    @Transactional // có cái này
    public boolean preHandle( // logic trước khi controller xử lý yêu cầu
            HttpServletRequest request,
            HttpServletResponse response, Object handler)
            throws Exception {

        String path = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        String requestURI = request.getRequestURI();
        String httpMethod = request.getMethod();
        System.out.println(">>> RUN preHandle");
        System.out.println(">>> path= " + path);
        System.out.println(">>> httpMethod= " + httpMethod);
        System.out.println(">>> requestURI= " + requestURI);

        // check permission
        // lấy ra email đã login và mỗi lần gửi token lên đã có hàm decode luuư vào
        // SecurityContex dùng hàm getCurrentUserLogin()
        String email = SecurityUtil.getCurrentUserLogin().isPresent() == true
                ? SecurityUtil.getCurrentUserLogin().get()
                : "";

        if (email != null && !email.isEmpty()) {
            User user = this.userService.handleGetUserByUsername(email);
            if (user != null) {
                Role role = user.getRole();
                if (role != null) {
                    List<Permission> permissions = role.getPermissions();
                    boolean isAllow = permissions.stream().anyMatch(item -> item.getApiPath().equals(path)
                            && item.getMethod().equals(httpMethod));

                    if (!isAllow) {
                        throw new PermissionException("Bạn không có quyền truy cập endpoint này.");
                    }
                } else {
                    throw new PermissionException("Bạn không có quyền truy cập endpoint này.");
                }
            }
        }

        // false thì nó sẽ không trả ra gì vì chưa đên controller thì đã dừng rồi nó xẩy
        // ra trước controller mà
        return true;
    }
}
