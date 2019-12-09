<template>
    <div>
        <el-button type='primary' @click="login">登陆</el-button>
        <ul class="nav">
            <li value="1">1</li>
            <li value="1">2</li>
            <li value="1">3</li>
            <li value="1">4</li>
        </ul>
    </div>
</template>



<<script>
export default {
    name: 'Button',
    data() {
        return {
            msg:"按钮"
        }
    },
    methods: {
        login(){
            alert("登陆成功")
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
    }
</style>


