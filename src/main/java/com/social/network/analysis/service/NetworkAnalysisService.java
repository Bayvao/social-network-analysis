package com.social.network.analysis.service;

import com.social.network.analysis.dto.CentralityDTO;

import java.util.List;

public interface NetworkAnalysisService {

    List<String> findShortestPath(String userId, String friendId);

    Object identifyCommunities();

    List<CentralityDTO> calculateDegreeCentrality();
}
