package com.social.network.analysis.repository;

import com.social.network.analysis.dto.CentralityDTO;
import com.social.network.analysis.entity.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends Neo4jRepository<User, String> {

    @Query("MATCH (u1:User {userId: $userId1}), (u2:User {userId: $userId2}), p = shortestPath((u1)-[:FRIENDS_WITH*]-(u2)) RETURN [n IN nodes(p) | n.userId] AS path")
    Optional<Object> findShortestPathBetweenUser(@Param("userId1") String userId1, @Param("userId2") String userId2);

    @Query("CALL algo.louvain.stream('User', 'FRIENDS_WITH', {iterations: 10}) YIELD nodeId, community RETURN community, collect(nodeId) AS users")
    Optional<Object> identifyCommunities();

    @Query("MATCH(u:User)-[r:FRIENDS_WITH]-() RETURN u.userId as userId, count(r) AS centrality")
    Optional<List<CentralityDTO>> calculateDegreeCentrality();

}
