<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<br>
<div class="container"> 
<nav aria-label="breadcrumb">
  <ol class="breadcrumb">
    <li class="breadcrumb-item linkSize"><i class="fas fa-tachometer-alt"></i> <a class="link-dark" href="<c:url value="/home"/>">Home</a></li>
    <li class="breadcrumb-item linkSize active" aria-current="page"> <i class="fa fa-arrow-right" aria-hidden="true"></i> Forget Password</li>
  </ol>
</nav>
</div>
<hr>
<div class="container"> 
<div class="card shadow  mb-5 bg-body rounded" style="width: 700px">
			<h5 class="card-header bgcolor" style=" color: white;">Forget Password</h5>
			<b><%@ include file="businessMessage.jsp"%></b>
			<div class="card-body">
				<sf:form role="form" action="${pageContext.request.contextPath}/forgetPassword" method="post" modelAttribute="form">
					<s:bind path="userId">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">UserId</label> 
								<sf:input path="${status.expression}" placeholder="Enter User Id"
										class="form-control" />
								<div class="form-text"><font color="red" style="font-size: 13px"><sf:errors path="${status.expression}"/></font></div>
							</div>
							</s:bind>
							
							<input type="submit" name="operation" class="btn btn-primary pull-right"
								value="Go">
				</sf:form>
			</div>
		</div>
	</div>
	