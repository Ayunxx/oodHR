package com.oodhr.admin.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class EmployeeVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 员工编号
     */
    private Integer id;
    /**
     * 员工姓名
     */
    private String empname;
    /**
     * 性别
     */
    private String gender;
    /**
     * 出生日期
     */
    private Date birthday;
    /**
     * 身份证号
     */
    private String idcard;
    /**
     * 婚姻状况
     */
    private String wedlock;
    /**
     * 民族
     */
    private String nationname;
    /**
     * 籍贯
     */
    private String nativeplace;
    /**
     * 政治面貌
     */
    private String politic;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 所属部门
     */
    private String departmentname;
    /**
     * 职称ID
     */
    private String joblevelname;
    /**
     * 职位ID
     */
    private String posname;
    /**
     * 聘用形式
     */
    private String engageform;
    /**
     * 最高学历
     */
    private String tiptopdegree;
    /**
     * 所属专业
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 入职日期
     */
    private Date begindate;
    /**
     * 在职状态
     */
    private String workstate;
    /**
     * 工号
     */
    private String workid;
    /**
     * 合同期限
     */
    private String contractterm;
    /**
     * 转正日期
     */
    private Date conversiontime;
    /**
     * 离职日期
     */
    private Date notworkdate;
    /**
     * 合同起始日期
     */
    private Date begincontract;
    /**
     * 合同终止日期
     */
    private Date endcontract;
    /**
     * 工龄
     */
    private Integer workage;

}