package com.example.demo.dto;

import com.example.demo.entity.User;
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
public class PersonVO {
    private int id;
    private String name;
    private String email;
    private LocalDateTime birthday;
    private User user;

    @Override
    public String toString() {
        return "id:" + id + "name: " + id + "email: " + email + "birthday: " + birthday + "user: " + user + "\n";
    }
}