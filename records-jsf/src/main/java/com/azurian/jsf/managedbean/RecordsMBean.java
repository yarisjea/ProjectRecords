package com.azurian.jsf.managedbean;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.azurian.dto.RecordDTO;

/**
 * @author Yarismel Correa
 **/

@ManagedBean(name = "recordsMBean")
@SessionScoped
public class RecordsMBean implements Serializable {

    private static final long serialVersionUID = -6913972022251814607L;

    private static List<RecordDTO> recordsAll;

    public List<RecordDTO> getRecordsAll() {

        if (recordsAll == null) {

            Client c = Client.create();
            WebResource wr = c.resource("http://localhost:8080/records-ws-2.1.4.RELEASE/api/records");

            String stringJson = wr.get(String.class);

            List<RecordDTO> recordDTOList = new ArrayList<>();
            ObjectMapper mapper = new ObjectMapper();
            try {
                JsonNode actualObj = mapper.readTree(stringJson);
                JsonNode embeddedNode = actualObj.get("_embedded");
                JsonNode recordsNode = embeddedNode.get("records");

                for (Iterator<JsonNode> elements = recordsNode.iterator(); elements.hasNext(); ) {
                    JsonNode element = elements.next();

                    RecordDTO recordDTO = new RecordDTO();
                    JsonNode firstNameNode = element.path("firstName");
                    JsonNode lastNameNode = element.path("lastName");
                    JsonNode emailNode = element.path("email");
                    JsonNode addressNode = element.path("address");
                    JsonNode phoneNumberNode = element.path("phoneNumber");

                    recordDTO.setFirstName(firstNameNode.textValue());
                    recordDTO.setLastName(lastNameNode.textValue());
                    recordDTO.setEmail(emailNode.textValue());
                    recordDTO.setAddress(addressNode.textValue());
                    recordDTO.setPhoneNumber(phoneNumberNode.textValue());
                    recordDTOList.add(recordDTO);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            recordsAll = recordDTOList;
        }

        return recordsAll;
    }
}
