package com.riccardoperra.reader.entity;

import java.util.UUID;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Jacksonized
@Builder(toBuilder = true)
public class Todo {
  private UUID id;
  private String title;
  private boolean completed;
}
