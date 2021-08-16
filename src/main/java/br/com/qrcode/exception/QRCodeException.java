package br.com.qrcode.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Não foi possível gerar o QRCode,entre em contato com o suporte.")
public class QRCodeException extends RuntimeException{

}
