import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

/* Layout */
import Layout from '@/layout'

/**
 * Note: sub-menu only appear when route children.length >= 1
 * Detail see: https://panjiachen.github.io/vue-element-admin-site/guide/essentials/router-and-nav.html
 *
 * hidden: true                   if set true, item will not show in the sidebar(default is false)
 * alwaysShow: true               if set true, will always show the root menu
 *                                if not set alwaysShow, when item has more than one children route,
 *                                it will becomes nested mode, otherwise not show the root menu
 * redirect: noRedirect           if set noRedirect will no redirect in the breadcrumb
 * name:'router-name'             the name is used by <keep-alive> (must set!!!)
 * meta : {
    roles: ['admin','editor']    control the page roles (you can set multiple roles)
    title: 'title'               the name show in sidebar and breadcrumb (recommend set)
    icon: 'svg-name'/'el-icon-x' the icon show in the sidebar
    breadcrumb: false            if set false, the item will hidden in breadcrumb(default is true)
    activeMenu: '/example/list'  if set path, the sidebar will highlight the path you set
  }
 */

/**
 * constantRoutes
 * a base page that does not have permission requirements
 * all roles can be accessed
 */
export const constantRoutes = [
  {
    path: '/login',
    component: () => import('@/views/login/index'),
    hidden: true
  },

  {
    path: '/404',
    component: () => import('@/views/404'),
    hidden: true
  },

  {
    path: '/',
    component: Layout,
    redirect: '/dashboard',
    children: [{
      path: 'dashboard',
      name: 'Dashboard',
      component: () => import('@/views/dashboard/index'),
      meta: { title: 'Dashboard', icon: 'dashboard' }
    }]
  },
{
  path: '/employee',
  component: Layout,
  redirect: '/employee',
  name: '员工管理',
  meta: {
    title: '员工管理',
    icon: 'nested'
  },
  children: [
    {
      path: 'emp',
      component: () => import('@/views/employee/index'), // Parent router-view
      name: '员工列表',
      meta: { title: '基本信息' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/employee/emp/list'),
          name: '员工列表',
          meta: { title: '员工列表' }
        },
        {
          path: 'add',
          component: () => import('@/views/employee/emp/add'),
          name: '添加',
          meta: { title: '添加新员工' },
        },
        {
          path: 'edit/:id',
          name: '修改',
          component: () => import('@/views/employee/emp/add'),
          meta: { title: '编辑', noCache: true },
          hidden: true
        },
      ]
    },
    {
      path: 'train',
      component: () => import('@/views/employee/index'),
      name: '培训列表',
      meta: { title: '培训记录' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/employee/train/list'),
          name: '记录列表',
          meta: { title: '记录列表' }
        },
        {
          path: 'add',
          component: () => import('@/views/employee/train/add'),
          name: '添加',
          meta: { title: '添加新记录' },
        },
        {
          path: 'edit/:id',
          name: '修改',
          component: () => import('@/views/employee/train/add'),
          meta: { title: '编辑', noCache: true },
          hidden: true
        },
      ]
    },
    {
      path: 'RandP',
      component: () => import('@/views/employee/index'),
      name: '奖惩列表',
      meta: { title: '奖惩记录' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/employee/RandP/list'),
          name: '记录列表',
          meta: { title: '记录列表' }
        },
        {
          path: 'add',
          component: () => import('@/views/employee/RandP/add'),
          name: '添加',
          meta: { title: '添加新记录' }, 
        },
        {
          path: 'edit/:id',
          name: '修改',
          component: () => import('@/views/employee/RandP/add'),
          meta: { title: '编辑', noCache: true },
          hidden: true
        },
      ]
    },
    {
      path: 'assessment',
      component: () => import('@/views/employee/index'),
      name: '考核列表',
      meta: { title: '考核记录' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/employee/assessment/list'),
          name: '考核列表',
          meta: { title: '记录列表' }
        },
        {
          path: 'add',
          component: () => import('@/views/employee/assessment/add'),
          name: '添加',
          meta: { title: '添加新记录' },
        },
        {
          path: 'edit/:id',
          name: '修改',
          component: () => import('@/views/employee/assessment/add'),
          meta: { title: '编辑', noCache: true },
          hidden: true
        },
      ]
    },
    {
      path: 'changejob',
      component: () => import('@/views/employee/index'),
      name: '调岗列表',
      meta: { title: '调岗列表' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/employee/changejob/list'),
          name: '调换列表',
          meta: { title: '调换列表' }
        },
        {
          path: 'add',
          component: () => import('@/views/employee/changejob/add'),
          name: '添加',
          meta: { title: '添加新记录' },
        },
        {
          path: 'edit/:id',
          name: '修改',
          component: () => import('@/views/employee/changejob/add'),
          meta: { title: '编辑', noCache: true },
          hidden: true
        },
      ]
    }
  ]
},
{
  path: '/salary',
  component: Layout,
  redirect: '/salary',
  name: '工资管理',
  meta: { title: '工资管理', icon: 'el-icon-s-help' },
  children: [
    {
      path: 'list',
      name: '工资表',
      component: () => import('@/views/salary/list'),
      meta: { title: '工资表', icon: 'table' }
    },
    // {
    //   path: 'changelist',
    //   name: '调薪记录',
    //   component: () => import('@/views/salary/changesalary'),
    //   meta: { title: '调薪记录', icon: 'tree' },
    // },
    {
      path: 'add',
      name: '添加',
      component: () => import('@/views/salary/add'),
      meta: { title: '添加', icon: 'tree' },
    },
    {
      path: 'edit/:id',
      name: '修改',
      component: () => import('@/views/salary/add'),
      meta: { title: '编辑', noCache: true },
      hidden: true
    },
  ]
},
{
path: '/admin',
  component: Layout,
  redirect: '/admin',
  name: '系统管理',
  meta: {
    title: '系统管理',
    icon: 'nested'
  },
  children: [
    {
      path: '/role',
      component: () => import('@/views/admin/index'), // Parent router-view
      name: '角色管理',
      meta: { title: '角色管理' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/admin/role/list'),
          name: '角色列表',
          meta: { title: '角色列表' }
        },
      ]
    },
    {
      path: '/menu',
      component: () => import('@/views/admin/index'), // Parent router-view
      name: '权限管理',
      meta: { title: '权限管理' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/admin/menu/list'),
          name: '权限列表',
          meta: { title: '权限列表' }
        },
        {
          path: 'empowerment',
          component: () => import('@/views/admin/menu/role'),
          name: '角色权限',
          meta: { title: '角色权限' }
        },
        {
          path: 'add',
          component: () => import('@/views/admin/menu/add'),
          name: '添加',
          meta: { title: '添加' },
          hidden: true
        },
      ]
    },
    {
      path: '/email',
      component: () => import('@/views/admin/index'), // Parent router-view
      name: '邮件管理',
      meta: { title: '邮件管理' },
      children: [
        {
          path: 'list',
          component: () => import('@/views/admin/mail/list'),
          name: '邮件列表',
          meta: { title: '邮件列表' }
        },
        {
          path: 'status',
          component: () => import('@/views/admin/mail/status'),
          name: '状态',
          meta: { title: '状态' }
        },
      ]
    }
  ],
},

  // 404 page must be placed at the end !!!
  { path: '*', redirect: '/404', hidden: true }
]

const createRouter = () => new Router({
  // mode: 'history', // require service support
  scrollBehavior: () => ({ y: 0 }),
  routes: constantRoutes
})

const router = createRouter()

// Detail see: https://github.com/vuejs/vue-router/issues/1234#issuecomment-357941465
export function resetRouter() {
  const newRouter = createRouter()
  router.matcher = newRouter.matcher // reset router
}

export default router
