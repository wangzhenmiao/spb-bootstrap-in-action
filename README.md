# spb-bootstrap-in-action

一、集成bootstrap
1、项目启动后，访问url：http://localhost:8080/users

二、代码分析

1、thymeleaf标签之th:href的使用
一般写法为th:href="@{值}"
如果是需要从model中取值的话，写法为：th:href="@{${model中的name值}}"
有的时候我们不止需要从model中进行取值，还需写字符串与model中的值进行拼接，写法为：th:href="@{'字符串'+${model中的nam值}}"
如项目中的：view.html中，<a th:href="@{'/users/delete/'+${userModel.user.id}}">删除</a>
是把连接转为 /users/delete/{id} 地址来处理的

2、list.html代码走读之---btn的链接及显示

<a class="btn btn-default" href="/users/form.html" th:href="@{/users/form}">创建用户</a>

class值为btn，说明是一个button

href：在a标签中，href指向的是html页面

th:href="@{/users/form}：指向controller中的 /users/form 地址了

创建用户：是btn上的文本



二、HelloController是学习类，学习Model和ModelAndView的。
