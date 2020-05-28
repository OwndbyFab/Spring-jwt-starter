# Spring-jwt-starter
Spring jwt starter project
Create User Roles in psql:
  INSERT INTO roles(name) VALUES('ROLE_USER');
  INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
  INSERT INTO roles(name) VALUES('ROLE_ADMIN');
  
Create User via POST Request
POST http://localhost:8080/api/auth/signup
{
	"username": "admin",
	"email": "admin@example.com",
	"password": "12345678",
	"role": ["mod", "user"]
}
