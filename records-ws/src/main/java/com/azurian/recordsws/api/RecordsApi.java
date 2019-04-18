package com.azurian.recordsws.api;

import com.azurian.recordsws.dto.RecordDTO;
import com.azurian.recordsws.service.RecordsService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yarismel Correa
 **/

@RestController
public class RecordsApi {

    RecordsService recordsService;

    @RequestMapping(value = "/records", produces = "application/json")
    @ResponseBody
    public String getAll() {

        List<RecordDTO> recordDTOList = recordsService.getAll();

        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String records = gson.toJson(recordDTOList);

        return records;
    }
}

