
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

    val rvs = RandomVehicleSimulator()
    rvs.randomlyAddedVehicles(21)
    parking.listVehicles()
    rvs.randomlyCheckOut(1)
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
            parking.addVehicle(vehicle)
        }
    }

    fun randomlyCheckOut(totalCheckOut: Int) {
        for(i in 0..totalCheckOut){
            val theOne = parking.vehicles.random()
            parkingSpace.checkOutVehicle(theOne.plate)
        }
    }
}
//Faltaria agregar alguna entrada duplicada para testear eso!
