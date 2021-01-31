package com.knoldus.validator

import org.scalatest.flatspec.AnyFlatSpec

class EmailValidatorTest extends AnyFlatSpec{
  val emailValidator = new EmailValidator()

  "Email" should "be valid" in {
    val result : Boolean = emailValidator.emailIdIsValid("moghaankit.am@gmail.com")
    assert(result==true)
  }

  "Email" should "be invalid because @ missing " in {
    val result : Boolean = emailValidator.emailIdIsValid("moghaankit.amgmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because it cannot contain space in between" in {
    val result : Boolean = emailValidator.emailIdIsValid("ankit  @gmail.com")
    assert(result==false)
  }

  "Email" should "be invalid because of invalid domain name " in {
    val result : Boolean = emailValidator.emailIdIsValid("ankitmogha@gmail.mogha")
    assert(result==false)
  }

  "Email" should "be invalid because email cannot start from any special symbol" in {
    val result: Boolean = emailValidator.emailIdIsValid("@gmail.com")
    assert(result == false)
  }

    "Email" should "be invalid because email cannot be empty" in {
      val result : Boolean = emailValidator.emailIdIsValid("")
      assert(result==false)
  }

}
