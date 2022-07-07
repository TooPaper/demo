package com.example.analysis.dao.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author snq
 * @since 2022/4/28 16:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Track {

    private int id;

    private String name;

    private String email;

    private LocalDateTime birthday;


}