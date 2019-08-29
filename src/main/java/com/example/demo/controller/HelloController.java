package com.example.demo.controller;
import com.example.demo.model.MajorAlterationDocDTO;
import com.example.demo.model.PersonDTO;
import com.example.demo.model.TestList;
import com.example.demo.service.MajorAlterationService;
import com.google.gson.Gson;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JsonDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class HelloController {

    @Autowired
    MajorAlterationService majorAlterationService;

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello Java Code Geeks!";
    }
//    @PostMapping("/add")
//    public String addPerson(@RequestBody PersonDTO personDTO) throws Exception {
//        personService.saveData(personDTO);
//        return "save person success";
//    }

    @PostMapping("/adddoc")
    public String addDocument(@RequestBody MajorAlterationDocDTO majorAlterationDocDTO){
        majorAlterationService.saveDoc(majorAlterationDocDTO);
        return "save MajorAlteration Success";
    }

    @GetMapping("/test")
    public String testJasper(){
        File templateLocation = new File("src/main/resources/demo.jrxml");
        String outputFile = "src/main/resources/report2.pdf";
        List<PersonDTO> personDTOList = new ArrayList<>();
        List<TestList> list = new ArrayList<>();
        list.add(new TestList("0","barang1"));
        list.add(new TestList("1","barang2"));

        personDTOList.add(new PersonDTO("0","nama0","email0","ket0",list));
        personDTOList.add(new PersonDTO("1","nama1","email1","ket1",list));

        Map param = new HashMap();
        param.put("datasource1", personDTOList);

        JRBeanCollectionDataSource listJrbean = new JRBeanCollectionDataSource(list);

        Map param2 = new HashMap();
        param2.put("checklist",list);

        Gson gson = new Gson();
        String json = gson.toJson(list);
        ByteArrayInputStream jsonDataStream = new ByteArrayInputStream(json.getBytes());


        try {
        JasperDesign jasperDesign = JRXmlLoader.load(templateLocation);
        JasperReport jasperReport =(JasperReport) JasperCompileManager.compileReport(jasperDesign);
//        Map<String,Object> parameters = new HashMap<String,Object>();
//        parameters.put ("Title",generateCollection());
        System.out.println(personDTOList.toString());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param2, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint,outputFile);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
