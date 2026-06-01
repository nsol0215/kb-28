<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    Y : <input type="text" v-model.number="state.y" /> <br />
    <button @click="calcAdd">계산</button> <br />
    <div>결과: {{ state.result }}</div>
  </div>
</template>

<script>
import { reactive } from 'vue';

export default {
  name: 'Calc3',
  setup() {
    /* reactive()
    - 객체를 반응형 데이터로 변환
    - 반환된 객체의 프로퍼티(속성)로 직접 값에 접근 (.value 안씀)
    
    */
    const state = reactive({ x: 15, y: 25, result: 40 });
    const calcAdd = () => {
      state.result = state.x + state.y;
    };

    return { state, calcAdd };
  },
};
</script>

<style scoped></style>
