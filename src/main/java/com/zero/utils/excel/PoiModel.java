package com.zero.utils.excel;

import lombok.Data;

/**
 * @author sonata
 * @version V1.0.0
 */
@Data
public class PoiModel {
    private String content;

    private String oldContent;

    private int rowIndex;

    private int cellIndex;
}
