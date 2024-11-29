package com.example.demo.model;

public enum ApplicationStatus {
    PENDING("Pendente"),
    ACCEPTED("Aceita"),
    REJECTED("Rejeitada"),
    CANCELED("Cancelada");

    private final String description;

    ApplicationStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
