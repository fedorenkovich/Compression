class Decompression {
    companion object{
        fun decompressionRLE(text : String) : String {
            val result = StringBuilder()

            for (i in 0..<text.length step 2){
                val charCount = text[i].code
                for (j in 0..< charCount){
                    result.append(text[i + 1])
                }
            }

            return result.toString()
        }

        fun decompressionRLEBW(compressedText: String): String {
            val result = StringBuilder()
            var count = 0
            for (i in 0 until compressedText.length) {
                if (compressedText[i].isDigit()) {
                    count = count * 10 + (compressedText[i] - '0')
                } else {
                    for (j in 0 until count) {
                        result.append(compressedText[i])
                    }
                    count = 0
                }
            }
            return result.toString()
        }

        fun decompressionRLEGrey(compressedText: String): String {
            val result = StringBuilder()
            var count = 0
            for (i in 0 until compressedText.length) {
                if (compressedText[i].isDigit()) {
                    count = count * 10 + (compressedText[i] - '0')
                } else {
                    // Добавляем символ в результат в количестве, равном значению счетчика
                    for (j in 0 until count) {
                        result.append(compressedText[i])
                    }
                    // Сбрасываем счетчик
                    count = 0
                }
            }
            return result.toString()
        }

        /*fun decompressionRLERGB(compressedText: String): String {
            val result = StringBuilder()
            var count = 0
            var i = 0
            while (i < compressedText.length) {
                // Проверяем, является ли текущий символ цифрой
                if (compressedText[i].isDigit()) {
                    // Если да, то увеличиваем счетчик
                    count = count * 10 + (compressedText[i] - '0')
                } else {
                    // Если текущий символ не цифра, то он является началом блока RGB
                    val r = compressedText[i]
                    val g = compressedText[i + 1]
                    val b = compressedText[i + 2]
                    // Добавляем блок RGB в результат в количестве, равном значению счетчика
                    for (j in 0 until count) {
                        result.append(r).append(g).append(b)
                    }
                    // Сбрасываем счетчик
                    count = 0
                    // Переходим к следующему блоку RGB
                    i += 3
                }
                i++
            }
            return result.toString()
        }*/
        fun decompressionRLERGB(textCompressed: String): String {
            val result = StringBuilder()
            var i = 0
            while (i < textCompressed.length - 4) {
                val count = textCompressed[i].code/* - '0'.code*/
                repeat(count) {
                    result.append(textCompressed[i + 1])
                    result.append(textCompressed[i + 2])
                    result.append(textCompressed[i + 3])
                }
                i += 4
            }
            return result.toString()
        }
    }
}