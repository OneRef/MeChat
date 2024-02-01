package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.Question;
import xin.ucode.exam.mapper.QuestionMapper;
import xin.ucode.exam.service.IQuestionService;
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper,Question> implements IQuestionService{
}
