<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/welcome"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Apply For Loan</li>
  </ol>
</nav>
</div>
<hr>
<div class="container"> 
	<sf:form method="post"
		action="${pageContext.request.contextPath}/ctl/applyLoan"
		modelAttribute="form" enctype="multipart/form-data">
		<sf:hidden path="id"/>
		<div class="card">
			<h5 class="card-header bgcolor"
				style="color: white;">Apply For Loan</h5>
			<div class="card-body">
				<b><%@ include file="businessMessage.jsp"%></b>



				<div class="col-md-6">
					<s:bind path="name">
						<label for="inputEmail4" class="form-label">Name</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Name" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="phoneNo">
						<label for="inputEmail4" class="form-label">Phone No</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Phone No" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				
				
				
				<div class="col-md-6">
					<s:bind path="emailId">
						<label for="inputEmail4" class="form-label">Email Id</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Email Id" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
					
				<div class="col-md-6">
					<s:bind path="resume">
						<label for="inputEmail4" class="form-label">Resume</label>
						<sf:input type="file" path="${status.expression}"
							placeholder="Resume" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
					<div class="col-md-6">
					<s:bind path="projectPlan">
						<label for="inputEmail4" class="form-label">Project Plan</label>
						<sf:input type="file" path="${status.expression}"
							placeholder="Project Plan" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="personalCreditReport">
						<label for="inputEmail4" class="form-label">Personal Credit Report</label>
						<sf:input type="file" path="${status.expression}"
							placeholder="Personal Credit Report" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="businessCreditReport">
						<label for="inputEmail4" class="form-label">Business Credit Report</label>
						<sf:input type="file" path="${status.expression}"
							placeholder="Business Credit Report" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="financialStatement">
						<label for="inputEmail4" class="form-label">Financial Statement</label>
						<sf:input type="file" path="${status.expression}"
							placeholder="Financial Statement" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="bankStatement">
						<label for="inputEmail4" class="form-label">Bank Statement</label>
						<sf:input type="file" path="${status.expression}"
							placeholder="Bank Statement" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
			
				
				
				
				<div class="col-md-6">
					<s:bind path="loanAmount">
						<label for="inputEmail4" class="form-label">Loan Amount</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Loan Amount" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="loanTenure">
						<label for="inputEmail4" class="form-label">Loan Tenure</label>
						<sf:input path="${status.expression}"
							placeholder="Enter Loan Tenure" class="form-control" />
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				<div class="col-md-6">
					<s:bind path="EMIOption">
						<label for="inputEmail4" class="form-label">EMIOption</label>
						<sf:select class="form-control" path="${status.expression}">
									<sf:option value="" label="Select" />
									<sf:options   items="${emiOp}" />
								</sf:select>
						<font color="red" style="font-size: 13px"><sf:errors
								path="${status.expression}" /></font>
					</s:bind>
				</div>
				
				
				<div class="col-md-6">
					<s:bind path="address">
						<label for="inputEmail4" class="form-label">Address</label>
						<sf:textarea rows="4" cols="4" path="${status.expression}"
							placeholder="Enter Address" class="form-control" />
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