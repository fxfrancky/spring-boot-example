// NB: postgres is the container name
docker exec -it postgres bash

// connect to the database inside the postgres container
psql -U amigoscode

// List databases
\l

//connect to a database
"\c name_database"

// Describe a table
\d flyway_schema_history

//Expanded display is on.
\x

select * from flyway_schema_history;

// Init Sequence
select setval('customer_id_seq', 1, false);

// Execute the container
docker exec -it gracious_cray bash

// Connect directly to the database
psql -U amigoscode -d amigoscode-dao-unit-test

// Connect to the db
\c amigoscode-dao-unit-test
\d
Did not find any relations.


