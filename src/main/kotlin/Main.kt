
import AlkeParking.Companion.parking
import data.Parking
import data.ParkingSpace
import data.Vehicle
import utils.VehicleType
import java.util.*

/**
 * This is a superClass.
 */
open class AlkeParking {
    companion object {
        val parking: Parking = Parking(mutableSetOf())
        val parkingSpace = ParkingSpace()

        var cash = 0
        var cars = 0
    }
}


fun main() {

    //Example showed in pdf
    val car = Vehicle("aaabbbccc", VehicleType.CAR, Calendar.getInstance(), "DISCOUNT_CARD_001")
    val moto = Vehicle("aaabbccc", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val minibus = Vehicle("aaab3bccc", VehicleType.MINIBUS, Calendar.getInstance(), "DISCOUNT_CARD_002")
    val bus = Vehicle("aaabbb4cc", VehicleType.BUS, Calendar.getInstance())
    val autoNuevo = Vehicle("aaab3bccc", VehicleType.BUS, Calendar.getInstance())

    //Example
  /*  val resultado = parking.addVehicle(car)
    println(resultado)
    //Check duplicate
    val resultado2 = parking.addVehicle(car)
    println(resultado2)
    //Show parking
    println(parking.vehicles.toString())*/

    //Main
    val rvs = RandomVehicleSimulator()
    rvs.randomlyAddedVehicles(21)
    parking.listVehicles()
    rvs.randomlyCheckOut()
    rvs.randomlyCheckOut()
    println("Total Check out: ${parking.getProfit().first} | Total Profits: ${parking.getProfit().second}")

}


class RandomVehicleSimulator : AlkeParking(){


    /**
     * This function add the specified
     * amount of almost random vehicles in the params
     */
    fun randomlyAddedVehicles(totalVehicles: Int) {

        for (i in 1..totalVehicles) {

            var plateLetters = ""
            val plateNum = (100..999).random()

            (1..3).forEach { _ ->
                plateLetters += ('A'..'Z').random()
            }

            val type = when (i) {
                0, 4, 8, 12, 16 -> VehicleType.CAR
                1, 5, 9, 13, 17 -> VehicleType.MOTORCYCLE
                2, 6, 10, 14, 18 -> VehicleType.MINIBUS
                3, 7, 11, 15, 19 -> VehicleType.BUS
                else -> VehicleType.CAR
            }
            val vehicle: Vehicle = if (i % 3 == 0) {
                val dCard = (0..2000).random()
                Vehicle("$plateLetters$plateNum", type, Calendar.getInstance(), "DC_$dCard")
            } else {
                Vehicle("$plateLetters$plateNum", type, Calendar.getInstance())
            }
            //
            if (parking.addVehicle(vehicle)) {
                println("Welcome to AlkeParking!")
            } else {
                println("Sorry, the check-In has failled!")
            }
        }
    }

    fun randomlyCheckOut() {
        //
        val theOne = parking.vehicles.random()
        parkingSpace.checkOutVehicle(theOne.plate)
    }
}