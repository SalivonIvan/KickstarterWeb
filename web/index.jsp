<%@page import="ua.com.goit.gojava7.salivon.beans.Quote"%>
<%@page import="ua.com.goit.gojava7.salivon.beans.Category"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<section id="category">
    <h1>Welcome Kickstarter</h1>
    <h3><blockquote>${requestScope.quote.text} <br/>
            <em> <mark>${requestScope.quote.author}</mark></em></blockquote>
    </h3>
    <h2>Categories</h2>
    <ul>
        <c:forEach var="category" items="${requestScope.categories}">
            <li><a href="${pageContext.servletContext.contextPath}/category?id=${category.id}">${category.name}</a></li>
            </c:forEach>

    </ul> 
</section>
<%@include  file="WEB-INF/jspf/footer.jspf" %>
