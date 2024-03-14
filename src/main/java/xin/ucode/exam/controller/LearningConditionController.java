package xin.ucode.exam.controller;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import xin.ucode.exam.mapper.LearningConditionMapper;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.exam.service.ILearningConditionService;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import xin.altitude.cms.common.entity.PageEntity;
import io.swagger.annotations.ApiOperation;
import xin.ucode.exam.domain.LearningCondition;

@RestController
@CrossOrigin
@Api(tags = "考试模块-学情分析")
@RequestMapping("/exam/learning/condition")
public class LearningConditionController{
    @Autowired
    private ILearningConditionService learningConditionService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,LearningCondition learningCondition){
        return AjaxResult.success(learningConditionService.page(pageEntity.toPage(), Wrappers.lambdaQuery(learningCondition)));
    }
    @GetMapping("/list")
    public AjaxResult list(LearningCondition learningCondition){
        return AjaxResult.success(learningConditionService.list(Wrappers.lambdaQuery(learningCondition)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody LearningCondition learningCondition) {
        return AjaxResult.success(learningConditionService.save(learningCondition));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody LearningCondition learningCondition) {
        return AjaxResult.success(learningConditionService.updateById(learningCondition));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(learningConditionService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(learningConditionService.getById(id));
    }
}
