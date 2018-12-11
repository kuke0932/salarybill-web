<template>
  <div>

    <div class="container">
      <div style="height: 0;position: fixed;" class="header"></div>
      <template v-for="(item,index) in salarybills"  >
         <div class="headerBar" style="height: 32px;">
          <p class="headerBarItem" >{{item.date}}年工资列表（合计：￥{{item.total/100}}）</p>
         </div>
          <group class="salary_details">
              <div class="list">
                <template  v-for="(list,index) in item.list">
                   <router-link :to="{name:'details',query:{id:list.id}}">
                      <div class="list_item" >
                         <flexbox>
                           <flexbox-item :span="8">{{new Date(list.salaryDate).getMonth()+1}}月份</flexbox-item>
                           <flexbox-item v-if="list.status == 0">已保存</flexbox-item>
                           <flexbox-item v-if="list.status == 1">待确认</flexbox-item>
                           <flexbox-item v-if="list.status == 2">待打款</flexbox-item>
                           <flexbox-item v-if="list.status == 3">已打款￥{{list.alreadyPay/100}}</flexbox-item>
                         </flexbox>
                         <flexbox>
                           <flexbox-item :span="8">{{list.acturalPayTotal/100}}元</flexbox-item>
                           <flexbox-item>{{getYearMonthDay(list.salaryDate)}}</flexbox-item>
                         </flexbox>
                     </div>
                  </router-link>
                </template>
            </div>
          </group>
      </template>
    </div>
  </div>
</template>

<script>
  import { XHeader, Group, Flexbox, FlexboxItem} from 'vux'
  import { listSalarybillsByName } from '@/api/salary'
  import { setToken, getToken } from '@/utils/auth'
  export default {
    components: {
      XHeader,
      Group,
      Flexbox,
      FlexboxItem,
    },
    data() {
      return {
        salarybills: []
      }
    },
    created:function() {
      listSalarybillsByName(1, 100).then(res=>{
          if(res.status === 200){
            this.salarybills = res.data;
          }
      })
    },
    mounted() {
      // 监听屏幕滚动事件 判断吸顶效果
      setToken(location.search.split('=')[1])
      window.addEventListener('scroll', this.stickyTop1)
    },
    methods: {
      stickyTop1() {
        const scrollHeight = document.documentElement.scrollTop || document.body.scrollTop
        const headerBars = document.querySelectorAll('.headerBar')
        for (let i = 0; i < headerBars.length; i++) {
          if (i > 0 && scrollHeight >= (headerBars[i].offsetTop - 0 - 32)) {
            headerBars[i-1].childNodes[0].style.top = 0 - (scrollHeight - (headerBars[i].offsetTop - 0 - 32)) + 'px'
          }
          if (scrollHeight > (headerBars[i].offsetTop - 0)) {
            headerBars[i].childNodes[0].setAttribute("class", "fix headerBarItem")
            headerBars[i].childNodes[0].style.top = '0'
            i > 0 && headerBars[i-1].childNodes[0].setAttribute("class", "")

          } else {
            headerBars[i].childNodes[0].setAttribute("class", "headerBarItem")
          }
        }
      },
      getYearMonthDay(data) {
          const date = new Date(data);
          return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+(date.getDate());
      }

    }
  }
</script>
<style scoped lang="less">
  .container{
    color:#666;
    .headerBar{
      .headerBarItem{
        line-height: 32px;
        font-size: 14px;
        background-color: #2F7DCD;
        width:100%;
        color: #fff;
        text-indent:20px
      }
    }
    .list{
      font-size: 14px;
      .list_item:first-child{
        border-top: 1px solid #D9D9D9;
      }
      .list_item{
        border-bottom: 1px solid #D9D9D9;
        padding:10px 10px 10px 20px;
    }
  }
}

  .fix{
    position:fixed;
    top:0;
    left:0;
    z-index: 100;
  }
  .fixNo{
  }
</style>
