package com.devtoys.master_doc_builder.model.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
public class ReadmeDocumentationRequisitionModel extends ProjectDocumentationRequisitionModel {

  private String projectName;
  private String simpleDescription;
  private String detailedDescription;
  private String stackTechnologies;
  private String runInstructions;
  private String moreInformations;

}
