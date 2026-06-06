package com.devtoys.master_doc_builder.controller;

import com.devtoys.master_doc_builder.model.in.ProjectDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.in.ProjectDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.in.ReadmeDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.out.ProjectDocumentationResultModel;
import com.devtoys.master_doc_builder.service.ReadmeGeneratorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@AllArgsConstructor
public class DocumentationController {
  private ReadmeGeneratorService readmeGeneratorService;

  @PostMapping("/generate-doc")
  public ProjectDocumentationResultModel generateDocumentation(@RequestParam("type") String typeDoc, @RequestBody ProjectDocumentationRequisitionModel requisition) {
    if (typeDoc.equals("readme")) {
      return readmeGeneratorService.generateReadmeResultDocumentation(requisition);
    }
    return null;
  }
}
