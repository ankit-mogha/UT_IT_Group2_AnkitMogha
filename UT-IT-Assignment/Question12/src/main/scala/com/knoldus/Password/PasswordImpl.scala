package com.knoldus.Password

class PasswordImpl(password:String)
{
  def isValidPassword: Boolean = password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.\\S)(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$") && password != null
}
