package com.example.relationaldataaccessinitial;

public class Customer {
  private long id;
  private String firstTime, lastName;

  public Customer(long id, String firstName, String lastName) {
    this.id = id;
    this.firstTime = firstName;
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return String.format("Customer[id=%d, firstName='%s',lastName='%s'", id, firstTime, lastName);
  }
}
