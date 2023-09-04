package xin.ucode.sys.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xin.ucode.sys.domain.User;
import xin.ucode.sys.mapper.UserMapper;
import xin.ucode.sys.service.IUserService;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService{
}
