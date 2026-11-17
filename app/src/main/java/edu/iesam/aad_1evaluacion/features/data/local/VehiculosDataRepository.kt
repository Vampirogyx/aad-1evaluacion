package edu.iesam.aad_1evaluacion.features.data.local


import edu.iesam.aad_1evaluacion.features.data.local.xml.VehiculosXmlLocalDataSource


import edu.iesam.aad_1evaluacion.features.domain.Vehiculo

class VehiculosDataRepository (
    private val xmlLocalDataSource: VehiculosXmlLocalDataSource
) {

        override fun save(vehiculo : Vehiculo) {
            xmlLocalDataSource.save(vehiculo)
        }

        override fun getAll(): List<Vehiculo> {
            return xmlLocalDataSource.findAll()
        }

        override fun findById(id: Int): Vehiculo? {
            return xmlLocalDataSource.findById(id)
        }

        override fun update(vehiculo: Vehiculo) {
            xmlLocalDataSource.update(vehiculo)
        }

}