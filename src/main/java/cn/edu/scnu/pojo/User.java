package cn.edu.scnu.pojo;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@TableName(value = "t_user")
public class User  implements Serializable {
	private static final long serialVersionUID = -5644799954031156649L;
    //value与数据库主键列名一致，若实体类属性名与表主键列名一致可省略value
    @TableId(value = "user_id")
	private String userId;
	private String userName;
	private String userPassword;
	private String userNickname;
	private String userEmail;
	private Integer userType=0;//默认都是0
	public User(String userId, String userName, String userPassword, String userNickname, String userEmail,
			Integer userType) {
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNickname = userNickname;
		this.userEmail = userEmail;
		this.userType = userType;
	}
	public User(){}
}