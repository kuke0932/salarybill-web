<template>
  <div class="container">
    <el-form>
      <el-row>
        <el-col :span="8">
          <el-form-item label-width="80px" label="年月">
            <el-date-picker
              v-model="secrchDate"
              type="month"
              value-format="yyyy-MM"
              placeholder="选择月">
            </el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="8">
          <el-form-item label-width="80px" label="状态">
            <el-select v-model="searchStatus"  clearable placeholder="请选择状态">
              <el-option
                v-for="item in options"
                :key="item.value"
                :label="item.label"
                :value="item.value">
              </el-option>
            </el-select>
          </el-form-item>
        </el-col>
        <el-col :span="9">
          <el-form-item label-width="80px" label="员工姓名">
            <el-input style="max-width: 220px" placeholder="请输入员工姓名" v-model="searchName"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-button style="margin-left: 20px" type="primary" @click="search" :loading="listLoading">查询</el-button>
        </el-col>
      </el-row>

      <div class="btn_box">
        <el-button class="el-button--primary" code="leadin" @click="leadin()">导入</el-button>
        <el-button class="el-button--primary" code="numSend" @click="numSend">批量发送</el-button>
      </div>

      <el-table
        ref="tableList"
        :data="dataList"
        v-loading.body="listLoading"
        element-loading-text="拼命加载中"
        border
        fit
        tooltip-effect="dark"
        highlight-current-row
        style="width: 100%;margin-top: 20px"
        @selection-change="handleSelectionChange">
        <el-table-column type="selection" width="50">
        </el-table-column>
        <el-table-column label="年月" fixed="left" width="100" >
          <template slot-scope="scope">
              {{ new Date(scope.row.salaryDate).getFullYear()+'年'+(new Date(scope.row.salaryDate).getMonth()+1)+'月' }}
          </template>
        </el-table-column>
        <el-table-column  label="姓名" fixed="left">
         <template slot-scope="scope">
              {{ scope.row.name }}
         </template> 
        </el-table-column>
        <el-table-column label="入职时间" width="120">
          <template slot-scope="scope">
            {{ new Date(scope.row.salaryDate).getFullYear()+'年'+(new Date(scope.row.salaryDate).getMonth()+1)+'月'+ new Date(scope.row.salaryDate).getDate()+'日'}}
          </template>
        </el-table-column>
        <el-table-column label="应出勤">
          <template slot-scope="scope">
            {{ scope.row.dutyAttendance }}天
          </template>
        </el-table-column>
        <el-table-column label="实际出勤">
          <template slot-scope="scope">
            {{ scope.row.actualAttendance }}天
          </template>
        </el-table-column>
        <el-table-column label="基础工资" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.baseSalary/100 }}
          </template>
        </el-table-column>
        <el-table-column label="提成" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.percentage/100 }}
          </template>
        </el-table-column>
        <el-table-column label="工龄补贴" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.workAgeSubsidy/100 }}
          </template>
        </el-table-column>
        <el-table-column label="全勤奖" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.totalDayReward/100 }}
          </template>
        </el-table-column>
        <el-table-column label="交通补贴" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.trafficSubsidy/100 }}
          </template>
        </el-table-column>
        <el-table-column label="通讯补贴" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.communicationSubsidy/100 }}
          </template>
        </el-table-column>
        <el-table-column label="出差补助" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.businessTripSubsidy/100 }}
          </template>
        </el-table-column>
        <el-table-column label="生日福利" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.birthdaySubsidy/100 }}
          </template>
        </el-table-column>
        <el-table-column label="应发合计" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.shouldPayTotal/100 }}
          </template>
        </el-table-column>
        <el-table-column label="迟到扣款" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.beLateWithhold/100 }}
          </template>
        </el-table-column>
        <el-table-column label="养老保险" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.endowmentInsurance/100 }}
          </template>
        </el-table-column>
        <el-table-column label="医疗保险" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.medicalInsurance/100 }}
          </template>
        </el-table-column>
        <el-table-column label="失业保险" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.unemploymentInsurance/100 }}
          </template>
        </el-table-column>
        <el-table-column label="住房公积金" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.housingProvidentFund/100 }}
          </template>
        </el-table-column>
        <el-table-column label="补差" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.balancePay/100 }}
          </template>
        </el-table-column>
        <el-table-column label="实发合计" width="90">
          <template slot-scope="scope">
            ￥{{ scope.row.acturalPayTotal/100 }}
          </template>
        </el-table-column>
        <el-table-column label="状态" fixed="right" width="140">
          <template  slot-scope="scope">
              <p v-if="scope.row.status == 0">已保存</p>
              <p v-if="scope.row.status == 1">待确认
                <el-popover  v-if="scope.row.problem == 1"  placement="top-start"  title="问题"
                  width="200"
                  trigger="hover"
                  :content="getProblems(scope.$index)">
                  <el-button slot="reference">问题</el-button>
                </el-popover>
              </p>
              <p v-if="scope.row.status == 2">待打款</p>
              <p v-if="scope.row.status == 3">已打款￥{{scope.row.alreadyPay/100}}</p>
          </template>
        </el-table-column>
        <el-table-column label="操作"  fixed="right" width="180">
          <template slot-scope="scope">
            <el-button class="el-button--primary" code="send" size="small" @click="send(scope.$index, scope.row)">发送</el-button>
            <el-button class="el-button--primary" code="remit" size="small" @click="remit(scope.$index, scope.row)">打款</el-button>
          </template>
        </el-table-column>
      </el-table>

      <el-pagination
        style="float:right;margin-top: 15px"
        background
        layout="prev, pager, next"
        :total="total"
        :page-size="pageSize"
        @current-change="handleCurrentPageChange">
      </el-pagination>

      <el-dialog
        title="导入工资"
        :visible.sync="leadinDialog"
        width="30%">
      <!--   <el-form-item label-width="80px" label="excel表名">
        <el-input
          v-model="sheetname"
          placeholder="请输入sheetname">
        </el-input>
      </el-form-item> salarybill.hbwrrj.com -->
        <el-form-item label="导入exe表">
          <el-upload
            :action="'http://salarybill.hbwrrj.com/salarybill/admin/salarybill/addSalaryBills?x='+token['x-auth-token']"
            :limit="1"
            ref="uploadExcel"
            :on-change="handleChange"
            :on-remove="handleRemove"
            :file-list="fileList">
            <el-button size="small" type="primary">上传附件</el-button>
          </el-upload>
        </el-form-item>
        <span slot="footer" class="dialog-footer">
          <el-button @click="confirmExcel">取 消</el-button>
          <el-button type="primary"  @click="confirmExcel">确 定</el-button>
        </span>
      </el-dialog>

      <el-dialog
        class="remitDialog"
        title="打款明细"
        :visible.sync="remitDialog"
        width="30%"
        :before-close="handleClose">
        <el-form-item label-width="80px" label="打款金额">
          <el-input placeholder="输入打款金额" style="max-width: 220px;" v-model="remitMoney"></el-input>
        </el-form-item>
        <el-form-item label-width="80px" label="打款凭据">
          <el-upload
            ref="uploadTransform"
            :limit="1"
            :data="getTransformData"
            :action="'http://salarybill.hbwrrj.com/salarybill/admin/salarybill/addSalaryTransforms?x='+token['x-auth-token']"
            list-type="picture-card"
            :auto-upload="false"
            :on-success="transformSuccess"
            :on-preview="picPreview"
            :on-remove="removeImg">
            <i class="el-icon-plus"></i>
          </el-upload>
          <el-dialog :visible.sync="imgDialog">
            <img width="100%" :src="dialogImageUrl" alt="">
          </el-dialog>
        </el-form-item>
        <span slot="footer" >
          <el-button @click="cancelTransform">取 消</el-button>
          <el-button type="primary" @click="submitTransform">确 定</el-button>
        </span>
      </el-dialog>
    </el-form>
  </div>
