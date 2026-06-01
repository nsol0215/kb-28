<template>
  <div class="card card-body">
    <h2>Member Info</h2>
    <div>
      경로 패턴: /members/:id<br />
      요청 경로: {{ currentRoute.fullPath }}<br />
      id값: {{ currentRoute.params.id }}<br />
    </div>
  </div>
  <div className="mt-5">
    <img :src="member.photo" class="img" />
    <h4 class="mt-2">{{ member.name }}- {{ member.role }}</h4>
    <p>{{ member.desc }}</p>
    <a class="fa fa-instagram m-1"></a>
    <a class="fa fa-facebook m-1"></a>
    <a class="fa fa-youtube m-1"></a>
    <br /><br />
    <!-- <router-link to="/members">멤버 목록으로</router-link> -->
    <router-link :to="{ name: 'members' }">멤버 목록으로</router-link>
  </div>
</template>
<script setup>
import { useRoute } from 'vue-router';
import members from '@/members.json';
const currentRoute = useRoute();

const id = parseInt(currentRoute.params.id, 10); // 10진법 숫자로 파싱
console.log(id);

//멤버 정보 조회
// 배열.find((요소) => 조건 ) : 조건이 true라면 해당 요소 반환 및 종료
//                              없다면 undefined 반환
const member = members.find((mem) => mem.id === id);
console.log(members);
</script>
