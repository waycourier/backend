package com.waycourier.app.models;

import jakarta.persistence.Embeddable;

@Embeddable
public record Location(double lat, double lng) {
}
