package xin.ucode.exam.domain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "course")
public class Course{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "课程名称", position = 2)
    private String name;
    @ApiModelProperty(value = "任课老师", position = 3)
    private String courseTeacher;
    @ApiModelProperty(value = "课程相关学科id", position = 4)
    private Integer subjectId;
    @ApiModelProperty(value = "课程开始日期", position = 5)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    
    public Course(Course course) {
        if (Objects.nonNull(course)) {
            this.id=course.id;
            this.name=course.name;
            this.courseTeacher=course.courseTeacher;
            this.subjectId=course.subjectId;
            this.createTime=course.createTime;
        }
    }
}
