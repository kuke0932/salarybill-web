/**
 *  @author wangyunlong
 *  @create 2018-5-15 08:30
 */

import request from '@/utils/request'
import qs from 'qs'

/**
 *条件查询工资清单
 * @param username 员工姓名
 * @param status 工资清单状态
 * @param salaryDate 工资发放日期
 * @param pageNum 页码
 * @param pageSize 页面大小
 */
export function listSalaryBillsByCondition(username, status, salaryDate, pageNum, pageSize) {
  const data = {
    username: username,
    status: status,
    salaryDate: salaryDate,
    pageNum: pageNum,
    pageSize: pageSize
  }
  return request({
    url: '/salarybill/admin/salarybill/listSalaryBillsByCondition',
    method: 'get',
    params: data
  })
}

/**
 *添加收据凭证
 * @param files 收据图片文件流
 * @param money 金额
 * @param salarybillId 工资清单id
 */
export function addSalaryTransforms(files, money, salarybillId,token) {
  const data = {
    files: files,
    money: money,
    salarybillId: salarybillId,
    'x-auth-token': token
  }
  return request({
    url: '/salarybill/admin/salarybill/addSalaryTransforms',
    method: 'post',
    data: qs.stringify(data)
  })
}

/**
 * 打款后,发送系统通知
 * @param tousers 员工姓名
 * @param salarybillId 工资清单id
 * @param salaryDate 工资发放日期
 */
export function sendWebChatMessage(salarybillIds, salaryDates, enterpriseIds,token) {
  const data = {
    salarybillIds: salarybillIds,
    salaryDates: salaryDates,
    enterpriseIds: enterpriseIds,
    'x-auth-token': token
  }
  return request({
    url: '/salarybill/admin/salarybill/sendWebChatMessage',
    method: 'post',
    data: qs.stringify(data)
  })
}

