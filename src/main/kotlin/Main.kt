import java.util.*

//import android.os.Handler

fun main(args: Array<String>) {

    //Prueba de push
    val vehiculo1 = Vehicle("HJU667", VehicleType.CAR, Calendar.getInstance(), "Card01")
    val vehiculo2 = Vehicle("JJU456", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val vehiculo3 = Vehicle("FGR234", VehicleType.BUS, Calendar.getInstance(), "Card02")
    val vehiculo4 = Vehicle("JUJ672", VehicleType.MINIBUS, Calendar.getInstance())

    randomlyAddedVehicles()

    val parking = Parking(mutableSetOf(vehiculo1, vehiculo2, vehiculo3, vehiculo4))

    val newMinibus = Vehicle("JUJ672", VehicleType.MINIBUS, Calendar.getInstance())
    val isIn = parking.vehicles.add(newMinibus)

    //Parking
    println(parking.vehicles.contains(vehiculo1)) //true
    println(isIn) //false
    parking.vehicles.remove(vehiculo3)
    println(parking.vehicles.contains(vehiculo3)) //false

}

fun randomlyAddedVehicles() {
    for (i in 0..20) {

        var type: VehicleType = VehicleType.BUS
        val plateNum = (100..999).random()
        var vehicle = Vehicle("", type, Calendar.getInstance())
        val parking = Parking(mutableSetOf())

        when (i) {
            0, 4, 8, 12, 16 -> type = VehicleType.CAR
            1, 5, 9, 13, 17 -> type = VehicleType.MOTORCYCLE
            2, 6, 10, 14, 18 -> type = VehicleType.MINIBUS
            3, 7, 11, 15, 19 -> type = VehicleType.BUS
        }
        if (i % 3 == 0) {
            val dCard = (0..2000).random()
            vehicle = Vehicle("ABC+$plateNum", type, Calendar.getInstance(), "DC_$dCard")
        } else {
            vehicle = Vehicle("ABC$plateNum", type, Calendar.getInstance())
        }
        parking.addVehicle(vehicle)
        println("Aber: $vehicle")

    }
}

