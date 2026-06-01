<template>
  <div>
    x : <input type="text" v-model.number="x" /> <br />
    결과 : {{ result }}
  </div>
</template>

<script>
import { ref, watch } from 'vue';

export default {
  name: 'Calc5',
  setup() {
    const x = ref(0);
    const result = ref(0);

    /* watch()
    - 반응형 데이터의 변화를 감지하고 콜백 함수를 실행
    - 첫 번째 인자 : 감시 대상(ref, reactive 또는 getter 함수)
    - 두 번째 인자 : 콜백 함수 (현재 값, 이전 값)
    - 세 번째 인자 : 옵션 객체

    immediate : true
    -> 최초 실행 시에도 콜백 함수 실행

    - deep : true
    -> 객테/배열 내부 값 변화까지 감지
    */
    watch(
      x, // 첫 번째 인자
      (current, old) => {
        result.value = current - old;
      }, // 두 번째 인자
      { immediate: true },
    );
    return { x, result };
  },
};
</script>

<style scoped></style>
