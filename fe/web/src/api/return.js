/**
 *
 * @author Dragon
 * @create 2018-03-02 11:02
 **/
import request from '@/utils/request'

/**
 * 未还料页面 （查询借料调拨单接口）
 * @param organizationID 组织ID（从用户登录接口获取）
 * @param userNumber 员工编码（FSTAFFNUMBER）（从用户登录接口获取）
 * @param pageIndex 当前页码
 * @param pageSize 每页显示条数
 */
export function getUnReturnMaterial(organizationID, userNumber, pageIndex, pageSize) {
  const data = [{
    'OrganizationID': organizationID,
    'UserNumber': userNumber,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: 'K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialReturn.GetBorrowMaterialList,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 已还料页面 (分页+搜索)接口
 * @param organizationID 组织ID（从用户登录接口获取）
 * @param userNumber 员工编码（FSTAFFNUMBER）（从用户登录接口获取）
 * @param billNo：单据编号（用户输入）
 * @param documentStatus 单据状态 A:已保存 B:已提交 C:已审核 D: 已保存（撤销/反审核之后的状态）
 * @param beginDate：开始时间（用户选择）
 * @param endDate：结束时间（用户选择）
 * @param pageIndex 当前页码
 * @param pageSize 每页显示条数
 */
export function getIsReturnMaterial(organizationID, userNumber, documentStatus, beginDate, endDate, billNo, pageIndex, pageSize) {
  const data = [{
    'OrganizationID': organizationID,
    'UserNumber': userNumber,
    'DocumentStatus': documentStatus,
    BillTypeID: '5aab2d4cba410b',
    BeginDate: beginDate,
    EndDate: endDate,
    'BillNo': billNo,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: 'K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialReturn.RetBorrowMaterialList,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 获取物料分组接口
 * @param organizationID 组织id
 */
export function getMaterialGroup(organizationID) {
  const data = [{
    OrganizationID: organizationID
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialReturn.GetMaterialGroup,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 点击分组获取物料明细
 * @param groupID 物料分组id
 * @param organizationID
 * @param pageIndex
 * @param pageSize
 */
export function getMaterial(groupID, organizationID, pageIndex, pageSize) {
  const data = [{
    'GroupID': groupID,
    'OrganizationID': organizationID,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialReturn.getMaterial,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 搜索物料
 * @param materialNumber
 * @param materialName
 * @param specification
 * @param organizationID
 * @param pageIndex
 * @param pageSize
 */
export function selectMaterial(materialNumber, materialName, specification, organizationID, pageIndex, pageSize) {
  const data = [{
    'materialNumber': materialNumber,
    'MaterialName': materialName,
    'Specification': specification,
    'OrganizationID': organizationID,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialReturn.SelectMaterial,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

export function retMainList(organizationID, userId, documentStatus, billNo, pageIndex, pageSize) {
  const data = [{
    'OrganizationID': organizationID,
    'UserId': userId,
    'DocumentStatus': documentStatus,
    'BillNo': billNo,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialReturn.RetMainList,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

export function listOfReturnMaterials(organizationID, userId, documentStatus, billNo, pageIndex, pageSize) {
  const data = [{
    'OrganizationID': organizationID,
    'UserId': userId,
    'DocumentStatus': documentStatus,
    'BillNo': billNo,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialAudit.ListOfReturnMaterials,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}
