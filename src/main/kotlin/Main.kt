import AlkeParking.Companion.parking
import data.Parking
import data.ParkingSpace
import data.Vehicle
import utils.VehicleType
import java.util.*

/**
 * This is a superClass.
 */
open class AlkeParking(){
    companion object {
        val parking: Parking = Parking(mutableSetOf())
        val parkingSpace = ParkingSpace()
    }

}


fun main(args: Array<String>) {

    //Example showed in pdf
    val car = Vehicle("aaabbbccc",VehicleType.CAR,Calendar.getInstance().timeInMillis, "DISCOUNT_CARD_001")
    val moto = Vehicle("aaabbccc",VehicleType.MOTOCYCLE,Calendar.getInstance().timeInMillis)
    val minibus = Vehicle("aaab3bccc",VehicleType.MINIBUS,Calendar.getInstance().timeInMillis,"DISCOUNT_CARD_002")
    val bus = Vehicle("aaabbb4cc",VehicleType.BUS,Calendar.getInstance().timeInMillis)
    val autoNuevo = Vehicle("aaab3bccc",VehicleType.BUS,Calendar.getInstance().timeInMillis)

    //Example
    var resultado = parking.addVehicle(car)
    println(resultado)
    //Check duplicate
    var resultado2 = parking.addVehicle(car)
    println(resultado2)
    //Show parking
    println(parking.vehicles.toString())

}
