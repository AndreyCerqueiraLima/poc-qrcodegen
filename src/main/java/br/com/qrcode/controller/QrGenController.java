package br.com.qrcode.controller;

import br.com.qrcode.service.QrCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RequestMapping("api/v1/")
@RestController
@RequiredArgsConstructor
public class QrGenController {

    private final QrCodeService qrCodeService;

    @GetMapping(value="generate", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> recuperarQrCode(){
        this.qrCodeService.setText("Swing simpatia...");
        return ResponseEntity.ok(qrCodeService.generateQRCodeImage());
    }

    @Bean
    public HttpMessageConverter<BufferedImage> createImageHttpMessageConverter() {
        return new BufferedImageHttpMessageConverter();
    }
}
