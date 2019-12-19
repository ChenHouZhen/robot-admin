<template>
    <div>
        <el-form style="width:100%">
            <div>
                查询条件
            </div>
        </el-form>
        <el-table :data="table_data" style="width:100%">
            <el-table-column prop="userId" label="用户ID"></el-table-column>
            <el-table-column prop="username" label="用户名"></el-table-column>
            <el-table-column prop="email" label="邮箱"></el-table-column>
            <el-table-column prop="mobile" label="手机号"></el-table-column>
            <el-table-column prop="deptName" label="部门"></el-table-column>
            <el-table-column prop="createTime" label="创建时间"></el-table-column>
            <el-table-column label="头像">
                <template slot-scope="scope">
                    <i @click="view_avatar(scope.row.avatar)" style="cursor: pointer;">
                        <el-avatar size="small" :src="scope.row.avatar" shape='circle'></el-avatar>
                    </i>
                </template>
            </el-table-column>
            <el-table-column label="操作" fixed='right'>
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" icon="el-icon-edit" size="mini">编辑</el-button>
                    <el-button type="danger" size="mini" icon="el-icon-delete">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
        <el-pagination background layout="prev, pager, next" :total="1000"></el-pagination>

        <div  class="custom_avatar_view" v-if="is_show_avatar">
            <span class="el-image-viewer__btn el-image-viewer__close">
                <i class="el-icon-circle-close"></i>
                <img class="custom_avatar_view_image" v-bind:src="show_avatar"/>
            </span>
        </div>

    </div>
</template>


<script>
export default {
    data() {
        return {
            show_avatar:'',
            is_show_avatar:false,
            table_data:[{
                "userId": 88,
                "username": "陈小小",
                "password": "1f04ab269a64457413af789fc142b3526987175c1ae35108f01ee0ad176280a3",
                "salt": "C91keVcTDLmqX4F3cNNz",
                "email": null,
                "mobile": "15622758019",
                "status": true,
                "deptId": 32,
                "createTime": "2019-05-09 17:36:14",
                "avatar": 'https://hqjy-coursetest.oss-cn-shenzhen.aliyuncs.com/image/md/20181227/eefb9829222b45d890bcc737871a9fdc.jpg'
         }],
        }
    },
    methods: {
        view_avatar(src){
            console.log('查看头像：src：'+src)
            this.show_avatar = src;
            this.is_show_avatar = true;
        }
    },  
}
</script>


<style>
    .custom_avatar_view{
        z-index: 2000;
        width: 100%;
        height: 100%;
        background-color: #0000006e;
        position :absolute;
        top: 0px;
        left: 0px;
    }
    .custom_avatar_view_image{
        width: 100%;
        height: 100%;
        display: flex;
        justify-content: center;
        align-items: center;
    }
</style>
