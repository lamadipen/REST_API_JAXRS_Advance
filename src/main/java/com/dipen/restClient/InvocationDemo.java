package com.dipen.restClient;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dipen on 5/1/2017.
 */
public class InvocationDemo {

    public  static void main(String[] args)
    {
        InvocationDemo invocationDemo = new InvocationDemo();
        Invocation invocation= invocationDemo.prepareRequestForMessageByYear(2015);
        Response response = invocation.invoke();

        System.out.print(response.getStatus());
    }

    private Invocation prepareRequestForMessageByYear(int year) {
        Client client = ClientBuilder.newClient();

        return client.target("http://localhost:8080/webapi/").
        path("messages").
        queryParam("year",year)
        .request(MediaType.APPLICATION_JSON).buildGet();
    }
}
