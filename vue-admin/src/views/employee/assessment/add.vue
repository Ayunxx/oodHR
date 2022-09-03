<!--  -->
<template>
    <div class=''>
        <el-form ref="form" label-width="80px" :model="assessmentEntity">
            <el-form-item label="员工编号">
                <el-input style="width: 100px" v-model="assessmentEntity.eid"> </el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input style="width: 120px" v-model="assessmentEntity.empName"> </el-input>
            </el-form-item>
            <el-form-item label="时间">
                <el-col :span="10">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 100%;"  v-model="assessmentEntity.appDate"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="考核内容">
                <el-input type="textarea" style="width: 80%;"  v-model="assessmentEntity.appContent"></el-input>
            </el-form-item>
            <el-form-item label="考核结果">
                <el-input style="width: 100px;"  v-model="assessmentEntity.appResult"> </el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input v-model="assessmentEntity.remark"> </el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="saveOrUpdate()">立即创建</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

import assessment from '@/api/assessment';

export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            assessmentEntity: {

            },

        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        save() {
            assessment.addAssessment(this.assessmentEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "添加成功"
                    });
                    this.$router.push({ path: "/employee/assessment/list" });
                })
        },
        update() {
            assessment.updateAssessment(this.assessmentEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "修改成功!",
                    });
                    //跳转页面，使用路由跳转
                    this.$router.push({ path: "/employee/assessment/list" });
                })
        },
        saveOrUpdate() {
            //判断添加还是修改
            if (!this.assessmentEntity.id) {
                // 没有id，就是添加
                this.save();
            } else {
                //有id，做修改
                this.update();
            }
        },
        getAssessmentById(id){
            assessment.getAssessmentById(id)
            .then(res =>{
                this.assessmentEntity = res.data
            })
        }

    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        //获取路由id值
        if (this.$route.params && this.$route.params.id) {
            const id = this.$route.params.id;
            this.getAssessmentById(id);
        } else {
            this.assessmentEntity = {};
        }
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