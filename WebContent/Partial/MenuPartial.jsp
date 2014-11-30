<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">

            <a class="navbar-brand" href="Home">SupMessaging</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li
                        <c:if test="${requestScope['javax.servlet.forward.servlet_path'] == '/Home' }">class="active"</c:if> >
                    <a href="Home">Home</a></li>
                <c:if test="${empty sessionScope.userId}">
                    <li
                            <c:if test="${requestScope['javax.servlet.forward.servlet_path'] == '/Contact' }">class="active"</c:if> >
                        <a href="Contact">Contact</a></li>

                    <li
                            <c:if test="${requestScope['javax.servlet.forward.servlet_path'] == '/Login' }">class="active"</c:if> >
                        <a href="Login">Login</a></li>
                    <li
                            <c:if test="${requestScope['javax.servlet.forward.servlet_path'] == '/Register' }">class="active"</c:if> >
                        <a href="Register">Register</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.userId}">
                    <li
                            <c:if test="${requestScope['javax.servlet.forward.servlet_path'] == '/Chat' }">class="active"</c:if> >
                        <a href="Chat">Chat</a></li>

                    <li>
                        <a href="Logout">Logout</a></li>
                </c:if>
            </ul>
            <c:if test="${not empty sessionScope.userId}">
                <form class="navbar-form navbar-right" role="form" method="post" action="Search">

                    <div class="form-group">
                        <input class="form-control" name="search" type="text" placeholder="Search...">
                    </div>
                    <button class="btn btn-success" type="submit">Search</button>
                </form>
            </c:if>
        </div>

    </div>
</nav>
