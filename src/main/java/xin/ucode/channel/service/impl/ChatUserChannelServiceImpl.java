package xin.ucode.channel.service.impl;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.channel.domain.ChatUserChannel;
import xin.ucode.channel.mapper.ChatUserChannelMapper;
import xin.ucode.channel.service.IChatUserChannelService;

import java.util.List;

@Service
public class ChatUserChannelServiceImpl extends ServiceImpl<ChatUserChannelMapper,ChatUserChannel> implements IChatUserChannelService{
    @Autowired
    ChatUserChannelMapper chatUserChannelMapper;
    @Override
    public List<ChatUserChannel> getFriendsById(Integer id) {
        QueryWrapper<ChatUserChannel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id)
                .eq("channel_type",1);
        return chatUserChannelMapper.selectList(queryWrapper);
    }

    @Override
    public List<ChatUserChannel> getGroupsById(Integer id) {
        QueryWrapper<ChatUserChannel> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", id)
                .eq("channel_type",2);
        return chatUserChannelMapper.selectList(queryWrapper);
    }
}
