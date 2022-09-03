<!--  -->
<template>
    <div class=''>
        <el-table :data="list" border style="width: 100%" >
            <el-table-column type="index" label="序号" width="50"></el-table-column>
            <el-table-column prop="menuName" label="菜单名" width="120"></el-table-column>
            <el-table-column prop="component" label="组件地址" width="120"></el-table-column>
            <el-table-column prop="path" label="路由地址" width="120"></el-table-column>
            <el-table-column prop="status" label="菜单状态" width="120"></el-table-column>
            <el-table-column prop="perms" label="权限表示" width="180"></el-table-column>
            <el-table-column prop="createBy" label="创建人" width="100"></el-table-column>
            <el-table-column prop="createTime" label="创建时间" width="100"></el-table-column>
            <el-table-column prop="updateBy" label="更新人" width="100"></el-table-column>
            <el-table-column prop="updateTime" label="更新时间" width="100"></el-table-column>
            <el-table-column prop="remark" label="备注" width="75"></el-table-column>
            <el-table-column label="操作" width="120" align="center">
                <template slot-scope="scope">
                    <router-link :to="'/admin/menu/edit/' + scope.row.id">
                        <el-button type="primary" icon="el-icon-edit" size="mini"></el-button>
                    </router-link>
                    <el-button type="danger" icon="el-icon-delete" size="mini" @click="deleteById(scope.row.id)">
                    </el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
//这里可以导入其他文件（比如：组件，工具js，第三方插件js，json文件，图片文件等等）
//例如：import 《组件名称》 from '《组件路径》';

import admin from '@/api/admin';

export default {
    //import引入的组件需要注入到对象中才能使用
    components: {},
    data() {
        //这里存放数据
        return {
            list: [],

        };
    },
    //监听属性 类似于data概念
    computed: {},
    //监控data中的数据变化
    watch: {},
    //方法集合
    methods: {
        getMenuList(){
            admin.getMenuList().then(res =>{
                this.list = res.data
            })
        },

    },
    //生命周期 - 创建完成（可以访问当前this实例）
    created() {
        this.getMenuList()

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