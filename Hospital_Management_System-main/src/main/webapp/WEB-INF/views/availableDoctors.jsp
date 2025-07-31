<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Available Doctors</title>
    <style>
        body {
            background: #f2f6fc;
            font-family: Arial, sans-serif;
        }
        .container {
            max-width: 700px;
            margin: 40px auto;
            padding: 24px;
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 24px rgba(0,0,0,0.08);
        }
        h2 {
            color: #007bff;
            text-align: center;
            margin-bottom: 32px;
        }
        .msg {
            color: #fff;
            background: #28a745;
            font-weight: bold;
            margin-bottom: 24px;
            padding: 12px 0;
            border-radius: 6px;
            text-align: center;
        }
        .doctor-card {
            background: #f8fafc;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.04);
            padding: 10px 12px 8px 12px;
            margin-bottom: 14px;
        }
        .doctor-card p {
            font-size: 15px;
            font-weight: bold;
            color: #333;
            margin-bottom: 6px;
        }
        form {
            display: flex;
            flex-wrap: wrap;
            gap: 12px;
            align-items: center;
        }
        label {
            flex: 1 0 100px;
            font-weight: 500;
            color: #555;
        }
        input[type=number], input[type=datetime-local], input[type=text] {
            flex: 2 0 180px;
            padding: 8px;
            border-radius: 4px;
            border: 1px solid #cfd8dc;
            font-size: 15px;
        }
        input[type=submit] {
            background: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            padding: 8px 18px;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            margin-left: auto;
            transition: background 0.2s;
        }
        input[type=submit]:hover {
            background: #0056b3;
        }
        .doctor-card form {
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
            gap: 6px;
            align-items: center;
        }
        .doctor-card label {
            font-weight: 500;
            color: #555;
            margin-bottom: 0;
            font-size: 13px;
        }
        .doctor-card input[type=number],
        .doctor-card input[type=datetime-local],
        .doctor-card input[type=text] {
            width: 110px;
            padding: 4px 6px;
            border-radius: 3px;
            border: 1px solid #cfd8dc;
            font-size: 13px;
            margin-bottom: 0;
        }
        .doctor-card input[type=submit] {
            align-self: center;
            background: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            padding: 4px 12px;
            font-size: 13px;
            font-weight: bold;
            cursor: pointer;
            margin-top: 0;
            margin-left: 8px;
            transition: background 0.2s;
        }
        .doctor-card input[type=submit]:hover {
            background: #0056b3;
        }
        @media (max-width: 600px) {
            .container { padding: 10px; }
            .doctor-card { padding: 12px; }
            form { flex-direction: column; gap: 8px; }
            label, input { flex: 1 0 100%; }
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Available Doctors for ${disease}</h2>

        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>
		
		
		<br><br/>
        <c:forEach var="doc" items="${doctors}">
            <div class="doctor-card">
                <form action="bookAppointment" method="post" style="display: block;">
                    <p style="font-size: 16px; font-weight: bold; margin-bottom: 18px;">${doc.name} — ${doc.specialization}</p>
                    <input type="hidden" name="doctorId" value="${doc.id}" />
                    <input type="hidden" name="disease" value="${disease}" />

                    <div style="margin-bottom: 16px;">
                        <label style="display: block; font-weight: 500; margin-bottom: 4px;">Patient ID:</label>
                        <input type="number" name="patientId" required style="width: 100%; padding: 8px; border-radius: 4px; border: 1px solid #cfd8dc;" />
                    </div>
                    <div style="margin-bottom: 16px;">
                        <label style="display: block; font-weight: 500; margin-bottom: 4px;">Date & Time:</label>
                        <input type="datetime-local" name="datetime" required style="width: 100%; padding: 8px; border-radius: 4px; border: 1px solid #cfd8dc;" />
                    </div>
                    <div style="margin-bottom: 20px;">
                        <label style="display: block; font-weight: 500; margin-bottom: 4px;">Purpose:</label>
                        <input type="text" name="purpose" required style="width: 100%; padding: 8px; border-radius: 4px; border: 1px solid #cfd8dc;" />
                    </div>
                    <div style="text-align: center;">
                        <input type="submit" value="Book Appointment" style="background: #007bff; color: #fff; border: none; border-radius: 4px; padding: 10px 24px; font-size: 16px; font-weight: bold; cursor: pointer; transition: background 0.2s;" />
                    </div>
                </form>
            </div>
        </c:forEach>
    </div>
</body>
</html>
