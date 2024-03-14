package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.LearningCondition;
import xin.ucode.exam.mapper.LearningConditionMapper;
import xin.ucode.exam.service.ILearningConditionService;
@Service
public class LearningConditionServiceImpl extends ServiceImpl<LearningConditionMapper,LearningCondition> implements ILearningConditionService{
}
