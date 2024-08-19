package com.hdu.entity.issues;

import com.hdu.util.DatabaseTypeHandler;
import lombok.Data;
import org.apache.ibatis.annotations.Result;
import org.springframework.context.annotation.Description;
import sun.security.krb5.internal.crypto.Des;

@Data
public class Issue {


    private Integer issueId;
    private String title;
    private DataBaseType databaseType;
    private String description;


}
