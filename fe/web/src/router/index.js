import Vue from 'vue'
import Router from 'vue-router'
import Salary from '@/views/salary/index.vue'
import Details from '@/views/salary/details.vue'

Vue.use(Router)

const routes = [
  {
    path: '/',
    component: Salary
  },
  {
    path: '/salary',
    name: 'salary',
    component: Salary
  },
  {
    path: '/salary/details',
    name: 'details',
    component: Details
  },
]

export default new Router({
  mode: 'history',
  routes
})
