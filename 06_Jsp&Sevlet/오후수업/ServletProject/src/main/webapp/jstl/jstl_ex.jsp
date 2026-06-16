<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"   %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title> JSTL 예제</title>
</head>
<body>
<%-- 예제 코드 작성: <c:set> --%>
<c:set var="username" value="KB_User" scope="request" />
<p>사용자 이름: ${username}</p>


<%-- 예제 코드 작성: <c:out> --%>
<c:set var="message" value="<b>Hello</b> JSTL!" />
<p>이스케이프 안 함: <c:out value="${message}" escapeXml="false" /></p>
<p>이스케이프 함: <c:out value="${message}" /></p>
<c:set var="undefinedVar" />
<p>기본값: <c:out value="${undefinedVar}" default="값이 없습니다" /></p>

<%-- 예제 코드 작성: <c:if> --%>
<c:set var="score" value="85" />
<c:if test="${score >= 90}">
    <p>점수가 90점 이상입니다 (A학점)</p>
</c:if>
<c:if test="${score < 60}">
    <p>점수가 60점 미만입니다 (F학점)</p>
</c:if>

<%--<c:choose>, <c:when>, <c:otherwise>--%>
<c:set var="grade" value="B" />
<c:choose>
    <c:when test="${grade eq 'A'}">
        <p>Excellent!</p>
    </c:when>
    <c:when test="${grade eq 'B'}">
        <p>Good!</p>
    </c:when>
    <c:otherwise>
        <p>Try Harder!</p>
    </c:otherwise>
</c:choose>

<%--<c:forEach>--%>
<%-- 숫자 반복 --%>
<p>1부터 5까지 반복:</p>
<ul>
    <c:forEach var="i" begin="1" end="5">
        <li>${i}</li>
    </c:forEach>
</ul>

<%-- 배열/리스트 반복 --%>
<c:set var="fruits" value="${['사과', '바나나', '오렌지', '포도']}" />
<p>과일 목록:</p>
<ul>
    <c:forEach var="fruit" items="${fruits}" varStatus="status">
        <li>${status.index}. ${fruit} ${status.first ? '(첫 번째)' : ''} ${status.last ? '(마지막)' : ''}</li>
    </c:forEach>
</ul>

<%--<c:url>, <c:redirect>, <c:param>--%>
<%-- URL 생성 --%>
<c:url var="myUrl" value="/user/profile.jsp">
    <c:param name="id" value="kbuser" />
    <c:param name="mode" value="view" />
</c:url>
<p>생성된 URL: <a href="${myUrl}">${myUrl}</a></p>

<%-- 리다이렉트 (실행하면 이 페이지가 아닌 다른 페이지로 이동) --%>
<%--
<c:redirect url="<http://www.google.com>" />
<c:redirect url="/anotherPage.jsp">
    <c:param name="redirected" value="true" />
</c:redirect>
--%>


<%--<fmt:formatNumber>--%>
<c:set var="price" value="12345.678" />
<c:set var="percentage" value="0.75" />
<p>일반 숫자: <fmt:formatNumber value="${price}" type="number" /></p>
<p>통화: <fmt:formatNumber value="${price}" type="currency" currencySymbol="₩" /></p>
<p>퍼센트: <fmt:formatNumber value="${percentage}" type="percent" /></p>
<p>소수점 두 자리: <fmt:formatNumber value="${price}" pattern="#,##0.00" /></p>


</body>
</html>