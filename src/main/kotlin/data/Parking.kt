package data

import AlkeParking

data class Parking(
    val vehicles : MutableSet<Vehicle>
) :AlkeParking() {

    /**
     * This function add vehicle in parking.
     * @return boolean if operation is successful
     */
    fun addVehicle(vehicle: Vehicle):Boolean{
        val disponibilidad: Any
        val cantidadGarage = getCount()


        disponibilidad = if(cantidadGarage<20 && !checkDuplicate(vehicle)) {
            parking.vehicles.add(vehicle)
            true
        } else {
            false
        }
        return disponibilidad
    }

    /**
     * Get count of vehicles in parking.
     * @return Int
     */
    private fun getCount() : Int = parking.vehicles.size

    /**
     * This function check duplicate plates.
     * @return boolean
     */
    private fun checkDuplicate(vehiclePut: Vehicle):Boolean{
        var isDuplicate = false
        for(vehicle in parking.vehicles){
            isDuplicate = vehiclePut.hashCode() == vehicle.hashCode()
        }
        return isDuplicate
    }


    fun getProfit()= Pair( cars, cash )


    fun listVehicles(){
        parking.vehicles.forEach{vehicle -> println(vehicle.plate) }
    }

}
