data class Parking(
    val vehicles : MutableSet<Vehicle>
){
    //vehicles deberia ser privada?
    companion object{
        const val vehiclesLimit = 20
        var actualLimit=0
    }

    fun addVehicle(vehicle: Vehicle):Boolean{
        return if(actualLimit<= vehiclesLimit){
            vehicles.add(vehicle)
            actualLimit+=1
            true
        }else{
            false
        }
    }
}
