package xin.ucode.channel.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import xin.ucode.channel.domain.ChatChannel;
@Mapper
@Transactional(rollbackFor = Exception.class)
public interface ChatChannelMapper extends BaseMapper<ChatChannel>{
}
