import request from '@/utils/request'
export default{
    getUserRole(){
        return request({
            url: `/admin/getUserList`,
            method: 'get'
        })
    },
    updateUserStatusById(id,status){
        return request({
            url: `/admin/updateUserStatusById/${id}/${status}`,
            method: 'put',
        })
    },
    addUser(userEntity){
        return request({
            url: `/admin/addUser`,
            method: 'post',
            data: userEntity
        })
    },
    deleteUserById(id){
        return request({
            url: `/admin/deleteUserById/${id}`,
            method: 'delete',
        })
    },
    getMenuList(){
        return request({
            url: `/admin/getMenuList`,
            method: 'get'
        })
    },
    getRoleAndMenu(){
        return request({
            url: `/admin/getRoleAndMenu`,
            method: 'get'
        })
    },
    updateRoleStatus(roleid,menuid,status){
        return request({
            url: `/admin/updateRoleStatus/${roleid}/${menuid}/${status}`,
            method: 'put'
        })
    }
}