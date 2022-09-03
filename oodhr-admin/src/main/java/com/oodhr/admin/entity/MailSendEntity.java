package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @auther Ayun
 * @date 2022/9/3 13:42
 */
@Data
@TableName("mail_send")
public class MailSendEntity {
    private String msgId;
    private Integer empId;
    //0 消息投递中   1 投递成功   2投递失败
    private Integer status;
    private String routeKey;
    private String exchange;
    private Integer count;
    private Date tryTime;
    private Date createTime;
    private Date updateTime;
}
