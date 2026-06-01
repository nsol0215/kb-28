import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/Pages/Home.vue';
import About from '@/Pages/About.vue';
import Members from '@/Pages/Members.vue';
import Videos from '@/Pages/Videos.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/members',
      name: 'members',
      component: Members,
    },
    {
      path: '/videos',
      name: 'videos',
      component: Videos,
    },
  ],
});

export default router;
