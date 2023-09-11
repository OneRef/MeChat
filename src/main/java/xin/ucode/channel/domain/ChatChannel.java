package xin.ucode.channel.domain;
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
@TableName(value = "chat_channel")
public class ChatChannel{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "创建时间", position = 2)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @ApiModelProperty(value = "更新时间", position = 3)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "类型 1：“个人” 2：“群组”", position = 4)
    private Integer type;
    @ApiModelProperty(value = "频道名称", position = 5)
    private String channelName;
    @ApiModelProperty(value = "频道人数", position = 6)
    private Integer channelNum;
    @ApiModelProperty(value = "群聊头像", position = 7)
    private String avatar;
    
    public ChatChannel(ChatChannel chatChannel) {
        if (Objects.nonNull(chatChannel)) {
            this.id=chatChannel.id;
            this.createTime=chatChannel.createTime;
            this.updateTime=chatChannel.updateTime;
            this.type=chatChannel.type;
            this.channelName=chatChannel.channelName;
            this.channelNum=chatChannel.channelNum;
        }
    }
}
