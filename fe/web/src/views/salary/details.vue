<template>
  <div>
    <x-header class="header" :left-options="{backText: ''}">{{new Date(salarybill.salaryDate).getFullYear()}}年{{new Date(salarybill.salaryDate).getMonth()+1}}月工资详情</x-header>
    <div class="container">
      <p class="status" v-if="salarybill.status == 0">状态:已保存</p>
      <p class="status" v-if="salarybill.status == 1">状态:待确认</p>
      <p class="status" v-if="salarybill.status == 2">状态:待打款</p>
      <p class="status" v-if="salarybill.status == 3">状态:已打款￥{{salarybill.alreadyPay/100}}</p>
      <group class="salary_details">
        <x-input title="实发合计"   v-model="salarybill.acturalPayTotal/100" disabled></x-input>
        <x-input title="应发合计"   v-model="salarybill.shouldPayTotal/100" disabled></x-input>
        <x-input title="全勤奖"     v-model="salarybill.totalDayReward/100" disabled></x-input>
        <x-input title="基础工资"   v-model="salarybill.baseSalary/100" disabled></x-input>
        <x-input title="提成"       v-model="salarybill.percentage/100" disabled></x-input>
        <x-input title="交通补贴"   v-model="salarybill.trafficSubsidy/100" disabled></x-input>
        <x-input title="通讯补贴"   v-model="salarybill.communicationSubsidy/100" disabled></x-input>
        <x-input title="出差补助"   v-model="salarybill.businessTripSubsidy/100" disabled></x-input>
        <x-input title="生日福利"   v-model="salarybill.birthdaySubsidy/100" disabled></x-input>
        <x-input title="迟到扣款"   v-model="salarybill.beLateWithhold/100" disabled></x-input>
        <x-input title="养老保险"   v-model="salarybill.endowmentInsurance/100" disabled></x-input>
        <x-input title="医疗保险"   v-model="salarybill.medicalInsurance/100" disabled></x-input>
        <x-input title="失业保险"   v-model="salarybill.unemploymentInsurance/100" disabled></x-input>
        <x-input title="住房公积金" v-model="salarybill.housingProvidentFund/100" disabled></x-input>
        <x-input title="补差"       v-model="salarybill.balancePay/100" disabled></x-input>
        <x-textarea title="备注" v-model="salarybill.remark" autosize readonly></x-textarea>
        <cell-box>
          <span>打款凭据</span>
          <div class="img_box">
            <template v-for="(item,index) in images">
               <img width="60" height="60"   @click="previewMethod(item)"  :src="'data:image/jpeg;base64,'+item"  />
            </template>
          </div>
        </cell-box>
      </group>
    </div>
    <template v-if="salarybill.status == 1">
        <flexbox :gutter="0" class="btn_box" id="btn_box">
        <flexbox-item class="box_left"  @click.native="showMyQes">
          <p>我有疑问?</p>
        </flexbox-item>
        <flexbox-item class="box_right" @click.native="noQes">
          <p >好的，没问题</p>
        </flexbox-item>
      </flexbox>
    </template>
    <confirm v-model="showConfirm"
             title="你的疑问"
             @on-cancel="onCancel"
             @on-confirm="onConfirm">
      <x-textarea style="border: 1px solid #d9d9d9;" v-model="question" autosize></x-textarea>
    </confirm>
    <div class="img_preview" @click="cancelPreview"
         :style="showImgPre ? {width: screenWidth + 'px',height: screenHeight + 'px', lineHeight: screenHeight + 'px', display: 'block'}: 'display: none'">
               <img   :src="'data:image/jpeg;base64,'+imgUrl" />
    </div>
  </div>
</template>

<script>
  import { XHeader, Group, XInput, XTextarea, Flexbox, FlexboxItem, CellBox, Confirm, base64} from 'vux'
  import { getTransforms, updateSalarybillStatusById, addSalarybillQuestion, getSalaryBillById } from '@/api/salary'
  import { getToken } from '@/utils/auth'
  export default {
    components: {
      XHeader,
      Group,
      XInput,
      XTextarea,
      Flexbox,
      FlexboxItem,
      CellBox,
      Confirm
    },
    data () {
      return {
        screenWidth: window.screen.width,
        screenHeight: window.screen.height,
        imgUrl: '',
        showImgPre: false,
        showConfirm: false,
        question: '',
        data:{
          status: 1,
          SFHJ: 5000,
          YFHJ: 5000,
          QQJ: 100,
          JCGZ: 1500,
          TC: 2000,
          JTBT: 50,
          TXBT: 40,
          CCBZ: 0,
          SRFL: 0,
          CDKK: 0,
          YLBX: 0,
          ylbx: 0,
          SYBX: 0,
          ZFGJJ: 0,
          BC: 100,
          remark: '这里写一些请假 出勤的明细这里写一些请假 出勤的明细这里写一些请假 出勤的明细这里写一些请假 出勤的明细这里写一些请假 出勤的明细'
        },
        salarybill: {},
        images: []
      }
    },
    created() {
      //his.salarybill = JSON.parse(this.$route.query.id);
      const salarybillId =this.$route.query.id;
      getSalaryBillById(salarybillId).then(res => {
        console.log(res)
        if(res.status == 200) {
          this.salarybill = res.data;
        }
      })
      getTransforms(salarybillId).then(res => {
         if(res.status == 200) {
            this.images = res.data;
          }
      })

    },
    methods: {
      showMyQes() {
        this.showConfirm = true
      },
      noQes() {
        updateSalarybillStatusById(this.salarybill.id).then( res => {
          if(res.status == 200) {
            this.$router.push({ path: '/salary?x='+getToken() });
          }
        })
        
      },
      onCancel() {

      },
      onConfirm() {
          if(this.question != ''){
              addSalarybillQuestion(this.question,this.salarybill.id);
          } 
      },
      // 预览
      previewMethod(e) {
        this.showImgPre = true
        this.imgUrl = e
      },
      // 取消预览
      cancelPreview() {
        this.showImgPre = false
      }
    }
  }
</script>
<style scoped lang="less">
  .container{
    margin-top: 46px;
    margin-bottom: 50px;
    color:#666;
    .status{
      padding: 5px 0;
      margin-right: 20px;
      text-align: right;
      font-size: 15px;
      color:#666;
    }
    .salary_details{
      padding-bottom: 50px;
      .img_box{
        width: 70%;
        margin-left: 20px;
      }
    }
  }
  .btn_box{
    position:fixed;
    bottom:0;
    width:100%;
    color: #fff;
    font-size: 14px;
    z-index: 100;
    text-align: center;
    font-weight: bold;
    .box_left{
      background-color: #FCFAF2;
      color:#666;
      padding: 10px;
    }
    .box_right{
      background-color: #5BB75B;
      padding: 10px;
      text-align: center;
    }
  }
  .img_preview{
    position: fixed;
    top: 0;
    z-index: 100;
    text-align: center;
    background: #000;
    img{
      vertical-align: middle;
      width:100%;
    }
  }
</style>
