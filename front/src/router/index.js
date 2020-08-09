import Vue from 'vue'
import Router from 'vue-router'
import CompanySearch from "../components/CompanySearch";
import CompanyRegistry from "../components/CompanyRegistry";
import Index from "../components/Index";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'search',
      component: CompanySearch
    },
    {
      path: '/registry',
      name: 'registry',
      component: CompanyRegistry
    },
    {
      path: '/index',
      name: 'index',
      component: Index
    }
  ]
})
