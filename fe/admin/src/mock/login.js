// import { param2Obj } from '@/utils'

// const userMap = {
//   admin: {
//     roles: ['admin'],
//     token: 'admin',
//     introduction: '我是超级管理员',
//     avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
//     name: 'admin'
//   },
//   editor: {
//     roles: ['editor'],
//     token: 'editor',
//     introduction: '我是编辑',
//     avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
//     name: 'Normal Editor'
//   }
// }

export default {
  loginByUsername: config => {
    return {
      status: 200,
      message: '',
      data: 'login'
    }
  },
  getUserInfo: config => {
    return {
      status: 200,
      message: '',
      data: {
        roles: ['editor'],
        token: 'editor',
        introduction: '我是编辑',
        avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
        name: 'Normal Editor'
      }
    }
  },
  logout: () => 'success',
  generateRoutes: () => {
    return {
      'status': 200,
      'message': '请求成功！',
      'data': [
        {
          'path': '',
          'component': '',
          'name': '系统管理',
          'meta': { 'icon': 'systemManagement', 'title': '系统管理', 'role': null, 'functionType': 1 },
          'children': [
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '用户管理',
              'meta': { 'icon': 'user', 'title': '用户管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/department/index',
              'component': 'systemManagement/department/index',
              'name': '部门管理',
              'meta': { 'icon': 'department', 'title': '部门管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/role/index',
              'component': 'systemManagement/role/index',
              'name': '角色管理',
              'meta': { 'icon': 'role', 'title': '角色管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/group/index',
              'component': 'systemManagement/group/index',
              'name': '群组管理',
              'meta': { 'icon': 'group', 'title': '群组管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '查看',
                'meta': { 'icon': null, 'title': '查看', 'functionType': 2, 'code': 'check' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/menu/index',
              'component': 'systemManagement/menu/index',
              'name': '菜单管理',
              'meta': { 'icon': 'menu', 'title': '菜单管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '保存',
                'meta': { 'icon': null, 'title': '保存', 'functionType': 2, 'code': 'save' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/menuAuthor/index',
              'component': 'systemManagement/menuAuthor/index',
              'name': '菜单授权管理',
              'meta': { 'icon': 'menuAuthor', 'title': '菜单授权管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除角色',
                'meta': { 'icon': null, 'title': '删除角色', 'functionType': 2, 'code': 'delRole' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加角色',
                'meta': { 'icon': null, 'title': '添加角色', 'functionType': 2, 'code': 'addRole' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '保存',
                'meta': { 'icon': null, 'title': '保存', 'functionType': 2, 'code': 'save' },
                'children': [],
                'hidden': true
              }]
            }
          ]
        },
        /*{
          'path': '',
          'component': '',
          'name': '工资管理',
          'meta': { 'icon': 'systemManagement', 'title': '工资管理', 'role': null, 'functionType': 1 },
          'children': [
            {
              'path': 'salaryManagement/index',
              'component': 'salaryManagement/index',
              'name': '工资管理',
              'meta': { 'icon': 'department', 'title': '工资管理', 'systemManagement': null, 'functionType': 1, 'code': '' },
              'children': [
                {
                  'path': '',
                  'component': '',
                  'name': '导入',
                  'meta': { 'icon': null, 'title': '导入', 'functionType': 2, 'code': 'leadin' },
                  'children': [],
                  'hidden': true
                },
                {
                  'path': '',
                  'component': '',
                  'name': '批量发送',
                  'meta': { 'icon': null, 'title': '批量发送', 'functionType': 2, 'code': 'numSend' },
                  'children': [],
                  'hidden': true
                },
                {
                  'path': '',
                  'component': '',
                  'name': '发送',
                  'meta': { 'icon': null, 'title': '发送', 'functionType': 2, 'code': 'send' },
                  'children': [],
                  'hidden': true
                },
                {
                  'path': '',
                  'component': '',
                  'name': '打款',
                  'meta': { 'icon': null, 'title': '打款', 'functionType': 2, 'code': 'remit' },
                  'children': [],
                  'hidden': true
                },
                {
                  'path': '',
                  'component': '',
                  'name': '启用禁用',
                  'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                  'children': [],
                  'hidden': true
                }
              ]
            }
          ]
        }*/
      /*  {
          'path': '',
          'component': '',
          'name': '系统管理',
          'meta': { 'icon': 'systemManagement', 'title': '系统管理', 'role': null, 'functionType': 1 },
          'children': [
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '用户管理',
              'meta': { 'icon': 'user', 'title': '用户管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/department/index',
              'component': 'systemManagement/department/index',
              'name': '部门管理',
              'meta': { 'icon': 'department', 'title': '部门管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/role/index',
              'component': 'systemManagement/role/index',
              'name': '角色管理',
              'meta': { 'icon': 'role', 'title': '角色管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '菜单管理',
              'meta': { 'icon': 'user', 'title': '菜单管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '授权管理',
              'meta': { 'icon': 'user', 'title': '授权管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '行政区划管理',
              'meta': { 'icon': 'user', 'title': '行政区划管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '供应商管理',
              'meta': { 'icon': 'user', 'title': '供应商管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '单位管理',
              'meta': { 'icon': 'user', 'title': '单位管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }
             ]
            }
            //分割线
          ]
        },
        {
          'path': '',
          'component': '',
          'name': '电商管理',
          'meta': { 'icon': 'systemManagement', 'title': '电商管理', 'role': null, 'functionType': 1 },
          'children': [
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '订单管理',
              'meta': { 'icon': 'user', 'title': '订单管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '车型管理',
              'meta': { 'icon': 'user', 'title': '车型管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '客户信息管理',
              'meta': { 'icon': 'user', 'title': '客户信息管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '客户需求管理',
              'meta': { 'icon': 'user', 'title': '客户需求管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '用车管理',
              'meta': { 'icon': 'user', 'title': '用车管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '资源管理',
              'meta': { 'icon': 'user', 'title': '资源管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '回访管理',
              'meta': { 'icon': 'user', 'title': '回访管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
            {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '投诉管理',
              'meta': { 'icon': 'user', 'title': '投诉管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            }




          ]
        },
        {
          'path': '',
          'component': '',
          'name': '生产管理',
          'meta': { 'icon': 'systemManagement', 'title': '生产管理', 'role': null, 'functionType': 1 },
          'children': [
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '订单分配',
              'meta': { 'icon': 'user', 'title': '订单分配', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '打印快递单',
              'meta': { 'icon': 'user', 'title': '打印快递单', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '工人管理',
              'meta': { 'icon': 'user', 'title': '工人管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '工序管理',
              'meta': { 'icon': 'user', 'title': '工序管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '车型帮助管理',
              'meta': { 'icon': 'user', 'title': '车型帮助管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '产品属性管理',
              'meta': { 'icon': 'user', 'title': '产品属性管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '物料规格管理',
              'meta': { 'icon': 'user', 'title': '物料规格管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '货架管理',
              'meta': { 'icon': 'user', 'title': '货架管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '货位管理',
              'meta': { 'icon': 'user', 'title': '货位管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '物料管理',
              'meta': { 'icon': 'user', 'title': '物料管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '入库管理',
              'meta': { 'icon': 'user', 'title': '入库管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '出库管理',
              'meta': { 'icon': 'user', 'title': '出库管理', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            },
             {
              'path': 'systemManagement/user/index',
              'component': 'systemManagement/user/index',
              'name': '订单分配',
              'meta': { 'icon': 'user', 'title': '订单分配', 'role': null, 'functionType': 1, 'code': '' },
              'children': [{
                'path': '',
                'component': '',
                'name': '删除',
                'meta': { 'icon': null, 'title': '删除', 'functionType': 2, 'code': 'del' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '添加',
                'meta': { 'icon': null, 'title': '添加', 'functionType': 2, 'code': 'add' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '修改',
                'meta': { 'icon': null, 'title': '修改', 'functionType': 2, 'code': 'edit' },
                'children': [],
                'hidden': true
              }, {
                'path': '',
                'component': '',
                'name': '启用禁用',
                'meta': { 'icon': null, 'title': '启用禁用', 'functionType': 2, 'code': 'on_off' },
                'children': [],
                'hidden': true
              }]
            }

          ]
        }
      */






    ]
  }
}
}
