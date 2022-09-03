<!--  -->
<template>
    <div class=''>
        <el-form ref="form" label-width="80px" :model="RandPEntity">
            <el-form-item label="员工编号">
                <el-input style="width: 100px" v-model="RandPEntity.eid"> </el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input style="width: 120px" v-model="RandPEntity.empName"> </el-input>
            </el-form-item>
            <el-form-item label="时间">
                <el-col :span="10">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 100%;" v-model="RandPEntity.ecDate"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="奖惩原因">
                <el-input type="textarea" v-model="RandPEntity.ecReason"></el-input>
            </el-form-item>
            <el-form-item label="奖惩分">
                <el-input v-model="RandPEntity.ecPoint"> </el-input>
            </el-form-item>
            <el-form-item label="奖惩类型">
                <el-input v-model="RandPEntity.ecType"> </el-input>
            </el-form-item>
            <el-form-item label="备注">
                <el-input v-model="RandPEntity.remark"> </el-input>
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
import RandP from '@/api/RandP';
export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            RandPEntity: {
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
            RandP.addRandP(this.RandPEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "添加成功"
                    });
                    this.$router.push({ path: "/employee/RandP/list" });
                })
        },
        update() {
            RandP.updateRandP(this.RandPEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "修改成功!",
                    });
                    //跳转页面，使用路由跳转
                    this.$router.push({ path: "/employee/RandP/list" });
                })
        },
        saveOrUpdate() {
            //判断添加还是修改
            if (!this.RandPEntity.id) {
                // 没有id，就是添加
                this.save();
            } else {
                //有id，做修改
                this.update();
            }
        },
        getRandPById(id){
            RandP.getRandPById(id)
            .then(res =>{
                this.RandPEntity = res.data
            })
        }

    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        //获取路由id值
        if (this.$route.params && this.$route.params.id) {
            const id = this.$route.params.id;
            this.getRandPById(id);
        } else {
            this.RandPEntity = {};
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