<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<main>
    <section class="main">
        <div class="container-fluid">
            <div class="row">

                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 class="text-center"><strong>${requestScope.category.name}</strong></h2>
                        </div>
                        <div class="panel-body">
                            <c:forEach var="project" items="${requestScope.projects}">
                                <div class="col-sm-6 col-md-3">
                                    <div class="thumbnail">
                                        <img data-src="holder.js/300x300" alt="..." src="resource/image/Morning_Night.jpg"/> 
                                        <div class="caption">
                                            <h5><strong>${project.title}</strong></h5>
                                            <em>
                                                <mark>Author</mark>
                                            </em>
                                            <p>${project.description}</p>
                                            <div class="progress progress-category-project">
                                                <div class="progress-bar progress-bar-category" role="progressbar" aria-valuenow="2" aria-valuemin="0" aria-valuemax="100" style="width: ${(requestScope.mapTotal[project.idProject]/project.total)*100}%;">
                                                    
                                                </div>
                                            </div>
                                            <table class="table table-sm">
                                                <thead>
                                                    <tr>
                                                        <th>${requestScope.mapTotal[project.idProject]}$</th>
                                                        <th>${project.total}$</th>
                                                        <th>${project.getNumberOfDaysToEnd()}</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <tr>
                                                        <td>funded</td>
                                                        <td>plaged</td>
                                                        <td>days to go</td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            <a href="${pageContext.servletContext.contextPath}/project?id=${project.idProject}" class="btn btn-default" role="button">See more &raquo;</a>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>

                        </div>
                    </div>
                </div>
            </div>
    </section>
</main>
<%--
<section id="category">
    <h1>Category ${requestScope.category.name}</h1>
    <c:forEach var="project" items="${requestScope.projects}">
        <h2> <a href="project?id=${project.idProject}"> ${project.title}</a></h2>
        Description: ${project.description}<br>
        Total ${project.total}<br>
        Collected amount <br>
        Number of days to end ${project.getNumberOfDaysToEnd()}<br>
    </c:forEach>
</section>
--%>
<%@include file="WEB-INF/jspf/footer.jspf" %>
