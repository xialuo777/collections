package com.hdu.service.impl;

import com.hdu.mapper.IssuesMapper;
import com.hdu.entity.issues.DataBaseType;
import com.hdu.entity.issues.Issue;
import com.hdu.entity.issues.IssueSolution;
import com.hdu.entity.issues.Tag;
import com.hdu.service.IssuesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IssuesServiceImpl implements IssuesService {
    @Autowired
    private IssuesMapper issuesMapper;

    @Override
    public List<Issue> selectIssues() {
        return issuesMapper.selectIssues();
    }

    @Override
    public List<Issue> selectIssueByTitle(String title) {
        return issuesMapper.selectIssueByTitle(title);
    }
    @Override
    public Issue selectIssueById(Integer id) {
        return issuesMapper.selectIssueById(id);
    }
    @Override
    public boolean insertIssue(Issue issue) {
        return issuesMapper.insertIssue(issue) > 0;
    }

    @Override
    public boolean updateIssue(Issue issue) {
        return issuesMapper.updateIssue(issue) > 0;
    }

    @Override
    public boolean deleteIssue(Integer issueId) {
        return issuesMapper.deleteIssue(issueId) > 0;
    }
    @Override
    public List<IssueSolution> selectSolutionsByIssueId(Integer id) {
        return issuesMapper.selectSolutionsByIssueId(id);
    }

    @Override
    public IssueSolution selectSolutionById(Integer id) {
        return issuesMapper.selectSolutionById(id);
    }



    @Override
    public boolean insertSolution(IssueSolution issueSolution) {
        return issuesMapper.insertSolution(issueSolution) > 0;
    }

    @Override
    public boolean updateSolution(IssueSolution issueSolution) {
        return issuesMapper.updateSolution(issueSolution) > 0;
    }

    @Override
    public boolean deleteSolution(Integer id) {
        return issuesMapper.deleteSolution(id) > 0;
    }

    @Override
    public boolean insertTags(Tag tag) {
        return issuesMapper.insertTags(tag) > 0;
    }

    @Override
    public List<Tag> selectTagsByIssueId(Integer issueId) {
        return issuesMapper.selectTagsByIssueId(issueId);
    }

    @Override
    public boolean deleteTag(Integer tag_id) {
        return issuesMapper.deleteTag(tag_id) > 0;
    }

    @Override
    public boolean updateTag(Tag tag) {
        return issuesMapper.updateTag(tag) > 0;
    }
}
