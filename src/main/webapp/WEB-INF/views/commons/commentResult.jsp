<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<tr>
    <th>내용</th>
    <th>점수</th>
    <th>작성자</th>
</tr>
<c:forEach items="${list }" var="item" varStatus="status">
    <tr>
        <td>
            ${item.content }
        </td>
        <td>${item.rate }</td>
        <td>${item.name }</td>
    </tr>
</c:forEach>