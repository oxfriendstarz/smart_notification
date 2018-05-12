package com.buster.repository;

import com.buster.models.PublisherProfile;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Ramon on 5/12/2018.
 */
public interface PublisherRepository extends JpaRepository<PublisherProfile, Long> {

    PublisherProfile findByUsernameAndPassword(String username, String password);
}