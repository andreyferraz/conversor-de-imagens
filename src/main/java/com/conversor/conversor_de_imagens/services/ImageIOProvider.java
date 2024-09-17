package com.conversor.conversor_de_imagens.services;

import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public interface ImageIOProvider {
    BufferedImage readImage(File file) throws IOException;
    Iterator<ImageWriter> getImageWritersByFormatName(String formatName);
    ImageOutputStream createImageOutputStream(File file) throws IOException;
}
