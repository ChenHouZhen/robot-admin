<template>
    <div>
        <el-tree :data="data" show-checkbox node-key="id" v-loading="treeLoading" :props="defaultProps"></el-tree>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                treeLoading:false,
                data:[],
                defaultProps:{
                    children:'children',
                    label:'name',
                    key:'id'
                }
            }
        },

        methods: {
            queryDeptTree(){
                let _this = this;
                this.$axios.get('/api/v1/dept/tree')
                .then(function(res){
                    console.log("response",res);
                    if (res && res.status == 200 && res.data.code ==200) {
                        _this.data = res.data.data;
                    }else{
                        _this.$message.error("获取数据失败！")
                    }
                    _this.treeLoading = false;
                })
                .catch(err =>{
                    _this.$message.error("获取数据失败！")
                    _this.treeLoading = false;
                })
                
            },
        },

        mounted:function(){
            this.treeLoading = true;
            this.queryDeptTree();
        }
    }
</script>
