package com.azurian.recordsws.service;

import com.azurian.recordsws.dto.RecordDTO;

import java.util.List;

/**
 * @author Yarismel Correa
 **/

public interface RecordsService {

    List<RecordDTO> getAll();
}
