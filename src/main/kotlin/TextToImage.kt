import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

class TextToImage {
    companion object {
        fun drawImageFromRGBCompressed(compressedText: String, width: Int, height: Int, outputFile: String) {
            // Создаем новое пустое изображение
            val image = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

            // Декомпрессия
            var index = 0
            for (y in 0..<height) {
                for (x in 0..<width) {
                    // Извлекаем компоненты RGB из сжатой строки
                    val r = compressedText[index++].code
                    val g = compressedText[index++].code
                    val b = compressedText[index++].code
                    // Устанавливаем пиксель в изображение
                    image.setRGB(x, y, Color(r, g, b).rgb)
                }
            }

            // Сохраняем изображение в файл
            ImageIO.write(image, "jpg", File(outputFile))
        }

        fun drawColorImageFromTextFile(inputFilePath: String, width: Int, height: Int, outputImagePath: String) {
            // Создаем новое пустое изображение
            val image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB)

            // Читаем данные из файла
            val compressedText = File(inputFilePath).readText()

            // Отрисовка изображения
            var index = 0
            for (y in 0..<height) {
                for (x in 0..<width) {
                    // Извлекаем компоненты RGB из текста
                    val r = compressedText[index++].code
                    val g = compressedText[index++].code
                    val b = compressedText[index++].code
                    // Устанавливаем пиксель в изображение
                    image.setRGB(x, y, Color(r, g, b, 255).rgb)
                    //image.setRGB(x, y, (r and 0xFF shl 24) + (g and 0xFF shl 16) + (b and 0xFF shl 8) + (255 and 0xFF))
                }
            }

            // Сохраняем изображение в файл
            ImageIO.write(image, "png", File(outputImagePath))
        }
    }
}