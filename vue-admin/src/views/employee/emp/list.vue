<template>
    <div class=''>
        <el-form :inline="true" class="demo-form-inline">
            <el-form-item label="工号">
                <el-input v-model="searchObj.workid"></el-input>
            </el-form-item>
            <el-form-item label="姓名">
                <el-input v-model="searchObj.name"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="getList()">查询</el-button>
            </el-form-item>
        </el-form>
        <el-table :data="list" border style="width: 100%; height: 100%">
            <el-table-column type="selection" width="55" />
            <el-table-column prop="id" label="编号" width="50"></el-table-column>
            <el-table-column prop="workid" label="工号" width="80"></el-table-column>
            <el-table-column prop="empName" label="姓名" width="80"></el-table-column>
            <el-table-column prop="workage" label="工龄" width="80"></el-table-column>
            <el-table-column prop="gender" label="性别" width="50"></el-table-column>
            <el-table-column prop="birthday" label="出生年月" width="120"></el-table-column>
            <el-table-column prop="idcard" label="身份证号" width="120"></el-table-column>
            <el-table-column prop="wedlock" label="婚姻" width="50"></el-table-column>
            <el-table-column prop="nationname" label="民族" width="60"></el-table-column>
            <el-table-column prop="nativeplace" label="籍贯" width="60"></el-table-column>
            <el-table-column prop="politic" label="政治面貌" width="60"></el-table-column>
            <el-table-column prop="email" label="邮箱" width="180"></el-table-column>
            <el-table-column prop="phone" label="联系电话" width="120"></el-table-column>
            <el-table-column prop="address" label="地址" width="180"></el-table-column>
            <el-table-column prop="departmentname" label="所属部门" width="80"></el-table-column>
            <el-table-column prop="joblevelname" label="职称" width="50"></el-table-column>
            <el-table-column prop="posname" label="职位" width="60"></el-table-column>
            <el-table-column prop="engageform" label="聘用形式" width="60"></el-table-column>
            <el-table-column prop="tiptopdegree" label="最高学历" width="60"></el-table-column>
            <el-table-column prop="specialty" label="所属专业" width="80"></el-table-column>
            <el-table-column prop="school" label="毕业院校" width="100"></el-table-column>
            <el-table-column prop="begindate" label="入职日期" width="120"></el-table-column>
            <el-table-column prop="workstate" label="在职状态" width="60"></el-table-column>
            <el-table-column prop="contractterm" label="合同期限" width="120"></el-table-column>
            <el-table-column prop="conversiontime" label="转正日期" width="120"></el-table-column>
            <el-table-column prop="notworkdate" label="离职日期" width="120"></el-table-column>
            <el-table-column prop="begincontract" label="合同起始日期" width="120"></el-table-column>
            <el-table-column prop="endcontract" label="合同终止日期" width="120"></el-table-column>
            <el-table-column label="操作" width="180" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/employee/emp/edit/' + scope.row.id">
                        <el-button type="primary" icon="el-icon-edit"></el-button>
                    </router-link>
                    <el-button type="danger" icon="el-icon-delete"  @click="deleteEmployee(scope.row.id)">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>

        <!-- 分页 -->
        <el-pagination :current-page="page" :page-size="size" :total="total" style="padding: 30px 0; text-align: center"
            layout="total, prev, pager, next, jumper" @current-change="getList()" />
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import employee from '@/api/employee'
export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            searchObj: {},
            page: 0,
            current: 1,  //当前页
            size: 8, //每页显示多少条
            list: [], //每页集合
            total: 0 //总记录数
        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        getList(page = 1) {
            this.current = page;
            employee.getEmployeeList(this.current, this.size,this.searchObj)
                .then(res => {
                    this.list = res.data.records
                    this.total = res.data.total
                })
        },
        deleteEmployee(id) {
            this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                //调用删除接口
                employee.deleteEmployeeById(id)
                    .then(res => {
                        this.$message({
                            type: 'success',
                            message: '删除成功!'
                        });
                        //刷新页面
                        this.getList(1);
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });
            })

        }

    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getList()
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