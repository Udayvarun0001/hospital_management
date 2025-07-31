<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f7f9fc;
        }
        .login-box {
            margin-top: 100px;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0px 0px 15px #ccc;
        }
    </style>
</head>
<body class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 login-box">
            <h3 class="text-center mb-4">Login</h3>
            <form action="login" method="post">
                <div class="mb-3">
                    <label>Username</label>
                    <input type="text" name="username" class="form-control" required/>
                </div>
                <div class="mb-3">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" required/>
                </div>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </form>
            <p class="mt-3 text-center">Not registered? <a href="register">Sign up</a></p>
        </div>
    </div>
    
</body>
</html>