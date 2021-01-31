package com.knoldus.request

import com.knoldus.models.Company
import com.knoldus.validator.CompanyValidator
import org.mockito.MockitoSugar.{mock, when}

class CompanyImplTest extends org.scalatest.flatspec.AnyFlatSpec {
  val mockedCompanyValidate = mock[CompanyValidator]
  val knoldusCompany: Company = Company("knoldus", "knoluds@gmail.com", "Noida")
  val noiseCompany: Company = Company("noise", "noise@gmail.com", "Noida")

  "Company" should "be created" in{
    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(knoldusCompany)) thenReturn(true)
    val result = companyImpl.createCompany((knoldusCompany))
    assert(!result.isEmpty)
  }

  "Company" should "not be created" in{
    val companyImpl = new CompanyImpl(mockedCompanyValidate)
    when(mockedCompanyValidate.companyIsValid(noiseCompany)) thenReturn(false)
    val result = companyImpl.createCompany((noiseCompany))
    assert(result.isEmpty)
  }
}
