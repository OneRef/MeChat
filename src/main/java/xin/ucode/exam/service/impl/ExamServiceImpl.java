package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.Exam;
import xin.ucode.exam.mapper.ExamMapper;
import xin.ucode.exam.service.IExamService;
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper,Exam> implements IExamService{
}
