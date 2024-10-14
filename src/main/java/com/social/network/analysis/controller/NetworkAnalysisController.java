package com.social.network.analysis.controller;

import com.social.network.analysis.dto.CentralityDTO;
import com.social.network.analysis.service.NetworkAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/network")
public class NetworkAnalysisController {

    private final NetworkAnalysisService networkAnalysisService;

    @Autowired
    public NetworkAnalysisController(NetworkAnalysisService networkAnalysisService) {
        this.networkAnalysisService = networkAnalysisService;
    }

    @GetMapping("/shortest-path")
    public ResponseEntity<List<String>> findShortestPath(@RequestParam("userId") String userId,
                                                         @RequestParam("friendId") String friendId) {
        List<String> shortestPath = networkAnalysisService.findShortestPath(userId, friendId);
        return new ResponseEntity<>(shortestPath, HttpStatus.OK);
    }

    @GetMapping("/communties")
    public ResponseEntity<Object> identifyCommunties() {
        Object communities = networkAnalysisService.identifyCommunities();
        return new ResponseEntity<>(communities, HttpStatus.OK);
    }

    @GetMapping("/centrality")
    public ResponseEntity<List<CentralityDTO>> calculateDegreeCentrality() {
        List<CentralityDTO> degreeCentrality = networkAnalysisService.calculateDegreeCentrality();
        return new ResponseEntity<>(degreeCentrality, HttpStatus.OK);
    }
}
