<!--  -->
<template>
<div class=''>
    <el-table :data="list" border style="width: 100%;">
            <el-table-column type="index" label="序号" width="100"></el-table-column>
            <el-table-column prop="workId" label="工号" width="100"></el-table-column>
            <el-table-column prop="empName" label="姓名" width="120"></el-table-column>
            <el-table-column prop="beforeSalary" label="调前薪资" width="180"></el-table-column>
            <el-table-column prop="afterSalary" label="调后薪资" width="180"></el-table-column>
            <el-table-column prop="reason" label="调薪原因" width="180"></el-table-column>
            <el-table-column prop="asDate" label="调薪日期" width="180"></el-table-column>
            <el-table-column prop="remark" label="备注"></el-table-column>
        </el-table>
        <el-pagination :current-page="page" :page-size="size" :total="total" style="padding: 30px 0; text-align: center"
            layout="total, prev, pager, next, jumper" @current-change="getList" />
</div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';
import changesalary from '@/api/changesalary'
export default {
//import引入的组件需要注入到对象中才能使用
components: {},
data() {
//这里存放数据
return {
    list:[],
    page: 0,
    current: 1,
    size: 8,
    total: 0,
    searchObj: {},

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
        changesalary.getListPage(this.current,this.size,this.searchObj)
                    .then(res =>{
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