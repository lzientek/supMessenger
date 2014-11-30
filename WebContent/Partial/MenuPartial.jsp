<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button class="navbar-toggle collapsed" aria-expanded="false" aria-controls="navbar" type="button"
                    data-toggle="collapse" data-target="#navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">SupMessaging</a>
        </div>
        <div class="navbar-collapse collapse" id="navbar">
            <ul class="nav navbar-nav">
                <li class="active"><a href="Home">Home</a></li>
                <c:if test="${empty sessionScope.userId}">
                    <li><a href="Contact">Contact</a></li>

                    <li><a href="Login">Login</a></li>
                    <li><a href="Register">Register</a></li>
                </c:if>
                <c:if test="${not empty sessionScope.userId}">
                    <li><a href="Chat">Chat</a></li>

                    <li><a href="Logout">Logout</a></li>
                </c:if>
            </ul>
            <c:if test="${not empty sessionScope.userId}">
                <form class="navbar-form navbar-right" role="form" method="post" action="Search">

                    <div class="form-group">
                        <input class="form-control" type="text" placeholder="Search...">
                    </div>
                    <button class="btn btn-success" type="submit">Search</button>
                </form>
            </c:if>
        </div>
        <!--/.nav-collapse -->
    </div>
</nav>
