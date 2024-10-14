package com.social.network.analysis.service.impl;

import com.social.network.analysis.dto.CentralityDTO;
import com.social.network.analysis.repository.UserRepository;
import com.social.network.analysis.service.NetworkAnalysisService;
import org.neo4j.driver.internal.value.ListValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NetworkAnalysisServiceImpl implements NetworkAnalysisService {


    private final UserRepository userRepository;

    @Autowired
    public NetworkAnalysisServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param userId
     * @param friendId
     * @return
     */
    @Override
    public List<String> findShortestPath(String userId, String friendId) {
        List<String> shortestPath = new ArrayList<>();

        ListValue ls = (ListValue) userRepository.findShortestPathBetweenUser(userId, friendId).orElse(null);

        if (ls != null) {
            ls.values().forEach(value -> shortestPath.add(value.asString()));
        }

        return shortestPath;
    }

    /**
     * @return
     */
    @Override
    public Object identifyCommunities() {

        Object o = userRepository.identifyCommunities();
        return o;

    }

    /**
     * @return
     */
    @Override
    public  List<CentralityDTO> calculateDegreeCentrality() {

        List<CentralityDTO> centarilityData = userRepository.calculateDegreeCentrality().get();

        return centarilityData;
    }
}
