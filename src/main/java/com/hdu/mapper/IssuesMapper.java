package com.hdu.mapper;

import com.hdu.entity.issues.DataBaseType;
import com.hdu.entity.issues.Issue;
import com.hdu.entity.issues.IssueSolution;
import com.hdu.entity.issues.Tag;
import com.hdu.util.DatabaseTypeHandler;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IssuesMapper {
    @Select("select * from issues")
    @Results({
            @Result(property = "databaseType", column = "database_type", typeHandler = DatabaseTypeHandler.class)
    })
    List<Issue> selectIssues();


    @Select("select * from issues where title like concat ('%',#{title},'%')")
    List<Issue> selectIssueByTitle(@Param("title") String title);

    @Select("select * from issues where issue_id= #{id}")
    Issue selectIssueById(Integer id);


    @Select("select * from issue_solutions where issue_id = #{id}")
    List<IssueSolution> selectSolutionsByIssueId(Integer id);


    @Select("select * from issue_solutions where solution_id = #{id}")
    IssueSolution selectSolutionById(Integer id);


    @Insert("insert into issues (issue_id,title,database_type,description) values (#{issueId},#{title},#{databaseType},#{description})")
    int insertIssue(Issue issue);

    @Update("update issues set title = #{title}, database_type = #{databaseType}, description= #{description} where issue_id = #{issueId}")
    int updateIssue(Issue issue);

    @Delete("delete from issues where issue_id = #{issueId}")
    int deleteIssue(Integer issueId);


    @Insert("insert into issue_solutions (solution_title,solution_description) values (#{solutionTitle},#{solutionDescription})")
    int insertSolution(IssueSolution issueSolution);

    @Update("update issue_solutions set solution_title = #{solutionTitle}, solution_description=#{solutionDescription} where solution_id = #{solutionId}")
    int updateSolution(IssueSolution issueSolution);

    @Delete("delete from issue_solutions where id = #{id}")
    int deleteSolution(Integer id);
    @Insert("insert into tags tag_name values #{tagName}")
    int insertTags(Tag tag);
    @Select("select* from tags where tag_id in (select tag_id from issue_tags where issue_id = #{issueId})")
    List<Tag> selectTagsByIssueId(Integer issueId);

    @Delete("delete from tags where tag_id = #{tagId}")
    int deleteTag(Integer tag_id);
    @Update("update tags set tag_name = #{tagName} where tag_id = tagId")
    int updateTag(Tag tag);
}
