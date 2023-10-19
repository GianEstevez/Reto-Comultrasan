// db.createCollection("test")
// db.test.insertOne( { x: 1 } )

// use reto_comultrasan
// db.createUser({
//     user: "gamma",
//     pwd: "1234",
//     roles: ["readWrite", "dbAdmin"]
// })

// Connect to the database
var db = db.getSiblingDB("reto_comultrasan");

// Create a user
db.createUser({
    user: "gamma",
    pwd: "1234",
    roles: [
        { role: "readWrite", db: "reto_comultrasan" },
        "dbAdmin"
    ]
});
