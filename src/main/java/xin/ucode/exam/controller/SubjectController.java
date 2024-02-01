package xin.ucode.exam.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.ucode.exam.mapper.SubjectMapper;
import java.util.Arrays;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import xin.ucode.exam.service.ISubjectService;
import xin.ucode.exam.domain.Subject;
import xin.altitude.cms.common.entity.AjaxResult;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;
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
@RequestMapping("/exam/subject")
public class SubjectController{
    @Autowired
    private ISubjectService subjectService;
    @GetMapping("/page")
    public AjaxResult page(PageEntity pageEntity,Subject subject){
        return AjaxResult.success(subjectService.page(pageEntity.toPage(), Wrappers.lambdaQuery(subject)));
    }
    @GetMapping("/list")
    public AjaxResult list(Subject subject){
        return AjaxResult.success(subjectService.list(Wrappers.lambdaQuery(subject)));
    }
    @PostMapping("/push")
    public AjaxResult add(@RequestBody Subject subject) {
        return AjaxResult.success(subjectService.save(subject));
    }
    @PutMapping("/edit")
    public AjaxResult edit(@RequestBody Subject subject) {
        return AjaxResult.success(subjectService.updateById(subject));
    }
    @DeleteMapping("/delete/{ids}")
    public AjaxResult delete(@PathVariable Integer[] ids) {
        return AjaxResult.success(subjectService.removeByIds(Arrays.asList(ids)));
    }
    @GetMapping(value = "/detail/{id}")
    public AjaxResult detail(@PathVariable("id") Integer id) {
        return AjaxResult.success(subjectService.getById(id));
    }
}
