package com.sajjadbashar.cameraIQ.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sajjadbashar.cameraIQ.models.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Integer> {

    @Modifying
    @Query(value = "INSERT INTO affiliations (organization_id, user_id) VALUES (:organization_id, :user_id)", nativeQuery = true)
    void addUserToOrganization(@Param("organization_id") Integer organizationId, @Param("user_id") Integer userId);

    @Modifying
    @Query(value = "DELETE FROM affiliations WHERE user_id = :user_id AND organization_id = :organization_id", nativeQuery = true)
    void removeUserFromOrganization(@Param("user_id") Integer userId, @Param("organization_id") Integer organizationId);

    @Modifying
    @Query(value = "DELETE FROM affiliations WHERE organization_id = :organization_id", nativeQuery = true)
    void removeUsersFromOrganization(@Param("organization_id") Integer organizationId);
}
