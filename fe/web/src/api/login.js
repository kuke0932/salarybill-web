import request from '@/utils/request'

export function loginByUsername(username, password) {
  const data = [{
    phoneNumber: username,
    passWord: password
  }]
  return request({
    url: '/K3Cloud/Joy.NHBusiness.ServicePlugIn.PhoneWebApi.LoginAndGetUsersInfo.login,Joy.NHBusiness.ServicePlugIn.common.kdsvc',
    method: 'post',
    data: data
  })
}

export function logout() {
  return request({
    url: '/system/admin/logout',
    method: 'post'
  })
}

export function getUserInfo(token) {
  return request({
    url: '/system/admin/getUserInfo',
    method: 'get'
  })
}

export function init() {
  const data = [
    '5a55e9ea6006cf',
    // 'administrator',
    // 'nh6.66',
    'webapi',
    '888888',
    2052
  ]
  // const token = getToken()
  // if (token) {
  //   return new Promise((resolve, reject) => {
  //     if (token) {
  //       resolve()
  //     }
  //   })
  // } else {
  return request({
    url: 'K3Cloud/Kingdee.BOS.WebApi.ServicesStub.AuthService.ValidateUser.common.kdsvc',
    method: 'post',
    data
  })
  // }
}

export function generateRoutes() {
  return request({
    url: '/system/admin/generateRoutes',
    method: 'get'
  })
}
