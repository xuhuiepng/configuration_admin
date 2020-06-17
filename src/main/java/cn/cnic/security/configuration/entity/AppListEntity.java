package cn.cnic.security.configuration.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class AppListEntity {
    @TableId(type= IdType.AUTO)
    private Integer cId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 应用id
     */
    private Integer clientId;

    /**
     * 用户名
     */
    private String userName;
}
