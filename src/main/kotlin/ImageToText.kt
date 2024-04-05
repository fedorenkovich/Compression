import java.awt.Color
import java.awt.image.BufferedImage

class ImageToText {
    companion object {
        fun blackWhite(image: BufferedImage): String {
            val result = StringBuilder()
            for (y in 0..<image.height) {
                for (x in 0..<image.width) {
                    val color = Color(image.getRGB(x, y))
                    val brightness = (color.red + color.green + color.blue) / 3 // Среднее значение RGB
                    val pixel = if (brightness > 127) '$' else '@' // Порог яркости для черного и белого
                    result.append(pixel)
                }
                result.append("\n")
            }
            return result.toString()
        }

        fun grey(image: BufferedImage): String {
            val result = StringBuilder()
            for (y in 0..<image.height) {
                for (x in 0..<image.width) {
                    val color = Color(image.getRGB(x, y))
                    val brightness = (color.red + color.green + color.blue) / 3 // Среднее значение RGB
                    val pixel = brightness.toChar()
                    result.append(pixel)
                }
                result.append("\n")
            }
            return result.toString()
        }

        fun RGB(image: BufferedImage): String {
            val result = StringBuilder()
            for (y in 0..<image.height) {
                for (x in 0..<image.width) {
                    val color = Color(image.getRGB(x, y))
                    result.append(color.red.toChar()).append(color.green.toChar()).append(color.blue.toChar())
                }
                result.append("\n")
            }
            return result.toString()
        }
    }
}