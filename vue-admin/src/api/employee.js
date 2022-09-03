import request from '@/utils/request'

export default {
  getEmployeeList(current,size,searchObj) {
    return request({
      url: `/employee/getEmployeeList/${current}/${size}`,
      method: 'post',
      data: searchObj
    })
  },
  addEmployee(employeeEntity){
    return request({
      url: `/employee/addEmployee`,
      method: 'post',
      data: employeeEntity
    })
  },
  updateEmployee(employeeEntity){
    return request({
      url: `/employee/updateEmployee`,
      method: 'post',
      data: employeeEntity
    })
  },
  getEmployeeById(id){
    return request({
      url: `/employee/getEmployeeById/${id}`,
      method: 'get'
    })
  },
  deleteEmployeeById(id){
    return request({
      url: `/employee/deleteEmployeeById/${id}`,
      method: 'delete'
    })
  },
  getNationList(){
    return request({
      url: `/employee/getNationList`,
      method: 'get'
    })
  },
  getDepartmentList(){
    return request({
      url: `/employee/getDepartmentList`,
      method: 'get'
    })
  },
  getJobLevelList(){
    return request({
      url: `/employee/getJobLevelList`,
      method: 'get'
    })
  },
  getPositionList(){
    return request({
      url: `/employee/getPositionList`,
      method: 'get'
    })
  },

}
