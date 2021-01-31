package com.knoldus.FactPalidrome

class InterfaceImpl extends InterfaceDef
 {
  def palindrome(num: Int): Boolean =
  {
    var temp_num = 0
    var rev_num = 0
    temp_num = num
    while (temp_num > 0) {
      var rem = temp_num % 10
      rev_num = (rev_num * 10) + rem
      temp_num = temp_num / 10
    }
    if (num == rev_num)
    {
      return true
    }
    else
    {
      return false
    }
  }

  def factorial(num: Int): Int =
  {
    var fact = 1
    for (loop_variable <- 1 to num)
    {
      fact = fact * loop_variable
    }
   return fact
  }
 }
