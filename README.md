# bookcatalog
bookcatalog is a Digital Library catalog system which helps manage Library book information and associated authors

Technical information and specifications

For Users
Dev Setup

1. Install Java 8 and maven on your system
2. Clone https://github.com/tendomart/bookcatalog.git
3. Go to the root of the folder and do the following

  #To Build and Run the project
- Buiild with `mvn clean install` or `mvn clean package`
- Run the project with `mvn spring-boot:run`

Running `mvn spring-boot:run` will start the server at default port  http://localhost:8080/

The Project endpoints have been documented using OpenAPI(Swagger 3.0)
So to see and or  test out the endpoints navigate to http://localhost:8080/swagger-ui.html

To See the changes performed on the In-memory database, open the browser and go to http://localhost:8080/h2



