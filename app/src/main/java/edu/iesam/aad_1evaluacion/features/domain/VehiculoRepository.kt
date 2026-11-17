package edu.iesam.aad_1evaluacion.features.domain

interface VehiculoRepository {
    fun getAll(): List<Vehiculo>
    fun update(vehiculo: Vehiculo)
}