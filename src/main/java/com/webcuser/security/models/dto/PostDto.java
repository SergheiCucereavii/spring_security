package com.webcuser.security.models.dto;

import com.webcuser.security.models.Category;
import lombok.Getter;

import java.util.List;

@Getter
public class PostDto {
    public String title;
    public String description;
    public List<Long> categoryIds;
    public List<Long> userIds;
}
