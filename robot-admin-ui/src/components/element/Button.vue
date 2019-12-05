<template>
    <div>
        <h1>{{msg}}</h1>
        <el-button type='primary' @click="login">登陆</el-button>
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


