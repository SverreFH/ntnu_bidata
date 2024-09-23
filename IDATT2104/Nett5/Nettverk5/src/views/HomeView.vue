<script setup lang="ts">
import TheWelcome from '../components/TheWelcome.vue'
import Compiler from "@/components/Compiler.vue";
</script>

<template>
  <div class = calcArea>
    <main>
      <Compiler />
    </main>
  </div>
</template>

<style scoped>
  @media (min-width: 1024px) {
    .calcArea {
      min-height: 100vh;
      display: flex;
      align-items: center;
      justify-content: center;
      background-color: antiquewhite;
      border: 3px solid #000;
      border-left: 1.5px;
      max-height: 100vh;
    }
  }
</style>
