db.adminCommand('listDatabases');
db = db.getSiblingDB('myFirstDb');
//db.users.find();
cursor = db.users.find();
while ( cursor.hasNext() ) {
	printjson( cursor.next() );
}
