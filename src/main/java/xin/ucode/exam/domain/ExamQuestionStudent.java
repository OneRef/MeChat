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
@TableName(value = "exam_question_student")
public class ExamQuestionStudent{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "队对应考试id", position = 2)
    private Integer examId;
    @ApiModelProperty(value = "试题id", position = 3)
    private Integer questionId;
    @ApiModelProperty(value = "用户学生的id", position = 4)
    private Integer studentId;
    @ApiModelProperty(value = "学生的答案", position = 5)
    private String answeText;
    @ApiModelProperty(value = "该题分数", position = 6)
    private Integer score;
    
    public ExamQuestionStudent(ExamQuestionStudent examQuestionStudent) {
        if (Objects.nonNull(examQuestionStudent)) {
            this.id=examQuestionStudent.id;
            this.examId=examQuestionStudent.examId;
            this.questionId=examQuestionStudent.questionId;
            this.studentId=examQuestionStudent.studentId;
            this.answeText=examQuestionStudent.answeText;
            this.score=examQuestionStudent.score;
        }
    }
}
