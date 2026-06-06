package com.devtoys.master_doc_builder.service;

import com.devtoys.master_doc_builder.model.in.ReadmeDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.out.ReadmeDocumentationResultModel;
import org.springframework.stereotype.Service;

@Service
public class ReadmeGeneratorService {

  public ReadmeDocumentationResultModel generateReadmeResultDocumentation(ReadmeDocumentationRequisitionModel requisition) {
    ReadmeDocumentationResultModel result = new ReadmeDocumentationResultModel();
    result.setProjectName(requisition.getProjectName());
    result.setSimpleDescription(requisition.getSimpleDescription());
    result.setDetailedDescription(requisition.getDetailedDescription());
    result.setStackTechnologies(requisition.getStackTechnologies());
    result.setRunInstructions(requisition.getRunInstructions());
    result.setMoreInformations(requisition.getMoreInformations());
    return result;
  }

}
