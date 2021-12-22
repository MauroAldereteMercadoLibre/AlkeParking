package utils

enum class VehicleType() {
    CAR,MOTOCYCLE,MINIBUS,BUS;

    //This fun returns price per hour
    fun getPrice(vehicleType: VehicleType) :Int {
        when(vehicleType){
            CAR ->return 20
            MOTOCYCLE -> return 15
            MINIBUS ->return 25
            BUS ->return 30
        }
    }

}