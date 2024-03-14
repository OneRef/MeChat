package xin.ucode.channel.controller;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.channel.domain.ChatUserChannel;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;

import xin.ucode.channel.pojo.query.IdRequest;
import xin.ucode.channel.service.IChatUserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.utils.ResponseResult;
@CrossOrigin
@RestController
@Api(tags = "频道模块-用户频道")
@RequestMapping("/channel/chat/user")
public class ChatUserChannelController{
    @Autowired
    private IChatUserChannelService chatUserChannelService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,ChatUserChannel chatUserChannel){
        return AjaxResult.success(chatUserChannelService.page(pageEntity.toPage(), Wrappers.lambdaQuery(chatUserChannel)));
    }
    @GetMapping("/list")
    public AjaxResult list(ChatUserChannel chatUserChannel){
        return AjaxResult.success(chatUserChannelService.list(Wrappers.lambdaQuery(chatUserChannel)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody ChatUserChannel chatUserChannel) {
        return AjaxResult.success(chatUserChannelService.save(chatUserChannel));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ChatUserChannel chatUserChannel) {
        return AjaxResult.success(chatUserChannelService.updateById(chatUserChannel));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(chatUserChannelService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(chatUserChannelService.getById(id));
    }
    @PostMapping("/getFriends")
    @Operation(summary = "用户频道-获取好友列表")
    public ResponseResult<List<ChatUserChannel>> getFriendsById(@RequestBody IdRequest id){
        return ResponseResult.success(chatUserChannelService.getFriendsById(id.getId()));
    }
    @PostMapping("/getGroups")
    @Operation(summary = "用户频道-获取群聊列表")
    public ResponseResult<List<ChatUserChannel>> getGroupsById(@RequestBody IdRequest id){
        return ResponseResult.success(chatUserChannelService.getGroupsById(id.getId()));
    }
}
