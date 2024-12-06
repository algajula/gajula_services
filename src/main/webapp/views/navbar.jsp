<div class="navbar">
        <a href="/index">Home</a>
        <div class="subnav">
            <button class="subnavbtn">Book <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/bookview">View Books</a>
                <a href="${pageContext.request.contextPath}/api/v1/user/register">Add Book</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/customerview">Edit Book</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/customerview">Authors</a>
            </div>
        </div>
        <div class="subnav">
            <button class="subnavbtn">Customer <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/customerview">View Customers</a>
                <a href="${pageContext.request.contextPath}/api/v1/user/register">Add Customer</a>
                <a href="${pageContext.request.contextPath}/api/v1/user/register">Edit Customer</a>
                <a href="${pageContext.request.contextPath}/api/v1/user/register">Vehicles</a>
            </div>
        </div>
        <div class="subnav">
            <button class="subnavbtn">Users <i class="fa fa-caret-down"></i></button>
            <div class="subnav-content">
                <a href="${pageContext.request.contextPath}/api/v1/templates/userview">View Users</a>
                <a href="${pageContext.request.contextPath}/api/v1/user/register">Add User</a>
                <a href="${pageContext.request.contextPath}/api/v1/templates/customerview">Edit User</a>
            </div>
        </div>
        <a href="#contact">Contact</a>
</div>