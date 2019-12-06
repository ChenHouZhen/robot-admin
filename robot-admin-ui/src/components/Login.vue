<template>
    <el-form>
        <h3>系统登录</h3>
        <el-form-item class="input">
            <el-input placeholder="账号"></el-input>
        </el-form-item>

        <el-form-item class="input">
            <el-input placeholder="密码"></el-input>
        </el-form-item>

        <el-form-item>
            <el-checkbox>记住密码</el-checkbox>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" class="login_button">登录</el-button>
        </el-form-item>
    </el-form>
</template>


<script>
export default {
    
}
</script>


<style>
    .el-form{
        margin: 0 auto;
        margin-top: 160px;
        border:1px solid red;
        width: 450px;
        border-radius: 18px;
    }
    .input{
        margin: 0 auto;
        margin-bottom: 20px;
        width: 380px;
    }

    .el-form h3{
        margin-top: 40px;
        margin-bottom: 35px;
    }

    .login_button{
        width: 380px;;
    }

</style>
