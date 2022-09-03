package com.oodhr.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oodhr.admin.entity.HrEntity;
import com.oodhr.admin.vo.HrVo;
import com.oodhr.admin.vo.RoleVo;

import java.util.List;
import java.util.Map;

public interface HrService extends IService<HrEntity> {


    Map<String,String> verify(HrVo user);

    void logout();

    HrEntity encryption(HrEntity hrEntity);

    List<HrVo> getUserList();
}
