package com.devtoys.master_doc_builder.model.in;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class ReadMeDocumentationInModel extends ProjectDocumentationInModel {

  private String projectName;
  private String simpleDescription;
  private String detailedDescription;
  private String stackTechnologies;
  private String runInstructions;
  private List<String> moreInformations;

}
