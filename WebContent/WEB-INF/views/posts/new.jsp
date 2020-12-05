<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
  <c:param name="content">
    <h2>新規投稿ページ</h2>

    <form method="POST" action="<c:url value='/posts/create' />"
      enctype="multipart/form-data">
      <c:import url="_form.jsp" />
    </form>


    <br />
    <a href="<c:url value='/posts/index' />">トップへ</a>
  </c:param>
</c:import>