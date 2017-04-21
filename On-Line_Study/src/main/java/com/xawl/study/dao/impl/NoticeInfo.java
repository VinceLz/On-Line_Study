package com.xawl.study.dao.impl;

import com.xawl.study.model.Comment;
import com.xawl.study.model.Forum;
import com.xawl.study.model.Student;

public class NoticeInfo {
private Comment comment;
private Student student;
private Forum forum;
public Forum getForum() {
	return forum;
}
public void setForum(Forum forum) {
	this.forum = forum;
}
public Comment getComment() {
	return comment;
}
public void setComment(Comment comment) {
	this.comment = comment;
}
public Student getStudent() {
	return student;
}
public void setStudent(Student student) {
	this.student = student;
}

}
