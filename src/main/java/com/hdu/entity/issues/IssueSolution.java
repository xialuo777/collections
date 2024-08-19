package com.hdu.entity.issues;

import lombok.Data;

@Data
public class IssueSolution {
    private Integer solutionId;
    private Integer issueId;
    private String solutionTitle;
    private String solutionDescription;

}
