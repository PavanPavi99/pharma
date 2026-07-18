<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">

<head>

<meta charset="UTF-8">

<title>Bill List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">


<style>

body{
    background:#eef5ff;
}

.container-box{

    margin-top:40px;
    background:white;
    padding:30px;
    border-radius:20px;
    box-shadow:0 5px 20px rgba(0,0,0,.15);

}


.header{

    background:linear-gradient(45deg,#0d6efd,#00c6ff);
    color:white;
    padding:20px;
    border-radius:15px;
    margin-bottom:25px;

}


.btn{

    border-radius:10px;

}


.table{

    border-radius:15px;
    overflow:hidden;

}

</style>


</head>


<body>


<div class="container">


<div class="container-box">


<div class="header">

<h2>
🧾 Billing Management
</h2>

</div>



<a href="/bill/add" class="btn btn-success mb-3">

➕ Create New Bill

</a>




<table class="table table-bordered table-hover">


<thead class="table-primary">


<tr>

<th>ID</th>

<th>Bill Date</th>

<th>Total Amount</th>

<th>Payment Status</th>

<th>Actions</th>

</tr>


</thead>



<tbody>



<tr th:each="bill : ${bills}">


<td th:text="${bill.id}"></td>


<td th:text="${bill.billDate}"></td>


<td th:text="${bill.totalAmount}"></td>


<td>


<span class="badge bg-success"
      th:if="${bill.paymentStatus == 'Paid'}">

Paid

</span>


<span class="badge bg-warning text-dark"
      th:if="${bill.paymentStatus == 'Pending'}">

Pending

</span>


<span class="badge bg-danger"
      th:if="${bill.paymentStatus == 'Unpaid'}">

Unpaid

</span>


</td>



<td>


<a th:href="@{/bill/view/{id}(id=${bill.id})}"
class="btn btn-info btn-sm text-white">

👁 View

</a>



<a th:href="@{/bill/delete/{id}(id=${bill.id})}"
class="btn btn-danger btn-sm"
onclick="return confirm('Delete this bill?')">

🗑 Delete

</a>


</td>


</tr>



</tbody>


</table>




<a href="/dashboard" class="btn btn-secondary">

⬅ Dashboard

</a>



</div>


</div>


</body>

</html>