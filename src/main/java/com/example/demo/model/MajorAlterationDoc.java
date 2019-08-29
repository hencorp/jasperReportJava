package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "ALTERATION_DOC")
public class MajorAlterationDoc implements Serializable {
    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MAJOR_ALTERATION_SEQ")
    @SequenceGenerator(sequenceName = "major_alteration_seq", allocationSize = 1, name = "MAJOR_ALTERATION_SEQ")

    private long id;
    @Column(name="DOC_ID")
    private String docId;
    @Column(name="DOC_TYPE")
    private String docType;
    @Column(name="FILE_NAME")
    private String fileName;
    @Column(name="FILE_PATH")
    private String filePath;
    @Column(name = "FILENET_FILE_PATH")
    private String filenetFilePath;
    @Column(name = "CREATED_DATE")
    private String createdDate;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "UPDATED_DATE")
    private String updatedDate;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @Column(name = "NOT_USE")
    private Integer notUse;

    public MajorAlterationDoc(String docId, String docType, String fileName, String filePath, String filenetFilePath, String createdDate, String createdBy, String updatedDate, String updatedBy, Integer notUse) {
        this.docId = docId;
        this.docType = docType;
        this.fileName = fileName;
        this.filePath = filePath;
        this.filenetFilePath = filenetFilePath;
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.notUse = notUse;
    }

    public MajorAlterationDoc() {
    }
}
