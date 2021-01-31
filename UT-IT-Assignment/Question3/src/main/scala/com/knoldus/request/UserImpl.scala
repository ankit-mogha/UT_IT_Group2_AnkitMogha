package com.knoldus.request

import com.knoldus.models.User
import com.knoldus.validator.UserValidator

class UserImpl(userValidator: UserValidator) {

  def createUser(user: User):String = {
    if (userValidator.userIsValid(user)) user.companyName
    else ""
  }
}
