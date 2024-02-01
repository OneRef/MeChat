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
@TableName(value = "exam_question")
public class ExamQuestion{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "关联试卷", position = 2)
    private Integer examId;
    @ApiModelProperty(value = "关联题库", position = 3)
    private Integer questionId;
    @ApiModelProperty(value = "在该题库中的分值", position = 4)
    private String score;
    
    public ExamQuestion(ExamQuestion examQuestion) {
        if (Objects.nonNull(examQuestion)) {
            this.id=examQuestion.id;
            this.examId=examQuestion.examId;
            this.questionId=examQuestion.questionId;
            this.score=examQuestion.score;
        }
    }
}
