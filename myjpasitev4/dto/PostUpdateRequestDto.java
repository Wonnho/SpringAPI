package com.example.demo.myjpasitev4.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {


 private String title;
 private String content;

//생성이 아니라 수정하는 것이기 때문에 builder가 필요가 없다.

}
