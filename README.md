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
2、
二、HelloController是学习类，学习Model和ModelAndView的。
