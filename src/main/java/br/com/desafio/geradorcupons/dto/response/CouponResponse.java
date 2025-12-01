package br.com.desafio.geradorcupons.dto.response;

public class CouponResponse {
    private final String status = "OK";
    private String message;


    public CouponResponse(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
