/**
 *
 * @author Dragon
 * @create 2018-03-02 11:02
 **/
import request from '@/utils/request'

/**
 * 获取物料分组接口
 * @param organizationID 组织id
 */
export function getMaterialGroup(organizationID, userId, pageIndex, pageSize) {
  const data = [{
    OrganizationID: organizationID,
    UserId: userId,
    PageIndex: pageIndex,
    PageSize: pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.Material_Query.GetMaterialGroup,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
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
export function getMaterial(groupID, organizationID, userId, pageIndex, pageSize) {
  const data = [{
    'GroupID': groupID,
    'OrganizationID': organizationID,
    UserId: userId,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.Material_Query.getMaterial,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
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
export function selectMaterial(materialNumber, materialName, specification, organizationID, userId, pageIndex, pageSize) {
  const data = [{
    'MaterialNumber': materialNumber,
    'MaterialName': materialName,
    'Specification': specification,
    'OrganizationID': organizationID,
    UserId: userId,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.Material_Query.SelectMaterial,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

export function retMainList(organizationID, userId, documentStatus, beginDate, endDate, billNo, pageIndex, pageSize) {
  const data = [{
    'OrganizationID': organizationID,
    'UserNumber': userId,
    'DocumentStatus': documentStatus,
    BeginDate: beginDate,
    EndDate: endDate,
    'BillNo': billNo,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.Material_Query.RetMainList,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

export function retBorrowMaterialList(organizationID, userId, userName, documentStatus, endDate, beginDate, billNo, pageIndex, pageSize) {
  const data = [{
    'OrganizationID': organizationID,
    UserId: userId,
    'UserName': userName,
    'DocumentStatus': documentStatus,
    BeginDate: beginDate,
    EndDate: endDate,
    'BillNo': billNo,
    'PageIndex': pageIndex,
    'PageSize': pageSize
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.MaterialAudit.RetBorrowMaterialList,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}
