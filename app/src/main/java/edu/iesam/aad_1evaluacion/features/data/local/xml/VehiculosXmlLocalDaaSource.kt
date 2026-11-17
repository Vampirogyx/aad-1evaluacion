package edu.iesam.aad_1evaluacion.features.data.local.xml

import android.content.Context
import edu.iesam.aad_1evaluacion.R
import edu.iesam.aad_1evaluacion.core.serialization.JsonSerializer
import edu.iesam.aad_1evaluacion.features.superheroes.domain.Vehiculo
import kotlin.collections.filterNot
import kotlin.collections.find

class VehiculosXmlLocalDaaSource(
    private val context: Context,
    private val serializer: JsonSerializer<List<Vehiculo>>,
)
 {

        private val keyVehiculo: String = "vehiculo"
        private val ttl: Long = 2 * 60 * 1000

        val sharedPref = context.getSharedPreferences(
            context.getString(R.string.local_source_vehiculo), Context.MODE_PRIVATE
        )

        fun save(vehiculo: List<Vehiculo>) {
            sharedPref.edit().apply {
                putString(keyVehiculo, serializer.toJson(vehiculo))
                apply()
            }
        }


        fun findAll(): List<Vehiculo> {
            if (!appCache.isExpired(keyVehiculo, ttl)) {
                val jsonList: String? = sharedPref.getString(keyVehiculo, null)
                jsonList?.let {
                    return serializer.fromJson(it)
                }
            }
            return emptyList()
        }

        fun findById(id: String): Vehiculo? {
            return findAll().find { it.id == id }
        }

        fun update(vehiculo: Vehiculo) {

            val superHeroes = findAll().filterNot { it.id == vehiculo.id }.toMutableList()
            superHeroes.add(vehiculo)
            save(superHeroes)
        }
    }

    fun deleteById(id: String) {
        save(findAll().filterNot { it.id == id })
    }

    fun deleteAll() {
        sharedPref.edit().apply {
            remove(keyVehiculo)
            apply()
        }
    }
