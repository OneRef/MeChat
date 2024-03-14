package xin.ucode.sys.controller;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.sys.domain.User;
import xin.ucode.sys.service.IUserService;
import xin.altitude.cms.common.entity.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.sys.service.LoginServcie;
import xin.ucode.utils.Constants;
import xin.ucode.utils.ResponseResult;
@CrossOrigin
@RestController
@Api(tags = "系统模块-用户接口")
@RequestMapping("/user")
public class UserController{
    @Autowired
    private LoginServcie loginServcie;

    @Autowired
    private IUserService userService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity, User user){
        return AjaxResult.success(userService.page(pageEntity.toPage(), Wrappers.lambdaQuery(user)));
    }
    @GetMapping("/list")
    public AjaxResult list(User user){
        return AjaxResult.success(userService.list(Wrappers.lambdaQuery(user)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody User user) {
        return AjaxResult.success(userService.save(user));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody User user) {
        return AjaxResult.success(userService.updateById(user));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(userService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(userService.getById(id));
    }

    @Operation(summary = "用户登录")
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user){
        return loginServcie.login(user);
    }

    @Operation(summary = "用户注册")
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user){
        return userService.register(user);
    }

    @Operation(summary = "用户退出登录")
    @PostMapping("/logout")
    public ResponseResult logout(@RequestBody User user){
        return userService.logout(user);
    }


}
