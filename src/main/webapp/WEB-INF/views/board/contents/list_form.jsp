<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Horizontal Form -->
<div class="card card-info">
  <div class="card-header">
    <h3 class="card-title">List Form</h3>
  </div>
  <div class="card-body">
    <table id="boardTable" class="table table-bordered table-striped">
      <thead>
        <tr>
          <th>NO</th>
          <th>TESTID</th>
          <th>TITLE</th>
          <th>COMPANY</th>
          <th>REGDT</th>
          <th>STATUS</th>
        </tr>
      </thead>
      <!-- 
      <tbody>
        <tr>
          <td>Trident</td>
          <td>Internet
            Explorer 4.0
          </td>
          <td>Win 95+</td>
          <td> 4</td>
          <td>X</td>
        </tr>
      </tbody>
      -->
    </table>
  </div>
</div>

<script>
	require(["board"], function(board) {		
		/*
		$("#boardTable").DataTable({
			"columns": [
				{"data": "col1"}, 
				{"data": "col2"},
				{"data": "col3"},
				{"data": "col4"},
				{"data": "col5"},
				{"data": "col6"}
			], 
			"data": [{
				"col1": "Tiger Nixon",
				"col2": "System Architect",
				"col3": "Edinburgh",
				"col4": "5421",
				"col5": "2011/04/25",
				"col6": "$3,120"
			}, {
				"col1": "Garrett Winters",
				"col2": "Director",
				"col3": "Edinburgh",
				"col4": "8422",
				"col5": "2011/07/25",
				"col6": "$5,300"
			}]
		});
		*/
	});
</script>