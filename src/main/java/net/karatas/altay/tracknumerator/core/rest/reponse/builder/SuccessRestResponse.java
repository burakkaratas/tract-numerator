package net.karatas.altay.tracknumerator.core.rest.reponse.builder;


import net.karatas.altay.tracknumerator.core.context.Context;
import net.karatas.altay.tracknumerator.core.rest.BaseDTO;
import net.karatas.altay.tracknumerator.core.rest.reponse.BaseRestResponse;
import org.springframework.http.HttpStatus;

public class SuccessRestResponse {

    private SuccessRestResponse() {
    }

    public static <B extends BaseDTO> BaseRestResponse<B> create(B body) {
        BaseRestResponse<B> result = new BaseRestResponse<>();
        result.setResponseStatus(HttpStatus.OK.toString());
        result.setTransaction(Context.getTx());
        result.setBody(body);
        return result;
    }

}
