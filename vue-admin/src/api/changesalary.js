import request from '@/utils/request'

export default{
    getListPage(current,size,searchObj){
        return request({
            url:`/changeSalary/getChangeSalaryList/${current}/${size}`,
            method: 'post',
            data: searchObj
        })
    },
}