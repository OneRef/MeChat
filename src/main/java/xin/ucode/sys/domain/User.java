package xin.ucode.sys.domain;
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
@TableName(value = "user")
public class User{
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime;
    @ApiModelProperty(value = "用户名", position = 4)
    private String username;
    @ApiModelProperty(value = "用户类型（学生 老师 管理员）", position = 5)
    private String role;
    @ApiModelProperty(value = "密码", position = 6)
    private String password;
    @ApiModelProperty(value = "昵称", position = 7)
    private String nickname;
    @ApiModelProperty(value = "电子邮箱", position = 8)
    private String email;
    @ApiModelProperty(value = "个人头像", position = 9)
    private String avatar;
    
    public User(User user) {
        if (Objects.nonNull(user)) {
            this.id=user.id;
            this.createTime=user.createTime;
            this.updateTime=user.updateTime;
            this.username=user.username;
            this.role=user.role;
            this.password=user.password;
            this.nickname=user.nickname;
            this.email=user.email;
        }
    }
}
