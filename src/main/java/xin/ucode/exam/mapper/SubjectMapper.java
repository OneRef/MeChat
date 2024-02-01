package xin.ucode.exam.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;
import xin.ucode.exam.domain.Subject;
@Mapper
@Transactional(rollbackFor = Exception.class)
public interface SubjectMapper extends BaseMapper<Subject>{
}
