const express = require('express');
const app = express();

// Allow all origins
app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', '*');
  res.header('Access-Control-Allow-Methods', 'GET, PUT, POST, DELETE');
  res.header('Access-Control-Allow-Headers', 'Content-Type');
  res.header('Access-Control-Allow-Credentials', 'true'); // Set this header to 'true' only
  next();
});

// Handle requests
app.get('/', (req, res) => {
  res.send('Hello World!');
});

// Start server
app.listen(3000, () => {
  console.log('Server listening on port 3000');
});
