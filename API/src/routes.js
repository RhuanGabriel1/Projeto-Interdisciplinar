const express = require("express");
const { comumQuery } = require("./controllers/comumQuery");
const router = express.Router();

//will router the controllers.
router.post("/mysqlQuery", comumQuery);
//cache test
module.exports = router;
