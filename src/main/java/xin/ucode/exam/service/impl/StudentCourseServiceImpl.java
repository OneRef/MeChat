package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.StudentCourse;
import xin.ucode.exam.mapper.StudentCourseMapper;
import xin.ucode.exam.service.IStudentCourseService;
@Service
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper,StudentCourse> implements IStudentCourseService{
}
