package com.dipen.restClient;

import com.dipen.model.Message;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by dipen on 5/1/2017.
 */
public class RestApiClient {

    public  static void main(String[] args)
    {
       /* Client client = ClientBuilder.newClient();

        Response response= client.target("http://localhost:8080/webapi/messages/1").request().get();
        Message message = response.readEntity(Message.class);

       System.out.print(message.getMessage());*/

        //best practices
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target("http://localhost:8080/webapi/");
        WebTarget messageTarget = baseTarget.path("messages");
        WebTarget singleMsgTarget = messageTarget.path("{messageId}");

        Response response= singleMsgTarget.resolveTemplate("messageId",2).request(MediaType.APPLICATION_JSON).get();
        Message msg= singleMsgTarget.resolveTemplate("messageId",2).request(MediaType.APPLICATION_JSON).get(Message.class);

        Message message = response.readEntity(Message.class);

        System.out.print(message.getMessage());

        //using post method to create new message
        Message newMessage = new Message(1,"New message from jax-rs client","Dipen");
        Response postResponse = messageTarget.request().post(Entity.json(newMessage));

    }
}
