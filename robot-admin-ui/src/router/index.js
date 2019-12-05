import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Knowledge from '@/components/Knowledge'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/knowledge',
      name: 'Knowledge',
      component: Knowledge,
      meta:{
        title:"知识点管理"
      }
    }
  ]
})
