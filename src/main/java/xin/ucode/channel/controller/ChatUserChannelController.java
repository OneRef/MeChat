package xin.ucode.channel.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.channel.domain.ChatUserChannel;
import xin.ucode.channel.mapper.ChatUserChannelMapper;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import xin.ucode.channel.service.IChatUserChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@Api(tags = "频道模块-用户频道")
@RequestMapping("/channel/chat/user/channel")
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
}
