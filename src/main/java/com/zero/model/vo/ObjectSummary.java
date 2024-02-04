package com.zero.model.vo;

import com.aliyun.oss.model.Owner;
import lombok.Data;

import java.util.Date;

/**
 * @author nqs
 * @project: px-account-cloud-dev
 * @package: com.sgcc.entity
 * @description TODO
 * @date 2023/12/5 14:47
 */
@Data
public class ObjectSummary {

    private String bucketName;

    private String key;

    private String eTag;

    private long size;

    private Date lastModified;

    private String storageClass;

    private Owner owner;

    private String type;

    private String restoreInfo;
}
