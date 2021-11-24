const mysql = require("mysql2/promise");
const express = require("express");
const cors = require("cors");
const router = require("./routes");
const app = express();

(async () => {
  app.use(express.json());
  app.use(cors());
  app.use(express.urlencoded({ extended: false }));
  app.use(router);

  const connection = await mysql.createConnection({
    host: "127.0.0.1",
    user: "root",
    password: "admin",
    port: "3306",
    database: "imed",
  });
  console.clear();
  global.con = connection;
  console.log("Conectou no MySQL!");

  app.listen(4000, function () {
    console.log("Server is running on port 4000");
  });
})();
