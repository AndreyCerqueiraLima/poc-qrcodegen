package br.com.qrcode.service;

import br.com.qrcode._interfaces.GenerateQRCode;
import br.com.qrcode.exception.QRCodeException;
import lombok.RequiredArgsConstructor;
import net.glxn.qrgen.javase.QRCode;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class QrCodeService implements GenerateQRCode {

    private String text;

    @Override
    public  BufferedImage generateQRCodeImage(){
        ByteArrayOutputStream stream = QRCode
                .from(this.text)
                .withSize(250, 250)
                .stream();
        ByteArrayInputStream bis = new ByteArrayInputStream(stream.toByteArray());
        try {
            return ImageIO.read(bis);
        } catch (IOException e) {
            throw new QRCodeException();
        }
    }

    public void setText(String text) {
        this.text = text;
    }
}
