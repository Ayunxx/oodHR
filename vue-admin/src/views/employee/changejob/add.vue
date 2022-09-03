<!--  -->
<template>
<div class=''>
    <el-form ref="form" label-width="100px"  :inline="true" :model="changejobEntity">
            <el-form-item label="员工编号">
                <el-input style="width: 100px" v-model="changejobEntity.eid"> </el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input style="width: 120px" v-model="changejobEntity.empName"> </el-input>
            </el-form-item>
            <el-form-item label="调整时间">
                <el-col :span="20">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 100%;" v-model="changejobEntity.removeDate"></el-date-picker>
                </el-col>
            </el-form-item>
            <br>
            <el-form-item label="调整前职位" >
                <el-input style="width: 80%;" v-model="changejobEntity.jobName"></el-input>
            </el-form-item>
            <el-form-item label="调整后职位">
                <el-input style="width: 80%;" v-model="changejobEntity.afterJobId"> </el-input>
            </el-form-item>
            <br>
            <el-form-item label="调整前部门">
                <el-input  style="width: 80%;" v-model="changejobEntity.departName"></el-input>
            </el-form-item>
            <el-form-item label="调整后部门">
                <el-input style="width: 80%;" v-model="changejobEntity.afterDepId"> </el-input>
            </el-form-item>
            <br>
            <el-form-item label="调整原因">
                <el-input type="textarea" style="width: 500px" v-model="changejobEntity.removeDate"> </el-input>
            </el-form-item>
            <br>
            <el-form-item label="备注">
                <el-input> </el-input>
            </el-form-item>
            <br>
            <el-form-item >
                <el-button type="primary">立即创建</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
</div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

export default {
//import引入的组件需要注入到对象中才能使用
components: {},
data() {
//这里存放数据
return {
    changejobEntity: {},

};
},
//监听属性 类似于data概念
computed: {},
//监控data中的数据变化
watch: {},
//方法集合
methods: {
    

},
//生命周期 - 创建完成（可以访问当前this实例）
created() {

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