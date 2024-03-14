package xin.ucode.sys.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import xin.ucode.sys.domain.User;

@Mapper
@Transactional(rollbackFor = Exception.class)
public interface UserMapper extends BaseMapper<User>{
    @Select("SELECT role from user where username=#{username}")
    String selectRoleByUsername(String username);
    @Select("SELECT id from user where username=#{username}")
    String selectIdByUsername(String username);
    @Select("SELECT avatar from user where username=#{username}")
    String selectAvatarByUsername(String username);
}
