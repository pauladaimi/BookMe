var express = require("express"),
    app = express(),
    bodyParser = require("body-parser"),
    expressSanitizer = require("express-sanitizer"),
    methodOverride = require("method-override");

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

app.listen(8000, function() {
   console.log("BookMe Server Running..."); 
});