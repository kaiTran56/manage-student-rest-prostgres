package com.tranquyet.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ExcelModel {
    private String nameTable;

    private String createdDate;

    private int currentPage;

    private int totalPage;
}
