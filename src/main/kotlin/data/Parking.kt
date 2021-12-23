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
        val aviability: Any
        val totalParked = getCount()

        aviability = if(totalParked<20 && !checkDuplicate(vehicle)) {
            parking.vehicles.add(vehicle)
            println("Welcome to AlkeParking!")
            true
        } else {
            println("Sorry, the check-In has failled!")
            false
        }
        return aviability
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
