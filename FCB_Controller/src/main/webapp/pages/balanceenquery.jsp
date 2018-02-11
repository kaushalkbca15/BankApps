<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script>
	var app = angular.module('MyApp', []);
	app.controller('MyController',function($scope, $http, $window) {
		$scope.welcomePageFlage=true;
		$scope.accountStatusPageFlage=false;
		$scope.balanceEnquiryPageFlage=false;
		$scope.depositPageFlage=false;
		$scope.registerEmployeePageFlage=false;
		
		$scope.messageColor="";
		$scope.disabledAccountStatusManuButton=true;
		$scope.disabledDepositManuButton=false;
		$scope.disabledBalanceEnquiryManuButton=false;
		$scope.disabledWithdrawManuButton=false;
		$scope.registerEmployeeManuButton=true;
		
		
		$scope.accountStatusPage=function(){
			$scope.accountStatusPageFlage=true;
			$scope.welcomePageFlage=false;
			$scope.depositPageFlage=false;
			$scope.balanceEnquiryPageFlage=false;
			$scope.registerEmployeePageFlage=false;
			
		}//accountStatusPage
		
		$scope.accountStatusOperation=function(){
			$http({
				url : "accountStatus",
				method : "get",
				params : {
					"accountNumber" : $scope.accountNumber
				}
			}).then(function(result) {
				$scope.responce = result.data;
				if ($scope.responce.status === "SUCCESS") {
					var accountStatusObj = angular.fromJson($scope.responce.data);
					$scope.message = "Account holder name : "+ accountStatusObj.accountHolderName
						+ ",   Branch name : "+ accountStatusObj.branchName;
					if (accountStatusObj.accountStatus == '0') {
						//in active	account
						
						$scope.message = "Account holder name : "+ accountStatusObj.accountHolderName
						+ ",   Branch name : "+ accountStatusObj.branchName+",  Account is Inactive";
						$scope.messageColor='#F31409';
						
						$scope.disabledAccountStatusManuButton=true;
						$scope.disabledDepositManuButton=false;
						$scope.disabledBalanceEnquiryManuButton=false;
						
					} else if (accountStatusObj.accountStatus == '1') {
						$scope.message = "Account holder name : "+ accountStatusObj.accountHolderName
						+ ",   Branch name : "+ accountStatusObj.branchName;
						$scope.accountHolderName=accountStatusObj.accountHolderName;
						$scope.branchName=accountStatusObj.branchName;
						$scope.disabledAccountStatusManuButton=false;
						$scope.disabledBalanceEnquiryManuButton=true;
						$scope.disabledDepositManuButton=true;
						$scope.disabledWithdrawManuButton=true;
						$scope.registerEmployeeManuButton=true;
					} else if (accountStatusObj.accountStatus == '2') {
						//blocked account
						$scope.message = "Account holder name : "+ accountStatusObj.accountHolderName
						+ ",   Branch name : "+ accountStatusObj.branchName+",  Account is blocked";
						$scope.disabledAccountStatusManuButton=true;
						$scope.disabledDepositManuButton=false;
						$scope.disabledBalanceEnquiryManuButton=false;
						$scope.disabledWithdrawManuButton=false;
					}
				}//if success	
				else{
					$scope.message = "Not valid account number";
					$scope.disabledAccountStatusManuButton=true;
					$scope.disabledDepositManuButton=false;
					$scope.disabledBalanceEnquiryManuButton=false;
					$scope.disabledWithdrawManuButton=false;
				}
			}, function(result) {
				console.log("" + result.data);
			});
		}//accountStatusOperation
		$scope.balanceEnquiry=function(){
			$scope.accountStatusPageFlage=false;
			$scope.balanceEnquiryPageFlage=true;
			$scope.depositPageFlage=false;
			$scope.withdrawPageFlage=false;
			$scope.registerEmployeePageFlage=false;
			$scope.depositMessage="";
			$http({
				url:"balanceEnquiey",
				method:"get",
				params:{
					"accountNumber" : $scope.accountNumber
				}			
			}).then(function(result){
				var balanceStatusObj=angular.fromJson(result.data);
				$scope.balance=balanceStatusObj.data;
			},function(result){
				//console.log(result.data);
			})
		}//balance enquiry
		$scope.depositPage=function(){
			$scope.depositMessage="";
			$scope.depositPageFlage=true;
			$scope.accountStatusPageFlage=false;
			$scope.balanceEnquiryPageFlage=false;
			$scope.welcomePageFlage=false;
			$scope.withdrawPageFlage=false;
			$scope.registerEmployeePageFlage=false;
		}//deposit
		$scope.homefun=function(){
			$scope.disabledAccountStatusManuButton=true;
			$scope.disabledDepositManuButton=false;
			$scope.disabledBalanceEnquiryManuButton=false;
			$scope.disabledWithdrawManuButton=false;
			
			$scope.welcomePageFlage=true;
			$scope.accountStatusPageFlage=false;
			$scope.balanceEnquiryPageFlage=false;
			$scope.depositPageFlage=false;
			
			$scope.accountNumber="";
			$scope.transactionMode="";
			$scope.chqOrDdNumber="";
			$scope.chqOrDdNumber="";
			$scope.issuedBy="";
			$scope.issuedDate="";
			$scope.message="";
			$scope.depositMessage="";
		}//home
		
		$scope.transactionModeFun=function(){
			$scope.chequOrDDFieldFlage=false;
			
				if($scope.transactionMode=='cash'){
					
					$scope.chequOrDDFieldFlage=false;
					$scope.chqOrDdNumber="";
					$scope.issuedBy="";
					$scope.issuedDate="";
				}else if($scope.transactionMode=='cheque' ||$scope.transactionMode=='dd' ){
					$scope.chequOrDDFieldFlage=true;
				}
		}//transactionModeFun
		
		$scope.deposit=function(){
			 $http({
				url:"deposit",
				method:"post",
				data:{
					"accountNumber":$scope.accountNumber,
					"amount":$scope.amount,
					"transactionMode":$scope.transactionMode,
					"number":$scope.chqOrDdNumber,
					"issuedBy":$scope.issuedBy,
					"issuedDate":$scope.issuedDate
				}
			}).then(function(result){
				console.log(result.data);
				var responseObj=angular.fromJson(result.data);
				$scope.depositMessage=responseObj.message;
				console.log(responseObj.message);
				
			},function(result){
				
			}) 
		/* 	console.log("accountNumber :"+$scope.accountNumber);
			console.log("amount :"+$scope.amount);
			console.log("transactionMode :"+$scope.transactionMode);
			console.log("chqOrDdNumber :"+$scope.chqOrDdNumber);
			console.log("issuedBy :"+$scope.issuedBy);
			console.log("issuedDate :"+$scope.issuedDate); */
			
			$scope.amount="";
			$scope.transactionMode="";
			$scope.chqOrDdNumber="";
			$scope.chqOrDdNumber="";
			$scope.issuedBy="";
			$scope.issuedDate="";
		}//deposit
		//withdraw page start
		$scope.withdrawPage=function(){
			$scope.withdrawMessage="";
			$scope.welcomePageFlage=false;
			$scope.accountStatusPageFlage=false;
			$scope.balanceEnquiryPageFlage=false;
			$scope.depositPageFlage=false;
			$scope.withdrawPageFlage=true;
			$scope.registerEmployeePageFlage=false;
		}//withdraw page end
		//withdraw page operatin start
		$scope.withdraw=function(){
			
			$scope.welcomePageFlage=false;
			$scope.accountStatusPageFlage=false;
			$scope.balanceEnquiryPageFlage=false;
			$scope.depositPageFlage=false;
			$http({
				url:"withdraw",
				method:"post",
				data:{
					"accountNumber":$scope.accountNumber,
					"amount":$scope.amount,
					"transactionMode":$scope.transactionMode,
					"number":$scope.chqOrDdNumber,
					"issuedBy":$scope.issuedBy,
					"issuedDate":$scope.issuedDate
				}
			}).then(function(result){
				console.log(result.data);
				$scope.withdrawMessage=result.data.message;
				
			},function(result){
				console.log(result.data);
			})
			$scope.amount="";
			$scope.transactionMode="";
			$scope.chqOrDdNumber="";
			$scope.chqOrDdNumber="";
			$scope.issuedBy="";
			$scope.issuedDate="";
		}//withdraw page operatin end
		$scope.branchAllId=[];
		//Register Employee page start
		$scope.registerEmployeePage=function(){
			/* this ajex call for load branch id */
			$http.get("branchid")
			.then(function(responce){
				console.log(responce.data.data);
				$scope.branchAllId=responce.data.data;
				console.log($scope.branchAllId);
			},function(responce){
				
			})
			$scope.registerEmployeePageFlage=true;
			$scope.accountStatusPageFlage=false;
			$scope.welcomePageFlage=false;
			$scope.depositPageFlage=false;
			$scope.withdrawPageFlage=false;
			$scope.balanceEnquiryPageFlage=false;	
			
		}//end Register Employee page
		
		$scope.employeeJson={};
		$scope.permanentAddJson={};
		$scope.presentAddJson={};
		$scope.identificationProofJson={};
		$scope.addressProofJson={};
		$scope.passportJson={};
		$scope.otherCardJson={};
	
		
		$scope.registerEmployee=function(){
		
			console.log($scope.employeeJson);
			console.log($scope.permanentAddJson);
			$http({
				url:"registerEmployee",
				method:"post",
				data:{
					"employeeJson":$scope.employeeJson,
					"permanentAddJson":$scope.permanentAddJson,
					"presentAddJson":$scope.presentAddJson,
					"identificationProofJson":$scope.identificationProofJson,
					"addressProofJson":$scope.addressProofJson,
					"passportJson":$scope.passportJson,
					"otherCardJson":$scope.otherCardJson
				}
				
			}).then(function(result){
				
				$scope.registerEmployeeMessage=result.data.message;
			},function(result){
				$scope.registerEmployeeMessage="Error occure while register employee details";
			})
			//$http close
		}
	});
	
