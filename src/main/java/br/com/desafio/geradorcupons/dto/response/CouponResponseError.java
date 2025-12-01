package br.com.desafio.geradorcupons.dto.response;

public class CouponResponseError {

    private final boolean isError = true;
    private String message;

    public CouponResponseError(String message) {
        this.message = message;
    }

    public boolean isError() {
        return isError;
    }

    public String getMessage() {
        return message;
    }
}
