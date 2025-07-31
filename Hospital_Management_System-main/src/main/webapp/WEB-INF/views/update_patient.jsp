<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Patient</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2 class="mb-4">Update Patient</h2>

    <form action="/savePatient" method="post">
        <input type="hidden" name="id" value="${patient.id}">

        <div class="mb-3">
            <label class="form-label">Name:</label>
            <input type="text" name="name" value="${patient.name}" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Disease:</label>
            <input type="text" name="disease" value="${patient.disease}" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Phone:</label>
            <input type="text" name="phone" value="${patient.phone}" class="form-control" required>
        </div>

        <div class="mb-3">
            <label class="form-label">Address:</label>
            <input type="text" name="address" value="${patient.address}" class="form-control" required>
        </div>

        <button type="submit" class="btn btn-primary">Update Patient</button>
        <a href="/" class="btn btn-secondary">Cancel</a>
    </form>
</body>
</html>
