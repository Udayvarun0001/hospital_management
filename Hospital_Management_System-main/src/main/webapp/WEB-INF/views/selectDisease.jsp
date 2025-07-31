<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Doctor Appointment</title>
    <style>
        body {
            background: #f2f6fc;
            font-family: Arial, sans-serif;
        }
        .card {
            background: #fff;
            max-width: 400px;
            margin: 60px auto;
            padding: 32px 24px;
            border-radius: 10px;
            box-shadow: 0 4px 24px rgba(0,0,0,0.08);
            text-align: center;
        }
        select, input[type=submit] {
            width: 100%;
            padding: 10px;
            margin: 18px 0 0 0;
            border-radius: 5px;
            border: 1px solid #cfd8dc;
            font-size: 16px;
        }
        input[type=submit] {
            background: #007bff;
            color: #fff;
            border: none;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.2s;
        }
        input[type=submit]:hover {
            background: #0056b3;
        }
        label {
            font-weight: bold;
            margin-bottom: 8px;
            display: block;
        }
        h2 {
            color: #007bff;
            margin-bottom: 24px;
        }
    </style>
</head>
<body>
    <div class="card">
        <h2>Doctor Appointment</h2>
        <form action="availableDoctors" method="get">
            <label>Select Disease:</label>
            <select name="disease">
                <option value="Cardiology">Cardiology</option>
                <option value="Dermatology">Dermatology</option>
                <option value="Neurology">Neurology</option>
                <option value="Orthopedics">Orthopedics</option>
                <option value="ENT">ENT</option>
                <option value="General Medicine">General Medicine</option>
                <option value="Gynecology">Gynecology</option>
                <option value="Psychiatry">Psychiatry</option>
            </select>
            <input type="submit" value="Find Doctor">
        </form>
    </div>
</body>
</html>
