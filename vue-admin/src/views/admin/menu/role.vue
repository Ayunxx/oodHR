<!--  -->
<template>
    <div class=''>
        <el-button type="primary" @click="dialogFormVisible = true" class="adduserbttn">新建策略</el-button>
        <el-dialog title="新建用户" :visible.sync="dialogFormVisible">
            <el-form :model="userEntity" :inline="true">
                <el-form-item label="姓名" >
                    <el-input v-model="userEntity.hrName" style="width:120px;"></el-input>
                </el-form-item>
                <el-form-item label="手机号码" >
                    <el-input v-model="userEntity.phone" style="width:200px;"></el-input>
                </el-form-item>
                <el-form-item label="住宅电话" >
                    <el-input v-model="userEntity.telephone" style="width:200px;"></el-input>
                </el-form-item>
                <el-form-item label="联系地址" >
                    <el-input v-model="userEntity.address" style="width:400px;"></el-input>
                </el-form-item>
                <br>
                <el-form-item label="用户名" >
                    <el-input v-model="userEntity.username" style="width:120px;"></el-input>
                </el-form-item>
                <el-form-item label="密码" >
                    <el-input type="passoword" v-model="userEntity.password" style="width:180px;"></el-input>
                </el-form-item>
                <el-form-item label="头像" >
                    <el-input v-model="userEntity.avatar" style="width:180px;"></el-input>
                </el-form-item>
                <el-form-item label="账户是否可用" >
                    <el-select v-model="userEntity.status" >
                        <el-option label="启用" :value="0"></el-option>
                        <el-option label="禁用" :value="1"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="备注" >
                    <el-input v-model="userEntity.remark" style="width:400px;"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save()">确 定</el-button>
            </div>
        </el-dialog>
        <el-table border style="width: 100%" :data="list">
            <el-table-column type="index" label="序号" width="50"></el-table-column>
            <el-table-column prop="roleName" label="角色"></el-table-column>
            <el-table-column prop="roleKey" label="角色名"></el-table-column>
            <el-table-column prop="menuName" label="权限名"></el-table-column>
            <el-table-column prop="perms" label="权限字符"></el-table-column>
            <el-table-column prop="status" label="菜单状态"></el-table-column>
            <el-table-column label="操作" width="120" align="center">
                <template slot-scope="scope">
                    <el-switch v-model="scope.row.status" active-color="#13ce66" inactive-color="#ff4949"
                                active-value="0" inactive-value="1" @change="updateRoleStatus(scope.row.roleId,scope.row.menuId,scope.row.status)">
                            </el-switch>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

import admin from '@/api/admin';

export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            list: [],
            dialogFormVisible: false,
            userEntity: {},
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        //更新权限状态
        updateRoleStatus(roleid,menuid,status){
            console.log(roleid,menuid,status)
            admin.updateRoleStatus(roleid,menuid,status).then(res =>{
                this.getRoleAndMenu()
            })

        },
        getRoleAndMenu() {
            admin.getRoleAndMenu().then(res => {
                this.list = res.data
            })
        },
    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getRoleAndMenu()
    },
    //生命周期 - 挂载完成（可以访问DOM元素）
    mounted() {

    },
    beforeCreate() { }, //生命周期 - 创建之前
    beforeMount() { }, //生命周期 - 挂载之前
    beforeUpdate() { }, //生命周期 - 更新之前
    updated() { }, //生命周期 - 更新之后
    beforeDestroy() { }, //生命周期 - 销毁之前
    destroyed() { }, //生命周期 - 销毁完成
    activated() { }, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped>
/*@import url(); 引入公共css类*/
</style>