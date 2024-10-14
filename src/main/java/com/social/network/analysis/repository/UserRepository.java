package com.social.network.analysis.repository;

import com.social.network.analysis.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends Neo4jRepository<User, String> {

}
