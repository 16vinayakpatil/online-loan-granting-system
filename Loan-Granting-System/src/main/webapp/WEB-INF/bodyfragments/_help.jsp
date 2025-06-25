<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Help</li>
  </ol>
</nav>
</div>
<hr>
<div class="container"> 
	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/help"
		modelAttribute="form">
		<sf:hidden path="id"/>
		<div class="card">
			<h5 class="card-header bgcolor"
				style="color: white;"> Help</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>

				
				<div class="col-md-6">
					<s:bind path="issue">
						<label for="inputEmail4" class="form-label">Issue</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Issue" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
					
				<div class="col-md-6">
					<s:bind path="description">
						<label for="inputEmail4" class="form-label">Description</label>
						<sf:textarea rows="4" cols="4" path="${status.expression}"
							placeholder="Enter Description" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<c:if test="${sessionScope.user.roleId == 1}">
				<div class="col-md-6">
					<s:bind path="comment">
						<label for="inputEmail4" class="form-label">Add Solution</label>
						<sf:textarea rows="4" cols="4" path="${status.expression}"
							placeholder="Enter Solution" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				</c:if>
				
				<br>
				<div class="col-12">
					<input type="submit" name="operation"
						class="btn btn-primary pull-right" value="Save"> or <input
						type="submit" name="operation" class="btn btn-primary pull-right"
						value="Reset">
				</div>
			</div>
		</div>
	</sf:form>
</div>