package com.knoldus.request

import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Company
import com.knoldus.validator.{CompanyValidator, EmailValidator}
import org.scalatest.flatspec.AnyFlatSpec

class CompanyImplIntegrationTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val companyValidator = new CompanyValidator(companyReadDto, emailValidator)
  val companyImpl = new CompanyImpl(companyValidator)


  "Company" should "be valid" in {
    val AppleCompany: Company = Company("Apple", "apple@gmail.com", "USA")
    val result =  companyImpl.createCompany(AppleCompany)
    assert(!result.isEmpty)
  }

  "Company" should "be invalid as it already exists in DB" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldus@gmail.com", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }

  "Company" should "be invalid as email id is invalid" in {
    val knoldusCompany: Company = Company("Knoldus", "knoldusgmailcom", "Noida")
    val result =  companyImpl.createCompany(knoldusCompany)
    assert(result.isEmpty)
  }
}
