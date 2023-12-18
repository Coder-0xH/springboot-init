package com.zero.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "user")
public class User implements Serializable {

    /**
     * id
     */
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 用户账号
     */
    @TableField("user_account")
    private String userAccount;

    /**
     * 用户密码
     */
    @TableField("user_password")
    private String userPassword;

    /**
     * 开放平台id
     */
    @TableField("union_id")
    private String unionId;

    /**
     * 公众号openId
     */
    @TableField("mp_open_id")
    private String mpOpenId;

    /**
     * 用户昵称
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户头像
     */
    @TableField("user_avatar")
    private String userAvatar;

    /**
     * 用户简介
     */
    @TableField("user_profile")
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    @TableField("user_role")
    private String userRole;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 推广码
     */
    @TableField("referral_code")
    private String referralCode;
    /**
     * 冻结金额
     */
    @TableField("frozen_balance")
    private double frozenBalance;
    /**
     * 可提现余额
     */
    @TableField("withdraw_balance")
    private double withdrawBalance;
    /**
     * 可提现余额
     */
    @TableField("promotion_link")
    private String promotionLink;
    /**
     * 推荐人
     */
//    private User referrer;

    /**
     * 是否删除
     */
    @TableLogic
    @TableField("is_delete")
    private Integer isDelete;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
