package com.conversor.conversor_de_imagens.services;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;

import org.springframework.stereotype.Component;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Component
public class DefaultImageIOProvider implements ImageIOProvider {

    @Override
    public BufferedImage readImage(File file) throws IOException {
        return ImageIO.read(file);
    }

    @Override
    public Iterator<ImageWriter> getImageWritersByFormatName(String formatName) {
        return ImageIO.getImageWritersByFormatName(formatName);
    }

    @Override
    public ImageOutputStream createImageOutputStream(File file) throws IOException {
        return ImageIO.createImageOutputStream(file);
    }
}
