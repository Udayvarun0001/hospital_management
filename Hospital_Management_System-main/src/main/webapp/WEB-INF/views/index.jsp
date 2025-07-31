<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Patient List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body class="container mt-4">

    <!-- Logout Button -->
    <div class="d-flex justify-content-end mb-2">
        <a href="logout" class="btn btn-danger">Logout</a>
    </div>

    <h2 class="text-center mb-4">Patient List</h2>

    <!-- Top Controls: Add Patient + Search + Show Doctors -->
    <div class="d-flex justify-content-between mb-3">
        <a href="showNewPatientForm" class="btn btn-primary">Add New Patient</a>

        <div class="d-flex gap-2">
            <input type="text" id="searchInput" onkeyup="filterPatients()" placeholder="Search by name..." class="form-control" />
            <a href="/doctors" class="btn btn-info">Show All Doctors</a>
        </div>
    </div>

    <!-- Patient Table -->
    <table class="table table-bordered">
        <thead class="table-dark">
            <tr>
                <th>Name</th>
                <th>Disease</th>
                <th>Phone</th>
                <th>Address</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="patient" items="${listPatients}">
                <tr>
                    <td>${patient.name}</td>
                    <td>${patient.disease}</td>
                    <td>${patient.phone}</td>
                    <td>${patient.address}</td>
                    <td>
                        <a href="showFormForUpdate/${patient.id}" class="btn btn-warning btn-sm">Edit</a>
                        <a href="deletePatient/${patient.id}" class="btn btn-danger btn-sm"
                           onclick="return confirm('Are you sure you want to delete this patient?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <!-- Book Appointment Button -->
    <div class="d-flex justify-content-center" style="margin-top: 20px;">
        <a href="<c:url value='/bookAppointmentForm' />">
            <button style="background-color: #28a745; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer;">
                Book Appointment
            </button>
        </a>
    </div>

    <!-- Client-side Search Script -->
    <script>
        function filterPatients() {
            const input = document.getElementById("searchInput");
            const filter = input.value.toLowerCase();
            const rows = document.querySelectorAll("tbody tr");

            rows.forEach(row => {
                const nameCell = row.querySelector("td:first-child");
                const name = nameCell.textContent.toLowerCase();
                row.style.display = name.includes(filter) ? "" : "none";
            });
        }

        function resetSearch() {
            document.getElementById("searchInput").value = "";
            filterPatients();
        }
    </script>
</body>
</html>

