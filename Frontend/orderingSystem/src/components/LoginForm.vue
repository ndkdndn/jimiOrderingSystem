<template>
  <div class="login-container">
    <div class="login-header"></div>
    <div class="login-background">
      <transition name="el-fade-in-linear">
        <div
          v-if="view==='register'"
          class="login-form-container register-form-container"
        >
          <el-form key="register" ref="registerForm" :model="registerForm" :rules="registerRules" class="login-form" auto-complete="on" label-position="left">
            <div class="title-container">
              <h3 class="title">注册</h3>
            </div>
            <el-form-item prop="username">
          <span class="svg-container">
            <svg-icon icon-class="user" />
          </span>
              <el-input
                ref="username"
                v-model="registerForm.username"
                placeholder="用户名"
                name="usernameregister_doe"
                type="text"
                tabindex="1"
                auto-complete="on"
              />
            </el-form-item>
            <el-form-item prop="password">
          <span class="svg-container">
            <svg-icon icon-class="password" />
          </span>
              <el-input
                :key="passwordType['register1']+'register1'"
                ref="passwordregister1"
                v-model="registerForm.password"
                :type="passwordType['register1']"
                placeholder="密码"
                name="passwordregister1_doe"
                tabindex="2"
                auto-complete="on"
                @keyup.enter="handleLogin"
              />
              <span class="show-pwd" @click="showPwd('register1')">
            <svg-icon :icon-class="passwordType['register1'] === 'password' ? 'eye' : 'eye-open'" />
          </span>
            </el-form-item>
            <el-form-item prop="passwordConfirm">
          <span class="svg-container">
            <svg-icon icon-class="password" />
          </span>
              <el-input
                :key="passwordType['register2']+'register2'"
                ref="passwordregister2"
                v-model="registerForm.passwordConfirm"
                :type="passwordType['register2']"
                placeholder="确认密码"
                name="passwordregister2_doe"
                tabindex="3"
                auto-complete="on"
                @keyup.enter="handleLogin"
              />
              <span class="show-pwd" @click="showPwd('register2')">
            <svg-icon :icon-class="passwordType['register2'] === 'password' ? 'eye' : 'eye-open'" />
          </span>
            </el-form-item>
            <el-form-item prop="department">
          <span class="svg-container">
            <svg-icon icon-class="building-solid" />
          </span>
              <el-input
                ref="department"
                v-model="registerForm.department"
                placeholder="部门"
                name="department_doe"
                type="text"
                tabindex="4"
                auto-complete="on"
              />
            </el-form-item>
            <el-form-item prop="tel">
          <span class="svg-container">
            <svg-icon icon-class="phone-solid" />
          </span>
              <el-input
                ref="tel"
                v-model="registerForm.tel"
                placeholder="电话"
                name="tel_doe"
                type="text"
                tabindex="5"
                auto-complete="on"
              />
            </el-form-item>
            <el-form-item prop="email">
          <span class="svg-container">
            <svg-icon icon-class="envelope-solid" />
          </span>
              <el-input
                ref="email"
                v-model="registerForm.email"
                placeholder="邮件"
                name="email_doe"
                type="text"
                tabindex="6"
                auto-complete="on"
              />
            </el-form-item>
            <el-button :loading="loading" type="primary" @click.prevent="handleRegister">注册</el-button>
            <div class="tips">
              <el-link :underline="false" @click="toggleView">前往登录</el-link>
            </div>
          </el-form>
        </div>
      </transition>
      <transition name="el-fade-in-linear">
        <div
          v-if="view==='login'"
          class="login-form-container"
        >
          <el-form key="login" ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form" auto-complete="on" label-position="left">
            <div class="title-container">
              <h3 class="title">用户登录</h3>
            </div>
            <el-form-item prop="username">
          <span class="svg-container">
            <svg-icon icon-class="user" />
          </span>
              <el-input
                ref="username"
                v-model="loginForm.username"
                placeholder="用户名"
                name="usernamelogin_doe"
                type="text"
                tabindex="1"
                auto-complete="on"
              />
            </el-form-item>
            <el-form-item prop="password">
          <span class="svg-container">
            <svg-icon icon-class="password" />
          </span>
              <el-input
                :key="passwordType['login']+'login'"
                ref="passwordlogin"
                v-model="loginForm.password"
                :type="passwordType['login']"
                placeholder="密码"
                name="passwordlogin_doe"
                tabindex="2"
                auto-complete="on"
                @keyup.enter="handleLogin"
              />
              <span class="show-pwd" @click="showPwd('login')">
            <svg-icon :icon-class="passwordType['login'] === 'password' ? 'eye' : 'eye-open'" />
          </span>
            </el-form-item>
            <el-button :loading="loading" type="primary" @click.prevent="handleLogin">登录</el-button>
            <div class="tips">
              <el-link :underline="false" @click="toggleView">注册</el-link>
            </div>
          </el-form>
        </div>
      </transition>
    </div>
    <div class="login-feature">
      <table class="login-feature-table">
        <tr>
        </tr>
        <tr style="height: 40px;">
        </tr>
      </table>
    </div>
    <div class="login-footer">版权所有© Copyright 2022</div>
  </div>
