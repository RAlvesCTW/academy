/*
package com.ctw.workstation.team;

import com.ctw.workstation.team.entity.HelloAcademy;
import com.ctw.workstation.team.entity.MathOperations;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MathTest {
    @ParameterizedTest
    @MethodSource("addArguments")
    void add(int expected, int a, int b, UUID uuid) {
        //Given or Arrange
        MathOperations mathOperations = new MathOperations();

        //When
        int result = mathOperations.add(a, b);

        //Then
        assertEquals(expected, result, "Validate if application could add properly.");
    }

    static List<Arguments> addArguments() {
        return List.of(
                arguments(10, 4, 6, UUID.randomUUID()),
                arguments(0, 0, 0, UUID.randomUUID())
        );
    }
}
*/