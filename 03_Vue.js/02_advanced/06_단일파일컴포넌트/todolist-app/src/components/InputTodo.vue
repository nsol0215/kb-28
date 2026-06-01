<template>
  <div class="row mb-3">
    <div class="col">
      <div class="input-group">
        <input
          type="text"
          class="form-control"
          placeholder="할일을 여기에 입력!"
          v-model="todo"
          @keyup.enter="addTodoHandler"
        />
        <span class="btn btn-primary" @click="addTodoHandler">추가</span>
      </div>
    </div>
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'InputTodo',
  emits: ['add-todo'],
  setup(props, { emit }) {
    const todo = ref('');
    const addTodoHandler = () => {
      if (todo.value.length >= 3) {
        emit('add-todo', todo.value);
        todo.value = '';
      }
    };
    return {
      todo,
      addTodoHandler,
    };
  },
};
</script>
