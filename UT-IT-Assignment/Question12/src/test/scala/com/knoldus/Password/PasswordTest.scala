package com.knoldus.Password

import org.scalatest.flatspec.AnyFlatSpec

class PasswordTest extends AnyFlatSpec
{
  "Password" should "be in  this format" in
    {
    val password = new PasswordImpl("AnkitMogha@123")
    assert(password.isValidPassword)
    }
  "Password" should "contain at least one Uppercase Character" in
    {
    val password = new PasswordImpl("ankitmogha@123")
    assert(!password.isValidPassword)
    }
  "Password" should "contain at least one Lowercase Character" in
    {
    val password= new PasswordImpl("ANKITMOGHA@123")
    assert(!password.isValidPassword)
    }
  "Password" should "contain at least one number" in
    {
    val password= new PasswordImpl("AnkitMogha@")
    assert(!password.isValidPassword)
    }
  "Password" should "contain at least one Special Character" in
    {
    val password= new PasswordImpl("AnkitMogha123")
    assert(!password.isValidPassword)
    }
  "Password" should "contain minimum 8 Characters" in
    {
    val password= new PasswordImpl("An@123")
    assert(!password.isValidPassword)
    }
  "Password" should "be less than 15 Characters" in
    {
    val password= new PasswordImpl("AnkitMogha@123456")
    assert(!password.isValidPassword)
    }
  "Password" should "not contain any spaces" in
    {
    val password= new PasswordImpl("Ankit Mogha @ 123")
    assert(!password.isValidPassword)
   }
}


