<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>회원가입 화면 샘플 - Bootstrap</title>

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

  <style>



    .container{
     width: 70%;
     margin: 0 auto;
    }
  </style>
</head>

 <body>
 <%
	String memberId = request.getParameter("memberId");
	System.out.println("addteacherjsp:"+memberId);
%>	
<<<<<<< HEAD

       <div class="container">
           <div class="input-form-backgroud row">
               <div class="input-form col-md-12 mx-auto">
                   <h4 class="mb-3">강사 가입</h4>
                   <form:form modelAttribute="addTeacher" class="form-horizontal" action="/MAV/teacher/add" method="post">
               <fieldset>
                <div class="row">
                         <div class="col-md-6 ">
                             <label for="teacherCategory">강사종류</label>
                             <form:hidden class="form-control" path="teacherId" value="<%=memberId%>"/>
                             
                            <form:input path="teacherCategory" class="form-control" name="teacherCategory"/>                          
                          </div>
                        <div class="invalid-feedback">
                            전공을 입력해주세요
                        </div>                    
                        <div class="col-md-6 ">
                            <label for="teacherRecode">강사이력</label>
                            <form:input class="form-control" path="teacherRecode" name="teacherRecode"/>
                        </div>
                        <div class="invalid-feedback">
                              강사이력을 입력해주세요.
                        </div>  
                        <div class="col-md-12">
           				 	<label for="teacherInfomation">강사소개<span class="text-muted">&nbsp;(필수 아님)</span></label>
           					<form:textarea cols="50" rows="5" class="form-control" path="teacherInfomation" name="teacherInfomation"/>
           			   </div>
                     
                        <!--             <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                    <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                   <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
                <div  class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                   <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
                <div  class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                    <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
            </div>  -->
                                      
                       
         				 
                                            
                        
            </div>
                   <br>
                    <hr class="mb-4">
                    <div class="mb-4"></div>   
                      <input class="btn btn-primary btn-lg btn-block" type="submit" value="신청 완료"/>            
            </fieldset>
            </form:form>
               </div>
           </div>
       </div>

   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
 </body>
</html>

=======

       <div class="container">
           <div class="input-form-backgroud row">
               <div class="input-form col-md-12 mx-auto">
                   <h4 class="mb-3">강사 가입</h4>
                   <form:form modelAttribute="addTeacher" class="form-horizontal" action="/MAV/teacher/add" method="post">
               <fieldset>
                <div class="row">
                         <div class="col-md-6 mb-3">
                             <label for="teacherCategory">강사종류</label>
                             <form:hidden class="form-control" path="teacherId" value="<%=memberId%>"/>
                             
                            <form:input path="teacherCategory" class="form-control" name="teacherCategory"/>                          
                          </div>
                        <div class="invalid-feedback">
                            전공을 입력해주세요
                        </div>                    
                        <div class="col-md-6 mb-3">
                            <label for="teacherRecode">강사이력</label>
                            <form:input class="form-control" path="teacherRecode" name="teacherRecode"/>
                        </div>
                        <div class="invalid-feedback">
                              강사이력을 입력해주세요.
                        </div>   
                        <!--             <div class="row">
                <div class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                    <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
                <div class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                   <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
                <div  class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                   <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
                <div  class="col-md-6 mb-3">
                    <label for="teacherLicense" class="form-label">강사자격증</label>
                    <form:input class="form-control" type="file" path="teacherLicense"/>
                </div>
            </div>  -->
                                      
                        <div class="mb-3">
            				 <label for="teacherInfomation">자기소개<span class="text-muted">&nbsp;(필수 아님)</span></label>
            				 <form:input  class="form-control"  path="teacherInfomation" name="teacherInfomation" />
         				 </div>
                                            
                        
            </div>
                   <br>
                    <hr class="mb-4">
                    <div class="mb-4"></div>   
                      <input class="btn btn-primary btn-lg btn-block" type="submit" value="신청 완료"/>            
            </fieldset>
            </form:form>
               </div>
           </div>
       </div>

<<<<<<< HEAD
          <div class="mb-3">
            <label for="teacherInfomation">자기소개<span class="text-muted">&nbsp;(필수 아님)</span></label>
            <input type="text" class="form-control" id="teacherInfomation" placeholder="자기소개를 작성부탁드립니다.">
          </div>
          <hr class="mb-4">
          <div class="custom-control custom-checkbox">
            <input type="checkbox" class="custom-control-input" id="aggrement" required>
            <label class="custom-control-label" for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
          </div>
          <div class="mb-4"></div>
          	<button class="" type="submit">가입 완료</button>
        </form>
      </div>
    </div>

  </div>
  <script>
    window.addEventListener('load', () => {
      const forms = document.getElementsByClassName('validation-form');

      Array.prototype.filter.call(forms, (form) => {
        form.addEventListener('submit', function (event) {
          if (form.checkValidity() === false) {
            event.preventDefault();
            event.stopPropagation();
          }

          form.classList.add('was-validated');
        }, false);
      });
    }, false);
  </script>
</body>
</html>
=======
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
 </body>
</html>

>>>>>>> origin/PMS
>>>>>>> origin/KTY
