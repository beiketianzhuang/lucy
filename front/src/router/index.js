import Vue from 'vue'
import Router from 'vue-router'
import CompanySearch from "../components/CompanySearch";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'search',
      component: CompanySearch
    }
  ]
})
