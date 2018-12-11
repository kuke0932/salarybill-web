webpackJsonp([10],{"7bhJ":function(n,e,t){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var a=t("YY3n"),i=t("COTu"),s=t("5ybE"),r={name:"viewUser",props:{groupId:{type:Number,required:!0}},data:function(){return{total:-1,unTotal:-1,pageNum:1,pageSize:10,unPageNum:1,unPageSize:10,userList:null,multipleSelection:[],removeSelection:[],departmentTree:null,searchLoginName:null,searchUserName:null,searchUnUserName:null,searchUnLoginName:null,groupUserList:null,listLoading:!1,treeVisible:!1,dialogVisible:!1,addForm:{groupName:"",groupDes:""},defaultProps:{children:"children",label:"label"}}},watch:{groupId:function(n){this.fetchData(this.groupId,null,null,this.pageNum,this.pageSize),this.initDepartmentTree()}},mounted:function(){Object(a.a)(location.hash.substring(2)),this.fetchData(this.groupId,null,null,this.pageNum,this.pageSize),this.initDepartmentTree()},methods:{fetchData:function(n,e,t,a,s){var r=this;this.listLoading=!0,Object(i.g)(n,e,t,a,s).then(function(n){r.groupUserList=n.data.data.rows,r.groupUserList.forEach(function(n,e){n.idx=e}),r.total=n.data.data.total,r.pageNum=n.data.data.pageNum,r.pageSize=n.data.data.pageSize,r.listLoading=!1})},searchUser:function(){this.fetchData(this.groupId,this.searchLoginName,this.searchUserName,this.pageNum,this.pageSize)},searchUnUser:function(){this.getUserList(this.groupId,this.departmentId,this.searchUnLoginName,this.searchUnUserName,2,this.pageNum,this.pageSize)},initDepartmentTree:function(){var n=this;Object(s.e)().then(function(e){n.departmentTree=e.data.data})},getUserList:function(n,e,t,a){var s=arguments.length>4&&void 0!==arguments[4]?arguments[4]:2,r=this,o=arguments[5],l=arguments[6];this.listLoading=!0,Object(i.d)(n,e,t,a,s,o,l).then(function(n){r.userList=n.data.data.rows,r.userList.forEach(function(n,e){n.idx=e}),r.unTotal=n.data.data.total,r.unPageNum=n.data.data.pageNum,r.unPageSize=n.data.data.pageSize,r.listLoading=!1})},handleCurrentPageChangeGroup:function(n){this.pageNum=n,this.fetchData(this.groupId,this.searchLoginName,this.searchUserName,this.pageNum,this.pageSize)},handleCurrentPageChangeUser:function(n){this.pageNum=n,this.getUserList(this.groupId,this.departmentId,this.searchUnLoginName,this.searchUnUserName,2,this.unPageNum,this.unPageSize)},handleNodeClick:function(n){this.departmentId=n.id,n.parentId||(this.departmentId=null),this.getUserList(this.groupId,this.departmentId,null,null,2,this.unPageNum,this.unPageSize)},handleSelectionChange:function(n){this.multipleSelection=n},handleRemoveSelection:function(n){this.removeSelection=n},goAddGroupUser:function(){this.dialogVisible=!0,this.getUserList(this.groupId,this.departmentId,null,null,2,this.unPageNum,this.unPageSize)},saveAddUser:function(){var n=this;this.multipleSelection.length<1?this.$message({type:"warning",message:"请至少选中一行再执行此操作",duration:"2000"}):this.$confirm("确定保存？","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){for(var e=n.multipleSelection,t=[],a=0;a<e.length;a++)t.push(e[a].id);Object(i.b)(n.groupId,t.join(",")).then(function(){n.$message({type:"success",message:"保存成功",duration:2e3,onClose:function(){n.fetchData(n.groupId,n.searchLoginName,n.searchUserName,n.pageNum,n.pageSize),n.dialogVisible=!1}})})})},deleteGroupUser:function(){var n=this;this.removeSelection.length<1?this.$message({type:"warning",message:"请至少选中一行再执行此操作",duration:"2000"}):this.$confirm("此操作将永久删除该角色，是否继续","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){for(var e=n.removeSelection,t=[],a=0;a<e.length;a++)t.push(e[a].id);Object(i.f)(n.groupId,t.join(",")).then(function(){n.$message({type:"success",message:"删除成功",duration:2e3,onClose:function(){n.fetchData(n.groupId,n.searchLoginName,n.searchUserName,n.pageNum,n.pageSize)}})})})},resetForm:function(n){this.$refs[n].resetFields()},handleClose:function(n){this.$confirm("确认关闭吗?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then(function(){n()}).catch(function(){})}}},o={render:function(){var n=this,e=n.$createElement,t=n._self._c||e;return t("div",{staticClass:"container"},[t("el-form",[t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{"label-width":"70px",label:"登录名"}},[t("el-input",{staticStyle:{"min-width":"120px"},model:{value:n.searchLoginName,callback:function(e){n.searchLoginName=e},expression:"searchLoginName"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:9}},[t("el-form-item",{attrs:{"label-width":"80px",label:"用户昵称"}},[t("el-input",{staticStyle:{"min-width":"120px"},model:{value:n.searchUserName,callback:function(e){n.searchUserName=e},expression:"searchUserName"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:3}},[t("el-button",{staticStyle:{"margin-left":"20px"},attrs:{type:"primary",loading:n.listLoading},on:{click:n.searchUser}},[n._v("查询")])],1)],1),n._v(" "),t("div",{staticClass:"btn_box"},[t("el-button",{staticClass:"el-button--primary",attrs:{code:"add"},on:{click:n.goAddGroupUser}},[n._v("添加群组用户")]),n._v(" "),t("el-dialog",{attrs:{title:"添加群组用户",visible:n.dialogVisible,width:"80%","append-to-body":"","before-close":n.handleClose},on:{"update:visible":function(e){n.dialogVisible=e}}},[t("el-row",[t("el-col",{attrs:{span:5}},[t("el-button",{staticClass:"el-button--primary",attrs:{size:"small",code:"save"},on:{click:n.saveAddUser}},[n._v("保存")]),n._v(" "),t("h4",{staticStyle:{"margin-top":"0",color:"#606266"}},[n._v("部门列表")]),n._v(" "),t("el-tree",{ref:"tree",attrs:{data:n.departmentTree,"node-key":"id","highlight-current":"","default-expand-all":"","expand-on-click-node":!1,props:n.defaultProps},on:{"node-click":n.handleNodeClick}})],1),n._v(" "),t("el-col",{attrs:{span:18}},[t("el-form",[t("el-row",[t("el-col",{attrs:{span:8}},[t("el-form-item",{attrs:{"label-width":"70px",label:"登录名"}},[t("el-input",{staticStyle:{"min-width":"120px"},model:{value:n.searchUnLoginName,callback:function(e){n.searchUnLoginName=e},expression:"searchUnLoginName"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:9}},[t("el-form-item",{attrs:{"label-width":"80px",label:"用户昵称"}},[t("el-input",{staticStyle:{"min-width":"120px"},model:{value:n.searchUnUserName,callback:function(e){n.searchUnUserName=e},expression:"searchUnUserName"}})],1)],1),n._v(" "),t("el-col",{attrs:{span:3}},[t("el-button",{staticStyle:{"margin-left":"20px"},attrs:{type:"primary",loading:n.listLoading},on:{click:n.searchUnUser}},[n._v("查询")])],1)],1),n._v(" "),t("el-table",{directives:[{name:"loading",rawName:"v-loading.body",value:n.listLoading,expression:"listLoading",modifiers:{body:!0}}],staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:n.userList,"element-loading-text":"拼命加载中",border:"",fit:"","tooltip-effect":"dark","highlight-current-row":""},on:{"selection-change":n.handleSelectionChange}},[t("el-table-column",{attrs:{type:"selection",width:"50"}}),n._v(" "),t("el-table-column",{attrs:{label:"登录名"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n                    "+n._s(e.row.loginName)+"\n                  ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"部门"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n                    "+n._s(e.row.departmentName)+"\n                  ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"用户昵称"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n                    "+n._s(e.row.userName)+"\n                  ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"手机号"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n                    "+n._s(e.row.mobile)+"\n                  ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"状态"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n                    "+n._s(1==e.row.status?"正常":"冻结")+"\n                  ")]}}])})],1),n._v(" "),t("el-pagination",{staticStyle:{float:"right","margin-top":"15px"},attrs:{background:"",layout:"prev, pager, next",total:n.unTotal,"page-size":n.unPageSize},on:{"current-change":n.handleCurrentPageChangeUser}})],1)],1)],1)],1),n._v(" "),t("el-button",{staticClass:"el-button--danger",attrs:{code:"del"},on:{click:n.deleteGroupUser}},[n._v("删除群组用户")])],1),n._v(" "),t("el-table",{directives:[{name:"loading",rawName:"v-loading.body",value:n.listLoading,expression:"listLoading",modifiers:{body:!0}}],staticStyle:{width:"100%","margin-top":"20px"},attrs:{data:n.groupUserList,"element-loading-text":"拼命加载中",border:"",fit:"","tooltip-effect":"dark","highlight-current-row":""},on:{"selection-change":n.handleRemoveSelection}},[t("el-table-column",{attrs:{type:"selection",width:"50"}}),n._v(" "),t("el-table-column",{attrs:{prop:"loginName",label:"登录名",width:"180"}}),n._v(" "),t("el-table-column",{attrs:{label:"部门"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n          "+n._s(e.row.departmentName)+"\n        ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"用户昵称"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n          "+n._s(e.row.userName)+"\n        ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"手机号"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n          "+n._s(e.row.mobile)+"\n        ")]}}])}),n._v(" "),t("el-table-column",{attrs:{label:"状态"},scopedSlots:n._u([{key:"default",fn:function(e){return[n._v("\n          "+n._s(1==e.row.status?"正常":"冻结")+"\n        ")]}}])})],1),n._v(" "),t("el-pagination",{staticStyle:{float:"right","margin-top":"15px"},attrs:{background:"",layout:"prev, pager, next",total:n.total,"page-size":n.pageSize},on:{"current-change":n.handleCurrentPageChangeGroup}})],1)],1)},staticRenderFns:[]};var l=t("VU/8")(r,o,!1,function(n){t("G/J/")},"data-v-7614607e",null);e.default=l.exports},COTu:function(n,e,t){"use strict";e.c=function(n){var e=arguments.length>1&&void 0!==arguments[1]?arguments[1]:1,t=arguments.length>2&&void 0!==arguments[2]?arguments[2]:10,i={groupName:n,pageNum:e,pageSize:t};return Object(a.a)({url:"/system/admin/sysGroup/listGroup",method:"get",params:i})},e.a=function(n,e){var t={groupName:n,groupDesc:e};return Object(a.a)({url:"/system/admin/sysGroup/addGroup",method:"post",data:s.a.stringify(t)})},e.h=function(n,e,t){var i={id:n,groupName:e,groupDesc:t};return Object(a.a)({url:"/system/admin/sysGroup/updateGroup",method:"post",data:s.a.stringify(i)})},e.e=function(n){var e={ids:n};return Object(a.a)({url:"/system/admin/sysGroup/removeGroup",method:"post",data:s.a.stringify(e)})},e.g=function(n,e,t){var i=arguments.length>3&&void 0!==arguments[3]?arguments[3]:1,s=arguments.length>4&&void 0!==arguments[4]?arguments[4]:10,r={groupId:n,loginName:e,userName:t,pageNum:i,pageSize:s};return Object(a.a)({url:"/system/admin/sysGroup/showGroupUsers",method:"get",params:r})},e.d=function(n,e,t,i){var s=arguments.length>4&&void 0!==arguments[4]?arguments[4]:2,r=arguments.length>5&&void 0!==arguments[5]?arguments[5]:1,o=arguments.length>6&&void 0!==arguments[6]?arguments[6]:10,l={groupId:n,departmentId:e,loginName:t,userName:i,showOrAdd:s,pageNum:r,pageSize:o};return Object(a.a)({url:"/system/admin/sysUser/listUser",method:"get",params:l})},e.b=function(n,e){var t={groupId:n,userIds:e};return Object(a.a)({url:"/system/admin/sysGroup/addUserToGroup",method:"post",data:s.a.stringify(t)})},e.f=function(n,e){var t={groupId:n,userIds:e};return Object(a.a)({url:"/system/admin/sysGroup/removeUserFromGroup",method:"post",data:s.a.stringify(t)})};var a=t("vLgD"),i=t("mw3O"),s=t.n(i)},"G/J/":function(n,e,t){var a=t("ivRl");"string"==typeof a&&(a=[[n.i,a,""]]),a.locals&&(n.exports=a.locals);t("rjj0")("cf0bc8de",a,!0)},ivRl:function(n,e,t){(n.exports=t("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])}});