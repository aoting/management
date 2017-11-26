db.adminCommand('listDatabases');
db = db.getSiblingDB('myFirstDb');

db.users.insert([{
    "username": "testuser1",
    "password": "xat",
    "authorities": [
        "ADMIN"
    ],
    "lastModified": ISODate("2017-09-10T13:39:39.718Z"),
    "organisation" : DBRef("organisations", ObjectId("59b518daa9aa9e944cfac4a6")),
    "firstName" : "David",
    "lastName" : "Beckham"

}, {
    "username": "testuser2",
    "password": "xat",
    "authorities": [
        "ADMIN"
    ],
    "lastModified": ISODate("2017-09-10T13:39:39.718Z"),
    "organisation" : DBRef("organisations", ObjectId("59b518daa9aa9e944cfac4a6")),
    "firstName" : "Ryan",
    "lastName" : "Giggs"
}]);

//cursor = db.users.find();
//while ( cursor.hasNext() ) {
//	printjson( cursor.next() );
//}