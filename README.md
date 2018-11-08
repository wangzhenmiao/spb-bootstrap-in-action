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

文本：< 分割 a class="btn btn-default" href="/users/form.html" th:href="@{/users/form}">创建用户< 分割 /a>

（添加 “分割” 要不然看见html的代码了）

class值为btn，说明是一个button

href：在a标签中，href指向的是html页面

th:href="@{/users/form}：指向controller中的 /users/form 地址了

创建用户：是btn上的文本

3、controller中model传递数据，view传递html页面路径

a)代码片段：return new ModelAndView("users/list","userModel",model);

b)构造函数：public ModelAndView(String viewName, String modelName, Object modelObject)

c)具体参数含义：

viewName:是templates下对应的html文件，全路径为：templates/users/list.html

modeName:是对应html页面中，可以用 ${modelName} 来取值的

   比如：list.html页面中，通过：< 分割 h3 th:text="${userModel.title}">waylau< 分割 /h3>

   用 ${userModel.title} 取值，但是还放在双引号里哎，😌

modelObject:是关联数据库等，取到的数据源

4、thymeleaf 中 if 的使用，model中list的size（）应用

    <tr th:if="${userModel.userList.size()} eq 0">
            <td colspan="3">没有用户信息！</td>
    </tr>

代码分析：

a)model中list的size调用：${userModel.userList.size()}

b) th:if=" 变量 eq 0" : if 的判断

c) 如果为真，才显示 “没有用户信息” 的文本

5、thymeleaf中的forearch循环，超链接

    <tr th:each="user : ${userModel.userList}">
            <td th:text="${user.id}"></td>
            <td th:text="${user.email}"></td>
            <td ><a th:href="@{'/users/'+${user.id}}" th:text="${user.name}"></a></td>
    </tr>

a) th:each="user : ${userModel.userList}" 传递user 变量到每行

td 标签中，${user.id} 可以实现遍历取值

b) td中，套用 a 标签

a标签中，th:href 写 controller 中的地址，th:text 是显示的文本

6、controller中，接收url中的参数

@GetMapping("{id}")

    public ModelAndView view(@PathVariable("id") Long id, Model model)
    
1、@GetMapping("{id}"),get请求，具体url为：/users/id,其中uers是类映射，@RequestMapping("/users")中提供的

2、@PathVariable("id") Long id ，表示参数为id

7、thymeleaf中的form有关标签使用

    <form action="/users" th:action="@{/users}" method="POST" th:object="${userModel.user}">
        <input type="hidden" name="id" th:value="*{id}">
        名称：<br>
        <input type="text" class="form-control" name="name" th:value="*{name}">
        邮箱：<br>
        <input type="text" class="form-control" name="email" th:value="*{email}">
        <input type="submit" class="btn btn-default" value="提交">
    </form>
    
   a) action:属性规定当提交表单时，向何处发送表单数据
    
   b) th:action= :定义后台控制器路径，类似<form>标签的action属性，发到users,表单存储见 8 😁
   
   c) th:object=:用于表单数据对象绑定，将表单绑定到后台controller的一个JavaBean参数。常与th:field一起使用进行表单数据绑定
   
   d) th:value= :th:value="*{name}"，不知道为什么是*{name},这个form是一个编辑和添加公用的form,name是bean的属性
 
 8、表单的存储
 
 controller中代码:
 
 类的注解：
 
a) @RequestMapping("/users")

表示controller的基本url是：/users

b)路径为 /users的get和post请求的处理方式

     @GetMapping
    public ModelAndView list(Model model)
    
        @PostMapping
    public ModelAndView saveOrUpdateUser(User user) 

所以：当路径为 /users 的get请求时，调用 list 方法

当路径为 /users 的post请求时，调用 saveOrUpdateUser方法

c)form.html中的from表单，提交的action路径是 users,类型是 post，所以会提交到controller中路径为users的postMapping注解下的saveOrUpdateUser方法处理 😁😁😊

9、controller中的重定向

ModelAndView("redirect:/users");

重定向页面到list页面了，一般在添加、删除操作后执行

二、HelloController是学习类，学习Model和ModelAndView的。
