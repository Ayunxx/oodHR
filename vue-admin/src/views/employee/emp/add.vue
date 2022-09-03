<!--添加页面-->
<template>
    <div class=''>
        <el-form ref="form" label-width="80px" :inline="true" :model="empEntity">
            <el-form-item label="姓名">
                <el-input style="width: 150px;" v-model="empEntity.empName"></el-input>
            </el-form-item>
            <el-form-item label="性别">
                <el-select placeholder="性别" style="width: 80px;" v-model="empEntity.gender">
                    <el-option label="男" value="男"></el-option>
                    <el-option label="女" value="女"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="身份证号">
                <el-input style="width: 300px;" v-model="empEntity.idcard"></el-input>
            </el-form-item>
            <el-form-item label="婚姻状况">
                <el-input style="width: 60px;" v-model="empEntity.forwedlock"></el-input>
            </el-form-item>
            <el-form-item label="民族">
                <el-select placeholder="" style="width: 100px;" v-model="empEntity.nationid">
                    <el-option v-for="item in nation"
                    :key="item.id"
                    :label="item.natName"
                    :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="籍贯">
                <el-input style="width: 60px;" v-model="empEntity.nativeplace"></el-input>
            </el-form-item>
            <el-form-item label="政治面貌">
                <el-select placeholder="" style="width: 80px;" v-model="empEntity.politic">
                    <el-option label="群众" value="群众"></el-option>
                    <el-option label="团员" value="团员"></el-option>
                    <el-option label="党员" value="党员"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="邮箱">
                <el-input style="width: 200px;" v-model="empEntity.email"></el-input>
            </el-form-item>
            <el-form-item label="电话号码">
                <el-input style="width: 200px;" v-model="empEntity.phone"></el-input>
            </el-form-item>
            <el-form-item label="联系地址">
                <el-input style="width: 250px;" v-model="empEntity.address"></el-input>
            </el-form-item>
            <el-form-item label="工号">
                <el-input style="width: 60px;" v-model="empEntity.workid"></el-input>
            </el-form-item>
            <el-form-item label="工龄">
                <el-input style="width: 60px;" v-model="empEntity.workage"></el-input>
            </el-form-item>
            <el-form-item label="合同期限">
                <el-input style="width: 60px;" v-model="empEntity.contractterm"></el-input>
            </el-form-item>
            <el-form-item label="毕业院校">
                <el-input style="width: 200px;" v-model="empEntity.school"></el-input>
            </el-form-item>
            <el-form-item label="所属专业">
                <el-input style="width: 200px;" v-model="empEntity.specialty"></el-input>
            </el-form-item>
            <el-form-item label="所属部门">
                <el-select placeholder="部门" style="width: 100px;" v-model="empEntity.departmentid">
                    <el-option v-for="item in department"
                    :key="item.id"
                    :label="item.departName"
                    :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="职称">
                <el-select placeholder="职称" style="width: 100px;" v-model="empEntity.joblevelid">
                    <el-option v-for="item in jobLevel"
                    :key="item.id"
                    :label="item.jobName"
                    :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="职位">
                <el-select placeholder="职位" style="width: 100px;" v-model="empEntity.posid">
                    <el-option v-for="item in position"
                    :key="item.id"
                    :label="item.posName"
                    :value="item.id"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="聘用形式">
                <el-select placeholder="选择" style="width: 100px;" v-model="empEntity.engageform">
                    <el-option label="校招" value="校招"></el-option>
                    <el-option label="社招" value="社招"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="最高学历">
                <el-select placeholder="学历" style="width: 100px;" v-model="empEntity.tiptopdegree">
                    <el-option label="专科" value="专科"></el-option>
                    <el-option label="本科" value="本科"></el-option>
                    <el-option label="研究生" value="研究生"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="在职状态">
                <el-select placeholder="选择" style="width: 100px;" v-model="empEntity.workstate">
                    <el-option label="在职" value="在职"></el-option>
                    <el-option label="离职" value="离职"></el-option>
                </el-select>
            </el-form-item>
            <el-form-item label="出生日期">
                <el-col :span="4">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 200px;" v-model="empEntity.birthday">
                    </el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="入职日期">
                <el-col :span="4">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 200px;" v-model="empEntity.begindate">
                    </el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="转正日期">
                <el-col :span="4">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 200px;"
                        v-model="empEntity.conversiontime"></el-date-picker>
                </el-col>
            </el-form-item>
            <el-form-item label="合同起始">
                <el-col :span="4">
                    <el-date-picker type="date" placeholder="选择日期" style="width: 200px;"
                        v-model="empEntity.begincontract"></el-date-picker>
                </el-col>
            </el-form-item>
            <br />
            <el-form-item>
                <el-button type="primary" @click="saveOrUpdate()">提交</el-button>
                <el-button>取消</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import employee from '@/api/employee';
export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            empEntity: {

            },
            nation: [],
            department: [],
            jobLevel: [],
            position: [],
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        //获取职位
        getposition(){
            employee.getPositionList()
            .then(res =>{
                this.position = res.data
            })
        },
        //获取职称
        getJobLevel(){
            employee.getJobLevelList()
            .then(res =>{
                this.jobLevel = res.data
            })
        },
        //获取部门
        getDepartment(){
            employee.getDepartmentList()
            .then(res =>{
                this.department = res.data
            })
        },
        //获取民族
        getNation(){
            employee.getNationList()
                .then(res =>{
                    this.nation = res.data
                })
        },
        save() {
            employee.addEmployee(this.empEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "添加成功"
                    });
                    this.$router.push({ path: "/employee/emp/list" });
                })
        },
        update() {
            employee.updateEmployee(this.empEntity)
                .then(res => {
                    //提示信息
                    this.$message({
                        type: "success",
                        message: "修改成功!",
                    });
                    //跳转页面，使用路由跳转
                    this.$router.push({ path: "/employee/emp/list" });
                })
        },
        saveOrUpdate() {
            //判断添加还是修改
            if (!this.empEntity.id) {
                // 没有id，就是添加
                this.save();
            } else {
                //有id，做修改
                this.update();
            }
        },

        //根据id查询
        getEmployeeById(id) {
            employee.getEmployeeById(id)
                .then(res => {
                    this.empEntity = res.data

                });
        }

    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getNation()
        this.getDepartment()
        this.getJobLevel()
        this.getposition()
        //获取路由id值
        if (this.$route.params && this.$route.params.id) {
            const id = this.$route.params.id;
            this.getEmployeeById(id);
        } else {
            this.empEntity = {};
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