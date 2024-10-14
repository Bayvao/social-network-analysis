package com.social.network.analysis.dto;

public class CentralityDTO {
    private String userId;
    private Long centrality;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getCentrality() {
        return centrality;
    }

    public void setCentrality(Long centrality) {
        this.centrality = centrality;
    }
}
