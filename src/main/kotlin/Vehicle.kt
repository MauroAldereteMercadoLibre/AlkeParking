import java.util.*

data class Vehicle(
    val plate: String,
    val type: VehicleType,
    val discountCard: String? = null,
    val checkInTime: Calendar = Calendar.getInstance()
) {

    companion object{
        const val MINUTES_IN_MLS = 1000
    }

    val parkedTime: Long get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / MINUTES_IN_MLS
    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int = this.plate.hashCode()

}

//el type puede estar prefijado

//cupo maximo de 20
//auto: $20, moto: $15, mini bus: $25, bus: $30
//$5 por cada 15min extra!
//Tarjeta de descuento del 15%
//puedo listar siempre los autos que hay
//fecha de ingreso
//calcular tiempo total de estacionamiento