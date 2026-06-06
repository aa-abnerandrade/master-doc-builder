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

  public ReadmeDocumentationResultModel generateReadmeResultDocumentation(ProjectDocumentationRequisitionModel requisition) {
    ReadmeDocumentationRequisitionModel readmeReq = toReadmeRequisition(requisition);

    ReadmeDocumentationResultModel result = new ReadmeDocumentationResultModel();
    result.setProjectName(readmeReq.getProjectName());
    result.setSimpleDescription(readmeReq.getSimpleDescription());
    result.setDetailedDescription(readmeReq.getDetailedDescription());
    result.setStackTechnologies(readmeReq.getStackTechnologies());
    result.setRunInstructions(readmeReq.getRunInstructions());
    result.setMoreInformations(readmeReq.getMoreInformations());

    readmeDocumentationRender.renderDocumentation(result);
    return result;
  }

  private ReadmeDocumentationRequisitionModel toReadmeRequisition(ProjectDocumentationRequisitionModel requisition) {
    if (requisition == null) {
      return new ReadmeDocumentationRequisitionModel(null, null, null, null, null, null);
    }
    if (requisition instanceof ReadmeDocumentationRequisitionModel) {
      return (ReadmeDocumentationRequisitionModel) requisition;
    }
    ObjectMapper mapper = new ObjectMapper();
    try {
      return mapper.convertValue(requisition, ReadmeDocumentationRequisitionModel.class);
    } catch (IllegalArgumentException ex) {
      return new ReadmeDocumentationRequisitionModel(null, null, null, null, null, null);
    }
  }

}
