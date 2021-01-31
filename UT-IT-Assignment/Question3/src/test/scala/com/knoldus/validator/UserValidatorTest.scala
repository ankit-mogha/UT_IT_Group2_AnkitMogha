package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.{Company, User}
import org.mockito.MockitoSugar.{mock, when}


class UserValidatorTest extends org.scalatest.flatspec.AnyFlatSpec {

  val msUser : User = User("MS", "Dhoni", 34, 50000000, "WK" ,"BCCI", "msdhoni@gmail.com")
  val bcciCompany: Company = Company("bcci", "bcci@gmail.com", "Mumbai")

  val mockedCompanyReadDto = mock[CompanyReadDto]
  val mockedEmail = mock[EmailValidator]


  "User" should "be a valid" in{

    when(mockedCompanyReadDto.getCompanyByName(msUser.companyName)) thenReturn (Option(bcciCompany))
    when(mockedEmail.emailIdIsValid(msUser.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(msUser)
    assert(result)

  }

  "User" should "be a invalid because email id is not valid" in{

    when(mockedCompanyReadDto.getCompanyByName(msUser.companyName)) thenReturn (Option(bcciCompany))
    when(mockedEmail.emailIdIsValid(msUser.emailId)) thenReturn(false)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(msUser)
    assert(!result)

  }

  "User" should "be a invalid because company does exist in the DataBase" in{

    when(mockedCompanyReadDto.getCompanyByName(msUser.companyName)) thenReturn (None)
    when(mockedEmail.emailIdIsValid(msUser.emailId)) thenReturn(true)

    val uservalidator = new UserValidator(mockedCompanyReadDto, mockedEmail)
    val result = uservalidator.userIsValid(msUser)
    assert(!result)

  }



}
