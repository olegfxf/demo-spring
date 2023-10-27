package ru.rt.demo.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

public class GetPagable extends PageRequest {
    public GetPagable(int from, int size, Sort sort) {
        super(from / size, size, sort);
    }
}
