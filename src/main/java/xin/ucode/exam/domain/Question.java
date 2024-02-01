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
@TableName(value = "question")
public class Question{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "题目内容", position = 2)
    private String questionText;
    @ApiModelProperty(value = "题目难度（0-100）", position = 3)
    private Integer difficulty;
    @ApiModelProperty(value = "关联学科id", position = 4)
    private Integer subjecId;
    @ApiModelProperty(value = "章节", position = 5)
    private Integer chapter;
    @ApiModelProperty(value = "题目类型（1单选2多选3填空4主观）", position = 6)
    private Integer type;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "分数", position = 9)
    private Integer score;
    @ApiModelProperty(value = "参考答案", position = 10)
    private String answerText;
    
    public Question(Question question) {
        if (Objects.nonNull(question)) {
            this.id=question.id;
            this.questionText=question.questionText;
            this.difficulty=question.difficulty;
            this.subjecId=question.subjecId;
            this.chapter=question.chapter;
            this.type=question.type;
            this.createTime=question.createTime;
            this.updateTime=question.updateTime;
            this.score=question.score;
            this.answerText=question.answerText;
        }
    }
}
