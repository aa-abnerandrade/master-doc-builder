package com.devtoys.master_doc_builder.usecase;

import com.devtoys.master_doc_builder.model.in.ReadMeDocumentationInModel;
import com.devtoys.master_doc_builder.model.out.ReadMeDocumentationOutModel;

public class ReadMeGeneratorUseCase {

  public ReadMeDocumentationOutModel generateDocumentation(ReadMeDocumentationInModel readMeDocumentationInModel) {
    if (readMeDocumentationInModel == null) {
      return null;
    }
    ReadMeDocumentationOutModel readmeDocOut = new ReadMeDocumentationOutModel();
    readmeDocOut.setProjectName(readMeDocumentationInModel.getProjectName());
    readmeDocOut.setSimpleDescription(readMeDocumentationInModel.getSimpleDescription());
    readmeDocOut.setStackTechnologies(readMeDocumentationInModel.getStackTechnologies());
    readmeDocOut.setRunInstructions(readMeDocumentationInModel.getRunInstructions());
    readmeDocOut.setMoreInformations(readMeDocumentationInModel.getMoreInformations());
    return readmeDocOut;
  }
}
