import axios from 'axios'
import UUID from 'uuid'
import Vue from 'vue'
import { removeToken, getToken } from '@/utils/auth'

// create an axios instance
const service = axios.create({
  baseURL: process.env.BASE_API, // api的base_url
  timeout: 15000, // request timeout 15s
  withCredentials: true
})

// request interceptor

service.interceptors.request.use(config => {
  //Do something before request is sent
  /*if (store.getters.token) {
    config.headers['x-auth-token'] = getToken() // 让每个请求携带token-- ['X-Token']为自定义key 请根据实际情况自行修改
  }*/
  config.headers['x-auth-token'] = getToken()
  config.headers['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8'
  return config
}, error => {
  // Do something with request error
  console.log(error) // for debug
  Promise.reject(error)
})

// respone interceptor

service.interceptors.response.use(
  response => {
    if (typeof response.data === 'string' && response.data.startsWith('response_error:')) {
      return Promise.reject(new Error('系统内部出错,请联系管理员或者稍后重试！'))
    } else {
      return response.data
    }
  },
  error => {
    console.log('err' + error)// for debug
    return Promise.reject(error)
  })



export default service