</script>
<style>
	.navbar-custom {
		 
    background-color: #b1b5af;
	}
</style>
</head>
<body ng-app="MyApp" ng-controller="MyController" ng-clock>
	
	<div class="container">
		 <div class="row">
		    <div class="col-sm-12 bg-primary text-white" style="height: 200px" ></div>
 		 </div>
	 	<div class="row" style="margin-top: 2px;">
	 		<nav class="navbar navbar-expand-sm navbar-custom  ">
			   	<div class="col-sm-2 " style="height: 40px" >
			   		<ul class="nav navbar-nav">
					      <li ><a href="#" ng-click=homefun()>Home</a></li>  
				    </ul>
			   	</div>
			   	<div class="col-sm-8 " style="height: 40px" ></div>
			   	<div class="col-sm-2 text" style="height: 40px; color: white;" >
			   		<%-- WELCOME:&nbsp;&nbsp;&nbsp;<%= request.getUserPrincipal().getName().toUpperCase()%> --%>
			   		<a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <span class="glyphicon glyphicon-user"></span> 
                        <strong><%=request.getUserPrincipal().getName().toUpperCase() %></strong>
                        <span class="glyphicon glyphicon-chevron-down"></span>
                    </a>
                     <ul class="dropdown-menu">
                        <li>
                            <div class="navbar-login">
                                <div class="row">
                                    <div class="col-lg-2">
                                        <p class="text-center">
                                            <span class="glyphicon glyphicon-user icon-size"></span>
                                        </p>
                                    </div>
                                    <div class="col-lg-8">
                                        <p class="text-left"><strong>Nombre Apellido</strong></p>
                                        <p class="text-left small">correoElectronico@email.com</p>
                                        <p class="text-left">
                                            <a href="#" class="btn btn-success btn-block" style="border-radius: 70px;">User Details</a>
                                        </p>
                                    </div>
                                    <div class="col-lg-2"></div>
                                </div>
                            </div>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <div class="navbar-login navbar-login-session">
                                <div class="row">
                                    <div class="col-lg-2"></div>
                                    <div class="col-lg-8">
									<p>
										<form id="logout" action="logout" method="post" >
  											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
											<a style="border-radius: 70px;" class="btn btn-danger btn-block" href="javascript:document.getElementById('logout').submit()">Logout</a>
										</form>
                                            <!-- <a href="#" class="btn btn-danger btn-block">Logout</a> -->
									</p>
                                    </div>
                                    <div class="col-lg-2"></div>
                                </div>
                            </div>
                        </li>
                    </ul>
			   	</div>
			</nav>
 		</div>
 		 
 		 <div class="row">
			<!-- menu -->
			<div class="col-sm-2 "  >
				<div class="btn-group btn-group-justified ">
   					 <a href="#" class="btn btn-primary" ng-show="disabledAccountStatusManuButton" ng-click="accountStatusPage()">Account Status</a>
			    </div>
			    <div class="btn-group btn-group-justified ">
   					 <a href="#" class="btn btn-primary" ng-show="registerEmployeeManuButton" ng-click="registerEmployeePage()">Register Employee +</a>
			    </div>
			    <div class="btn-group btn-group-justified ">
   					 <a href="#" class="btn btn-primary" ng-show="disabledBalanceEnquiryManuButton" ng-click="balanceEnquiry()">Balance Enquiry</a>
			    </div>	
			    <div class="btn-group btn-group-justified ">
   					 <a href="#" class="btn btn-primary" ng-show="disabledDepositManuButton" ng-click="depositPage()">Deposit</a>
			    </div>
			     <div class="btn-group btn-group-justified ">
   					 <a href="#" class="btn btn-primary" ng-show="disabledWithdrawManuButton" ng-click="withdrawPage()">Withdraw</a>
			    </div>		
			</div>
			<!-- body -->
			<div class="col-sm-8" style="height: 1200px">
				<!-- welcome page -->
				<div ng-show="welcomePageFlage">
					<h1 align="center" style="color:green">-:WELCOME:-</h1>	
				</div>
				<!-- account status -->
				<div ng-show="accountStatusPageFlage">
					<div>
						<h3 align="center" style="color: green">-:Account Status:-</h3><hr><br><br>
						<div>
							<p align="center" style="coloe:{{messageColor}}">{{message}}</p>
						</div>
						<div class="col-sm-6">
							<input class="form-control input-lg" id="inputlg"" type="text" ng-model="accountNumber" placeholder="Enter Account Number ">
						</div>	
						<div class="col-sm-6">
							<button type="button" class="btn btn-success btn-lg btn-block" ng-click="accountStatusOperation()">submit</button>
						</div>
					</div>				
				</div>
				
				<!-- employee register start page -->
				<div ng-show="registerEmployeePageFlage">
					
					<div>
						<h3 align="center" style="color: green">-:Registe Employee:-</h3><hr><br>
					</div>
					<div class="rows">
						<div class="col-sm-12"> 
							<h3>Employee Details</h3>
						</div>
					</div>
					<div class="rows">
						<div>
							<p align="center" style="color: green">{{registerEmployeeMessage}}</p>
						</div>
						<div class="col-sm-6">
							<input class="form-control input-lg" id="inputlg" type="text" ng-model="employeeJson.firstName" placeholder="First name">
						</div>
						<div class="col-sm-6">
							<input class="form-control input-lg" id="inputlg" type="text" ng-model="employeeJson.lastName" placeholder="Last name">
						</div>
					</div>
					<div class="rows" >
						<div class="col-sm-6" style=" margin-top: 5px;">
							<input class="form-control input-lg" id="inputlg" type="text" ng-model="employeeJson.dob" placeholder="Date of birth Ex.(20/01/2018)">
						</div>
						<div class="col-sm-6" style=" margin-top: 5px;">
							<label class="form-control input-lg">Gender: &nbsp;&nbsp; 
							<input type="radio" ng-model="employeeJson.gender" value="male" >Mele&nbsp;&nbsp;<!-- ng-checked="true" -->
  							<input type="radio" ng-model="employeeJson.gender" value="female">Female</label>
						</div>
						
					</div>
					<div class="rows">
						<div class="col-sm-6" style=" margin-top: 5px;">
							<input class="form-control input-lg" id="inputlg" type="text" ng-model="employeeJson.mobile" placeholder="Mobile number">
						</div>
						<div class="col-sm-6" style=" margin-top: 5px;">
							<input class="form-control input-lg" id="inputlg" type="text" ng-model="employeeJson.email" placeholder="Example@gmail.com">
						</div>
					</div>
					<div class="rows">
						<div class="col-sm-6" style=" margin-top: 5px;">
							<select class="form-control input-lg" ng-model="employeeJson.bloodGroup">
								<option value="">  Select blood group  	</option>
								<option value="O+">O positive (O+)</option>
								<option value ="A-">A negative (A-)</option>
								<option value="A+">A positive (A+)</option>
								<option value="B-">B negative (B-)</option>
								<option value="B+">B positive (B+)</option>
								<option value="AB-">AB negative (AB-)</option>
								<option value="AB+">AB positive (AB+)</option>
							</select>
						</div>
						<div class="col-sm-6" style=" margin-top: 5px;">
							<!-- <input class="form-control input-lg" id="inputlg" type="text" ng-model="txtDOJ" placeholder="Date of join Ex.(20/01/2018)"> -->
							<input type="text" class="form-control input-lg" id="inputlg"  ng-model="employeeJson.joiningDate" placeholder="Date of join Ex.(20/01/2018)">
							
						</div>
					</div>
					<div class="rows">
						<div class="col-sm-6" style=" margin-top: 5px;">
							<select class="form-control input-lg" ng-model="employeeJson.desgination">
								<option value="">  Select designation </option>
								<option value="Branch manager"> Branch manager</option>
								<option value="Manager">  Manager </option>
								<option value="Clerks">Clerks</option>
								<option value="Officer">Officer</option>
							</select>
						</div>
						<div class="col-sm-6" style=" margin-top: 5px;">
							<select class="form-control input-lg" ng-model="employeeJson.salary">
								<option value="">  Select salary </option>
								<option value="15000">15000.00</option>
								<option value="18000">18000.00 </option>
								<option value="20000">20000.00</option>
								<option value="30000">30000.00</option>
							</select>
						</div>
					</div>
					<div class="rows">
						<div class="col-sm-8" style=" margin-top: 5px;">
							<label class="form-control input-lg">Status: &nbsp;&nbsp; 
								<input type="radio" ng-model="employeeJson.status" value="1" >Activ&nbsp;&nbsp;<!--  ng-checked="true"-->
								<input type="radio" ng-model="employeeJson.status" value="0" >Inactive&nbsp;&nbsp;
								<input type="radio" ng-model="employeeJson.status" value="2" >Blocked&nbsp;&nbsp;
							</label>
						</div>
						<!-- <div class="col-sm-4" style=" margin-top: 5px;">
							<select class="form-control input-lg" ng-model="employeeJson.branchId">
								<option value="">  select branch id </option>
								<option value="1111">  101 </option>
								<option value="201">  102 </option>
								<option value="125">  103 </option>
							</select>
						</div>-->
						<div class="col-sm-4" style=" margin-top: 5px;">
							<select class="form-control input-lg" ng-model="employeeJson.branchId">
								<option  value="">  select branch id </option>
								<option  ng-repeat="idValue in branchAllId" value="idValue"> {{idValue}}</option>
							</select>
						</div>
					</div>
					<div class="rows">
						<div class="col-sm-12">
						 <div class="panel-group" id="accordion">
						    <div class="panel panel-default"><!-- panel panel-default  collapse1-->
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Permanent Address</a>
						        </h4>
						      </div>
						      <div id="collapse1" class="panel-collapse collapse in">
						        <div class="panel-body">
						        	<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="permanentAddJson.address" placeholder="Address">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="permanentAddJson.city" placeholder="City">
										</div>
									</div><!-- rows -->
									<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="permanentAddJson.state" placeholder="State">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="permanentAddJson.country" placeholder="Country">
										</div>
									</div><!-- rows -->
									<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="permanentAddJson.zipcode" placeholder="ZipCode">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<!-- <input class="form-control input-lg" id="inputlg" type="text" ng-model="txtc" placeholder="Last name"> -->
										</div>
									</div><!-- rows -->
								</div><!-- panel-body -->
						      </div>
						    </div><!-- panel panel-default  collapse1-->
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Present Address</a>
						        </h4>
						      </div>
						      <div id="collapse2" class="panel-collapse collapse">
						        <div class="panel-body">
						        	<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="presentAddJson.address" placeholder="Address">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="presentAddJson.city" placeholder="City">
										</div>
									</div><!-- rows -->
									<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="presentAddJson.state" placeholder="State">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="presentAddJson.country" placeholder="Country">
										</div>
									</div><!-- rows -->
									<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="presentAddJson.zipcode" placeholder="ZipCode">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<!-- <input class="form-control input-lg" id="inputlg" type="text" ng-model="txtc" placeholder="Last name"> -->
										</div>
									</div><!-- rows -->
								</div><!-- panel -body -->
						      </div>
						    </div>
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Identification Proof</a>
						        </h4>
						      </div>
						      <div id="collapse3" class="panel-collapse collapse">
						        <div class="panel-body">
						        	<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="identificationProofJson.proofType" placeholder="Proof type">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="identificationProofJson.proofIdNumber" placeholder="Proof number">
										</div>
									</div><!-- rows -->
						        </div><!-- panel-body -->
						      </div>
						    </div>
						    
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" data-parent="#accordion" href="#collapse4">Address Proof</a>
						        </h4>
						      </div>
						      <div id="collapse4" class="panel-collapse collapse">
						        <div class="panel-body">
						        	<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="addressProofJson.proofType" placeholder="Proof type">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="addressProofJson.proofIdNumber" placeholder="Proof number">
										</div>
									</div><!-- rows --> 
						        </div><!-- panel-body -->
						      </div>
						    </div>
						    
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" data-parent="#accordion" href="#collapse5">Passport Details</a>
						        </h4>
						      </div>
						      <div id="collapse5" class="panel-collapse collapse">
						        <div class="panel-body">
						         	<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="passportJson.passportNumber" placeholder="Passport number">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="passportJson.passportIssuedDate" placeholder="Passport issue Date">
										</div>
									</div><!-- rows -->
									<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="passportJson.passportExpiryDate" placeholder="Passport Expiry date">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											 <input class="form-control input-lg" id="inputlg" type="text" ng-model="passportJson.issuedPlace" placeholder="Passport issue place">
										</div>
									</div><!-- rows --> 
						        </div><!-- panel-body -->
						      </div>
						    </div>
						    <div class="panel panel-default">
						      <div class="panel-heading">
						        <h4 class="panel-title">
						          <a data-toggle="collapse" data-parent="#accordion" href="#collapse6">Other Details</a>
						        </h4>
						      </div>
						      <div id="collapse6" class="panel-collapse collapse">
						        <div class="panel-body">
						        	<div class="rows">
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="otherCardJson.idCardType" placeholder="Proof type">
										</div>
										<div class="col-sm-6" style=" margin-top: 5px;">
											<input class="form-control input-lg" id="inputlg" type="text" ng-model="otherCardJson.idCardNumber" placeholder="Proof number">
										</div>
									</div><!-- rows --> 
						        </div><!-- panel-body -->
						      </div>
						    </div>
						  </div>  
						</div>
					</div>
					<div class="rows">
						<div class="col-sm-6" style=" margin-top: 5px;">
							<button type="button" class="btn btn-danger btn-lg btn-block">Cancel</button>
						</div>
						<div class="col-sm-6" style=" margin-top: 5px;">
							<button type="button" class="btn btn-success btn-lg btn-block" ng-click="registerEmployee()">Register</button>
						</div>
					</div>
				</div>
				<!-- employee register end page -->
				
			<!--balance enquiry -->
				<div ng-show="balanceEnquiryPageFlage">
					<div>
						<h3 align="center" style="color: green">-:Balance Enquiry:-</h3><hr><br><br>
					</div>
					<div>
						<table class="table table-bordered">
							<thead>
								<tr>
									<th>Account holder name</th>
									<th>Branch name</th>
									<th>&#x20B9 Total Amount</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>{{accountHolderName}}</td>
									<td>{{branchName}}</td>
									<td>{{balance}}</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			<!-- deposit -->
				<div ng-show="depositPageFlage">
					<div>
						<h3 align="center" style="color: green">-:Deposit:-</h3><hr><br><br>
					</div>
					<div>
						<h4 align="center" style="color:green">{{depositMessage}}</h4>
						<div class="col-sm-6">
							<input class="form-control input-lg" id="inputlg"" type="text" ng-model="amount" placeholder="&#x20B9  Enter amount">
						</div>
						<div class="col-sm-6" >
							<select ng-model="transactionMode" class="form-control input-lg" ng-change="transactionModeFun()">
								<option value="cash">Cash</option>
								<option value="cheque">Cheque</option>
								<option value="dd">DD</option>
							</select>	
						</div>
					</div>
					<div style=" margin-top: 60px;" ng-show="chequOrDDFieldFlage">
						<div style=" margin-top: 60px;">
							<div class="col-sm-6">
								<input class="form-control input-lg" id="inputlg" type="text" ng-model="chqOrDdNumber" placeholder="Enter Cheque/DD Number">
							</div>
						</div>
						<div style=" margin-top: 60px;">
							<div class="col-sm-6">
								<input class="form-control input-lg" id="inputlg" type="text" ng-model="issuedDate" placeholder="Enter Issued Date Ex.(20/01/2018)">
							</div>
						</div>
						<div>
							<div class="col-sm-6" style=" margin-top:12px;">
								<input class="form-control input-lg" id="inputlg" type="text" ng-model="issuedBy" placeholder="Enter Issued By ">
							</div>
						</div>
					</div>
					<div style=" margin-top: 60px;" ng-if="transactionMode">
						<div class="col-sm-6"></div>
						<div class="col-sm-6" style=" margin-top:12px;">
							<button type="button" class="btn btn-success btn-lg btn-block" ng-click="deposit()">Deposit</button>
						</div>
					</div>
				</div>
				<!-- deposit close -->
				<!-- withdraw open -->
				<div ng-show="withdrawPageFlage">
					<div>
						<h3 align="center" style="color: green">-:withdraw:-</h3><hr><br><br>
					</div>
					<div>
						<h4 align="center" style="color:green">{{withdrawMessage}}</h4>
						<div class="col-sm-6">
							<input class="form-control input-lg" id="inputlg"" type="text" ng-model="amount" placeholder="&#x20B9  Enter amount">
						</div>
						<div class="col-sm-6" >
							<select ng-model="transactionMode" class="form-control input-lg" ng-change="transactionModeFun()">
								<option value="cash">Cash</option>
								<option value="cheque">Cheque</option>
								<option value="dd">DD</option>
							</select>	
						</div>
					</div>
					<div style=" margin-top: 60px;" ng-show="chequOrDDFieldFlage">
						<div style=" margin-top: 60px;">
							<div class="col-sm-6">
								<input class="form-control input-lg" id="inputlg" type="text" ng-model="chqOrDdNumber" placeholder="Enter Cheque/DD Number">
							</div>
						</div>
						<div style=" margin-top: 60px;">
							<div class="col-sm-6">
								<input class="form-control input-lg" id="inputlg" type="text" ng-model="issuedDate" placeholder="Enter Issued Date Ex.(20/01/2018)">
							</div>
						</div>
						<div>
							<div class="col-sm-6" style=" margin-top:12px;">
								<input class="form-control input-lg" id="inputlg" type="text" ng-model="issuedBy" placeholder="Enter Issued By ">
							</div>
						</div>
					</div>
					<div style=" margin-top: 60px;" ng-if="transactionMode">
						<div class="col-sm-6"></div>
						<div class="col-sm-6" style=" margin-top:12px;">
							<button type="button" class="btn btn-success btn-lg btn-block" ng-click="withdraw()">Withdraw</button>
						</div>
					</div>
				</div>
				<!-- withdraw close -->
			</div>
			<div class="col-sm-2 ">WELCOME</div>
 		</div>
 		 <!-- <div class="row"><!-- footer 
			<div class="col-sm-12 ">
				<div style="background-color:#6D6969; height: 200px"></div>
			</div>
 		</div> -->
	</div>
</body>
</html>