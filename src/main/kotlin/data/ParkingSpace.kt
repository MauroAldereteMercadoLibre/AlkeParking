package data

import AlkeParking
import Vehicle
import utils.VehicleType
import java.util.*

@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
data class ParkingSpace(
    var vehicle: Vehicle?
) : AlkeParking() {

    constructor() :this(null)



    fun checkOutVehicle(plate: String) {

        var vehicleOut = Vehicle("", VehicleType.CAR, Calendar.getInstance())

        for (vehicle in AlkeParking.parking.vehicles) {
            if (vehicle.plate == plate) vehicle.also { vehicleOut = it }
        }
        if(vehicleOut.plate != ""){
            val hasDc: Boolean = vehicleOut.discountCard != null
            //Tendria que hacer un if aca para cambiar el valor de parkedTime y asi poder randomizar tiempos
            val fee = calculateFee(vehicleOut.type, vehicleOut.parkedTime, hasDc)
            AlkeParking.parking.vehicles.remove(vehicleOut)

            println("tipo de vehiculo ${vehicleOut.type}")
            onSuccess(fee)
        }else{
            onError()
        }
        //try catch again

    }

    private fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {

        //Añadamos algo de random al tiempo
        return if (parkedTime > 7200) {
            val dif: Int = ((parkedTime.toInt() - 7200) / 900) * 5
            returnTotal(hasDiscountCard, dif+1, type)
        } else {
            returnTotal(hasDiscountCard, 0, type)
        }
    }

    private fun returnTotal(dc: Boolean, hourDif: Int, type: VehicleType): Int {
        return if (dc) {
            type.tarifa - ((type.tarifa * 15) / 100) + hourDif
        } else {
            type.tarifa + hourDif
        }
    }

    private fun onSuccess(fee: Int) {
        println("Your fee is $fee. Come back soon.")
        ++AlkeParking.cars
        AlkeParking.cash +=fee
    }

    private fun onError() {
        println("Sorry the check-out failed.")
    }


}
