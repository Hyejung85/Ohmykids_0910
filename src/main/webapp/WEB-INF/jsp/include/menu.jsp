<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">

		<nav class="navbar navbar-expand-lg nav-tabs nav-fill">
		  <div class="collapse navbar-collapse" id="navbarSupportedContent">
		    <ul class="navbar-nav mr-auto">
		      <!-- 자녀관리 -->
		      <li class="nav-item dropdown">
		        <a class="nav-link dropdown-toggle title-text" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          My Kids 관리
		        </a>
		        <!-- 자녀관리 submenu dropdown-->
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
		          <a class="dropdown-item title-text" href="/user/accounts/kidsinfo/create_view">자녀정보등록</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item title-text" href="/user/accounts/kidsinfo/list_view">자녀목록</a>
		        </div>
		        <!-- /자녀관리 submenu dropdown-->
		      </li>
		      <!-- /자녀관리 -->
		      <!-- 알림장 -->
		      <li class="nav-item">
		        <a class="nav-link title-text" href="#">알림장</a>
		      </li>
		      <!-- /알림장 -->
		      <!-- 앨범 -->
		      <li class="nav-item">
		        <a class="nav-link title-text" href="#">앨범</a>
		      </li>
		      <!-- /앨범 -->
		    </ul>
		   </div>
		</nav>