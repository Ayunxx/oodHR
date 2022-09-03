import request from '@/utils/request'

export default {
    //获取列表
    getListPage(current,size,searchObj){
        return request({
            url: `/train/getTrainList/${current}/${size}`,
            method: 'post',
            data: searchObj
        })
    },
    getTrainById(id){
        return request({
            url: `/train/getTrainById/${id}`,
            method: 'get',
            data: id
        })
    },
    //添加
    addTrain(trainEntity){
        return request({
            url: `/train/addTrain`,
            method: 'post',
            data: trainEntity
        })
    },
    //删除
    deleteTrainById(id){
        return request({
            url: `/train/deleteTrainById/${id}`,
            method: 'delete',
            data: id
        })
    },
    //修改
    updateTrain(trainEntity){
        return request({
            url: `/train/updateTrain`,
            method: 'post',
            data: trainEntity
        })
    },
}