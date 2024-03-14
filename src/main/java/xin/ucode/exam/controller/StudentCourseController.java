package xin.ucode.exam.controller;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sun.xml.internal.bind.v2.TODO;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.exam.domain.Course;
import xin.ucode.exam.service.ICourseService;
import xin.ucode.exam.service.IStudentCourseService;
import xin.ucode.exam.mapper.StudentCourseMapper;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import io.swagger.annotations.ApiOperation;
import xin.ucode.exam.domain.StudentCourse;
import xin.ucode.sys.domain.User;

@RestController
@CrossOrigin
@Api(tags = "考试模块-学生选课")
@RequestMapping("/exam/student/course")
public class StudentCourseController{
    @Autowired
    private IStudentCourseService studentCourseService;
    @Autowired
    private ICourseService courseService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,StudentCourse studentCourse){
        return AjaxResult.success(studentCourseService.page(pageEntity.toPage(), Wrappers.lambdaQuery(studentCourse)));
    }
    @GetMapping("/list")
    public AjaxResult list(StudentCourse studentCourse){
        return AjaxResult.success(studentCourseService.list(Wrappers.lambdaQuery(studentCourse)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody StudentCourse studentCourse) {
        return AjaxResult.success(studentCourseService.save(studentCourse));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody StudentCourse studentCourse) {
        return AjaxResult.success(studentCourseService.updateById(studentCourse));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(studentCourseService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(studentCourseService.getById(id));
    }

    //TODO 添加课程（检查课程是否已存在，添加课程）
    //查询已选课程接口
    @PostMapping("/selectMyCourse")
    public AjaxResult selectMyCourse(PageEntity pageEntity, StudentCourse studentCourse) {
        Page<StudentCourse> studentCoursePage = studentCourseService.page(
                pageEntity.toPage(),
                Wrappers.lambdaQuery(studentCourse)
        );

        List<StudentCourse> studentCourses = studentCoursePage.getRecords();
        List<Course> courses = new ArrayList<>();

        for (StudentCourse sc : studentCourses) {
            // 根据课程id查询课程信息
            Course course = courseService.getById(sc.getCourseId());
            courses.add(course);
        }

        Page<Course> coursePage = new Page<>();
        coursePage.setRecords(courses);
        coursePage.setTotal(studentCoursePage.getTotal());
        coursePage.setCurrent(studentCoursePage.getCurrent());
        coursePage.setSize(studentCoursePage.getSize());

        return AjaxResult.success(coursePage);
    }
}
