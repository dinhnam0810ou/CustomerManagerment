<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags/"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Patients</title>
        <style type="text/css">
        #addCustomerForm {
            padding-top: 4px;
        }
        .Input {
           margin-bottom: 5px;
        }
        .LabelWrapper {
            width:150px;
        }
        .SearchInput {
            width: 300px;
            margin-bottom: 5px;
        }
        </style>
    </head>
    <body>
       <%@include file="header.jsp" %>
       <tag:searchBar></tag:searchBar>
       <tag:customerList></tag:customerList>
       <h3>Add Customer</h3>
       <tag:addCustomerForm></tag:addCustomerForm>
    </body>
</html>