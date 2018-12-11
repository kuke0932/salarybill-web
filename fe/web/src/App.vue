<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'app'
}
</script>

<style lang="less">
/*@import './assets/styles/common.less';*/
@import '~vux/src/styles/reset.less';

body {
  background-color: #fbf9fe;
}
a{
  color:#666;
}
a:visited{
  color:#666;
}
/* 导航条固定 */
.header{
  position: fixed!important;
  top:0;
  width: 100%;
  z-index: 100
}
.salary_details {
  .weui-cells{
    margin-top: 0;
    font-size: 14px!important;
  }
  .weui-input{
     text-align: right;
  }
  .weui-textarea{
    font-family: inherit;
  }
}


</style>
