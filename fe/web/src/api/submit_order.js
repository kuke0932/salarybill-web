/**
 *
 * @author Dragon
 * @create 2018-04-03 9:53
 **/

import request from '@/utils/request'

/**
 *
 * @param jsonData  json数据包
 */
export function save(jsonData) {
  const data = [
    jsonData
  ]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.SaveXDD,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 合作客户接口
 * @param orgid     组织id
 * @param number    合作客户编码
 * @param name      合作客户名称
 * @param pageIndex 页码
 * @param pageSize  每页条数
 */
export function getHZKH(search, orgid, pageIndex, pageSize) {
  const data = [{
    'PageIndex': pageIndex,
    'PageSize': pageSize,
    'orgid': orgid,
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetHZKH,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 活动类型接口
 * @param number    活动类型编码
 * @param name      活动类型名称
 * @param pageIndex 页码
 * @param pageSize  每页条数
 */
export function getHDLX(search, pageIndex, pageSize) {
  const data = [{
    'PageIndex': pageIndex,
    'PageSize': pageSize,
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetHDLX,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 促销方案接口
 * @param strOrgNumber    组织number
 * @param strCustNumber   客户number
 * @param search    促销方案number或name
 */
export function getCXFA(search, strOrgNumber, strCustNumber) {
  const data = [{
    'strOrgNumber': strOrgNumber,
    'strCustNumber': strCustNumber,
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetCXFA,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 票据类型接口
 * @param number    票据类型编码
 * @param name      票据类型编码
 * @param pageIndex 页码
 * @param pageSize  每页条数
 */
export function getPJLX(search, pageIndex, pageSize) {
  const data = [{
    'PageIndex': pageIndex,
    'PageSize': pageSize,
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetPJLX,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 岗位折扣负责人接口
 * @param number    岗位折扣负责人编码
 * @param name      岗位折扣负责人名称
 * @param pageIndex 页码
 * @param pageSize  每页条数
 */
export function getZKFZR(search, pageIndex, pageSize) {
  const data = [{
    'PageIndex': pageIndex,
    'PageSize': pageSize,
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetZKFZR,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 *  通过四位码获取信息接口
 *  录入四位码、四位码变更时调用的接口
 * @param forgnumber    组织number
 * @param fcustnumber   客户number
 * @param Fourbitcode   四位码
 * @param fcxnumber     促销方案number
 * @param FPBPBText4  以旧换新卡号
 */
export function iCSelectFourbitcode(forgnumber, fcustnumber, Fourbitcode, fcxnumber, FPBPBText4) {
  const data = [{
    'forgnumber': forgnumber,
    'fcustnumber': fcustnumber,
    'Fourbitcode': Fourbitcode,
    'fcxnumber': fcxnumber,
    'F_PBPB_Text4': FPBPBText4
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.ICSelectFourbitcode,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 物料赠品接口
 * @param forgnumber    组织number
 * @param fcustnumber   客户number
 * @param wlzpNumber    物料number
 * @param fcxnumber     促销方案number
 * @param FPBPBText4    以旧换新卡号
 */
export function iCSelectForWLZP(forgnumber, fcustnumber, wlzpNumber, fcxnumber, FPBPBText4) {
  const data = [{
    'forgnumber': forgnumber,
    'fcustnumber': fcustnumber,
    'wlzpNumber': wlzpNumber,
    'fcxnumber': fcxnumber,
    'F_PBPB_Text4': FPBPBText4
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.ICSelectForWLZP,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 物料查询接口
 * 获取赠品类型接口
 * @param orgid     组织id
 * @param search    物料编码或名称或者规格型号
 * @param pageIndex 页码
 * @param pageSize  每页条数
 */
export function chooseMaterial(search, orgid, pageIndex, pageSize) {
  const data = [{
    'PageIndex': pageIndex,
    'PageSize': pageSize,
    'orgid': orgid,
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.ChooseMaterial,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 加赠标志接口
 * @param number    加赠标志编码
 * @param name      加赠标志名称
 */
export function getJZBZ(search) {
  const data = [{
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetJZBZ,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 赠品类型接口
 * @param number    赠品类型编码
 * @param name      赠品类型名称
 */
export function getZPLX(search) {
  const data = [{
    'search': search
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetZPLX,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

/**
 * 通过物料number查询计量单位接口
 * @param number    赠品类型编码
 * @param orgid     组织ID
 */
export function getJLDW(orgid, number) {
  const data = [{
    'orgid': orgid,
    'number': number
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.PhoneTaxationFormInterface.GetJLDW,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}
