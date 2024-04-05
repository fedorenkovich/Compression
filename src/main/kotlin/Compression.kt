class Compression {
    companion object {
        fun compressionRLE(text: String): String { //first quantity next char
            val result = StringBuilder()
            var count = 1
            for (i in 0..<text.length - 1) {
                if (text[i] == text[i + 1]) {
                    count++
                } else {
                    result.append(count.toChar()).append(text[i])
                    count = 1
                }
            }
            result.append(text[text.length - 1]).append(count)
            return result.toString()
        }

        fun compressionRLEBW(text: String): String {
            val result = StringBuilder()
            var count = 1
            for (i in 0..<text.length - 1) {
                if (text[i] == text[i + 1]) {
                    count++
                } else {
                    result.append(count.toChar())
                    count = 1
                }
            }
            result.append(text[text.length - 1]).append(count)
            return result.toString()
        }

        fun compressionRLEGrey(textGrey: String): String {
            val result = StringBuilder()
            var count = 1
            for (i in 0..<textGrey.length - 1) {
                if (textGrey[i] == textGrey[i + 1]) {
                    count++
                } else {
                    result.append(count.toChar()).append(textGrey[i])
                    count = 1
                }
            }
            result.append(textGrey[textGrey.length - 1]).append(count)
            return result.toString()
        }

        fun compressionRLERGB(textRGB: String): String {
            val result = StringBuilder()
            var count = 1
            for (i in 0..<textRGB.length - 3 step 3) {
                if (textRGB[i] == textRGB[i + 3] && textRGB[i + 1] == textRGB[i + 4] && textRGB[i + 2] == textRGB[i + 5]) {
                    count++
                } else {
                    result.append(count.toChar()).append(textRGB[i]).append(textRGB[i + 1]).append(textRGB[i + 2])
                    count = 1
                }
            }
            result.append(textRGB[textRGB.length - 1]).append(count)
            return result.toString()
        }
    }
}