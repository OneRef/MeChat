package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.ExamQuestionStudent;
import xin.ucode.exam.mapper.ExamQuestionStudentMapper;
import xin.ucode.exam.service.IExamQuestionStudentService;
@Service
public class ExamQuestionStudentServiceImpl extends ServiceImpl<ExamQuestionStudentMapper,ExamQuestionStudent> implements IExamQuestionStudentService{
}
