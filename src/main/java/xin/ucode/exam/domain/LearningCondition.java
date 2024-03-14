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
@TableName(value = "learning_condition")
public class LearningCondition{
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "学习能力数值", position = 3)
    private Integer ability;
    @ApiModelProperty(value = "高考成绩", position = 6)
    private Integer entranceExamination;
    @ApiModelProperty(value = "平时作业平均得分", position = 5)
    private Integer homework;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "问卷分析", position = 7)
    private Integer questionnaire;
    @ApiModelProperty(value = "对应学生", position = 2)
    private Integer studentId;
    @ApiModelProperty(value = "平时表现得分（上课作答情况）", position = 4)
    private Integer usualPerformance;
    
    public LearningCondition(LearningCondition learningCondition) {
        if (Objects.nonNull(learningCondition)) {
            this.ability=learningCondition.ability;
            this.entranceExamination=learningCondition.entranceExamination;
            this.homework=learningCondition.homework;
            this.id=learningCondition.id;
            this.questionnaire=learningCondition.questionnaire;
            this.studentId=learningCondition.studentId;
            this.usualPerformance=learningCondition.usualPerformance;
        }
    }
}
