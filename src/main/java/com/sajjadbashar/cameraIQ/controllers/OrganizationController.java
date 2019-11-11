package com.sajjadbashar.cameraIQ.controllers;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sajjadbashar.cameraIQ.models.User;
import com.sajjadbashar.cameraIQ.models.Organization;
import com.sajjadbashar.cameraIQ.services.OrganizationService;


import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping(path = "/organizations", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrganizationController {

    private OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping()
    public ResponseEntity<List<Organization>> getAllOrganizations() {
        return ResponseEntity.ok(organizationService.getAllOrganizations());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Organization> createOrganization(@RequestBody Organization organization) {
        return organizationService.createOrganization(organization)
                .map(createdOrganization -> ResponseEntity.ok(createdOrganization))
                .orElseThrow();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Organization> getOrganizationById(@PathVariable(name = "id") Integer id) {
        return organizationService.getOrganizationById(id)
                .map(organization -> ResponseEntity.ok(organization))
                .orElseThrow();
    }

    @GetMapping(path = "/{id}/users")
    public ResponseEntity<List<User>> getUsersOfOrganizationById(@PathVariable(name = "id") Integer id) {
        return organizationService.getOrganizationById(id)
                .map(organization -> ResponseEntity.ok(organization.getUsers().stream().collect(toList())))
                .orElseThrow();
    }

    @PostMapping(path = "/{id}/users/{user_id}")
    public void addUserToOrgaization(@PathVariable(name = "id") Integer organizationId, @PathVariable(name = "user_id") Integer userId) {
        organizationService.addUserToOrganization(organizationId, userId);
    }

    @DeleteMapping(path = "/{id}/users/{user_id}")
    public void removerUserFromOrganization(@PathVariable(name = "id") Integer organizationId, @PathVariable(name = "user_id") Integer userId) {
        organizationService.removeUserToOrganization(organizationId, userId);
    }
}
