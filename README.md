# webservice
localhost:8080/user/signUp ==> signUp method==>POST
body example :
{
	"fullName":"sajad mohammadi",
	"username":"sajad",
	"password":"123"
}

Other api method need authentication
in postman set authorization to type "Basic Auth" and enter user pass
read/update/delete for user/profile need authentication

Method update user
localhost:8080/admin/updateUser/{Id}  method==>PUT
body example :{
	"fullName":"sajad",
	"username":"sajad",
	"password":"123",
	"userProfile":{
		"address":"iran",
		"info":"engineer"
	}
}

method update profile   method==>PUT
localhost:8080/admin/updateProfile/9
{
	"id":9,
	"address":"iran",
	"info":"student"
}

method read user or read profile
localhost:8080/admin/readUser/11  method==>GET
localhost:8080/admin/readProfile/9 method==>GET

method delete user or delete profile
localhost:8080/admin/deleteUser/11  method==>DELETE
localhost:8080/admin/deleteProfile/9 method==>DELETE
