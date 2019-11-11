package com.sajjadbashar.cameraIQ.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.sajjadbashar.cameraIQ.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Modifying
    @Query(value = "DELETE FROM affiliations WHERE user_id = :user_id AND organization_id = :organization_id", nativeQuery = true)
    void removeUserFromOrganization(@Param("user_id") Integer userId, @Param("organization_id") Integer organizationId);

    @Modifying
    @Query(value = "DELETE FROM affiliations WHERE user_id = :user_id", nativeQuery = true)
    void removeUserFromOrganizations(@Param("user_id") Integer userId);
}
