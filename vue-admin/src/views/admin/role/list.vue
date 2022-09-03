<!--  -->
<template>
    <div class=''>
        <el-button type="primary" @click="dialogFormVisible = true" class="adduserbttn">新建用户</el-button>
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
        <el-row>
            <el-col :span="5" v-for="item in user" :key="item.id">
                <el-card align="middle">
                    <img style="border-radius:50%;
                            overflow:hidden;
                            width: 100px;
                            height: 100px;" :src="item.avatar" class="image">
                    <div style="padding: 14px;">
                        <span>用户名：{{ item.username }}</span><br>
                        <span>角色：{{ item.roleName }}</span><br>
                        <span>联系电话：{{ item.phone }}</span><br>
                        <span>备注：{{ item.remark }}</span><br>
                        <div class="bottom clearfix">
                            <span>状态：</span>
                            <el-switch v-model="item.status" active-color="#13ce66" inactive-color="#ff4949"
                                :active-value="0" :inactive-value="1" @change="updateUserStatus(item.id, item.status)">
                            </el-switch>
                        </div>
                        <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteById(item.id)" class="rrr"></el-button>
                    </div>
                </el-card>
            </el-col>
        </el-row>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import admin from '@/api/admin'
export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            user: [],
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
        //删除
        deleteById(id){
            this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                //调用删除接口
                admin.deleteUserById(id)
                    .then(res => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        //刷新页面
                        this.getuserrole();
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
            })
        },
        //新建
        save(){
            admin.addUser(this.userEntity)
            .then(res =>{
                //提示信息
                this.$message({
                        type: "success",
                        message: "添加成功"
                    });
                    this.dialogFormVisible = false
            })

        },
        //更新用户状态
        updateUserStatus(id, status) {
            console.log(id)
            console.log(status)
            admin.updateUserStatusById(id, status)
                .then(res => {
                    this.getuserrole()
                })

        },
        getuserrole() {
            admin.getUserRole()
                .then(res => {
                    this.user = res.data
                })
        },


    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getuserrole()
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
.el-card {
    min-width: 100px;
    margin: 15px 15px 15px 15px;
    transition: all .5s;
}

.el-card:hover {
    margin-top: -1px;
}

.mid {
    margin-top: 25%;
    height: 50%;
}
.adduserbttn {
    margin-left: 15px;
    margin-top: 15px;
}
.rrr {
    margin-left: 160px;
}
</style>