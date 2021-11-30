import { MongoClient } from "mongodb";

const client = new MongoClient("mongodb://127.0.0.1:27017");

setInterval(async () => {
  try {
    await client.connect();

    const database = client.db("webflux-demo");
    const sensorData = database.collection("sensors");
    const data = generateRandomData();
    await sensorData.insertMany(data);
    console.log(`Inserted ${data.length} entries`);
  } finally {
    await client.close();
  }
}, 1000);

const generateRandomData = () => {
  let result = [];
  let count = getRandom(1, 11);
  for (let i = 0; i < count; i++) {
    result.push({
      metadata: {
        sensorId: getRandom(1, 6),
        type: "temperature",
      },
      timestamp: new Date(),
      value: getRandom(10, 36),
    });
  }
  return result;
};

const getRandom = (min, max) => {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min)) + min;
};
