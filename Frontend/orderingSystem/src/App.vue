<template>
    <div id="app">
      <login-form />
      kjm
    </div>
  </template>
  
  <script>
  import LoginForm from "./view/LoginForm.vue";
  
  export default {
    name: "App",
    components: {
      LoginForm,
    },
  };
  </script>
  
  <style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
  }
  </style>