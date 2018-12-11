/**
 *  @author wangyunlong
 *  @create 2018-5-11 15:22
 */
import request from '@/utils/request'
import qs from 'qs'

/**
 *查询个人工资清单
 */
export function listSalarybillsByName(pageNum, pageSize) {
  const data = {
    pageNum: pageNum,
    pageSize: pageSize
  }
  return request({
    url: '/salarybill/web/salarybill/listSalarybillsByName',
    method: 'get',
    params: data
  })
}

/**
 *员工提出问题
 * @param content 问题内容
 * @param salarybillId 工资清单id
 */
export function addSalarybillQuestion(content,salarybillId) {
  const data = {
    content: content,
    salarybillId: salarybillId
  }
  return request({
    url: '/salarybill/web/salarybill/addSalarybillQuestion',
    method: 'post',
    data: qs.stringify(data)
  })
}

/**
 * 查询工资清单问题
 * @param salarybillId 工资清单id
 */
export function listSalarybillQuestionsById(salarybillId) {
  const data = {
    salarybillId: salarybillId
  }
  return request({
    url: '/salarybill/web/salarybill/listSalarybillQuestionsById',
    method: 'get',
    params: data
  })
}

/**
 * 确认该工资清单没有问题
 * @param salarybilllId 工资清单id
 */
export function updateSalarybillStatusById(salarybilllId) {
  const data = {
    salarybillId: salarybilllId
  }
  return request({
    url: '/salarybill/web/salarybill/updateSalarybillStatusById',
    method: 'post',
    data: qs.stringify(data)
  })
}

/**
 *获取凭证图片
 * @param salarybillId 工资清单id
 */
export function getTransforms(salarybillId) {
  const data = {
    salarybillId: salarybillId
  }
  return request({
    url : '/salarybill/web/salarybill/listTransforms',
    method: 'get',
    params: data
})
}

/**
 *获取详情信息
 * @param salarybillId 工资清单id
 */
export function getSalaryBillById(salarybillId) {
  const data = {
    salarybillId: salarybillId
  }
  return request({
    url : '/salarybill/web/salarybill/getSalarybillById',
    method: 'post',
    data: qs.stringify(data)
})
}






