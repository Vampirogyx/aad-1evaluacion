package edu.iesam.aad_1evaluacion.superheroes.domain

import edu.iesam.aad_1evaluacion.features.superheroes.domain.Vehiculo

interface VehiculoRepository {
    fun getAll(): List<Vehiculo>
    fun update(vehiculo: Vehiculo)
}