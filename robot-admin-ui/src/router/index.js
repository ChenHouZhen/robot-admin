import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Knowledge from '@/components/Knowledge'
import Button from '@/components/element/Button'
import Login from '@/components/Login'
import Home from '@/components/Home'
import Table from '@/components/element/Table'
import SysDept from '@/components/sys/SysDept'
import SysUser from '@/components/sys/SysUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta:{
        title:"系统管理"
      },
      children:[
        {
          path: '/button',
          name: 'Button',
          component: Button,
          meta:{
            title:"按钮管理"
          }
        },
        {
          path: '/table',
          name: 'Table',
          component: Table,
          meta:{
            title:"表格管理"
          }
        },
        {
          path: '/knowledge',
          name: 'Knowledge',
          component: Knowledge,
          meta:{
            title:"知识点管理"
          }
        },
        {
          path: '/sys/dept',
          name: 'SysDept',
          component: SysDept,
          meta:{
            title:"部门管理"
          }
        },
        {
          path: '/sys/user',
          name: 'SysUser',
          component: SysUser,
          meta:{
            title:"用户管理"
          }
        },
      ]
    }
  ]
})
