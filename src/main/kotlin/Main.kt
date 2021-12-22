import java.util.*
import java.lang.Thread.sleep

fun main() {

    //Main
    randomlyAddedVehicles(22)

    //Prueba de push
    val vehiculo1 = Vehicle("HJU667", VehicleType.CAR, Calendar.getInstance(), "Card01")
    val vehiculo2 = Vehicle("JJU456", VehicleType.MOTORCYCLE, Calendar.getInstance())
    val vehiculo3 = Vehicle("FGR234", VehicleType.BUS, Calendar.getInstance(), "Card02")
    val vehiculo4 = Vehicle("JUJ672", VehicleType.MINIBUS, Calendar.getInstance())
    val parking1 = Parking(mutableSetOf(vehiculo1, vehiculo2, vehiculo3, vehiculo4))

    val newMinibus = Vehicle("JUJ672", VehicleType.MINIBUS, Calendar.getInstance())
    val isIn = parking1.vehicles.add(newMinibus)
    println(isIn) //false

    //Parking
    println(parking1.vehicles.contains(vehiculo1)) //true
    parking1.vehicles.remove(vehiculo3)
    println(parking1.vehicles.contains(vehiculo3)) //false
/*
    //Para probar el tiempo de salida
    sleep(10000)

    //Aca tengo dudas de para que le paso el vehiculo a parkingSpace ¿No deberia ser solo el parking?
    //Si es un auto tira 17 en lugar de 20 tampoco se porque... El resto esta bien.
    val parkingsp = ParkingSpace(vehiculo2, parking1)
    parkingsp.checkOutVehicle(vehiculo1.plate) //Va por onSucces
    parkingsp.checkOutVehicle(vehiculo3.plate) //Va por onError */
}

fun randomlyAddedVehicles(totalVehicles: Int) {

    val parking = Parking(mutableSetOf())

    for (i in 0..totalVehicles) {

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
        if (parking.addVehicle(vehicle)) {
            println("Welcome to AlkeParking!")
        } else {
            println("Sorry, the check-In has failled!")
        }
    }

    //Eliminacion random:
    println(parking.vehicles.size)
    randomlyCheckOut(parking.vehicles, parking)
}

fun randomlyCheckOut(vehicleList: MutableSet<Vehicle>, parking: Parking) {
    val theOne = vehicleList.random()
    val parkingS = ParkingSpace(Vehicle("", VehicleType.CAR, Calendar.getInstance()), parking)
    parkingS.checkOutVehicle(theOne.plate)
}

