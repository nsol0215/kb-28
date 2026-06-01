<template>
  <div class="card card-body">
    <h2>About</h2>
    <P>요청경로 : {{ $route.fullPath }}</P>
  </div>
</template>

<script>
export default {
  name: 'About',
  created() {
    console.log(this.$route);
  },
};
</script>

<style scoped></style>
