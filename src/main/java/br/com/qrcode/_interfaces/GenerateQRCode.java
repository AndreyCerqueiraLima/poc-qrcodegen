package br.com.qrcode._interfaces;


import br.com.qrcode.exception.QRCodeException;

import java.awt.image.BufferedImage;

public interface GenerateQRCode {
    BufferedImage generateQRCodeImage() throws QRCodeException;
}
