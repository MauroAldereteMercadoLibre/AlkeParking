@file:Suppress("NAME_SHADOWING")

import java.util.*

//import android.os.Handler

fun main(args: Array<String>) {

    //Prueba de push
    val vehiculo1 = Vehicle("HJU667", VehicleType.CAR, Calendar.getInstance(), "Card01")
    val vehiculo2 = Vehicle("JJU456", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val vehiculo3 = Vehicle("FGR234", VehicleType.BUS, Calendar.getInstance(), "Card02")
    val vehiculo4 = Vehicle("JUJ672", VehicleType.MINIBUS, Calendar.getInstance())
    val parking1 = Parking(mutableSetOf(vehiculo1, vehiculo2, vehiculo3, vehiculo4))

    randomlyAddedVehicles(21)


    val newMinibus = Vehicle("JUJ672", VehicleType.MINIBUS, Calendar.getInstance())
    val isIn = parking1.vehicles.add(newMinibus)

    //Parking
    println(parking1.vehicles.contains(vehiculo1)) //true
    println(isIn) //false
    parking1.vehicles.remove(vehiculo3)
    println(parking1.vehicles.contains(vehiculo3)) //false


}

fun randomlyAddedVehicles(totalVehicles: Int) {
    for (i in 0..totalVehicles) {

        var type: VehicleType = VehicleType.BUS
        var plateLetters = ""
        for (i in 1..3) {
            plateLetters += ('A'..'Z').random()
        }
        val plateNum = (100..999).random()
        var vehicle:Vehicle
        val parking = Parking(mutableSetOf())

        when (i) {
            0, 4, 8, 12, 16 -> type = VehicleType.CAR
            1, 5, 9, 13, 17 -> type = VehicleType.MOTORCYCLE
            2, 6, 10, 14, 18 -> type = VehicleType.MINIBUS
            3, 7, 11, 15, 19 -> type = VehicleType.BUS
            else -> type = VehicleType.CAR
        }
        if (i % 3 == 0) {
            val dCard = (0..2000).random()
            vehicle = Vehicle("$plateLetters$plateNum", type, Calendar.getInstance(), "DC_$dCard")
        } else {
            vehicle = Vehicle("$plateLetters$plateNum", type, Calendar.getInstance())
        }
        if (parking.addVehicle(vehicle)) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-In has failled!")
        }
        //println("Aber: $vehicle")

        //val parkingS = ParkingSpace(vehicle, parking)
        //parkingS.checkOutVehicle(vehicle.plate)
    }
}

