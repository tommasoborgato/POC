mvn package tomcat7:deploy
mvn package tomcat7:redeploy

http://localhost:8080/POC/rest/srv/prova
GET http://localhost:8080/POC/rest/srv/obj
POST http://localhost:8080/POC/rest/srv/obj
{"id":1,"content":"POC-GET","inputObjElems":[{"id":1,"content":"POC-1"},{"id":2,"content":"POC-2"}]}

-----------------------
Spring + Resteasy
-----------------------
http://maciej-miklas.blogspot.it/2012/07/resteasy-integration-with-spring.html

-----------------------
Angular 2 cli
-----------------------
https://github.com/angular/angular-cli
npm config set proxy http://icttb0:xxx@tmgproxy.esselunga.net:8080
npm config set https-proxy http://icttb0:xxx@tmgproxy.esselunga.net:8080
npm install -g angular-cli@latest

ng new ANGULAR2_POC
cd ANGULAR2_POC
ng serve
http://localhost:4200/