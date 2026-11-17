package edu.iesam.aad_1evaluacion.features.superheroes.domain

import edu.iesam.aad_1evaluacion.superheroes.domain.VehiculoRepository


class GetVehiculoUseCase(private val vehiculoRepository: VehiculoRepository) {

    operator fun invoke(): List<Vehiculo> {
        return vehiculoRepository.getAll()
    }

}