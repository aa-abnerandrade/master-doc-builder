package com.devtoys.master_doc_builder.render;

import com.devtoys.master_doc_builder.model.out.ReadmeDocumentationResultModel;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Component
public class ReadmeDocumentationRender {

  public void renderDocumentation(ReadmeDocumentationResultModel result) {
    String content = buildMarkdown(result);
    Path output = Path.of(System.getProperty("src/main/resources/artifacts"), "README.md");
    try {
      Files.writeString(output, content, StandardCharsets.UTF_8,
              StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    } catch (IOException e) {
      throw new RuntimeException("Erro ao escrever README.md em: " + output.toString(), e);
    }
  }

  private String buildMarkdown(ReadmeDocumentationResultModel r) {
    StringBuilder sb = new StringBuilder();
    sb.append("# ").append(nullSafe(r.getProjectName())).append("\n\n");
    sb.append(nullSafe(r.getSimpleDescription())).append("\n\n");
    sb.append("## About\n").append(nullSafe(r.getDetailedDescription())).append("\n\n");
    sb.append("## Stack\n").append(nullSafe(r.getStackTechnologies())).append("\n\n");
    sb.append("## Running\n").append(nullSafe(r.getRunInstructions())).append("\n\n");
    sb.append("## More Informations\n").append(nullSafe(r.getMoreInformations())).append("\n");
    return sb.toString();
  }

  private String nullSafe(String v) {
    return v == null ? "" : v;
  }
}
