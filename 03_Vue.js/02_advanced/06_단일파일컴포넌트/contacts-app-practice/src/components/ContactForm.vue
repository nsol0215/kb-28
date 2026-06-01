<template>
  <div class="input-form card card-body mt-3" @keyup.enter="addcontact">
    <div class="row g-3">
      <div class="col-md-2">
        <input
          type="text"
          class="form-control"
          placeholder="이름"
          v-model="name"
        />
      </div>
      <div class="col-md-2">
        <select class="form-select" v-model="gender">
          <option value="">성별</option>
          <option value="남">남</option>
          <option value="여">여</option>
        </select>
      </div>
      <div class="col-md-2">
        <input
          type="number"
          class="form-control"
          placeholder="나이"
          v-model="age"
        />
      </div>
      <div class="col-md-3">
        <input
          type="email"
          class="form-control"
          placeholder="이메일"
          v-model="email"
        />
      </div>
      <div class="col-md-2">
        <input
          type="text"
          class="form-control"
          placeholder="Github ID"
          v-model="github"
        />
      </div>
      <div class="col-md-1">
        <button class="btn btn-primary w-100" @click="addContactHandler">
          추가
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'ContactForm',

  data() {
    // 3. 사용할 변수들을 미리 선언해둡니다.
    return {
      name: '',
      gender: '',
      age: '',
      email: '',
      github: '',
    };
  },

  methods: {
    addContactHandler() {
      if (this.name.trim() === '') {
        alert('이름을 입력하세요');
        return;
      } else if (this.email.trim() === '') {
        alert('이메일을 입력하세요');
        return;
      }

      this.$emit('addcontact', this.contact);
      this.contact = { name: '', gender: '', age: '', email: '', github: '' };
      // 이름이 입력 안된 경우 '이름을 입력하세요' 알림창
      // 이메일이 입력 안된 경우 '이메일을 입력하세요' 알림창
      // 둘 다 입력이 된 경우 연락처 추가
    },
  },
};
</script>
