package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator
import org.mockito.MockitoSugar.{mock, when}

class UserImplTest extends org.scalatest.flatspec.AnyFlatSpec{
  val mockedUserValidate = mock[UserValidator]
  val ankitUser : User = User("Ankit", "Mogha", 23, 15000, "Software Engineer" ,"Knoldus", "ankit.mogha@knoldus.com")
  val adarshUser : User = User("Adarsh", "Verma", 23, 15100, "Software Engineer" ,"TTN", "adarsh.verma@gmail.com")

  "Employee" should "be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(ankitUser)) thenReturn(true)
    val result = userImpl.createUser((ankitUser))
    assert(!result.isEmpty)
  }

  "Employee" should "be not be valid" in{
    val userImpl = new UserImpl(mockedUserValidate)
    when(mockedUserValidate.userIsValid(adarshUser)) thenReturn(false)
    val result = userImpl.createUser((adarshUser))
    assert(result.isEmpty)
  }

}
