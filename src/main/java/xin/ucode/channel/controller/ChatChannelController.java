package xin.ucode.channel.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import xin.ucode.channel.domain.ChatChannel;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.channel.mapper.ChatChannelMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import xin.ucode.channel.service.IChatChannelService;
@RestController
@Api(tags = "频道模块-频道使用")
@RequestMapping("/channel/chat")
public class ChatChannelController{
    @Autowired
    private IChatChannelService chatChannelService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,ChatChannel chatChannel){
        return AjaxResult.success(chatChannelService.page(pageEntity.toPage(), Wrappers.lambdaQuery(chatChannel)));
    }
    @GetMapping("/list")
    public AjaxResult list(ChatChannel chatChannel){
        return AjaxResult.success(chatChannelService.list(Wrappers.lambdaQuery(chatChannel)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody ChatChannel chatChannel) {
        return AjaxResult.success(chatChannelService.save(chatChannel));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ChatChannel chatChannel) {
        return AjaxResult.success(chatChannelService.updateById(chatChannel));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(chatChannelService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(chatChannelService.getById(id));
    }
    @PostMapping("/hello")
    public AjaxResult hello(){
        return  AjaxResult.success("hello");
    }

}
