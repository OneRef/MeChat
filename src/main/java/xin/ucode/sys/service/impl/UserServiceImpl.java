package xin.ucode.sys.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xin.ucode.sys.domain.User;
import xin.ucode.sys.mapper.UserMapper;
import xin.ucode.sys.service.IUserService;
import xin.ucode.utils.Constants;
import xin.ucode.utils.ResponseResult;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public ResponseResult register(User user) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword()))
        {
            return  ResponseResult.error(Constants.CODE_400,"账户名和密码不能为空");
        }
        if (!isPasswordValid(user.getPassword())){
            return  ResponseResult.error(Constants.CODE_402,"密码必须由大小写字母数字和符号组成且大于八位");
        }
        if (StringUtils.isBlank(user.getEmail()))
        {
            return  ResponseResult.error(Constants.CODE_400,"邮箱不能为空");
        }
        //判断邮箱或者用户名是否存在
        if (isEmailExists(user.getEmail())){
            return  ResponseResult.error(Constants.CODE_402,"邮箱已存在");
        }
        if (isUsernameExists(user.getUsername())){
            return  ResponseResult.error(Constants.CODE_402,"用户名已存在");
        }

        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        //加密
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setId(null);
        save(user);
        return ResponseResult.success("注册成功");
    }

    public boolean isUsernameExists(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        Long count = userMapper.selectCount(queryWrapper);
        return count > 0;
    }

    public boolean isEmailExists(String email) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        Long count = userMapper.selectCount(queryWrapper);
        return count > 0;
    }

    //正则校验器
    public static boolean isPasswordValid(String password) {
        // 检查密码长度
        if (password.length() <= 8) {
            return false;
        }

        // 检查密码是否只包含数字、字符、大小写字母和特殊字符
        if (!password.matches("^[a-zA-Z0-9@#￥]+$")) {
            return false;
        }

        // 检查密码是否包含中文和其他语言字符
        if (password.matches(".*[\\u4E00-\\u9FA5].*") || password.matches(".*[^\\x00-\\x7F].*")) {
            return false;
        }

        return true;
    }
}
