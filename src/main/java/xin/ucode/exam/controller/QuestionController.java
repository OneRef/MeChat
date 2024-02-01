package xin.ucode.exam.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.ucode.exam.domain.Question;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.exam.service.IQuestionService;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import xin.ucode.exam.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
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
