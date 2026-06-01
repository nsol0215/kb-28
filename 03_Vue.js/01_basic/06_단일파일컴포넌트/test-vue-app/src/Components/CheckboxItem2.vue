<template>
  <li><input type="checkbox" />{{ idol.name }}</li>
</template>
<script>
export default {
  name: 'CheckboxItem', // 컴포넌트 이름
  props: ['idol'],
  // props로 전달 받은 idol 객체
};
</script>
