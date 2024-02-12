package com.zero.model.dto.demo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author LFH
 * @project .DS_Store
 * @package com.zero.model.dto.DemoRequest
 * @description
 * @date 2024/2/9 12:06
 */
@Data
public class DemoRequest {

    @ApiModelProperty(value = "id")
    private Integer id;

}
