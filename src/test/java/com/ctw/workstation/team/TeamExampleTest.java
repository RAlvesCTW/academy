package com.ctw.workstation.team;

import com.ctw.workstation.team.boundary.TeamResource;
import com.ctw.workstation.team.control.TeamRepository;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

//@QuarkusTestResource(WiremockResource.class)
@QuarkusTest
@QuarkusTestResource(DatabaseTestResource.class)
//@TestHTTPEndpoint(TeamResource.class)
//@TestProfile(CommonProfile.class)
public class TeamExampleTest {

    @Inject
    TeamRepository teamRepository;

    @BeforeEach
    @Transactional
    void setUp() {
        teamRepository.deleteAll();
        Team team1 = new Team();
        team1.setName("Team 1");
        team1.setProduct("Product 1");
        team1.setDefaultLocation("Lisbon");
        team1.setCreatedAt(LocalDateTime.now());
        team1.setModifiedAt(LocalDateTime.now());
        teamRepository.persist(team1);
    }

    @Test
    void get_team_id_returns_200() {
        when().
                get("/workstation/teams/{id}", 1).
        then().
                statusCode(200).
                body("id", equalTo(1), "name", equalTo("Team 1"));
    }

    @Test
    void get_team_id_returns_404() {
        when().
                get("/workstation/teams/{id}", 20).
        then().
                statusCode(404);
    }

    /*
    @Test
    void create_returns_201() {
        given().contentType(ContentType.JSON).body(team1).
        when().
                post("/workstation/teams").
        then().
                statusCode(201);
    }

     */
}