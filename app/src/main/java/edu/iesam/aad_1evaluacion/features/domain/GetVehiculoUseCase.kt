package edu.iesam.aad_1evaluacion.features.domain



class GetVehiculoUseCase(private val vehiculoRepository: VehiculoRepository) {

    operator fun invoke(): List<Vehiculo> {
        return vehiculoRepository.getAll()
    }

}