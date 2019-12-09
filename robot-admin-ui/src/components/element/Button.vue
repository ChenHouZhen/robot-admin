<template>
    <div>
        <el-button type='primary' @click="login">登陆</el-button>
        <ul class="nav" @click="selectNav">
            <li v-for="(item, index) in navList" :key="index" :data-index="index">{{item}}</li>
        </ul>
    </div>
</template>



<<script>
export default {
    name: 'Button',
    data() {
        return {
            msg:"按钮",
            navList:[1,2,3,4,5]
        }
    },
    methods: {
        login(){
            alert("登陆成功")
        },
        selectNav(e){
            console.log("e",e);
            let dom  = e.target;
            console.log(dom);
            let index = dom.getAttribute('data-index');
         
            
            console.log("index:"+ index);
            this.$message("index: "+index +"  value: " );
        }
    },
}
</script>


<style>

    .nav{   
        display: flex;
        justify-content: flex-start;
    }

    .nav > li {
        line-height: 30px;
        box-shadow: 6px 5px 15px 2px rgba(0, 0, 0, 0.349);
        border-radius: 30px;
        width: 30px;
        height: 30px;
        list-style: none;
        margin: 10px;
        cursor: pointer;
        overflow: hidden;
        text-overflow: ellipsis;
    }
</style>


