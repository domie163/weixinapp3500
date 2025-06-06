import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import discusscantingxinxi from '@/views/modules/discusscantingxinxi/list'
    import cantingxinxi from '@/views/modules/cantingxinxi/list'
    import pingjiaxinxi from '@/views/modules/pingjiaxinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import meishileixing from '@/views/modules/meishileixing/list'
    import storeup from '@/views/modules/storeup/list'
    import discusscantingmeishi from '@/views/modules/discusscantingmeishi/list'
    import cantingmeishi from '@/views/modules/cantingmeishi/list'
    import config from '@/views/modules/config/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: '校园资讯',
        component: news
      }
      ,{
	path: '/discusscantingxinxi',
        name: '餐厅信息评论',
        component: discusscantingxinxi
      }
      ,{
	path: '/cantingxinxi',
        name: '餐厅信息',
        component: cantingxinxi
      }
      ,{
	path: '/pingjiaxinxi',
        name: '评价信息',
        component: pingjiaxinxi
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/meishileixing',
        name: '美食类型',
        component: meishileixing
      }
      ,{
	path: '/storeup',
        name: '我的收藏管理',
        component: storeup
      }
      ,{
	path: '/discusscantingmeishi',
        name: '餐厅美食评论',
        component: discusscantingmeishi
      }
      ,{
	path: '/cantingmeishi',
        name: '餐厅美食',
        component: cantingmeishi
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
