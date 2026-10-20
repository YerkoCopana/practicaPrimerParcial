def procesarRango(
    desde: Int,
    hasta: Int,
    transformar: Int => Int,
    combinar: (Int, Int) => Int,
    valorInicial: Int
  ): Int = {

    if (desde > hasta) valorInicial
    else {
      val resultado = transformar(desde)
      val nuevoValor = combinar(valorInicial, resultado)

      procesarRango(desde + 1, hasta, transformar, combinar, nuevoValor)
    }
  }

  def buscar(
    desde: Int,
    hasta: Int,
    condicion: Int => Boolean
  ): Int = {

    if (desde > hasta) -1
    else if (condicion(desde)) desde
    else buscar(desde + 1, hasta, condicion)
  }

  def cantidadDivisores(n: Int): Int = {
    procesarRango(
      1,
      n,
      i => if (n % i == 0) 1 else 0,
      (a, b) => a + b,
      0
    )
  }

  def maxDivisores(desde: Int, hasta: Int): Int = {
    procesarRango(
      desde,
      hasta,
      n => cantidadDivisores(n),
      (a, b) => if (a > b) a else b,
      0
    )
  }

  def esPrimo(n: Int): Boolean = {
    n >= 2 && cantidadDivisores(n) == 2
  }

  def primoMenor(desde: Int, hasta: Int): Int = {
    buscar(desde, hasta, n => esPrimo(n))
  }