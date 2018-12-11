package com.htcs.wework.salarybill.mock_controller;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.salarybill.model.SalaryTransform;
import com.htcs.wework.salarybill.model.WebWeworkMessage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
@Api(tags = "工资清单后台页面", description = "会计工资清单后台页面增删改查接口")
@RestController
@RequestMapping("/mock/admin/salarybill")
public class SalarybillAdminController {

	@ApiOperation("根据条件查询工资清单表")
    @GetMapping(value = "/listSalaryBillsByCondition", produces = "application/json")
    public ReturnStatus<Map<String,Object>> listSalaryBillsByCondition(@ApiParam(value = "员工姓名")@RequestParam String username,
    																 @ApiParam(value = "工资清单状态")@RequestParam Integer status,
    																 @ApiParam(value = "日期")@RequestParam String salaryDate,
    																 @ApiParam(value = "页码",required = true) @RequestParam int pageNum,
                                                                     @ApiParam(value = "页大小", required = true) @RequestParam int pageSize) {
        return ReturnStatus.success();
    }
	
	@ApiOperation("添加打款凭证,并发送通知")
	@PostMapping(value = "/addSalaryTransforms",produces = "application/json")
	public  ReturnStatus addSalaryTransforms(
							 @ApiParam(value = "凭据图片",required = true) @RequestParam MultipartFile file,
							 @ApiParam(value = "打款金额",required = true) @RequestParam   String money,
							 @ApiParam(value = "工资清单id",required = true) @RequestParam String salarybillId,
							 @ApiParam(value = "当期工资日期",required = true) String salaryDate,
							 @ApiParam(value = "员工企业微信id",required = true) String enterpriseId
																){
		return ReturnStatus.success();
	}
	
	@ApiOperation("打款后,向系统发送通知")
	@PostMapping(value = "/sendWebChatMessage",produces = "application/json")
	public  ReturnStatus sendWebChatMessage(
			 @ApiParam(value = "微信发送数据实体对象",required = true)WebWeworkMessage webChatMessage) {
		return ReturnStatus.success();
	}
	
	@ApiOperation("解析Excel,添加工资清单")
	@PostMapping(value = "/addSalaryBills",produces = "application/json")
	public  ReturnStatus addSalaryBills(
			 @ApiParam(value = "excel文件，form-data类型",required = true)@RequestParam MultipartFile file,
			 @ApiParam(value = "操作的sheet(表)名称",required = true)@RequestParam String  sheetname
			 ){
		return ReturnStatus.success();
	}
	
	
	
	
	
	
	
}
