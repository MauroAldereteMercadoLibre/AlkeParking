fun main(args: Array<String>) {

    //Prueba de push
    val vehiculo1: Vehicle = Vehicle("HJU667",VehicleType.CAR,"Card01")
    val vehiculo2 = Vehicle("JJU456", VehicleType.MOTORCYCLE)
    val vehiculo3 = Vehicle("FGR234", VehicleType.BUS, "Card02")
    val vehiculo4 = Vehicle("JUJ672", VehicleType.MINIBUS)
    println(vehiculo1.plate)
    println("Tipo: ${vehiculo1.type} Tarifa primeras 2 hs: $${vehiculo1.type.tarifa}")
    println("Ingreso: ${vehiculo1.checkInTime.time}")
}