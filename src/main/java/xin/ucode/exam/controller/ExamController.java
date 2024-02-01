package xin.ucode.exam.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Arrays;
import xin.ucode.exam.service.IExamService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import xin.altitude.cms.common.entity.PageEntity;
import xin.ucode.exam.mapper.ExamMapper;
import xin.ucode.exam.domain.Exam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/exam/exam")
public class ExamController{
    @Autowired
    private IExamService examService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Exam exam){
        return AjaxResult.success(examService.page(pageEntity.toPage(), Wrappers.lambdaQuery(exam)));
    }
    @GetMapping("/list")
    public AjaxResult list(Exam exam){
        return AjaxResult.success(examService.list(Wrappers.lambdaQuery(exam)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Exam exam) {
        return AjaxResult.success(examService.save(exam));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Exam exam) {
        return AjaxResult.success(examService.updateById(exam));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(examService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(examService.getById(id));
    }
}
