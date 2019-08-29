package com.example.demo.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class JasperGenerator {
//    private static final Logger LOGGER = LogManager.getLogger(JasperGenerator.class);

    public static <T> JasperPrint executeTemplate(File sourceDesign, Map param) throws IOException {
        JasperPrint jasperPrint = null;
        ObjectMapper mapper = new ObjectMapper();

        try (FileInputStream templateLocation = new FileInputStream(sourceDesign)) {

//            LOGGER.info("Parameters <K,V> : " + param);

            JasperDesign design = JRXmlLoader.load(templateLocation);
            JasperReport report = JasperCompileManager.compileReport(design);
            jasperPrint = JasperFillManager.fillReport(report, param, new JREmptyDataSource());

//            LOGGER.info("Compiling Form " + sourceDesign + " SUCCEEDED");

        } catch (Exception e) {

//            LOGGER.error("ERROR Compiling Form : " + sourceDesign + e.getMessage(), e);

        }
        return jasperPrint;
    }

    private JasperGenerator() {
        throw new IllegalAccessError("FormGenerator Constant");
    }
}
