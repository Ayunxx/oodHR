import request from '@/utils/request'

export default{
    getListPage(current,size,serachObj){
        return request({
            url:`/salary/getSalaryList/${current}/${size}`,
            method: 'post',
            data: serachObj
        })
    },
    getSalaryById(id){
        return request({
            url: `/salary/getSalaryById/${id}`,
            method: 'get',
            data: id
        })
    },
    deleteSalaryById(id){
        return request({
            url: `/salary/deleteSalaryById/${id}`,
            method: 'delete',
            data: id
        })
    },
    addSalary(salaryEntity){
        return request({
            url: `/salary/addChangeSalary`,
            method: 'post',
            data: salaryEntity
        })
    },
    upDateSalaryById(salaryEntity){
        return request({
            url: `/salary/upDateSalaryById`,
            method: 'post',
            data: salaryEntity
        })
    },
}