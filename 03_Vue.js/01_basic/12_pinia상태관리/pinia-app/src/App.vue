<script setup>
// 컴포넌트 가져오기
import Like from '@/components/like.vue';
import Counter from '@/components/Counter.vue';

// 01_basic
import { useLikeStore } from '@/stores/01_basic/like';
// import { defineStore } from '@/stores/01_basic/counter';
const LikeStore = useLikeStore();
</script>

<template>
  <div>
    <h1>Pinia 상태 관리 예제</h1>
    <h2>좋아요 수 : {{ LikeStore.like }}</h2>
    <h2>좋아요 수 5배 증가 : {{ LikeStore.fivetimes }}</h2>
    <Like />
    <hr />
    <Counter />
  </div>
</template>

<style scoped></style>
