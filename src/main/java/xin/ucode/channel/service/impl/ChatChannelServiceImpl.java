package xin.ucode.channel.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.channel.domain.ChatChannel;
import xin.ucode.channel.mapper.ChatChannelMapper;
import xin.ucode.channel.service.IChatChannelService;
@Service
public class ChatChannelServiceImpl extends ServiceImpl<ChatChannelMapper,ChatChannel> implements IChatChannelService{
}
