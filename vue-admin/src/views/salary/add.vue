<!--  -->
<template>
<div class=''>
   <el-form :inline="true" ref="form" label-width="80px" :model="salaryEntity">
            <el-form-item label="员工编号">
                <el-input style="width: 100px" v-model="salaryEntity.eid"> </el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input style="width: 120px" v-model="salaryEntity.empName"> </el-input>
            </el-form-item>
            <br>
            <el-form-item label="基本工资" >
                <el-input style="width: 120px" v-model="salaryEntity.basicSalary"> </el-input>
            </el-form-item>
            <el-form-item label="奖金">
                <el-input style="width: 80%;" v-model="salaryEntity.bonus"></el-input>
            </el-form-item>
            <el-form-item label="午餐补助">
                <el-input style="width: 100px;" v-model="salaryEntity.lunchSalary"> </el-input>
            </el-form-item>
            <el-form-item label="交通补助">
                <el-input v-model="salaryEntity.trafficSalary"> </el-input>
            </el-form-item>
            <el-form-item label="应发工资">
                <el-input v-model="salaryEntity.allSalary"> </el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input v-model="salaryEntity.remark"> </el-input>
            </el-form-item>
            <br>
            <el-form-item>
                <el-button type="primary" @click="saveOrUpdate">提交</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
</div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import salary from '@/api/salary';
export default {
//import引入的组件需要注入到对象中才能使用
components: {},
data() {
//这里存放数据
return {
    salaryEntity: {},

};
},
//监听属性 类似于data概念
computed: {},
//监控data中的数据变化
watch: {},
//方法集合
methods: {
    save() {
        salary.addSalary(this.salaryEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "添加成功"
                    });
                    this.$router.push({ path: "/salary/list" });
                })
        },
        update() {
            salary.upDateSalaryById(this.salaryEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "修改成功!",
                    });
                    //跳转页面，使用路由跳转
                    this.$router.push({ path: "/salary/list" });
                })
        },
        saveOrUpdate() {
            //判断添加还是修改
            if (!this.salaryEntity.id) {
                // 没有id，就是添加
                this.save();
            } else {
                //有id，做修改
                this.update();
            }
        },
        getSalaryById(id){
            salary.getSalaryById(id)
            .then(res =>{
                this.salaryEntity = res.data
            })
        }
    },
//生命周期 - 创建完成（可以访问当前this实例）
created() {
//获取路由id值
        if (this.$route.params && this.$route.params.id) {
            const id = this.$route.params.id;
            this.getSalaryById(id);
        } else {
            this.trainEntity = {};
        }

    },
//生命周期 - 挂载完成（可以访问DOM元素）
mounted() {

},
beforeCreate() {}, //生命周期 - 创建之前
beforeMount() {}, //生命周期 - 挂载之前
beforeUpdate() {}, //生命周期 - 更新之前
updated() {}, //生命周期 - 更新之后
beforeDestroy() {}, //生命周期 - 销毁之前
destroyed() {}, //生命周期 - 销毁完成
activated() {}, //如果页面有keep-alive缓存功能，这个函数会触发
}
</script>
<style scoped>
/*@import url(); 引入公共css类*/

</style>