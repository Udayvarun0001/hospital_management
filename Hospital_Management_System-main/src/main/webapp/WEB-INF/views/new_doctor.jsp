<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Doctor List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="container mt-4">

    <h2 class="text-center mb-4">Doctor List</h2>

    <div class="d-flex justify-content-between mb-3">
        <a href="showNewDoctorForm" class="btn btn-primary">Add New Doctor</a>

        <div class="d-flex gap-2">
            <input type="text" id="searchInput" onkeyup="filterDoctors()" placeholder="Search by name..." class="form-control" />
            <input type="number" id="searchIdInput" onkeyup="filterDoctorsById()" placeholder="Search by ID..." class="form-control" />
            <a href="/" class="btn btn-info">Show All Patients</a>
        </div>
    </div>

    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Name</th>
                <th>Specialization</th>
                <th>Phone</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="doctor" items="${listDoctors}">
                <tr>
                    <td>${doctor.name}</td>
                    <td>${doctor.specialization}</td>
                    <td>${doctor.phone}</td>
                    <td>
                        <a href="showFormForUpdateDoctor/${doctor.id}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="deleteDoctor/${doctor.id}" class="btn btn-danger btn-sm" onclick="return confirm('Are you sure you want to delete this doctor?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div style="text-align:center; margin-top: 20px;">
        <a href="<c:url value='/bookAppointmentForm' />">
            <button class="btn btn-success">Book Appointment</button>
        </a>
    </div>

    <script>
        function filterDoctors() {
            const input = document.getElementById("searchInput");
            const filter = input.value.toLowerCase();
            const rows = document.querySelectorAll("tbody tr");

            rows.forEach(row => {
                const nameCell = row.querySelector("td:first-child");
                const name = nameCell.textContent.toLowerCase();
                row.style.display = name.includes(filter) ? "" : "none";
            });
        }

        function filterDoctorsById() {
            const input = document.getElementById("searchIdInput");
            const filter = input.value;
            const rows = document.querySelectorAll("tbody tr");

            rows.forEach(row => {
                const idCell = row.querySelector("td:nth-child(1)");
                if (!idCell) return;
                const id = row.rowIndex; // fallback if no id
                row.style.display = idCell.textContent.trim() === filter || filter === "" ? "" : "none";
            });
        }

        function resetSearch() {
            document.getElementById("searchInput").value = "";
            document.getElementById("searchIdInput").value = "";
            filterDoctors();
            filterDoctorsById();
        }
    </script>
</body>
</html>
