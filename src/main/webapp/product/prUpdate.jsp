<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ include file="./../common/common.jsp"%>
<%
/* position for grid system */
int offset = 2;
int mywidth = twelve - 2 * offset;
int formleft = 3;
int formright = twelve - formleft;
int rightButton = 2;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min2.css" type="text/css">
<script type="text/javascript">

   /* 게시판 입력 폼 유효성 검사 */
   function checkForm() {
      /* 제목 길이 체크 */
      var title = document.insertform.title.value;
      if (title.length < 2) {
         alert('제목은 최소 2자리 이상이어야 합니다.');
         document.insertform.title.focus();
         return false;
      } else if (title.length > 20) {
         alert('제목은 최소 20자리 이하이어야 합니다.');
         document.insertform.title.focus();
         return false;
      }

      /* 내용 길이 체크 */
      var content = document.insertform.content.value;
      if (content.length < 5) {
         alert('내용은 최소 5자리 이상이어야 합니다.');
         document.insertform.content.focus();
         return false;
      } else if (content.length > 1333) {
         alert('내용은 최대 1333자리 이하이어야 합니다.');
         document.insertform.content.focus();
         return false;
      }

      /* 카테고리 선택 체크 */
      var category = document.insertform.category.value;
      if (category == "-") {
         alert('카테고리를 선택해주세요.');
         document.insertform.category.focus();
         return false;

      }
      
      
   }
   
</script>

<style type="text/css">
   .checkout__input_2 input{
      height: 350px;
      width: 100%;
      border: 1px solid #e1e1e1;
      font-size: 14px;
      color: #666666;
      padding-left: 20px;
      margin-bottom: 20px;
   }
   .checkout__input_2 p span {
        color: #f08632;
   }
</style>
</head>
<body>
   <!-- 게시판 입력 폼 시작 -->

   <!-- Breadcrumb Begin -->
   <div class="breadcrumb-option">
      <div class="container">
         <div class="row">
            <div class="col-lg-6 col-md-6 col-sm-6">
               <div class="breadcrumb__text">
                  <h2>
                     상품게시판
                  </h2>
               </div>
            </div>
            <div class="col-lg-6 col-md-6 col-sm-6">
               <div class="breadcrumb__links">
                  <a href="<%=FormNo%>main">
                     Home
                  </a>
                  <span>
                      상품게시판
                  </span>
               </div>
            </div>
         </div>
      </div>
   </div>
   <!-- Breadcrumb End -->

   <!-- Checkout Section Begin -->
   <section class="checkout spad">
      <div class="container">
         <div class="checkout__form">
            <form name="insertform" action="<%=FormYes%>" method="post">
               <input type="hidden" name="command" value="prInsert"> 
               <input type="hidden" name="writer" value="${sessionScope.loginfo.id}">
               <div class="row">
                  <div class="col-lg-12 col-md-6">
                     <h6 class="coupon__code">
                        <span class="icon_tag_alt"> </span> 
                        상품 게시물 수정
                     </h6>
                     <div class="row">
                        <div class="col-lg-8">
                           <div class="checkout__input">
                              <p>
                                 제목
                                    <span>
                                       *
                                    </span>
                              </p>
                              <input type="text" class="form-control" id="title" 
                                name="title" value="${bean.title}">
                           </div>
                        </div>
                        <div class="col-lg-4">
                           <div class="checkout__input">
                              <p>
                                 카테고리
                                    <span>
                                       *
                                    </span>
                              </p>
                              <div>
                                 <select id="state" name="state" class="form">
                                    <option value="-" selected="selected">선택하세요
                                    <option value="">판매중
                                    <option value="">판매완료
                                 </select>
                              </div>
                           </div>
                        </div>
                     </div>
                     <div class="input-div">
                        <div class="checkout__input_2">
                           <p>
                              글 내용
                                 <span>
                                    *
                                 </span>
                           </p>
                           <textarea rows="10" cols="125" name="content" style="resize: none;">${bean.content}</textarea>
                        </div>
                     </div>
                     <br>
                     <button type="submit" class="site-btn" onclick="return checkForm();">
                        등록
                     </button>
                  </div>
               </div>
            </form>
         </div>
      </div>
   </section>
   <!-- Checkout Section End -->

   <!-- 게시판 입력 폼 끝 -->
</body>
</html>
<jsp:include page="/common/footer.jsp"></jsp:include>