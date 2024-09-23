<script setup lang="ts">

import axios from 'axios'

  async function sendCodeToBackEnd(){
    const entry = document.getElementById("entry")
    const stringToSend = entry.value;
    console.log(stringToSend)


    const response = await axios.post("http://localhost:8080/Execute", stringToSend ,{
      headers:{
        'Content-Type' : 'text/plain'
      }
    })

    const answer = response.data

    const result = document.getElementById("result")
    result.value = answer;
    console.log("Method call finishes")
  }

</script>

<template>
  <div class = compiler>
      <div class = entry>
        <textarea class = entryArea id = entry>
        </textarea>
      </div>
      <div class = buttons>
        <button id = compile @click="sendCodeToBackEnd()">Compile</button>
      </div>
      <div class = result>
        <textarea class = entryArea id = result>
        </textarea>
      </div>
  </div>

</template>

<style scoped>
@media (min-width: 1024px) {
  .compiler{
    min-height: 100vh;
    display: grid;
    align-items: center;
    justify-content: center;
  }

  .entryArea{
    min-height: 40vh;
    min-width: 70vh;
    max-width: 70vh;
    max-height: 40vh;
  }

  #compile{
    min-width: 70vh;
    min-height: 10vh;
    color: white;
    border: 0px;
    background-color: var(--color-heading);
    font-size: 20px;
  }


  button:hover {
    transform: scale(1.02);
  }
;
}


</style>