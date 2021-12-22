package data

import AlkeParking
import sun.net.InetAddressCachePolicy.get
import utils.VehicleType
import java.util.*

data class ParkingSpace(
    var vehicle: Vehicle?
) : AlkeParking(){

    constructor(): this(null)


    /**
     * Check if parking contains vehicle with plate inserted in param
     */
    fun checkOutVehicle(plate:String){
        for (vehicle in parking.vehicles){
            if (vehicle.plate.equals(plate)){
                onSuccess(calculateFee(vehicle.vehicleType , 123L,vehicle.discountCard))
            } else {
                onError()
            }
        }
    }


    fun calculateFee(type: VehicleType, parkerTime : Long, discountCard : String?) : Int{
        return 0
    }

    fun onSuccess(finalPrice : Int){
        println("pago $finalPrice")
    }

    fun onError(){
        println("Error")
    }

}
