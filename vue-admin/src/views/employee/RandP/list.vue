<!--  -->
<template>
    <div class=''>
        <el-table :data="list" style="width: 100%;" border>
            <el-table-column type="index" label="序号" width="80" align="center"></el-table-column>
            <el-table-column prop="workId" label="工号" width="100" align="center"></el-table-column>
            <el-table-column prop="empName" label="姓名" width="100" align="center"></el-table-column>
            <el-table-column prop="ecReason" label="奖罚原因" align="center"></el-table-column>
            <el-table-column prop="ecPoint" label="奖罚分" align="center" width="80"></el-table-column>
            <el-table-column prop="ecType" label="奖罚类别" align="center" width="80"></el-table-column>
            <el-table-column prop="ecDate" label="时间" width="100" align="center"></el-table-column>
            <el-table-column prop="remark" label="备注" align="center" width="180"></el-table-column>
            <el-table-column label="操作" width="180" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/employee/RandP/edit/' + scope.row.id">
                        <el-button type="primary" icon="el-icon-edit"></el-button>
                    </router-link>
                    <el-button type="danger" icon="el-icon-delete" @click="deleteById(scope.row.id)">
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
import RandP from '@/api/RandP';
export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            current: 1,
            size: 8,
            list: [],
            total: 0,
            page: 0,
            serachObj: {},

        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        deleteById(id) {
            this.$confirm('此操作将永久删除数据, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                //调用删除接口
                RandP.deleteRandPById(id)
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
        },
        getList(page = 1) {
            this.current = page
            RandP.getListPage(this.current, this.size, this.serachObj)
                .then(res => {
                    this.list = res.data.records
                    this.total = res.data.total
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