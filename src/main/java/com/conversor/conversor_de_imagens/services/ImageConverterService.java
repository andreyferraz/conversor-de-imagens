package com.conversor.conversor_de_imagens.services;

import org.springframework.stereotype.Service;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Service
public class ImageConverterService {

    private final ImageIOProvider imageIOProvider;

    public ImageConverterService(ImageIOProvider imageIOProvider) {
        this.imageIOProvider = imageIOProvider;
    }

    public void converterToWebP(File inputFile, File outputFile) throws IOException {
        BufferedImage image = imageIOProvider.readImage(inputFile);
        
        // Encontrar o ImageWriter para WebP
        Iterator<ImageWriter> writers = imageIOProvider.getImageWritersByFormatName("webp");
        if (!writers.hasNext()) {
            throw new IOException("Não há um ImageWriter disponível para o formato WebP.");
        }

        ImageWriter writer = writers.next();
        try (ImageOutputStream ios = imageIOProvider.createImageOutputStream(outputFile)) {
            writer.setOutput(ios);
            ImageWriteParam param = writer.getDefaultWriteParam();
            writer.write(null, new javax.imageio.IIOImage(image, null, null), param);
        }
    }
}
