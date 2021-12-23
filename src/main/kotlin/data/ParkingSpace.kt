package data

import AlkeParking
import utils.VehicleType
import java.util.*

@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
data class ParkingSpace(
    var vehicle: Vehicle?
) : AlkeParking() {

    constructor() : this(null)


    fun checkOutVehicle(plate: String) {

        var vehicleOut = Vehicle("", VehicleType.CAR, Calendar.getInstance())

        for (vehicle in parking.vehicles) {
            if (vehicle.plate == plate) vehicle.also { vehicleOut = it }
        }
        if (vehicleOut.plate != "") {
            val hasDc: Boolean = vehicleOut.discountCard != null
            val totalParkingTime = if (vehicleOut.plate.contains('A', true)) {
                (7200..86400).random().toLong()
            } else {
                vehicleOut.parkedTime
            }
            val fee = calculateFee(vehicleOut.type, totalParkingTime, hasDc)

            try {
                println("Vehicle type: ${vehicleOut.type} ${vehicleOut.plate}")
                parking.vehicles.remove(vehicleOut)
                onSuccess(fee)
            } catch (e: Throwable) {
                onError()
            }
        } else {
            onError()
        }
    }

    private fun calculateFee(type: VehicleType, parkedTime: Long, hasDiscountCard: Boolean): Int {

        return if (parkedTime > 7200) {
            val dif: Int = ((parkedTime.toInt() - 7200) / 900)
            returnTotal(hasDiscountCard, (dif + 1)*5, type)
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
        ++cars
        cash += fee
    }

    private fun onError() {
        println("Sorry the check-out failed.")
    }


}
