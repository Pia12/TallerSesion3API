package helpers;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReportHtml {
    public static void main(String [] args){
    String path ="D:\\ClasesTESTING\\RestApi\\ProyectoRest\\build\\reports\\cucumber\\";
    File reportOutput= new File(path+"target");

    List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add(path+"report.json");

    String buildNumber= "9";
    String projectName="RestAssured";
    Configuration configuration = new Configuration (reportOutput,projectName);
        configuration.setBuildNumber(buildNumber);
        configuration.addClassifications("Empresa","Ejemplo");
        configuration.addClassifications("Empresa1","Ejemplo");
        configuration.addClassifications("Sistema operativo","Windows 10");

    ReportBuilder reportBuilder = new ReportBuilder(jsonFiles,configuration);
    Reportable res=reportBuilder.generateReports();

}

}
