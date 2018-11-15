//https://docs.mongodb.com/manual/reference/method/

db.user.save({
  "firstname": "Michael",
  "lastname": "Zhang",
  "tag": ["apple", "orange", "banana"]
});

db.user.save({
  "firstname": "Apple",
  "lastname": "Orange",
  "tag": ["pineapple", "cherry"]
});

