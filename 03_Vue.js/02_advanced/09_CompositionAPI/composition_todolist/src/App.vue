<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div class="title">🕒 TodolistApp 💻</div>
    </div>

    <div class="mt-2">
      <div
        v-if="notCompletedCount === 0"
        class="alert alert-success text-center"
      >
        <strong>고생했어요</strong> 모든 할 일을 끝냈어요
      </div>
      <div v-else class="alert alert-info text-center">
        오늘 할 일이 <strong>{{ notCompletedCount }}개</strong> 남았어요
        힘내세요!
      </div>
    </div>
    <div class="card card-body">
      <div class="row text-center">
        <div class="col">전체 todo 개수: {{ totalCount }}</div>
        <div class="col">
          완료 todo 개수:
          <strong class="text-success">{{ completedCount }}</strong>
        </div>
        <div class="col">
          미완료 todo 개수:
          <strong class="text-danger">{{ notCompletedCount }}</strong>
        </div>
      </div>
    </div>
    <div class="text-end mb-2">
      <button
        class="btn btn-danger btn-sm"
        @click="clearAll"
        v-confirm="'정말 모두 삭제할까요?'"
      >
        모든 할 일 삭제
      </button>
    </div>

    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo @add-todo="addTodo" />
        <TodoList
          :todoList="todoList"
          @toggle-completed="toggleCompleted"
          @delete-todo="deleteTodo"
        />
      </div>
    </div>
  </div>
</template>

<script>
import InputTodo from './components/InputTodo.vue';
import TodoList from './components/TodoList.vue';
import { ref, computed } from 'vue';

let ts = new Date().getTime();

export default {
  name: 'App',
  components: { TodoList, InputTodo },
  setup() {
    const todoList = ref([
      { id: ts, todo: 'Vue 원고 집필', completed: false },
      { id: ts + 1, todo: '일요일 애견 카페', completed: false },
      { id: ts + 2, todo: '자전거타기', completed: false },
      { id: ts + 3, todo: '딸과공원산책', completed: true },
      { id: ts + 4, todo: '실습 문제 풀기', completed: true },
    ]);

    const totalCount = computed(() => todoList.value.length);

    const completedCount = computed(
      () => todoList.value.filter((item) => item.completed === true).length,
    );

    const notCompletedCount = computed(
      () => todoList.value.filter((item) => item.completed === false).length,
    );
    const toggleCompleted = (id) => {
      let index = todoList.value.findIndex((item) => id === item.id);
      todoList.value[index].completed = !todoList.value[index].completed;
    };

    const deleteTodo = (id) => {
      let index = todoList.value.findIndex((item) => id === item.id);
      todoList.value.splice(index, 1);
    };
    const addTodo = (todo) => {
      if (todo.length >= 2) {
        todoList.value.push({
          id: new Date().getTime(),
          todo: todo,
          completed: false,
        });
      }
    };
    const clearAll = () => {
      if (confirm('정말 모든 할 일을 삭제하시겠습니까?')) {
        todoList.value = []; // 배열을 빈 통으로 만들면 끝!
      }
    };

    return {
      todoList,
      totalCount,
      completedCount,
      notCompletedCount,
      toggleCompleted,
      deleteTodo,
      addTodo,
      clearAll,
    };
  },
};
</script>
