package xin.ucode.sys.service;
import com.baomidou.mybatisplus.extension.service.IService;
import xin.ucode.sys.domain.User;
import xin.ucode.utils.ResponseResult;

public interface IUserService extends IService<User>{
    ResponseResult register(User user);

    ResponseResult logout(User user);
}
