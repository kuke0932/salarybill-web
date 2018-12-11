package com.htcs.wework.salarybill.mock_controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.htcs.wework.common.bean.ReturnStatus;
import com.htcs.wework.salarybill.model.SalaryBill;
import com.htcs.wework.salarybill.model.SalaryQuestion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags = "工资清单前台页面", description = "会计工资清单前台页面增删改查接口")
@RestController
@RequestMapping("/mock/web/salarybill")
public class SalarybillWebController {
	
	@ApiOperation("查询个人工资清单")
    @GetMapping(value = "/listSalarybillsByName", produces = "application/json")
    public ReturnStatus<List<SalaryBill>> listSalarybillsByName() {
        return ReturnStatus.success();
    }
	
	@ApiOperation("员工提出问题")
	@PostMapping(value = "/addSalarybillQuestion", produces = "application/json")
	public ReturnStatus     addSalarybillQuestion(
												  @ApiParam(value = "问题内容",required = true)@RequestParam String content,
												  @ApiParam(value = "工资清单id",required = true)@RequestParam String salarybillId) {
		return ReturnStatus.success();
	}
	
	@ApiOperation("查询工资清单问题")
	@GetMapping(value = "/listSalarybillQuestionsById",produces = "application/json")
	public  ReturnStatus<List<SalaryQuestion>>  listSalarybillQuestionsById(
			 @ApiParam(value = "工资清单id",required = true)@RequestParam String salarybillId){
		return ReturnStatus.success();
	}
	
	@ApiOperation("确认该工资清单没有问题")
	@PostMapping(value = "/updateSalarybillStatusById",produces = "application/json")
	public  ReturnStatus updateSalarybillStatusById(
			 @ApiParam(value = "工资清单id",required = true)@RequestParam String salarybillId){
		return ReturnStatus.success();
	}
	
	
	@ApiOperation("获取凭证图片")
	@GetMapping(value = "/listTransforms",produces = "application/json")
	public  ReturnStatus<List<String>> getTransforms(
			 @ApiParam(value = "工资清单id",required = true)@RequestParam String salarybillId){
		return ReturnStatus.success();
	}
	
	@ApiOperation("根据salaryId获得工资条")
	@GetMapping(value = "/getSalarybillById",produces = "application/json")
	public  ReturnStatus<SalaryBill> getSalarybillById(
			 @ApiParam(value = "工资清单id",required = true)@RequestParam String salarybillId){
		return ReturnStatus.success();
	}
	
	@ApiOperation("获得企业微信code,跳转至个人工资列表页面")
	@GetMapping(value = "/getUserInfo",produces = "application/json")
	public  ReturnStatus<String> getUserInfo(
			 @ApiParam(value = "员工企业微信id",required = true)String code){
		return ReturnStatus.success();
	}
	
	@ApiOperation("获得企业微信code直接跳转至详情")
	@GetMapping(value = "/getUserInfoMessage",produces = "application/json")
	public  ReturnStatus<String> getUserInfoMessage(
			 @ApiParam(value = "员工企业微信id",required = true)String code,
			 @ApiParam(value = "工资清单id",required = true)String state){
		return ReturnStatus.success();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
