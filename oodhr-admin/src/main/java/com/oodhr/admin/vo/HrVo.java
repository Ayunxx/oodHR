package com.oodhr.admin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class HrVo {

    private String username;

    private String password;

    private List<String> roles;

    private String introduction;

}
