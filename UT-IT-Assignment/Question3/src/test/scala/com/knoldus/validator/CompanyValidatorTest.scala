package com.knoldus.validator

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import org.mockito.MockitoSugar.{mock, when}

class CompanyValidatorTest extends org.scalatest.flatspec.AnyFlatSpec
{
  val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
  val hpCompany: Company = Company("HP", "hp@gmail.com", "Delhi")
  val dellCompany: Company = Company("Dell", "dellgmail.com", "Pune")

  val mockedCompanyReadDto: CompanyReadDto = mock[CompanyReadDto]
  val mockedEmailValidator: EmailValidator = mock[EmailValidator]

  "Company" should "already exist" in {
    when(mockedCompanyReadDto.getCompanyByName(knoldusCompany.name)) thenReturn Option(knoldusCompany)
    when(mockedEmailValidator.emailIdIsValid(knoldusCompany.emailId)) thenReturn true

    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(knoldusCompany)

    assert(!result)
  }

  "Company" should "have an invalid email address" in {
    when(mockedCompanyReadDto.getCompanyByName(hpCompany.name)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(hpCompany.emailId)) thenReturn false

    val companyValidator = new CompanyValidator(mockedCompanyReadDto,mockedEmailValidator)
    val result = companyValidator.companyIsValid(hpCompany)

    assert(!result)
  }

  "Company" should "be created successfully" in {
    when(mockedCompanyReadDto.getCompanyByName(dellCompany.name)) thenReturn None
    when(mockedEmailValidator.emailIdIsValid(dellCompany.emailId)) thenReturn true

    val companyValidator = new CompanyValidator(mockedCompanyReadDto, mockedEmailValidator)
    val result = companyValidator.companyIsValid(dellCompany)

    assert(result)
  }



}
