package xin.ucode.fliter;



import com.github.xiaoymin.knife4j.core.util.StrUtil;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import xin.ucode.sys.domain.LoginUser;
import xin.ucode.utils.JwtUtil;
import xin.ucode.utils.RedisCache;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private RedisCache redisCache;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
       //获取token
        String token=request.getHeader("token");
        if(StrUtil.isBlank(token)){
            //放行
            filterChain.doFilter(request,response);
            return;
        }
        //解析token
        String userid;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userid=claims.getSubject();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("token非法");
        }
        //从redis中获取用户信息
        String redisKey="login:"+userid;
            LoginUser loginUser = redisCache.getCacheObject(redisKey);
            if(Objects.isNull(loginUser)) {
                throw new RuntimeException("用户未登录");
            }

        //用户信息存入securityContextHolder
        //TODO 获取权限信息到Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(loginUser,null,null);
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //放行
         filterChain.doFilter(request,response);
    }
}
