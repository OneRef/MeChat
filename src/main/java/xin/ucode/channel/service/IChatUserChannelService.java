package xin.ucode.channel.service;
import com.baomidou.mybatisplus.extension.service.IService;
import xin.ucode.channel.domain.ChatUserChannel;

import java.util.List;

public interface IChatUserChannelService extends IService<ChatUserChannel>{
    List<ChatUserChannel> getFriendsById(Integer id);

    List<ChatUserChannel> getGroupsById(Integer id);
}
