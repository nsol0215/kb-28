<template>
  <div>
    X : <input type="text" v-model.number="x" /><br />
    Y : <input type="text" v-model.number="y" /><br />
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc',

  // setup() : 컴포넌트의 로직을 작성하는 함수
  // 컴포넌트 생명 주기 : beforeCreate 이후 created 이전 단계에서 실행
  // 컴포넌트 템플릿에서 사용할 정보를 반환(return)해야 함
  setup() {
    const x = ref(10); // 10으로 초기화;
    const y = ref(20); // 20으로 초기화
    return;
  },
};
</script>

<!-- 브라우저 -> 개발자 도구(F12) -> vue 탭 -> 컴포넌트 클릭

X, Y값 변경 시
-> <Calc> 컴포넌트의 setup -> x, y값 변경 확인
-->
