<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Assign For Loan Verification</li>
  </ol>
</nav>
</div>
<hr>
<div class="container"> 
	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/assignLoanVerification"
		modelAttribute="form" >
		<sf:hidden path="id"/>
		<div class="card">
			<h5 class="card-header bgcolor"
				style="color: white;">Assign For Loan Verification</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>
		
				<div class="col-md-6">
					<s:bind path="loanOfficerId">
						<label for="inputEmail4" class="form-label">Loan Officer Name</label>
						<sf:select style="margin-bottom: 10px" class="form-control"
							path="${status.expression}">
							<sf:option value="-1" label="Select" />
							<sf:options itemLabel="firstName" itemValue="id" items="${loanOfList}" />
						</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="loanId">
						<label for="inputEmail4" class="form-label">Loan Id</label>
						<sf:select style="margin-bottom: 10px" class="form-control"
							path="${status.expression}">
							<sf:option value="-1" label="Select" />
							<sf:options itemLabel="requestLoanId" itemValue="id" items="${loanList}" />
						</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>

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