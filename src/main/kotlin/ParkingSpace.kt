@Suppress("TYPE_INFERENCE_ONLY_INPUT_TYPES_WARNING")
data class ParkingSpace(
    var vehicle: Vehicle,
    val parking: Parking
) {

    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Boolean?, onError: (Throwable) -> Unit) {

        try {
            //if(parking.vehicles.find { vehicle.plate==plate : ()-> Boolean})

            val autos= parking.vehicles
            for(auto in autos){
                if(auto.plate==plate){
                    println(auto.checkInTime)
                }
            }
            calculateCost()
            //Aca haria el calculo
            //le pasaria a onsuccess
            //y lo elimino
            //onSuccess(20)
            //parking.vehicles.remove(plate)
        } catch (e: Throwable) {
            onError(e)
        }
    }

    fun calculateCost(){

    }


//auto: $20, moto: $15, mini bus: $25, bus: $30
//$5 por cada 15min extra!
//Tarjeta de descuento del 15%
}
