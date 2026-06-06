package com.devtoys.master_doc_builder.usecase;

import com.devtoys.master_doc_builder.model.in.ReadmeDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.out.ReadmeDocumentationResultModel;
import com.devtoys.master_doc_builder.service.ReadmeGeneratorService;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ReadmeGeneratorUseCase {
  private static final String TEMPLATE_PATH = "templates/requisition/readme-requisition-template.txt";
  private ReadmeGeneratorService readmeGeneratorService;


  public ReadmeDocumentationResultModel generateDocumentation(String TEMPLATE_PATH) {
    try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(TEMPLATE_PATH)) {
      if (inputStream == null) {
        throw new IllegalStateException("Arquivo não encontrado: " + TEMPLATE_PATH);
      }
      Properties properties = new Properties();
      properties.load(inputStream);
      ReadmeDocumentationRequisitionModel requisition = new ReadmeDocumentationRequisitionModel(
              properties.getProperty("projectName"),
              properties.getProperty("simpleDescription"),
              properties.getProperty("detailedDescription"),
              properties.getProperty("stackTechnologies"),
              properties.getProperty("runInstructions"),
              properties.getProperty("moreInformations")
      );
      return readmeGeneratorService.generateReadmeResultDocumentation(requisition);
    } catch (IOException e) {
      throw new RuntimeException("Erro ao ler template de requisição", e);
    }
  }
}
