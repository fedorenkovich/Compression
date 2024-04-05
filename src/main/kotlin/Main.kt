import org.w3c.dom.Text
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    //Сжатие enwik7
    val enwikFile = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/enwik7.txt")
    val textEnwik = enwikFile.readText()

    val textEnwikCompressed = Compression.compressionRLE(textEnwik)

    val compressedTextEnwik = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/сжатый enwik7.txt")
    compressedTextEnwik.writeText(textEnwikCompressed)

    //Сжатие текста на русском
    val textFile = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/текст на русском.txt")
    val text = textFile.readText()

    val textCompressed = Compression.compressionRLE(text)

    val compressedText = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/сжатый текст на русском.txt")
    compressedText.writeText(textCompressed)

    //Сжатие черно-белого изображения
    val imageFileBW = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Черно белое изображение/beatles.jpg")
    val image = ImageIO.read(imageFileBW)
    val textBW = ImageToText.blackWhite(image)

    val imageCompressedBW = Compression.compressionRLEBW(textBW)

    val blackWhiteText = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Черно белое изображение/beatles сжатый.txt")
    blackWhiteText.writeText(textBW)

    val compressedBW = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Черно белое изображение/beatles.txt")
    compressedBW.writeText(imageCompressedBW)

    //Сжатие изображения в серых оттенках
    val imageFileGrey = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Серое изображение/a moon shaped pool.jpg")
    val imageGrey = ImageIO.read(imageFileGrey)
    val textGrey = ImageToText.grey(imageGrey)

    val imageCompressedGrey = Compression.compressionRLEGrey(textGrey)

    val compressedGrey = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Серое изображение/a moon shaped pool.txt")
    compressedGrey.writeText(imageCompressedGrey)

    //Сжатие цветного изображения
    val imageFileRGB = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Цветное изображение/in rainbows.jpg")
    val imageRGB = ImageIO.read(imageFileRGB)
    val textRGB = ImageToText.RGB(imageRGB)

    val imageCompressedRGB = Compression.compressionRLERGB(textRGB)

    val compressedRGB = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Цветное изображение/in rainbows.txt")
    compressedRGB.writeText(imageCompressedRGB)

    //Декомпрессия текстового файла
    val decompressedTextFile = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/decompressed enwik7.txt")
    val decompressedText = Decompression.decompressionRLE(textCompressed)
    decompressedTextFile.writeText(decompressedText)

    /*//Декомпрессия ЧБ изображения
    val decompressedBlackWhiteImageFile = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/decompressed enwik7.txt")
    val decompressedBlackWhite = Decompression.decompressionRLE(imageCompressedBW)
    decompressedBlackWhiteImageFile.writeText(decompressedBlackWhite)


    //Декомпрессия Серого изображения
    val decompressedGreyImageFile = File("D:/ЛЭТИ/АиСД/Второй семестр/Лабораторная №1 (compression)/Текстовый файл/decompressed enwik7.txt")
    val decompressedGrey = Decompression.decompressionRLE(imageCompressedGrey)
    decompressedGreyImageFile.writeText(decompressedGrey)*/

    //Декомпрессия Цветного изображения
    val decompressedRGBImageFile = File("D:\\ЛЭТИ\\АиСД\\Второй семестр\\Лабораторная №1 (compression)\\Цветное изображение\\Разжатый текст RGB.txt")
    val decompressedRGBText = Decompression.decompressionRLERGB(imageCompressedRGB)
    decompressedRGBImageFile.writeText(decompressedRGBText)
    /*val compressedRGBText = Decompression.decompressionRLERGB(imageCompressedRGB)*/
    //Отрисовка разжатого изображения
    //TextToImage.drawImageFromRGBCompressed(decompressedRGBText, 900, 900, "D:\\ЛЭТИ\\АиСД\\Второй семестр\\Лабораторная №1 (compression)\\Цветное изображение\\Разжатое цветное.jpg")
    TextToImage.drawColorImageFromTextFile("D:\\ЛЭТИ\\АиСД\\Второй семестр\\Лабораторная №1 (compression)\\Цветное изображение\\Разжатый текст RGB.txt", 900, 900, "D:\\ЛЭТИ\\АиСД\\Второй семестр\\Лабораторная №1 (compression)\\Цветное изображение\\Разжатое цветное.jpg")
}