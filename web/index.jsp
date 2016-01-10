<%@page import="ua.com.goit.gojava7.salivon.beans.Quote"%>
<%@page import="ua.com.goit.gojava7.salivon.beans.Category"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/jspf/header.jspf" %>
<main>
    <section class="main">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Categories</strong></h3>
                        </div>
                        <div class="panel-body">
                            <ul class="nav nav-pills nav-stacked">
                                <c:forEach var="category" items="${requestScope.categories}">
                                    <li role="presentation">
                                        <a class="link-category" href="${pageContext.servletContext.contextPath}/category?id=${category.id}">${category.name}
                                        </a>
                                    </li>    
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Top The Project</strong></h3>
                        </div>
                        <div class="panel-body">
                            <h4> The sum of the funds collected</h4>
                            <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                            <p><a class="btn btn-default" href="#" role="button">See more &raquo;</a></p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Top 5 Categories</strong></h3>
                        </div>
                        <div class="panel-body">
                            <h4> The sum of the funds collected</h4>
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Category</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>1</td>
                                        <td>Art</td>
                                        <td>456$</td>
                                    </tr>
                                    <tr>
                                        <td>2</td>
                                        <td>Games</td>
                                        <td>3685$</td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
    </section>
</main>
<%@include  file="WEB-INF/jspf/footer.jspf" %>
