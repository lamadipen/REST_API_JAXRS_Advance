package com.dipen.restClient;

import com.dipen.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by dipen on 5/1/2017.
 */
public class RestGenericDemo {

    public  static void main(String[] args)
    {
        Client client = ClientBuilder.newClient();

        List<Message>  messages= client.target("http://localhost:8080/webapi/").
                path("messages").
                queryParam("year",2015)
                .request(MediaType.APPLICATION_JSON).get(new GenericType<List<Message>>(){});

        System.out.print(messages);
    }

}
