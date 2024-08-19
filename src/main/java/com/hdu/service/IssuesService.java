package com.hdu.service;

import com.hdu.entity.issues.DataBaseType;
import com.hdu.entity.issues.Issue;
import com.hdu.entity.issues.IssueSolution;
import com.hdu.entity.issues.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface IssuesService {
    /**
     * 获取所有的问题
     * @return
     */
    List<Issue> selectIssues();

    /**
     * 根据主题进行模糊查询
     * @param title
     * @return
     */
    List<Issue> selectIssueByTitle( String title);

    /**
     * 模糊查询后，根据id进行精确查询
     * @param id
     * @return
     */
    Issue selectIssueById(Integer id);

    /**
     *  根据问题id查询出所有的解决方法
     * @param id
     * @return
     */
    List<IssueSolution> selectSolutionsByIssueId(Integer id);

    /**
     * 根据方法id查询具体解决方法，查看解决方法的详细信息
     * @param id
     * @return
     */
    IssueSolution selectSolutionById(Integer id);

    /**
     * 查询不到相关问题，将问题上传求助
     * @param issue
     * @return
     */
    boolean insertIssue(Issue issue);

    /**
     * 更新问题
     * @param issue
     * @return
     */
    boolean updateIssue(Issue issue);

    /**
     * 删除问题
     * @param issueId
     * @return
     */
    boolean deleteIssue(Integer issueId);

    /**
     * 上传解决方法
     * @param issueSolution
     * @return
     */
    boolean insertSolution(IssueSolution issueSolution);

    /**
     * 更新解决方法
     * @param issueSolution
     * @return
     */
    boolean updateSolution(IssueSolution issueSolution);

    /**
     * 删除解决方法
     * @param id
     * @return
     */
    boolean deleteSolution(Integer id);

    /**
     * 上传新的标签信息
     * @param tag
     * @return
     */
    boolean insertTags(Tag tag);

    /**
     *  根据问题id查询出所有的标签
     * @param id
     * @return
     */
    List<Tag> selectTagsByIssueId(Integer id);
    boolean deleteTag(Integer tag_id);
    boolean updateTag(Tag tag);

}