</template>

<script>
  import { authMenuButton } from '@/utils/authMenuButton'
  import { listSalaryBillsByCondition, addSalaryTransforms, sendWebChatMessage, addSalaryBills } from '@/api/salary'
  import { getToken } from '@/utils/auth'
  export default {
    name: 'salary',
    components: {
    },
    data() {
      return {
        total: -1,
        pageNum: 1,
        pageSize: 50,
        dataList: [
          {
          }
        ],
        options: [
          {
            value: '0',
            label: '已保存'
          },
          {
            value: '1',
            label: '待确认'
          },
          {
            value: '2',
            label: '待打款'
          },
          {
            value: '3',
            label: '已打款'
          }
        ],
        status: '',
        multipleSelection: [],
        secrchDate: '2018-04',
        searchStatus: null,
        searchName: null,
        listLoading: false,
        leadinDialog: false,
        sheetname: null,
        fileList: [],
        token: {
          'x-auth-token': getToken()
        },
        ids: '',
        remitDialog: false,
        imgDialog: false,
        remitMoney: null,
        dialogImageUrl: '',
        salarybillId: 0,
        currentIndex: -1,
        currentEnterpriseId: 0,
        currentDate: ''
      }
    },

    computed: {
       getTransformData() {
        const obj =  {
          salarybillId: this.salarybillId,
          money: this.remitMoney,
          enterpriseId: this.currentEnterpriseId,
          salaryDate: this.getDate(this.currentDate)
        }
        return obj;
      }
    },

    mounted() {
      authMenuButton(location.hash.substring(2))
      this.fetchData(this.secrchDate, null, null, this.pageNum, this.pageSize).then(res => {
        if(res.data.status == 200) {;
          this.dataList = res.data.data.list;
          this.total = res.data.data.cout;
        }
      })
    },
    methods: {
      /* 初始化角色列表 */
      fetchData(date, status, name, pageNum, pageSize) {
        return listSalaryBillsByCondition(name, status, date, pageNum, pageSize);
      },

      /* 查询 */
      search() {
        this.pageNum = 1;
        this.fetchData(this.secrchDate, this.searchStatus, this.searchName, this.pageNum, this.pageSize).then(res => {
          if(res.data.status === 200) {
            this.dataList = res.data.data.list;
            this.total = res.data.data.cout;
          }
        })
      },

      /* 获取所勾选用户 */
      handleSelectionChange(val) {
        this.multipleSelection = val
      },

      /* 导入 */
      leadin() {
        this.leadinDialog = true;
      },

      handleChange(file, fileList) {
        this.fileList = fileList
        this.ids = this.handleUpOrDel(fileList)
      },
      handleRemove(file, fileList) {
        this.fileList = fileList
        this.ids = this.handleUpOrDel(fileList)
      },
      handleUpOrDel(fileList) {
        if (fileList) {
          for (let i = 0; i < fileList.length; i++) {
            console.log(fileList[i].response)
            const obj = fileList[i].response
            if (obj) {
              if (obj.code) {
                this.ids += obj.record.successResponse[0].id
                if (i < fileList.length - 1) {
                  this.ids += ','
                }
              }
            }
          }
        }
        return this.ids
      },

      /* 批量发送 */
      numSend() {
        if (this.multipleSelection.length < 1) {
          this.$message({
            type: 'warning',
            message: '请选中一行再执行此操作!'
          })
          return
        }
        let salarybillIds = ''
        let salaryDates = ''
        let enterpriseIds = ''
        //获得发送信息的字符串
        for(let i =0;i<this.multipleSelection.length;i++){
          if(i == 0) {
            salarybillIds += this.multipleSelection[i].id
            salaryDates += this.getDate(this.multipleSelection[i].salaryDate)
            enterpriseIds += this.multipleSelection[i].enterpriseId
          }else {
            salarybillIds += ',' + this.multipleSelection[i].id
            salaryDates += ',' + this.getDate(this.multipleSelection[i].salaryDate)
            enterpriseIds += ',' + this.multipleSelection[i].enterpriseId
          }
        }
        sendWebChatMessage(salarybillIds, salaryDates, enterpriseIds, getToken()).then(res => {
          if(res.data.status === 200) {
            //更改页面显示状态
           for(let i=0;i<this.multipleSelection.length;i++) {
            for(let j=0;j<this.dataList.length;j++) {
              if(this.dataList[j].id == this.multipleSelection[i].id){
                this.dataList[j].status = 1;
              }
            }
          }
          this.$refs.tableList.clearSelection()
          }
        })
      },

      /*获得工资条目问题*/
      getProblems(index) {
        const list = this.dataList[index].problems
        let problem = ''
        for (let i = 0; i < list.length; i++) {
          problem += (i+1) + '.' + list[i].content + '   '
        }
        return problem
      },

      /* 发送 */
      send(index,row) {
        sendWebChatMessage(row.id, this.getDate(row.salaryDate), row.enterpriseId, getToken()).then(res => {
          if(res.data.status === 200) {
            this.dataList[index].status = 1
            this.$refs.tableList.clearSelection()
          }
        })
      },

      /*获得日期*/
      getDate(salaryDate) {
        return new Date(salaryDate).getFullYear() +'-' + (new Date(salaryDate).getMonth()+1)
      },

      /* 打款 */
      remit(index,row) {
        this.currentIndex = index
        this.salarybillId = row.id
        this.remitDialog = true
        this.currentEnterpriseId = this.dataList[index].enterpriseId
        this.currentDate = this.dataList[index].salaryDate
      },

      /*点击确定上传图片*/
      submitTransform() {
        this.remitMoney = parseFloat(this.remitMoney);
        if (typeof this.remitMoney === 'number'){
          if (!isNaN(this.remitMoney)) {
            if (this.dataList[this.currentIndex].status >= 2) {
              this.$refs.uploadTransform.submit();
              return
            }  
          }else{
            return
          }
        }
      },

      /*凭证文件上传成功后的钩子函数*/
      transformSuccess(res,  file, fileList) {
        let money = parseInt(this.dataList[this.currentIndex].alreadyPay)
        money += this.remitMoney*100 
        this.dataList[this.currentIndex].alreadyPay = money + ''
        this.dataList[this.currentIndex].status = 3
        this.salarybillId = 0
        this.remitMoney = null
        this.remitDialog = false
        this.currentIndex = -1
        this.currentEnterpriseId = 0
        this.currentDate = ''
        this.$refs.uploadTransform.clearFiles();
      },

      cancelTransform() {
        this.salarybillId = 0;
        this.remitMoney = null;
        this.remitDialog = false;
        this.currentIndex = -1;
        this.$refs.uploadTransform.clearFiles();
      },
      
      /*关闭excel对话框并清空文件*/
      confirmExcel() {
        this.leadinDialog = false,
        this.$refs.uploadExcel.clearFiles();
        this.searchStatus = null
        this.secrchDate = '2018-04'
        this.searchName = null
        this.pageNum = 1
        this.fetchData(this.secrchDate, this.searchStatus, this.searchName, this.pageNum, this.pageSize).then(res => {
          if(res.data.status === 200) {
            this.dataList = res.data.data.list;
            this.total = res.data.data.cout;
          }
        })
      },

      removeImg(file, fileList) {
        console.log(file, fileList)
      },
      picPreview(file) {
        this.dialogImageUrl = file.url
        this.imgDialog = true
      },

      /* table表格当前页事件 */
      handleCurrentPageChange(currentPage) {
        this.pageNum = currentPage
        this.fetchData(this.secrchDate, this.searchStatus, this.searchName, this.pageNum, this.pageSize).then(res => {
          if(res.data.status == 200) {;
            this.dataList = res.data.data.list;
            this.total = res.data.data.cout;
          }
        })
      },

      /* 手动关闭对话框 */
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(_ => {
            this.remitDialog = false;
            this.salarybillId = 0;
            this.remitMoney = null;
            this.leadinDialog = false
            this.$refs.uploadTransform.clearFiles();
            this.$refs.uploadExcel.clearFiles();
          })
          .catch(_ => {})
      }


    }
  }
</script>

<style scoped>
</style>
