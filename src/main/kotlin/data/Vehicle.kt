package data

import utils.VehicleType
import java.util.*

data class Vehicle (
    val plate : String,
    val vehicleType: VehicleType,
    val checkInTime : Long,
    val discountCard: String?=null
        ) {

        override fun equals(other: Any?): Boolean {
                if(other is Vehicle){
                        return this.plate == other.plate
                }
                return super.equals(other)
        }

        override fun hashCode(): Int = this.plate.hashCode()



}
