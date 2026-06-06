package com.devtoys.master_doc_builder.service;

import com.devtoys.master_doc_builder.model.in.ProjectDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.in.ReadmeDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.out.ReadmeDocumentationResultModel;
import com.devtoys.master_doc_builder.render.ReadmeDocumentationRender;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ReadmeGeneratorService {
  private final ReadmeDocumentationRender readmeDocumentationRender;

  public ReadmeDocumentationResultModel generateReadmeResultDocumentation(ReadmeDocumentationRequisitionModel requisition) {

    ReadmeDocumentationResultModel result = new ReadmeDocumentationResultModel();
    result.setProjectName(requisition.getProjectName());
    result.setSimpleDescription(requisition.getSimpleDescription());
    result.setDetailedDescription(requisition.getDetailedDescription());
    result.setStackTechnologies(requisition.getStackTechnologies());
    result.setRunInstructions(requisition.getRunInstructions());
    result.setMoreInformations(requisition.getMoreInformations());

    readmeDocumentationRender.renderDocumentation(result);
    return result;
  }


}
