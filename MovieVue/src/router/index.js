import Vue from 'vue'
import VueRouter from 'vue-router'
import index from '../views/admin/index'
import HomeAdmin from '../views/admin/home/Home'
import CategoryAdmin from '../views/admin/categories/Category'
import FilmAdmin from '../views/admin/film/Film'
import LayoutFilmAdmin from '../views/admin/film/LayoutFilm'
import EpisodeAdmin from '../views/admin/film/Episode'
Vue.use(VueRouter)

const routes = [
  {
    path: '/Admin',
    component: index,
    children:[
    {
      path:'/',
      name:'HomeAdmin',
      component:HomeAdmin,
    },
    {
      path:'/category',
      name:'CategoryAdmin',
      component:CategoryAdmin,
    },
    {
      path:'/layoutFilm',
      component:LayoutFilmAdmin,
      meta: { requiresAuth: true },
      children:[
        {
          path:'/',
          name:'filmAdmin',
          component:FilmAdmin,
          meta: { requiresAuth: true }
        },
        {
          path:'/episode/:id',
          name:'episodeAdmin',
          component:EpisodeAdmin,
          meta: { requiresAuth: true }
        }

      ]
    },

    ]
  },

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
