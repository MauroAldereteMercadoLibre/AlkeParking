import java.util.*

@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
data class ParkingSpace(
    var vehicle: Vehicle,
    val parking: Parking
) {

    fun checkOutVehicle(plate: String) {

        var vehicleOut = Vehicle("",VehicleType.CAR, Calendar.getInstance())
        val autos = parking.vehicles
        for (auto in autos) {
            if (auto.plate == plate) auto.also { vehicleOut = it }

        }
        if(vehicleOut.plate != ""){
            val hasDc: Boolean = vehicleOut.discountCard != null
            //Tendria que hacer un if aca para cambiar el valor de parkedTime y asi poder randomizar tiempos
            val fee = calculateFee(vehicleOut.type, vehicleOut.parkedTime, hasDc)
            parking.vehicles.remove(vehicleOut)
            println("tipo de vehiculo ${vehicleOut.type}")
            onSuccess(fee)
        }else{
            onError()
        }


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
    }

    private fun onError() {
        println("Sorry the check-out failed.")
    }

}
