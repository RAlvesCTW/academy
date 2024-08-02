/*
package com.ctw.workstation.team;

import com.ctw.workstation.team.entity.HelloAcademy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class HelloTest {

    @ParameterizedTest
    //@ValueSource(strings = {"Xbox", "", " "})
    @MethodSource("helloArguments")
    void hello(String expected, String name, UUID uuid) {
        //Given or Arrange
        HelloAcademy helloAcademy = new HelloAcademy();

        //When
        String result = helloAcademy.sayHello(name);

        //Then
        //assertEquals(expected, result, "Validate if application could say hello properly.");
        assertThrows(IllegalArgumentException.class, () -> helloAcademy.sayHello(null));
    }

    static List<Arguments> helloArguments() {
        return List.of(
                arguments("Hello Xbox", "Xbox", UUID.randomUUID()),
                arguments("Hello ", "", UUID.randomUUID()),
                arguments("Hello  ", " ", UUID.randomUUID())
        );
    }


    @Test
    void helloNull() {
        //Given or Arrange
        HelloAcademy helloAcademy = new HelloAcademy();
        String name = null;

        //When
        String result = helloAcademy.sayHello(name);

        //Then
        assertEquals("Hello", result);
    }

    @Test
    void helloWrong() {
        //Given or Arrange
        HelloAcademy helloAcademy = new HelloAcademy();
        String name = "Xbox";

        //When
        String result = helloAcademy.sayHello(name);

        //Then
        assertEquals("Hello " + name, result, "Validate if application could say hello properly.");
    }


    //TeamRepository teamRepository = Mockito.mock(TeamRepository.class);
    //TeamService teamService = Mockito.mock(TeamService.class);
}
*/
