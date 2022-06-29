package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @Description TODO
 * @Author snq
 * @Date 2022/4/28 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    private int id;

    private String name;

    private String email;

    private LocalDateTime birthday;

    private User user;

}