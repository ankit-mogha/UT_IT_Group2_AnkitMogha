package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.User
import com.knoldus.validator.{EmailValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec

class UserImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val userImpl = new UserImpl(userValidator)

  "Employee" should "be valid" in {
    val ankitEmployee : User = User("Ankit", "Mogha", 23, 15000, "Software Engineer" ,"Knoldus", "ankit.mogha@knoldus.com")
    val result =  userImpl.createUser(ankitEmployee)
    assert(!result.isEmpty)
}

  "Employee" should "be invalid as it company does not exists in DB" in {
    val adarshUser : User = User("Adarsh", "Verma", 23, 15100, "Software Engineer" ,"QWERTy", "adarsh.verma@gmail.com")
    val result =  userImpl.createUser(adarshUser)
    assert(result.isEmpty)
}

  "Employee" should "be invalid as email id is invalid" in {
    val ankitUser : User = User("Ankit", "Mogha", 23, 15000, "Software Engineer" ,"Knoldus", "ankitknoldus.com")
    val result = userImpl.createUser(ankitUser)
    assert(result.isEmpty)
}
}