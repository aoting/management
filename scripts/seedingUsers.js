db.adminCommand('listDatabases');
db = db.getSiblingDB('myFirstDb');

db.users.insert([{"username": "xat", "password": "xat", "authorities": ["ADMIN"], "firstName": "admin", "lastName": "admin"}]);


db.organisations.insert([
	{ "_id" : ObjectId("5ae4680d1f740c1058bf7f55"), "_class" : "com.xat.model.Organisation", "name" : "Manchester United" },
	{ "_id" : ObjectId("5ae46a371f740c1058bf7f56"), "_class" : "com.xat.model.Organisation", "name" : "Arsenal" }

]);

db.users.insert([{
    "username": "testuser1",
    "password": "xat",
    "authorities": [
        "ADMIN"
    ],
    "lastModified": ISODate("2017-09-10T13:39:39.718Z"),
    "organisation" : DBRef("organisations", ObjectId("5ae4680d1f740c1058bf7f55")),
    "firstName" : "David",
    "lastName" : "Beckham"

}, {
    "username": "testuser2",
    "password": "xat",
    "authorities": [
        "ADMIN"
    ],
    "lastModified": ISODate("2017-09-10T13:39:39.718Z"),
    "organisation" : DBRef("organisations", ObjectId("5ae4680d1f740c1058bf7f55")),
    "firstName" : "Ryan",
    "lastName" : "Giggs"
}]);

db.products.insert[
	{ "_id" : ObjectId("5ae470561f740c166e0f00cd"), "_class" : "com.xat.model.Product", "name" : "Football", "suppliers" : [ DBRef("organisations", ObjectId("5ae4680d1f740c1058bf7f55")), DBRef("organisations", ObjectId("5ae46a371f740c1058bf7f56")) ] }
]

//cursor = db.users.find();
//while ( cursor.hasNext() ) {
//	printjson( cursor.next() );
//}