</template>
  
  <script>
  import { ref } from "vue";
  
  export default {
    name: "LoginForm",
    setup() {
      const username = ref("");
      const password = ref("");
      const isSubmitting = ref(false);
  
      const handleSubmit = () => {
        if (!username.value || !password.value) {
          alert("用户名和密码不能为空！");
          return;
        }
  
        isSubmitting.value = true;
  
        // 模拟登录逻辑
        setTimeout(() => {
          alert(`登录成功！用户名：${username.value}`);
          isSubmitting.value = false;
        }, 1000);
      };
  
      return {
        username,
        password,
        isSubmitting,
        handleSubmit,
      };
    },
  };
  </script>
  
  <style lang="scss">
/* 修复input 背景不协调 和光标变色 */
/* Detail see https://github.com/PanJiaChen/vue-element-admin/pull/927 */

$bg:#283443;
$light_gray:#fff;
$cursor: #fff;

//@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
//  .login-container .el-input input {
//    color: $cursor;
//  }
//}

/* reset element-ui css */
//.login-container {
//  .el-input {
//    display: inline-block;
//    height: 47px;
//    width: 85%;
//
//    input {
//      background: transparent;
//      border: 0px;
//      -webkit-appearance: none;
//      border-radius: 0px;
//      padding: 12px 5px 12px 15px;
//      color: $light_gray;
//      height: 47px;
//      caret-color: $cursor;
//
//      &:-webkit-autofill {
//        box-shadow: 0 0 0px 1000px $bg inset !important;
//        -webkit-text-fill-color: $cursor !important;
//      }
//    }
//  }
//
//  .el-form-item {
//    border: 1px solid rgba(255, 255, 255, 0.1);
//    background: rgba(0, 0, 0, 0.1);
//    border-radius: 5px;
//    color: #454545;
//  }
//}
</style>

<style lang="scss" scoped>
$bg:#2d3a4b;
$dark_gray:#889aa4;
$light_gray:#eee;
$light:#fff;

.login-container {
  position: relative;
  background: rgb(251, 253, 255);
  height: 100%;
  display: flex;
  flex-flow: column;
  .login-header{
    height: 15%;
  }
  .login-background{
    height: 443px;
    width: 100%;
    background: rgba(0, 21, 52, 0.22) url('~@/assets/login/bg.jpg') no-repeat center center;
    .login-form-container {
      background: rgba(41, 70, 90, 0.5);
      width: 360px;
      height: auto;
      overflow: hidden;
      top: calc(15% + 80px);
      left: calc(50% + 210px);
      position: absolute;
      border-radius: 5px;
      padding: 22px 30px;
      .el-input{
        width: 270px;
        padding: 0px 0px;
      }
      .el-button{
        z-index: 9999;
        width: 100%;
        margin-bottom:10px;
      }
      .el-form-item {
        margin-bottom: 12px;
       ::v-deep.el-form-item__error{
          margin-top: -8px;
         left: 30px;
        }
      }
      .title {
        font-size: 26px;
        color: $light;
        margin: 0px auto 20px auto;
        text-align: left;
        font-weight: bold;
      }
      .svg-container {
        padding: 6px 5px 6px 0px;
        color: $light;
        vertical-align: middle;
        width: 30px;
        display: inline-block;
      }
      .show-pwd {
        position: absolute;
        right: 10px;
        top: 5px;
        font-size: 16px;
        color: $light;
        cursor: pointer;
        user-select: none;
      }
      .el-link {
        z-index: 9999;
        color: $light;
      }
      .el-link:hover{
        color: #67b1ff;
      }
      .tips {
        font-size: 14px;
        color: $light;
        text-align: right;
        span {
          &:first-of-type {
            margin-right: 16px;
          }
        }
      }
    }
  }
  .login-feature{
    flex-grow: 1;
    text-align: center;
    width: 100%;
    .login-feature-table{
      margin: 0 auto;
      position: relative;
      top: calc(50% - 62px);
      width: 90%;
      .width-control{
        width: 20%;
        .module-img {
          height: 64px;
          width: 64px;
        }
      }
      .module-text {
        font-size: 18px;
        line-height: 26px;
        display: block;
        text-align: center;
      }
    }
  }
  .login-footer {
    background-color: rgb(251, 253, 255);
    width: 100%;
    text-align: center;
    padding-bottom: 10px;
  }
}
.register-form-container {
  z-index: 1;
  top: -50px!important;
  background: rgba(41, 70, 90, 0.9) !important;
  left: calc(50% - 180px)!important;
  position: relative!important; // 使用fixed会导致注册框被下方区域遮挡且z-index无效
}
</style>