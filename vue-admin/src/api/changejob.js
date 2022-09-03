import request from '@/utils/request'

export default{
    getListPage(current,size,serachObj){
        return request({
            url:`/changejob/getChangeJobList/${current}/${size}`,
            method: 'post',
            data: serachObj
        })
    },
    deleteChangeJobById(id){
        return request({
            url: `/changejob/deleteChangeJobById/${id}`,
            method: 'delete',
            data: id
        })
    },
}