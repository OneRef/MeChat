package xin.ucode.exam.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.ucode.exam.mapper.ExamQuestionMapper;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import xin.ucode.exam.service.IExamQuestionService;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.exam.domain.ExamQuestion;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(tags = "考试模块-试卷试题管理")
@RequestMapping("/exam/exam/question")
public class ExamQuestionController{
    @Autowired
    private IExamQuestionService examQuestionService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,ExamQuestion examQuestion){
        return AjaxResult.success(examQuestionService.page(pageEntity.toPage(), Wrappers.lambdaQuery(examQuestion)));
    }
    @GetMapping("/list")
    public AjaxResult list(ExamQuestion examQuestion){
        return AjaxResult.success(examQuestionService.list(Wrappers.lambdaQuery(examQuestion)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody ExamQuestion examQuestion) {
        return AjaxResult.success(examQuestionService.save(examQuestion));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody ExamQuestion examQuestion) {
        return AjaxResult.success(examQuestionService.updateById(examQuestion));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(examQuestionService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(examQuestionService.getById(id));
    }
}
