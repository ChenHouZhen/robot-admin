import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Knowledge from '@/components/Knowledge'
import Button from '@/components/element/Button'
import Login from '@/components/Login'
import Home from '@/components/Home'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
    },
    {
      path: '/home',
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
          path: '/knowledge',
          name: 'Knowledge',
          component: Knowledge,
          meta:{
            title:"知识点管理"
          }
        },
      ]
    }
  ]
})
