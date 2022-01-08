package com.example.demo;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.util.StringUtils;

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

  @Test
  public void BoardTitleMoreThanMaxSize() {
    Board board = new Board();
    board.setTitle(StringUtils.repeat("a", 256));
    Set<ConstraintViolation<Board>> violations = this.validator.validateProperty(board, "title");
    assertEquals("255文字以内で入力してください", violations.iterator().next().getMessage());
  }

  @Test
  public void BoardContentEmpty() {
    Board board = new Board();
    Set<ConstraintViolation<Board>> violations = this.validator.validateProperty(board, "content");
    assertEquals("空白だけの記事は投稿できません", violations.iterator().next().getMessage());
  }

  @Test
  public void BoardContentSpaceOnly() {
    Board board = new Board();
    board.setContent("\n");
    Set<ConstraintViolation<Board>> violations = this.validator.validateProperty(board, "content");
    assertEquals("空白だけの記事は投稿できません", violations.iterator().next().getMessage());

  }

}
