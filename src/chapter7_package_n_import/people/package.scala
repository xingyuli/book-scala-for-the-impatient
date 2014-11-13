package chapter7_package_n_import

package object people {
  var defaultName = "John Q. Public"
}

package people {
  class Person {
    var name = defaultName
  }
}