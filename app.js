const cors = require('cors');
const express = require('express');
const app = express();

app.use(cors({
  origin: '*',
  methods: 'GET,PUT,POST,DELETE',
  allowedHeaders: 'Content-Type',
}));

