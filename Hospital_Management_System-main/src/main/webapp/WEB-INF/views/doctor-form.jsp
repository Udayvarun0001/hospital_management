<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor Form</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-4">
    <h2 class="text-center mb-4">${doctor.id == null ? 'Add New Doctor' : 'Update Doctor'}</h2>

    <form action="${pageContext.request.contextPath}/saveDoctor" method="post">
        <input type="hidden" name="id" value="${doctor.id}" />

        <div class="mb-3">
            <label for="name" class="form-label">Name:</label>
            <input type="text" class="form-control" name="name" value="${doctor.name}" required />
        </div>

        <div class="mb-3">
            <label for="specialization" class="form-label">Specialization:</label>
            <input type="text" class="form-control" name="specialization" value="${doctor.specialization}" required />
        </div>

        <div class="mb-3">
            <label for="phone" class="form-label">Phone:</label>
            <input type="text" class="form-control" name="phone" value="${doctor.phone}" required />
        </div>

        <div class="mb-3">
            <label for="experience" class="form-label">Experience (in years):</label>
            <input type="number" class="form-control" name="experience" value="${doctor.experience}" required />
        </div>

        <div class="text-center">
            <button type="submit" class="btn btn-success">${doctor.id == null ? 'Add Doctor' : 'Update Doctor'}</button>
            <a href="${pageContext.request.contextPath}/doctors" class="btn btn-secondary">Back</a>
        </div>
    </form>
</body>
</html>
