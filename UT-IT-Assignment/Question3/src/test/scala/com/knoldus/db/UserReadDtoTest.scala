package com.knoldus.db
import org.scalatest.flatspec.AnyFlatSpec

class UserReadDtoTest extends  AnyFlatSpec
{
  "User" should "exist" in{
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Knoldus")
    assert(!result.isEmpty)
  }

  "User" should "not exist" in{
    val userReadDto = new UserReadDto
    val result = userReadDto.getUserByName("Noise")
    assert(result.isEmpty)
  }
}
