package com.hdu.controller;

import com.hdu.entity.issues.DataBaseType;
import com.hdu.entity.issues.Issue;
import com.hdu.entity.issues.IssueSolution;
import com.hdu.entity.issues.Tag;
import com.hdu.service.IssuesService;
import com.hdu.util.Code;
import com.hdu.util.Result;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/issues")
public class IssuesController {
    @Autowired
    private IssuesService issuesService;

    /**
     * issues  CRUD操作
     * @param title
     * @param databaseType
     * @param page
     * @param size
     * @return
     */
    @GetMapping
    public Result getByTitleAndType(@RequestParam(required = false) String title,
                                    @RequestParam(required = false) DataBaseType databaseType,
                                    @RequestParam(value = "page", defaultValue = "1") int page,
                                    @RequestParam(value = "size", defaultValue = "10") int size) {
        List<Issue> issues = issuesService.selectIssues();
        Optional<String> titleOptional = Optional.ofNullable(title);
        //判断是否根据标题进行模糊查询
        if (titleOptional.isPresent()) {
            // 根据标题进行模糊查询
            issues = issuesService.selectIssueByTitle(title);
            // 根据标题模糊查询后判断是否根据数据库类型进一步过滤
            Optional<DataBaseType> databaseTypeOptional = Optional.ofNullable(databaseType);
            if (databaseTypeOptional.isPresent()){
                issues = issues.stream()
                        .filter(issue -> databaseType.toString().equals(issue.getDatabaseType().name()))
                        .collect(Collectors.toList());
            }
        }
        int startIndex = (page - 1) * size;
        int endIndex = Math.min(startIndex + size, issues.size());
        List<Issue> issueList = issues.subList(startIndex, endIndex);
        Integer code = issueList != null ? Code.GET_OK : Code.GET_ERR;
        String msg =issueList != null ? "获取成功" : "获取失败";
        return new Result(code, issueList,msg);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Issue issue = issuesService.selectIssueById(id);
        Integer code = issue != null ? Code.GET_OK : Code.GET_ERR;
        String msg =issue != null ? "获取成功" : "获取失败";
        return new Result(code, issue,msg);
    }

    @PostMapping
    public Result saveIssue(@RequestBody Issue issue) {
        boolean flag = issuesService.insertIssue(issue);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/delete/{id}")
    public Result deleteIssue(@PathVariable Integer id) {
        boolean flag = issuesService.deleteIssue(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @PutMapping()
    public Result updateIssue(@RequestBody Issue issue) {
        boolean flag = issuesService.updateIssue(issue);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    /**
     * 问题下的解决方案CRUD操作
     * @param issueId
     * @param solutionId
     * @return
     */

    @GetMapping("/{issueId}/solutions")
    public Result getIssueSolutions(@PathVariable Integer issueId,@RequestParam(required = false) Integer solutionId) {
        List<IssueSolution> solutions = issuesService.selectSolutionsByIssueId(issueId);
        Integer code = solutions != null ? Code.GET_OK : Code.GET_ERR;
        String msg =solutions != null ? "获取成功" : "获取失败";
        if (solutionId != null) {
            IssueSolution solution =  issuesService.selectSolutionById(solutionId);
            code = solution != null ? Code.GET_OK : Code.GET_ERR;
            msg =solution != null ? "获取成功" : "获取失败";
            return new Result(code, solution,msg);
        }
        return new Result(code, solutions,msg);
    }

    @PostMapping("/{issueId}/solutions/post")
    public Result saveSolution(@PathVariable Integer issueId,@RequestBody IssueSolution solution) {
        boolean flag = issuesService.insertSolution(solution);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/{issueId}/solutions/delete/{solutionId}")
    public Result deleteSolution(@PathVariable Integer issueId,@PathVariable Integer solutionId) {
        boolean flag = issuesService.deleteSolution(solutionId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }
    @PutMapping("/{issueId}/solutions/put")
    public Result updateSolution(@RequestBody IssueSolution solution) {
        boolean flag = issuesService.updateSolution(solution);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }


    /**
     * 问题下的标签列表CRUD操作
     * @param issueId
     * @return
     */
    @GetMapping("/{issueId}/tags")
    public Result getIssueTags(@PathVariable Integer issueId) {
        List<Tag> tags = issuesService.selectTagsByIssueId(issueId);
        Integer code = tags != null ? Code.GET_OK : Code.GET_ERR;
        String msg = tags != null ? "获取成功" : "获取失败";
        return new Result(code, tags, msg);
    }
    @PostMapping("/{issueId}/tags/post")
    public Result saveTag(@PathVariable Integer issueId,@RequestBody Tag tag) {
        boolean flag = issuesService.insertTags(tag);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }
    @DeleteMapping("/{issueId}/tags/delete/{tagId}")
    public Result deleteTag(@PathVariable Integer issueId,@PathVariable Integer tagId) {
        boolean flag = issuesService.deleteTag(tagId);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }
    @PutMapping("/{issueId}/tags/put")
    public Result updateTag(@RequestBody Tag tag) {
        boolean flag = issuesService.updateTag(tag);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }
        
}
