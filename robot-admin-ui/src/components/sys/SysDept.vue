<template>
    <div>
        <el-input placeholder="输入关键字进行过滤" v-model="filterText">

        </el-input>
        <el-tree :data="data" node-key="id" :expand-on-click-node="true" :render-content="renderContent" 
        :props="defaultProps" :filter-node-method="filterNode" ref="tree">
        </el-tree>

        <el-dialog title="新增部门" :visible.sync="addFormVisible">
            <el-form :model="addForm">
              <el-form-item label="上级部门ID" >
                  <el-input :disabled="true" v-model="addForm.pDeptId" placeholder=""></el-input>
              </el-form-item>
              <el-form-item label="部门名">
                  <el-input v-model="addForm.deptName" placeholder=""></el-input>
              </el-form-item>
              <el-form-item label="排序">
                  <el-input v-model="addForm.orderNum" placeholder=""></el-input>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="addFormVisible=false">取 消</el-button>
                <el-button type="primary" @click="append()">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>



<script>
export default {
    data() {
        return {
            addForm:{
                deptName:'',
                orderNum: '',
                pDeptId:'',
            },
            filterText:'',
            clickNodeId:'',
            clickData:{},
            data:[],
            addFormVisible:false,
            defaultProps:{
                children:'children',
                label:'name',
                key:'id'
            }
        }
    },
    watch: {
      filterText(val) {
        this.$refs.tree.filter(val);
      }
    },
    
    methods:{

        queryDeptTree(){
            let _this = this;
            this.$axios.get('/api/dept/tree')
            .then(function(res){
                console.log("response",res);
                if (res && res.status == 200 && res.data.code ==200) {
                    _this.data = res.data.data;
                }else{
                    this.$message.error("获取数据失败！")
                }
            })
            .catch(err =>{
                this.$message.error("获取数据失败！")
                console.log(err);
            })
        },
        showAddForm(node,data){
            console.log(">>>>> node",node);
            this.addFormVisible=false;
            this.addForm.pDeptId = node.key;
            this.clickData = data;
            console.log(">>>>> pDeptId",this.addForm.pDeptId);
            console.log(">>>>> clickData",this.clickData);
            console.log(">>>>> this.$refs.tree",this.$refs.tree);
            // this.$refs 是啥？
             console.log(">>>>> node",this.$refs.tree.getNode(node.key));
            this.addFormVisible=true;
        },

        cleanAddForm(){
            this.addForm.deptName='';
            this.addForm.orderNum='';
            this.addForm.pDeptId='';
        },

        append(){
            let _this = this;
            console.log(">>>>> 新增");
            console.log(">>>>> form",this.addForm);
            let addParams = {"deptName":this.addForm.deptName,"orderNum":this.addForm.orderNum,"pid":this.addForm.pDeptId}
           
            this.$axios.post('/api/dept',addParams)
            .then(res => {
                console.log("res",res);
                const newChild = {id:res.data.data.deptId,name:res.data.data.name, children: []};
                console.log("111",newChild);
                _this.clickData.children.push(newChild);
            })
            .catch(err =>{
                this.$message.error("新增数据失败！")
                console.log(err);
            })
            this.cleanAddForm();
            this.addFormVisible=false;
        },

        remove(node, data){
            console.log(">>>>> 删除, params",node,data);

        },

        filterNode(value, data){
            console.log(">>>>> 调用 filter 方法");
            if(!value){
                return true;
            }
            return data.name.indexOf(value)!== -1
        },
        
        renderContent(h, { node, data, store }){
            return(
                <span class="custom-tree-node">
                    <span>{node.label}</span>
                    <span>
                        <el-button size="mini" type="text" on-click={() => {this.showAddForm(node,data)}}>Append</el-button>
                        <el-button size="mini" type="text" on-click={() => this.remove(node,data)}>Delete</el-button>
                    </span>
                </span>

            )
        }
    },
    mounted:function(){
        this.queryDeptTree();
    }
}
</script>



<style>

    .custom-tree-node{
        display: flex;
        align-items: center;
        justify-content: space-between;
        font-size: 14px;
        padding-right: 8px;
        flex:1;
    }
</style>
