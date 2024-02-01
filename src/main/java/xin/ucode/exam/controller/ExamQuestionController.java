package xin.ucode.exam.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import xin.ucode.exam.mapper.ExamQuestionMapper;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import xin.ucode.exam.service.IExamQuestionService;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.exam.domain.ExamQuestion;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
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
