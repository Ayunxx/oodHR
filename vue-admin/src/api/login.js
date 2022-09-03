import request from '@/utils/request'

export default{
    req_login(Hrvo){
        return request({
            url: "/hr/login",
            method: 'post',
            data: Hrvo
        })
    }
}