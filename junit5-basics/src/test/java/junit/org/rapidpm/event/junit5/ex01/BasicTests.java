package junit.org.rapidpm.event.junit5.ex01;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rapidpm.event.junit5.Person;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BasicTests {


  //add your code here
  void test001() {}


  @Test
  @DisplayName("Test grouped exception")
  void test002() {
    // GIVEN
    Person person = new Person();

    // WHEN
    person.setFirstName("John");
    person.setLastName("Doe");

    // THEN
    //check both attribute values together

  }


  @Test
  @DisplayName("Exception Testing")
  @Disabled
  void test003() {

    IllegalArgumentException ex = new IllegalArgumentException("a message");

    throw ex;

    //assertEquals("a message", ex.getMessage());
  }

}
