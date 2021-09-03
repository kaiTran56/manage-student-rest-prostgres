package com.tranquyet.dto;

import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDTO<T> {

    private Long id;

    private String createdDate;

    private String modifiedDate;

    private String createdBy;

    private String modifiedBy;

    private Long[] ids;

    private List<T> listResult = new ArrayList<T>();

    private Integer page;

    private Integer limit;

    private Integer totalPage;

    private Integer totalItem;

    private String sortBy;

    private String alert;

    private String type;

    private Integer currentPage;

    private String deleteTag;
}
