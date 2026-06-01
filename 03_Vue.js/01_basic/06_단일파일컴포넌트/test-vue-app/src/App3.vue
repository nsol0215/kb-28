<template>
  <div>
    <h2>관심있는 K-POP 가수?</h2>
    <ul>
      <CheckboxItem
        v-for="idol in idols"
        :key="idol.id"
        :idol="idol"
        :name="idol.name"
        :checked="idol.checked"
        :id="idol.id"
      />
    </ul>
  </div>
</template>
<script>
import CheckboxItem from './Components/CheckboxItem3.vue';

export default {
  // 내보내는 컴포넌트의 이름
  // App.vue는 루트 컴포넌트! -> 이름 미지정 시 <Root> 태그로 렌더링
  name: 'App',

  // 지역 컴포넌트 등록
  components: { CheckboxItem },
  data() {
    return {
      // props로 전달할 부모 데이터
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'ITZY', checked: false },
      ],
    };
  },
};
</script>
