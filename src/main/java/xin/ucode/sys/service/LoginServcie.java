package xin.ucode.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import xin.ucode.sys.domain.User;
import xin.ucode.utils.ResponseResult;

public interface LoginServcie  {
    ResponseResult login(User user);
}
