package com.example.demo.service;

import com.example.demo.model.MajorAlterationDoc;
import com.example.demo.model.MajorAlterationDocDTO;
import com.example.demo.repository.MajorAlterationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MajorAlterationServiceImpl implements MajorAlterationService {
    @Autowired
    MajorAlterationRepository majorAlterationRepository;

    @Override
    public String saveDoc(MajorAlterationDocDTO majorAlterationDocDTO) {
        MajorAlterationDoc majorAlterationDoc = new MajorAlterationDoc();
        majorAlterationDoc.setFileName(majorAlterationDocDTO.getFileName());
        majorAlterationDoc.setDocType(majorAlterationDocDTO.getDocType());
        majorAlterationDoc.setFilePath(majorAlterationDocDTO.getFilePath());
        majorAlterationRepository.saveAndFlush(majorAlterationDoc);
        return "saved MajorAlteration";
    }
}
