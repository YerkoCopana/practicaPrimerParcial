def crearTransformacion(factor: Double,desplazamiento: Double): Double => Double = {

 (valor: Double) => (valor * factor) + desplazamiento

}
    val corregirError: Double => Double = crearTransformacion(1.0, -1.5) 
    val calibrarSensor: Double => Double = crearTransformacion(1.04, 0.0)
    val convertirFahrenheit: Double => Double = crearTransformacion(1.8, 32.0)

    val procesarTemperatura: Double => Double = (temperatura: Double) => {
    val temperaturaCorregida = corregirError(temperatura)
    val temperaturaCalibrada = calibrarSensor(temperaturaCorregida)
    val temperaturaFahrenheit = convertirFahrenheit(temperaturaCalibrada) 
    temperaturaFahrenheit

}



    



