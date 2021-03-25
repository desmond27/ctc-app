# ctc-app
A web application for Crack The Code type competitions

Before use, make sure you have a database installed and a schema is created.

I personally recommend installing MariaDB: https://mariadb.org/download/

After installing, login to MariaDB:

`mysql -u <username> -p` 

Create a schema called `digit_ctc`:

`create database digit_ctc`

You might need to give your database user all privileges on `digit_ctc.*`.

Then, edit the `src/main/resources/application.properties` file and set the following properties:

```
spring.datasource.username=<your db username>
spring.datasource.password=<your db password>
```
Leave the remaining properties as is.

Once that is done, run the application by executing `mvnw spring-boot:run` in the project directory (where pom.xml is).

When the application starts, open the browser and go to localhost:8080 and enter one of these credentials:

root/root12345 (Root user)
or
test/test (Normal user)
