package data

import AlkeParking
import data.Vehicle

data class Parking(
    val vehicles : MutableSet<Vehicle>
) :AlkeParking() {

    /**
     * This function add vehicle in parking.
     * @return boolean if operation is successful
     */
    fun addVehicle(vehicle: Vehicle):Boolean{
        var disponibilidad: Any
        var cantidadGarage = getCount()

        //Condicional que chequea si es duplicada la patente y si hay espacio en parking.
        if(cantidadGarage<=20 && !checkDuplicate(vehicle)) {
            parking.vehicles.add(vehicle)
            disponibilidad=true
            println("Welcome to the AlkeParking!")

        } else {
            disponibilidad=false
            println("Sorry, the check-in failed.")

        }
        return disponibilidad
    }

    /**
     * Get count of vehicles in parking.
     * @return Int
     */
    fun getCount() : Int = parking.vehicles.size

    /**
     * This function check duplicate plates.
     * @return boolean
     */
    fun checkDuplicate(vehiclePut: Vehicle):Boolean{
        var isDuplicate = false
        for(vehicle in parking.vehicles){
            isDuplicate = vehiclePut.hashCode().equals(vehicle.hashCode())
        }
        return isDuplicate
    }

}
