package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.ExamQuestion;
import xin.ucode.exam.mapper.ExamQuestionMapper;
import xin.ucode.exam.service.IExamQuestionService;
@Service
public class ExamQuestionServiceImpl extends ServiceImpl<ExamQuestionMapper,ExamQuestion> implements IExamQuestionService{
}
