webpackJsonp([18],{HJuk:function(n,e,t){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=t("YY3n"),s=t("dmtY"),r=t("STSY"),c={name:"viewMenu",props:{roleId:{type:Number,required:!0}},data:function(){return{treeMenu:null,defaultProps:{children:"children",label:"label"}}},watch:{roleId:function(n){this.initFunctionTree(),this.getRoleFunction()}},mounted:function(){Object(i.a)(location.hash.substring(2)),this.initFunctionTree(),this.getRoleFunction()},methods:{initFunctionTree:function(){var n=this;Object(s.g)().then(function(e){n.treeMenu=e.data.data})},getRoleFunction:function(){var n=this;Object(r.c)(this.roleId).then(function(e){n.$refs.treeMenu.setCheckedKeys(e.data.data)})},addSelectPermission:function(){var n=this,e=this.$refs.treeMenu.getCheckedKeys();Object(r.h)(this.roleId,e).then(function(e){n.$message({type:"success",message:"保存成功",onClose:function(){n.$emit("closeViewMenu")}})})}}},o={render:function(){var n=this.$createElement,e=this._self._c||n;return e("div",{staticClass:"container"},[e("el-tree",{ref:"treeMenu",staticStyle:{padding:"0 50px"},attrs:{data:this.treeMenu,"node-key":"id","highlight-current":"","show-checkbox":"","check-strictly":"","expand-on-click-node":!1,props:this.defaultProps}}),this._v(" "),e("div",{staticStyle:{margin:"15px 0","text-align":"center"}},[e("el-button",{staticClass:"el-button--primary",attrs:{size:"small "},on:{click:this.addSelectPermission}},[this._v("保存")])],1)],1)},staticRenderFns:[]};var a=t("VU/8")(c,o,!1,function(n){t("t/Fm")},"data-v-31342682",null);e.default=a.exports},d1wd:function(n,e,t){(n.exports=t("FZ+f")(!1)).push([n.i,"\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n",""])},"t/Fm":function(n,e,t){var i=t("d1wd");"string"==typeof i&&(i=[[n.i,i,""]]),i.locals&&(n.exports=i.locals);t("rjj0")("1a9273ea",i,!0)}});