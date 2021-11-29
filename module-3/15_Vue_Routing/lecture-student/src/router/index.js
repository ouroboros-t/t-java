import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products.vue'
import ProductDetail from '@/views/ProductDetail.vue'
import AddReview from '@/views/AddReview.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    //create a dynamic url/path--cant' have hardcoded path
    path: '/products/:id', //:id is the placeholder/variable
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/products/:id/add-review',
    name: 'add-review',
    component: AddReview
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
