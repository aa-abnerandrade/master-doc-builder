package com.devtoys.master_doc_builder.render;

import com.devtoys.master_doc_builder.model.in.ReadmeDocumentationRequisitionModel;
import com.devtoys.master_doc_builder.model.out.ReadmeDocumentationResultModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class ReadmeDocumentationRender {
  private static final String TEMPLATE_PATH = "templates/requisition/readme-requisition-template.txt";


  public void renderDocumentation(ReadmeDocumentationResultModel result) {

  }
}
