package com.example.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardModelTest {

  @Autowired
  private Validator validator;

  @Test
  public void BoardTitleValidationTest() {
    Board board = new Board();
    Set<ConstraintViolation<Board>> violations = this.validator.validateProperty(board, "title");
    assertThat(violations).hasSize(1);
  }
}
