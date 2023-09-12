package com.rustemsarica.enoca.dto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class PostDto {
    private String text;
    private long userId;
}
