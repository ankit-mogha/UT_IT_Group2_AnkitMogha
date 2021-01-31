package com.knoldus.db

import com.knoldus.models.User

import scala.collection.immutable.HashMap

class UserReadDto
{
  val knoldusEmployee : User = User("Ankit", "Mogha", 23, 15000, "Software Engineer" ,"Knoldus", "ankit.mogha@knoldus.com")
  val philipsEmployee: User = User("Adarsh","Verma" , 23, 15100, "Software Engineer", "Philips", "adarsh.verma@philips.com")
  val user: HashMap[String, User] = HashMap("Knoldus" -> knoldusEmployee, "Philips" -> philipsEmployee)

  def getUserByName(name: String): Option[User] = user.get(name)
}
