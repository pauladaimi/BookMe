const express = require("express"),
    app = express(),
    bodyParser = require("body-parser"),
    expressSanitizer = require("express-sanitizer"),
    methodOverride = require("method-override"),
    admin = require("firebase-admin");

let serviceAccount = require("./bookme-e82d7-firebase-adminsdk-ma0t3-11a806d0f4.json");

admin.initializeApp({
  credential: admin.credential.cert(serviceAccount),
  databaseURL: "https://bookme-e82d7.firebaseio.com"
});

app.use(bodyParser.urlencoded({extended: true}));
app.use(express.static("public"));
app.use(methodOverride("_method"));
app.use(expressSanitizer());

app.get("/", function(req, res) {
    res.render("home.ejs");
});


app.get("/spaces/new", function(req, res) {
	res.render("canvas.ejs");
});

app.post("/newuser", (req, res, next) => {
	let userInfo = req.body;
	console.log(userInfo);
	admin.auth().createUser({
  "email": userInfo.email,
  "password": userInfo.password,
  "displayName": userInfo.name,
  "phoneNumber": userInfo.number
})
  .then(function(userRecord) {
    // See the UserRecord reference doc for the contents of userRecord.
    console.log("Successfully created new user:", userRecord.uid);

    //Eventually will return idToken here to client
    res.send("Success");
  })
  .catch(function(error) {
    console.log("Error creating new user:", error);
    res.status(500).send("ERROR: " + error);
  });
});

app.post("user", (req, res, next) => {
	let userInfo = req.body;

});

app.listen(8000, function() {
   console.log("BookMe Server Running..."); 
});