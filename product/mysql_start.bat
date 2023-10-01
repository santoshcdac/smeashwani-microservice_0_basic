docker container rm mysql
docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=product_DB -p 3306:3306 -d mysql