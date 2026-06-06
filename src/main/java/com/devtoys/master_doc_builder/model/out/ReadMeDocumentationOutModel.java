package com.devtoys.master_doc_builder.model.out;

import lombok.Data;

import java.util.List;

@Data
public class ReadMeDocumentationOutModel {

  private String projectName;
  private String simpleDescription;
  private String detailedDescription;
  private String stackTechnologies;
  private String runInstructions;
  private List<String> moreInformations;

}
