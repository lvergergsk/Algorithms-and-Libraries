#!/bin/bash

# There should be no space between -p and password, just like "-pYourPassword".
function load() {
    local table="$(basename "$1" '.csv')"
    local columns="($(head -n1 $1))"
    echo "LOAD DATA LOCAL INFILE '$1' INTO TABLE $table FIELDS TERMINATED BY ',' IGNORE 1 LINES $columns;" \
        | mysql -h localhost -u root -pexample -P 3306 example
}
for f in /docker-entrypoint-initdb.d/csv/*.csv; do
    load $f
done
