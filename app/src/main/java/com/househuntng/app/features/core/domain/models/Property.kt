package com.househuntng.app.features.core.domain.models

/**
 * @Author: ifechukwu.udorji
 * @Date: 12/21/2024
 */
data class Property(
    val id: String,
    val title: String,
    val description: String,
    val price: Double,
    val location: Location,
    val propertyType: PropertyType,
    val bedrooms: Int,
    val bathrooms: Int,
    val amenities: List<Amenity>,
    val images: List<String>,
    val agentId: String,
    val status: PropertyStatus,
    val createdAt: Long = System.currentTimeMillis()
)

data class Location(
    val latitude: Double,
    val longitude: Double,
    val address: String,
    val area: String,
    val city: String,
    val state: String
)

enum class PropertyType {
    HOUSE, APARTMENT, DUPLEX, TOWNHOUSE, MINI_FLAT
}

enum class PropertyStatus {
    AVAILABLE, RENTED, SOLD
}

data class Amenity(
    val type: AmenityType,
    val description: String
)

enum class AmenityType {
    POWER_BACKUP, WATER_SUPPLY, SECURITY, PARKING, CONSTANT_ELECTRICITY, TARRED_ROAD, OTHER
}
