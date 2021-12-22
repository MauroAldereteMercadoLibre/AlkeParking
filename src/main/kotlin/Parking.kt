data class Parking(
    val vehicles : MutableSet<Vehicle>
){
    //vehicles deberia ser privada?
    companion object{
        const val vacancy = 20
        var currentOcupation=0
    }

    fun addVehicle(vehicle: Vehicle):Boolean{
        return if(currentOcupation< vacancy){
            vehicles.add(vehicle)
            currentOcupation+=1
            true
        }else{
            false
        }
    }
}
