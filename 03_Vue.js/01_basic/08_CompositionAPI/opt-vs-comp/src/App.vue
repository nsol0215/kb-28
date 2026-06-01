<template>
  <div>
    <Composition />
    <hr />
    <Options />
    <hr />
    <Calc />
  </div>
</template>

<script>
import Options from './components/Options.vue';
import Composition from './components/Composition.vue';
import Calc from './components/Calc.vue';
export default {
  name: 'App',
  components: { Options, Composition, Calc },
};
</script>
