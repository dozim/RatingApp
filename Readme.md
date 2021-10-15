
# An in dev backend for a Rating App



### Used scratch commands

GET http://localhost:8080/ratingobjects/users/1
Accept: application/json


###
GET http://localhost:8080/goodratings/users/1
Accept: application/json

###
POST http://localhost:8080/goodratings
Content-Type: application/json

{ "userId":  1, "ratingObjectId":  1}

###
POST http://localhost:8080/ratingobjects
Content-Type: application/json

{}

###
POST http://localhost:8080/users
Content-Type: application/json
Accept: application/json

{ "name": "Tom" }




