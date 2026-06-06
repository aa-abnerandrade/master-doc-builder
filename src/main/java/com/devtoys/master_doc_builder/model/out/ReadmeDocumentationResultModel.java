package com.devtoys.master_doc_builder.model.out;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReadmeDocumentationResultModel extends ProjectDocumentationResultModel {

  private String projectName;
  private String simpleDescription;
  private String detailedDescription;
  private String stackTechnologies;
  private String runInstructions;
  private String moreInformations;

}
