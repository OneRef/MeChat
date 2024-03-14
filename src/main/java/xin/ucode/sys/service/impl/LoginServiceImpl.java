package xin.ucode.sys.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import xin.ucode.sys.domain.LoginUser;
import xin.ucode.sys.domain.User;
import xin.ucode.sys.mapper.UserMapper;
import xin.ucode.sys.service.LoginServcie;
import xin.ucode.utils.Constants;
import xin.ucode.utils.JwtUtil;
import xin.ucode.utils.RedisCache;
import xin.ucode.utils.ResponseResult;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginServcie {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private RedisCache redisCache;
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        if(Objects.isNull(authenticate)){
         return new ResponseResult(Constants.CODE_402,"密码错误");
        }
        //使用userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);
        //authenticate存入redis
       // redisCache.setCacheObject("login:"+userId,loginUser);
        //把token响应给前端
        HashMap<String,String> map = new HashMap<>();
        map.put("token",jwt);

        //获取角色身份

        Map<String, String> data = new HashMap<>();
        data.put("role",userMapper.selectRoleByUsername(user.getUsername()));
        data.put("userId",userMapper.selectIdByUsername(user.getUsername()));
        data.put("avatar",userMapper.selectAvatarByUsername(user.getUsername()));
        data.put("username",user.getUsername());
        return new ResponseResult(Constants.CODE_200,"登录成功",data);
    }
}
