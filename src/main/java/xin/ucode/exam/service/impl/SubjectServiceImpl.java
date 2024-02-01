package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.Subject;
import xin.ucode.exam.mapper.SubjectMapper;
import xin.ucode.exam.service.ISubjectService;
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper,Subject> implements ISubjectService{
}
