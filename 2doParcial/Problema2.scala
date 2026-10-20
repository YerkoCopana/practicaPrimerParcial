def crearValidador(minimo: Int)(maximo:Int)(numero: Int):Boolean = {
    numero >= minimo && numero <= maximo
}
val validarPorsentaje: Int => Boolean = crearValidador(0)(100)
val validarEdadLaboral: Int => Boolean = crearValidador(18)(65)  
val validarNota: Int => Boolean = crearValidador(0)(100)

def evaluar( numero: Int, validador: Int => Boolean ): String = {
    if (validador(numero)) "Válido" else "Inválido"
}
def main(args: Array[String]): Unit = {
    val porcentaje = 50
    val edadLaboral = 70
    val nota = -10

    println(s"Porcentaje $porcentaje: ${evaluar(porcentaje, validarPorsentaje)}")
    println(s"Edad laboral $edadLaboral: ${evaluar(edadLaboral, validarEdadLaboral)}")
    println(s"Nota $nota: ${evaluar(nota, validarNota)}")
}