<?xml version="1.0" encoding="UTF-8"?>
<!--
    Licensed to the Apache Software Foundation (ASF) under one
    or more contributor license agreements.  See the NOTICE file
    distributed with this work for additional information
    regarding copyright ownership.  The ASF licenses this file
    to you under the Apache License, Version 2.0 (the
    "License"); you may not use this file except in compliance
    with the License.  You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing,
    software distributed under the License is distributed on an
    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    KIND, either express or implied.  See the License for the
    specific language governing permissions and limitations
    under the License.
-->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xml:lang="en">
<head th:replace="/apps/fling/page/fragments/head.html::default">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="../../../../assets/css/fling.css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
<div class="container">
  <nav class="nav-main">
    <div class="pull-left">
      <ul class="breadcrumb" style="direction: rtl" th:replace="/apps/fling/page/fragments/navigation.html::breadcrumb">
        <li class="active dropdown">
          <span>2rd BAR</span>
        </li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" role="button" data-toggle="dropdown"><span class="caret"></span></a>
          <a href="#">1st FOO</a>
          <ul class="dropdown-menu" role="menu">
            <li role="presentation"><a role="menuitem" tabindex="-1" href="../simple/html.html">1st FOO CHILD</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" href="../simple/html.html">2nd FOO CHILD</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" href="../simple/html.html">3rd FOO CHILD</a></li>
            <li role="presentation"><a role="menuitem" tabindex="-1" href="../simple/html.html">4th FOO CHILD</a></li>
          </ul>
        </li>
      </ul>
    </div>
    <ul class="nav nav-pills" role="tablist" th:replace="/apps/fling/page/fragments/navigation.html::children">
      <li><a href="../user/html.html">3rd BAZ</a></li>
    </ul>
  </nav>
  <div class="panel panel-primary">
    <div class="panel-heading">
      <span th:text="${page.title}">SIMPLE PAGE</span>
    </div>
    <div class="panel-body">
      <div th:utext="${page.content}"><p>Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua.</p><pre>At vero eos et accusam et justo duo dolores et ea rebum.</pre></div>
      <img src="../../../../assets/images/feather.png" width="355" height="111" th:attr="src='/fling/assets/images/feather.png'"/>
    </div>
    <div class="panel-footer" th:replace="/apps/fling/page/fragments/panel.html::footer">
      <span>user | auth type</span>
    </div>
  </div>
</div>
</body>
</html>