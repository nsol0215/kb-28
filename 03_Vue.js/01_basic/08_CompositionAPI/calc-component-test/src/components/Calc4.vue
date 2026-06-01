<template>
  <div>
    X : <input type="text" v-model.number="state.x" /> <br />
    Y : <input type="text" v-model.number="state.y" /> <br />
    <div>결과: {{ result }}</div>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';
export default {
  name: 'Calc4',
  setup() {
    const state = reactive({ x: 35, y: 24 });

    /* computed()
    - 계산된 속성을 정의하는 함수
    - 반응형 데이터를 기반으로 계산된 반응형 값을 생성
    - 반환된 객체의 value 프로퍼티(==.value)로 접근

    */
    const result = computed(() => {
      return state.x + state.y; // 값 반환 및 함수 종료
    });
    console.log(result.value);

    return { state, result };
  },
};
</script>
