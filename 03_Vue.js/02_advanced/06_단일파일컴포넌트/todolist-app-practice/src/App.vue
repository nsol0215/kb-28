<script>
import TodoList from './components/TodoList.vue';
import InputTodo from './components/InputTodo.vue';

let ts = new Date().getTime();

export default {
  name: 'App',
  components: { InputTodo, TodoList },
  data() {
    return {
      todoList: [
        { id: ts, todo: '자전거 타기', completed: false },
        { id: ts + 1, todo: '딸과 공원 산책', completed: true },
        { id: ts + 2, todo: '일요일 애견 카페', completed: false },
        { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
      ],
    };
  },
};
</script>

<template>
  <div id="app" class="container">
    <div class="card card-body bg-light">
      <div classe="title">:: TodolistApp</div>
    </div>
    <div class="card card-default card-borderless">
      <div class="card-body">
        <InputTodo />

        <!-- 목록 컴포넌트
         props를 이용해서 todolist를 자식 컴포넌트로 전달
          -->
        <TodoList: todolist="todolist" />
        <!-- todolist -> 자식에게 todolist라는 속성으로 todolist(데이터) 데이터 전달 -->
      </div>
    </div>
  </div>
</template>

<style scoped></style>
