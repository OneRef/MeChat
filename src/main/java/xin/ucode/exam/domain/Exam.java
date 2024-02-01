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
@TableName(value = "exam")
public class Exam{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "试卷标题", position = 2)
    private String title;
    @ApiModelProperty(value = "试卷描述", position = 3)
    private String description;
    @ApiModelProperty(value = "考试时长", position = 4)
    private String duration;
    @ApiModelProperty(value = "考试总分", position = 5)
    private String totalMarks;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    
    public Exam(Exam exam) {
        if (Objects.nonNull(exam)) {
            this.id=exam.id;
            this.title=exam.title;
            this.description=exam.description;
            this.duration=exam.duration;
            this.totalMarks=exam.totalMarks;
            this.createTime=exam.createTime;
            this.updateTime=exam.updateTime;
        }
    }
}
