<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #eef2f7;
        }
        .signup-box {
            margin-top: 100px;
            padding: 30px;
            background: white;
            border-radius: 10px;
            box-shadow: 0px 0px 15px #bbb;
        }
    </style>
</head>
<body class="container">
    <div class="row justify-content-center">
        <div class="col-md-6 signup-box">
            <h3 class="text-center mb-4">Sign Up</h3>
            <form action="register" method="post">
                <div class="mb-3">
                    <label>Username</label>
                    <input type="text" name="username" class="form-control" required/>
                </div>
                <div class="mb-3">
                    <label>Email</label>
                    <input type="email" name="email" class="form-control" required/>
                </div>
                <div class="mb-3">
                    <label>Password</label>
                    <input type="password" name="password" class="form-control" required/>
                </div>
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <div class="d-grid gap-2">
                    <button type="submit" class="btn btn-success">Register</button>
                </div>
            </form>
            <p class="mt-3 text-center">Already have an account? <a href="/">Login</a></p>
        </div>
    </div>
</body>
</html>