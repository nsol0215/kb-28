<template>
  <div>
    <h2>Counter</h2>
    <h3>반응형으로 값 꺼내기 : {{ counter.count }}</h3>
    <h3>값 꺼내기 : {{ count }}</h3>
    <button @click="increment">플러스</button>
    <button @click="reset">0으로 초기화</button>
    <button @click="selfincrement">자체적으로 1 증가</button>
  </div>
</template>

<script setup>
import { useCounterStore } from '@/stores/01_basic/counter';

const counter = useCounterStore();
// 값 자체를 가져올 때 반응형이 깨지기 때문에
// 객체 자체를 가져와서 꺼내 쓰는 것이 권장됨
const { count, increment, reset } = useCounterStore();

// 권장하지 않는 방식(각 추적이나 유지보수 어려움)
const selfincrement = () => {
  counter.count++;
};
</script>
