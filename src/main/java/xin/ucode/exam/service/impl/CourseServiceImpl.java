package xin.ucode.exam.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.ucode.exam.domain.Course;
import xin.ucode.exam.mapper.CourseMapper;
import xin.ucode.exam.service.ICourseService;
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper,Course> implements ICourseService{
}
