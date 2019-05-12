package junit.org.rapidpm.event.junit5.ex01.solutions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.rapidpm.event.junit5.Person;

import static org.junit.jupiter.api.Assertions.*;

public class BasisTests {


  @Test
  @DisplayName("my super test name")
  void test001() {

  }

  @Test
  @DisplayName("Test grouped exception")
  void test002() {
    // GIVEN
    Person person = new Person();

    // WHEN
    person.setFirstName("John");
    person.setLastName("Doe");

    // THEN
    assertAll("person check" ,
              () -> assertEquals("John" , person.getFirstName()) ,
              () -> assertEquals("Doe" , person.getLastName()));
  }

  @Test
  @DisplayName("Exception Testing")
  void test003() {
    Throwable exception = assertThrows(
        IllegalArgumentException.class ,
        () -> {
          throw new IllegalArgumentException("a message");
        });
    assertEquals("a message" , exception.getMessage());
  }
}
