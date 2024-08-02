/*
package com.ctw.workstation.team;

import com.ctw.workstation.team.boundary.TeamResource;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@QuarkusTest
public class TeamResourceTest {

    @InjectMock
    TeamService teamService;

    @Inject
    TeamResource teamResource;

    private Team team;

    @BeforeEach
    void setUp() {
        team = new Team();
        team.setId(1L);
        team.setName("Team A");
    }

    @ParameterizedTest
    @MethodSource("teamArguments")
    void testGetById(Integer expected, Long id) {

        when(teamService.getTeam(anyLong())).thenAnswer(inv -> {
            Long inputId = inv.getArgument(0);
            if(inputId > 2L) {
                return null;
            } else {
                return team;
            }
        });

        Response response = teamResource.getById(id);
        assertEquals(expected, response.getStatus());
    }

    static Stream<Arguments> teamArguments() {
        return Stream.of (
                Arguments.arguments(200, 1L),
                Arguments.arguments(200, 2L),
                Arguments.arguments(404, 3L)
        );
    }


    @ParameterizedTest
    @MethodSource("teamNameArguments")
    void testGetByName(int expected, String name) {

        when(teamService.getByName(anyString())).thenAnswer(inv -> {
            String inputName = inv.getArgument(0);
            if(inputName.equalsIgnoreCase(team.getName())) {
                return team;
            } else {
                return null;
            }
        });

        Response response = teamResource.getByName(name);

        assertEquals(expected, response.getStatus());
    }

    static Stream<Arguments> teamNameArguments() {
        return Stream.of (
                Arguments.arguments(200, "Team A"),
                Arguments.arguments(404, "Team B")
        );
    }

}





    //@Test
    //@DisplayName("Validate ...")
    //void get() {
        //Given
        //ExternalAPI externalAPIMocked = Mockito.mock(ExternalAPI.class);
        //Mockito.when(externalAPI.hello()).thenReturn(new ExternalResponse("Hello XBox"));
        //HelloExtAcademy helloExtAcademy = new HelloExtAcademy(externalAPIMocked);

        //When
        //String result = helloExtAcademy.sayHello(null);

        //Then
        //assetEquals("Hello Xbox", result, "Validate ...");
    //}

 */
