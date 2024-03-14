package xin.ucode.exam.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.exam.domain.ExamQuestionStudent;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.exam.service.IExamQuestionStudentService;
import io.swagger.annotations.ApiOperation;
import xin.ucode.exam.mapper.ExamQuestionStudentMapper;
@RestController
@CrossOrigin
@Api(tags = "考试模块-作答情况管理")
@RequestMapping("/exam/exam/question/student")
public class ExamQuestionStudentController{
    @Autowired
    private IExamQuestionStudentService examQuestionStudentService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,ExamQuestionStudent examQuestionStudent){
        return AjaxResult.success(examQuestionStudentService.page(pageEntity.toPage(), Wrappers.lambdaQuery(examQuestionStudent)));
    }
    @GetMapping("/list")
    public AjaxResult list(ExamQuestionStudent examQuestionStudent){
        return AjaxResult.success(examQuestionStudentService.list(Wrappers.lambdaQuery(examQuestionStudent)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody ExamQuestionStudent examQuestionStudent) {
        return AjaxResult.success(examQuestionStudentService.save(examQuestionStudent));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ExamQuestionStudent examQuestionStudent) {
        return AjaxResult.success(examQuestionStudentService.updateById(examQuestionStudent));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(examQuestionStudentService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(examQuestionStudentService.getById(id));
    }
}
