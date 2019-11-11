package com.sajjadbashar.cameraIQ.services;

import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sajjadbashar.cameraIQ.models.Organization;
import com.sajjadbashar.cameraIQ.repositories.OrganizationRepository;

@Service
@Transactional
public class OrganizationService {

    private OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public List<Organization> getAllOrganizations() {
        return stream(organizationRepository.findAll().spliterator(), false)
                .collect(toList());
    }

    public Optional<Organization> getOrganizationById(Integer id) {
        return organizationRepository.findById(id);
    }

    public Optional<Organization> createOrganization(Organization organization) {
        return Optional.of(organizationRepository.save(organization));
    }

    public void removeOrganization(Integer organizationId) {
        organizationRepository.deleteById(organizationId);
        organizationRepository.removeUsersFromOrganization(organizationId);
    }

    public void addUserToOrganization(Integer organizationId, Integer userId) {
        organizationRepository.addUserToOrganization(organizationId, userId);
    }

    public void removeUserToOrganization(Integer organizationId, Integer userId) {
        organizationRepository.removeUserFromOrganization(organizationId, userId);
    }

}
