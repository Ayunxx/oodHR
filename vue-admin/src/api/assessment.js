import request from '@/utils/request'

export default{
    getListPage(current,size,serachObj){
        return request({
            url:`/assessment/getAssessmentList/${current}/${size}`,
            method: 'post',
            data: serachObj
        })
    },
    getAssessmentById(id){
        return request({
            url: `/assessment/getAssessmentById/${id}`,
            method: 'get',
            data: id
        })
    },
    deleteAssessmentById(id){
        return request({
            url: `/assessment/deleteAssessmentById/${id}`,
            method: 'delete',
            data: id
        })
    },
    addAssessment(assessmentEntity){
        return request({
            url: `/assessment/addAssessment`,
            method: 'post',
            data: assessmentEntity
        })
    },
    updateAssessment(assessmentEntity){
        return request({
            url: `/assessment/updateAssessment`,
            method: 'post',
            data: assessmentEntity
        })
    }
}