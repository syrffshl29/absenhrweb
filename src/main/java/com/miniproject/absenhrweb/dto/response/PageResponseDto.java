package com.miniproject.absenhrweb.dto.response;

import lombok.Data;

import java.util.List;
@Data
public class PageResponseDto<T> {
    
        private List<T> content;

        private int number;

        private int size;

        private int totalPages;

        private long totalElements;

        private boolean first;

        private boolean last;


}
