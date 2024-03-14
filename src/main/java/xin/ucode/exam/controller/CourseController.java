package xin.ucode.exam.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import xin.ucode.exam.domain.Course;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import io.swagger.annotations.ApiOperation;
import xin.ucode.exam.mapper.CourseMapper;
import xin.ucode.exam.service.ICourseService;

@CrossOrigin
@RestController
@Api(tags = "考试模块-课程管理")
@RequestMapping("/exam/course")
public class CourseController{
    @Autowired
    private ICourseService courseService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Course course){
        return AjaxResult.success(courseService.page(pageEntity.toPage(), Wrappers.lambdaQuery(course)));
    }
    @GetMapping("/list")
    public AjaxResult list(Course course){
        return AjaxResult.success(courseService.list(Wrappers.lambdaQuery(course)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Course course) {
        return AjaxResult.success(courseService.save(course));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Course course) {
        return AjaxResult.success(courseService.updateById(course));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(courseService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(courseService.getById(id));
    }
}
