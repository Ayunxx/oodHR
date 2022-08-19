package com.oodhr.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * 
 * @author Ayun
 * @email Ayunlccy@gmail.com
 * @date 2022-08-16 12:24:09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("department")
public class DepartmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * id 自增
	 */
	@TableId(value = "id" ,type = IdType.AUTO)
	private Integer id;
	/**
	 * 部门名称
	 */
	private String name;
	/**
	 * 父部门id
	 */
	private Integer parentid;
	/**
	 * 部门path
	 */
	private String deppath;
	/**
	 * 是否可用
	 */
	private Integer enabled;
	/**
	 * 是否为父部们
	 */
	private Integer isparent;

}
