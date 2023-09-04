package xin.ucode.channel.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.channel.domain.ChatUserChannel;
import xin.ucode.channel.mapper.ChatUserChannelMapper;
import xin.ucode.channel.service.IChatUserChannelService;
@Service
public class ChatUserChannelServiceImpl extends ServiceImpl<ChatUserChannelMapper,ChatUserChannel> implements IChatUserChannelService{
}
