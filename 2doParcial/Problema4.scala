abstract class Servicio(
  val nombre: String,
  val precio: Double
) {
  def descripcion: String

  def mostrar(): Unit = {
    println(nombre + " - Precio: " + precio + " Bs")
    println(descripcion)
  }
}

trait Descuento {
  def aplicarDescuento(porcentaje: Double): Double = {
    if (porcentaje >= 0 && porcentaje <= 100)
      precioConDescuento(porcentaje)
    else
      throw new IllegalArgumentException("Descuento no valido")
  }

  protected def precioConDescuento(porcentaje: Double): Double
}

class Catering(
  nombre: String,
  precio: Double,
  val personas: Int
) extends Servicio(nombre, precio) with Descuento {

  def descripcion: String = {
    "Servicio de comida para " + personas + " personas"
  }

  protected def precioConDescuento(porcentaje: Double): Double = {
    precio - (precio * porcentaje / 100)
  }
}

class Fotografia(
  nombre: String,
  precio: Double,
  val horas: Int
) extends Servicio(nombre, precio) {

  def descripcion: String = {
    "Servicio de fotografia por " + horas + " horas"
  }

  def +(extra: Double): Fotografia = {
    require(extra >= 0, "El costo extra no puede ser negativo")
    new Fotografia(nombre, precio + extra, horas)
  }
}

object Catering {
  def apply(nombre: String, precio: Double, personas: Int): Catering = {
    require(precio > 0, "El precio debe ser positivo")
    require(personas > 0, "Debe haber al menos una persona")
    new Catering(nombre, precio, personas)
  }
}

object Fotografia {
  def apply(nombre: String, precio: Double, horas: Int): Fotografia = {
    require(precio > 0, "El precio debe ser positivo")
    require(horas > 0, "Debe haber al menos una hora")
    new Fotografia(nombre, precio, horas)
  }
}