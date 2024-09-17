package com.conversor.conversor_de_imagens.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImageConverterServiceTest {

    @InjectMocks
    private ImageConverterService imageConverterService;

    @Mock
    private ImageIOProvider imageIOProvider;

    @Mock
    private BufferedImage bufferedImage;

    @Mock
    private Iterator<ImageWriter> imageWriterIterator;

    @Mock
    private ImageWriter imageWriter;

    @Mock
    private ImageOutputStream imageOutputStream;

    @BeforeEach
    public void setUp() {
        // Configurar os stubs necessários
        when(imageIOProvider.getImageWritersByFormatName("webp")).thenReturn(imageWriterIterator);
        when(imageWriterIterator.hasNext()).thenReturn(true);
        when(imageWriterIterator.next()).thenReturn(imageWriter);
    }

    @Test
    @DisplayName("Deve converter imagem para WebP com sucesso")
    public void converterToWebP_Sucesso() throws IOException {
        File inputFile = new File("input.png");
        File outputFile = new File("output.webp");

        // Configurar o comportamento do mock
        when(imageIOProvider.readImage(inputFile)).thenReturn(bufferedImage);
        when(imageIOProvider.createImageOutputStream(outputFile)).thenReturn(imageOutputStream);

        // Chamar o método a ser testado
        imageConverterService.converterToWebP(inputFile, outputFile);

        // Verificar interações
        verify(imageIOProvider).readImage(inputFile);
        verify(imageIOProvider).createImageOutputStream(outputFile);
        verify(imageWriter).setOutput(imageOutputStream);
        verify(imageWriter).write(any(), any(), any());
    }
}
