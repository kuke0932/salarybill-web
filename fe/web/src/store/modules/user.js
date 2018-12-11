import { loginByUsername, logout, getUserInfo } from '@/api/login'
import { getToken, removeToken } from '@/utils/auth'

const user = {
  state: {
    token: getToken(),
    name: '',
  },

  mutations: {
  
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_NAME: (state, name) => {
      state.name = name
    }
  },

  actions: {

    SetToken({ commit, state }, token) {
      return new Promise((resolve, reject) => {
        commit('SET_TOKEN', token)
        resolve()
      })
    },
    // 用户名登录
    LoginByUsername({ commit }, userInfo) {
      return new Promise((resolve, reject) => {
        loginByUsername(userInfo.mobile.trim().replace(/ /g, ''), userInfo.password).then(response => {
          const data = response[0]
          if (data.Result === 2) {
            // 默认使用第一个
            commit('SET_ORGANIZATIONS', [{
              ORGID: data.OrganizationsandappModel[0].ORGID,
              FNUMBER: data.OrganizationsandappModel[0].FNUMBER,
              FNAME: data.OrganizationsandappModel[0].FNAME
            }])
            resolve()
          } else {
            reject(data)
          }
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetUserInfo({ commit, state }) {
      return new Promise((resolve, reject) => {
        getUserInfo(state.token).then(response => {
          if (!response.data) { // 由于mockjs 不支持自定义状态码只能这样hack
            reject(new Error('error'))
          }
          const data = response.data.data
          // commit('SET_ROLES', data.roles)
          commit('SET_NAME', data.name)
          commit('SET_AVATAR', data.avatar)
          commit('SET_INTRODUCTION', data.introduction)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut({ commit }) {
      return new Promise(resolve => {
        removeToken()
        resolve()
      })
    }
  }
}

export default user
