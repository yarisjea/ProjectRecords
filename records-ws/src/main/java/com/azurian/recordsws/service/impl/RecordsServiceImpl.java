package com.azurian.recordsws.service.impl;

import com.azurian.recordsws.model.Record;
import com.azurian.recordsws.repository.RecordRepository;
import com.azurian.recordsws.dto.RecordDTO;
import com.azurian.recordsws.service.RecordsService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yarismel Correa
 **/

@Service
public class RecordsServiceImpl implements RecordsService {

    @Autowired
    RecordRepository recordRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<RecordDTO> getAll() {

        List<Record> recordList = recordRepository.findAll();

        return recordList.stream()
                .map(record -> convertToDto(record))
                .collect(Collectors.toList());
    }

    private RecordDTO convertToDto(Record record) {
        RecordDTO recordDTO = modelMapper.map(record, RecordDTO.class);
        return recordDTO;
    }

}
