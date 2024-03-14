package xin.ucode.exam.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import xin.ucode.exam.domain.Question;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.exam.service.IQuestionService;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;

import xin.ucode.exam.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin
@Api(tags = "考试模块-题库管理")
@RequestMapping("/exam/question")
public class QuestionController{
    @Autowired
    private IQuestionService questionService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Question question){
        return AjaxResult.success(questionService.page(pageEntity.toPage(), Wrappers.lambdaQuery(question)));
    }
    @GetMapping("/list")
    public AjaxResult list(Question question){
        return AjaxResult.success(questionService.list(Wrappers.lambdaQuery(question)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Question question) {
        return AjaxResult.success(questionService.save(question));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Question question) {
        return AjaxResult.success(questionService.updateById(question));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(questionService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(questionService.getById(id));
    }
}
