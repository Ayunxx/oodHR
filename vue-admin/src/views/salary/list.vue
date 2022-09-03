<!--  -->
<template>
    <div class=''>
        <el-table :data="list" border style="width: 100%;">
            <el-table-column type="index" label="序号" width="100"></el-table-column>
            <el-table-column prop="workID" label="工号" width="100"></el-table-column>
            <el-table-column prop="empName" label="姓名" width="120"></el-table-column>
            <el-table-column prop="basicSalary" label="基本工资" width="100"></el-table-column>
            <el-table-column prop="bonus" label="奖金" width="100"></el-table-column>
            <el-table-column prop="lunchSalary" label="午餐补助" width="80"></el-table-column>
            <el-table-column prop="trafficSalary" label="交通补助" width="80"></el-table-column>
            <el-table-column prop="allSalary" label="应发工资" width="80"></el-table-column>
            <el-table-column prop="remark" label="备注" align="center"></el-table-column>
            <el-table-column label="操作" width="180" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/salary/edit/' + scope.row.id">
                        <el-button type="primary" icon="el-icon-edit"></el-button>
                    </router-link>
                    <el-button type="danger" icon="el-icon-delete"  @click="deleteById(scope.row.id)">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination :current-page="page" :page-size="size" :total="total" style="padding: 30px 0; text-align: center"
            layout="total, prev, pager, next, jumper" @current-change="getList" />
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import salary from  '@/api/salary'

export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            list:[],
            searchObj: {},
            current: 1,
            size: 8,
            page: 0,
            total: 0,

        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        getList(page = 1){
            this.current = page
            salary.getListPage(this.current,this.size,this.searchObj)
                  .then(res =>{
                    this.list =  res.data.records
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