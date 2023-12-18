<template>
  <table class="table table-striped">
    <thead>
      <tr>
        <th>Timestamp</th>
        <th>Sensor ID</th>
        <th>Sensor Type</th>
        <th>Value</th>
      </tr>
    </thead>
    <tbody id="sensorData">
      <tr v-for="data in sensorData">
        <td>{{ data.timestamp }}</td>
        <td>{{ data.metadata.sensorId }}</td>
        <td>{{ data.metadata.type }}</td>
        <td>{{ data.value }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from "vue";

const sensorData = ref([]);
let evtSource;

onMounted(() => {
  evtSource = new EventSource("http://localhost:8080/sensor/api/temperature"); 
  evtSource.addEventListener("message", (event) => {
    console.log(JSON.parse(event.data));
    sensorData.value.unshift(JSON.parse(event.data));
  });
  evtSource.onerror = (err) => {
    console.error("EventSource failed:", err);
    evtSource.close();
  };
});

onUnmounted(() => {
  evtSource.close();
});
</script>