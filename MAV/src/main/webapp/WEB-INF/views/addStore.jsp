<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap" rel="stylesheet">
    <style>
        * 
        {
            font-family: 'Noto Sans KR', sans-serif;
        }
        .main-container
        {
            width: 70%;
            margin: 0 auto;
        }
        .container
        {
            margin-top: 20px;
        }
    </style>
  </head>
  <body>
  <%
   String memberId = request.getParameter("memberId");
   System.out.println("store:"+memberId);
%>   
    <div class="main-container">
       <jsp:include page="./section/nav.jsp"/>        
        <div class="container">
            <div class="input-form-backgroud row">
                <div class="input-form col-md-12 mx-auto">
                    <h4 class="mb-3">업체등록</h4>
                    <form:form modelAttribute="store" class="form-horizontal" action="add" method="post">
                  <fieldset>
                   <div class="row">
                            <div class="col-md-6 mb-3">
                                <label for="storeName">업체명</label>
                               <form:input path="storeName" class="form-control" />
                               <form:hidden class="form-control" path="storeId" value="${member.memberId}"/>                          
                             </div>
                            <div class="invalid-feedback">
                                업체명을 입력해주세요.
                            </div>
                           <div class="col-md-6 mb-3">
                               <label for="storeAddr">업체주소</label>
                               <form:input class="form-control" path="storeAddr"/>
                           </div>
                            <div class="invalid-feedback">
                                업체주소를 입력해주세요.
                            </div>
                           <div class="col-md-6 mb-3">
                                 <label for="storeCategory">업체종목</label>
                                 <form:input class="form-control" path="storeCategory" />
                             </div>
                            <div class="invalid-feedback">
                                업체종목을 입력해주세요.
                            </div>
                           <div class="col-md-2 mb-3">
                               <label for="storePhone01">업체번호</label>
                               <form:input class="form-select" aria-label="Default select example" path="storePhone01"/>                               
                           </div>
                           <div class="col-md-2 mb-3">
                               <label for="storePhone02"></label>
                               <form:input class="form-control" path="storePhone02"/>
                           </div>
                           <div class="col-md-2 mb-3">
                               <label for="storePhone03"></label>
                               <form:input class="form-control" path="storePhone03" />
                           </div>
                            <div class="invalid-feedback">
                                업체번호를 입력해주세요.
                            </div>
                           <%-- <div class="col-md-6 mb-3">
                               <label for="memberGender">업체이미지</label>
                               <form:select class="form-select" aria-label="Default select example" path="memberGender">
                                   <form:options items="${genderOptions}"/>
                               </form:select>
                           </div>
                            <div class="invalid-feedback">
                                업체 이미지를 등록해주세요
                            </div> --%>
                           <div class="col-md-6 mb-3">
                               <label for="storeCode">사업자번호</label>
                               <form:input class="form-control" path="storeCode" />                        
                           </div>
                            <div class="invalid-feedback">
                                사업자번호를 입력해주세요
                            </div>                        
                       </div>
                       <hr class="mb-4">
                       <div class="mb-4"></div>   
                       <input class="btn btn-primary btn-lg btn-block" type="submit" value="신청 완료"/>            
               </fieldset>
               </form:form>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
  </body>
</html>