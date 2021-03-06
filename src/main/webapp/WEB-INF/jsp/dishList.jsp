<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="webjars/datatables/1.10.11/css/jquery.dataTables.min.css">
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">
            <h3><spring:message code="dish.title"/></h3>

            <div class="view-box">

                <sec:authorize access="hasRole('ROLE_USER')">
                    <table class="table table-striped display" id="datatableUser">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Restaurant</th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>
                </sec:authorize>

                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <a class="btn btn-sm btn-info" onclick="add()"><spring:message code="dish.add"/></a>
                    <table class="table table-striped display" id="datatable">
                        <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                            <th>Restaurant</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                    </table>
                </sec:authorize>

            </div>
        </div>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>

<div class="modal fade" id="editRow">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h2 class="modal-title"><spring:message code="dish.edit"/></h2>
            </div>
            <div class="modal-body">
                <form:form class="form-horizontal" method="post" id="detailsForm">
                    <input hidden="hidden" id="id" name="id">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="price" class="control-label col-xs-3">Price</label>

                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="price" name="price" placeholder="price">
                        </div>
                    </div>
                    <input hidden="hidden" id="restaurantId" name="restaurantId">

                    <div class="form-group">
                        <label for="restaurantSelect" class="control-label col-xs-3">Restaurant</label>

                        <div class="col-xs-9">
                            <select class="form-control" id="restaurantSelect" name="restaurant ">
                                <option value="" disabled selected >restaurant.choose</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-xs-offset-3 col-xs-9">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
<%--<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>
<script type="text/javascript" src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>
<script type="text/javascript" src="webjars/datetimepicker/2.4.7/build/jquery.datetimepicker.full.min.js"></script>
<script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script type="text/javascript" src="resources/js/datatablesUtil.js"></script>
<script type="text/javascript" src="resources/js/dishDatatables.js"></script>
<script type="text/javascript" src="resources/js/restaurantSelect.js"></script>

</html>