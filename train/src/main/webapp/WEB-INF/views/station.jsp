<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap-responsive.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery.dataTables.css"/>" media="all">
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/jquery-ui.min.css"/>" media="all">
    <script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/bootstrap.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/head.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.dataTables.js"/>"></script>
    <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>" media="all">
    <script type="text/javascript" src="<c:url value="/js/table.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/topButton.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/station.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery-ui.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/jquery.cookie.js"/>"></script>


</head>
<body onload="createDataTableStation()">
<div class="container block-center-div">

        <h1>Stations &nbsp; &nbsp; </h1>

    <div class="container filter-blur rounded popin vcenter">
        <table id="stations_table" class="display" cellspacing="0" width="100%">
            <button id="create" class="btn br2">New</button>
            <button id="remove" class="btn br2" disabled>Remove</button>
            <div><input class="button-tools" type="checkbox" id="filter-archived">Show only active</input></div>
            <thead>
            <tr>
                <th>Station name</th>
                <th>Status</th>
            </tr>
            </thead>
            <tbody id="stations_body" class="table table-hover text-dark">

            </tbody>
        </table>
    </div>
</div>
<%--//////////////////////////////Modal Creat station///////////////////////////////////--%>
<div class="text-light">
    <div id="dialog-form" class="modal fade">
        <div class="modal-dialog popap">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">New Station</h4>
                    <button id="closeCreateDialog" type="button" class="close">&times;</button>
                </div>
                <div class="modal-body">
                    <div id="block_error" class="alert alert-danger invisible">
                        <a id="close_message" class="close" href="<c:url value="#"/>">×</a><span
                            id="errorMessage"></span>
                    </div>
                    <form id="station_form">
                        <fieldset>
                            <label for="name" class="form-label">Name</label>
                            <input type="text" name="name" id="name"
                                   class="form-field text ui-widget-content ui-corner-all">
                        </fieldset>
                    </form>
                </div>
                <div class="modal-footer">
                    <button  id="closeCreateDialogA"  class="btn br2">Close</button>
                    <button  id="createStationButton" class="btn br2">Create</button>
                </div>
            </div>
        </div>
    </div>

 <%-- Modal DELET station --%>
    <%--<div id="dialog-remove" class="modal fade">--%>
        <%--<div class="modal-dialog popap">--%>
            <%--<div class="modal-content">--%>
                <%--<div class="modal-header">--%>
                    <%--<h4 class="modal-title">Delete Station</h4>--%>
                    <%--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>--%>
                <%--</div>--%>
                <%--<div class="modal-body">--%>
                    <%--<div id="delete_dialog_message">Do you want really remove station with name: <span--%>
                            <%--id="removeStation"></span> ?--%>
                    <%--</div>--%>
                <%--</div>--%>
                <%--<div class="modal-footer">--%>
                    <%--<button type="button" class="btn br2" data-dismiss="modal">Cancel</button>--%>
                    <%--<button id="removeStationButton" type="button" class="btn br2">Delete</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<div id="toTop" class="text-light">^</div>
</body>
</html>