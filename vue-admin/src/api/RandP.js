import request from '@/utils/request'

export default {
    getListPage(current,size,serachObj){
        return request({
            url: `/RandP/getListPage/${current}/${size}`,
            method: 'post',
            data: serachObj
        })
    },
    getRandPById(id){
        return request({
            url: `/RandP/getRandPById/${id}`,
            method: 'get',
            data: id
        })
    },
    updateRandP(RandPEntity){
        return request({
            url: `/RandP/updateRandP`,
            method: 'post',
            data: RandPEntity
        })
    },
    //添加
    addRandP(RandPEntity){
        return request({
            url: `/RandP/addRandP`,
            method: 'post',
            data: RandPEntity
        })
    },
    deleteRandPById(id){
        return request({
            url: `/RandP/deleteRandPById/${id}`,
            method: 'delete',
            data: id
        })
    }
}