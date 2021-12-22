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
        val availability: Any
        val countCars = getCount()


        availability = if(countCars<20 && !checkDuplicate(vehicle)) {
            parking.vehicles.add(vehicle)
            true
        } else {
            false
        }
        return availability
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

    /**
     * @return Pair contains cars outside and accumulated profit
     */
    fun getProfit()= Pair( cars, cash )

    /**
     * Print plates vehicles in console
     */
    fun listVehicles(){
        parking.vehicles.forEach{vehicle -> println(vehicle.plate) }
    }

}
